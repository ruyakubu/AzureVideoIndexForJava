package com.video.demo.service;


//// This sample uses the Apache HTTP client from HTTP Components (http://hc.apache.org/httpcomponents-client-ga/)
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.video.demo.domain.BreakdownRoot;
import com.video.demo.domain.Faces;
import com.video.demo.domain.SummarizedInsights;
import com.video.demo.DTO.VideoBreakDownDTO;
import com.video.demo.DTO.BreakdownMetaDataDTO;
import com.video.demo.DTO.PersonGroupDTO;
import com.video.demo.DTO.UnknownPersonDTO;


@Service
public class VideoIndexService
{
	private static final String videoIndexerkey = "<Enter-you-video-indexer-key>"; 

	
	private final BlobStorageService storageService;
	
    @Autowired
    public VideoIndexService(BlobStorageService storageService) {
        this.storageService = storageService;
    }
	
	@Autowired
	private FaceService faceservice;
	
	public String upload(String fileUrl, VideoBreakDownDTO videoDetails)
	{
		String jsonResultBody = null;
   		
        try
        {

    	    RestTemplate restTemplate = new RestTemplate();
    	    
    	    HttpHeaders headers = new HttpHeaders();
    	    headers.set("Content-Type", "multipart/form-data");
    	    headers.set("Ocp-Apim-Subscription-Key", videoIndexerkey);

    		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

    		UriComponents builder = UriComponentsBuilder.newInstance().scheme("https")
    				.host("videobreakdown.azure-api.net").path("/Breakdowns/Api/Partner/Breakdowns")
    				.queryParam("name", videoDetails.getName())
    				.queryParam("privacy", videoDetails.getPrivacy())
    				.queryParam("videoUrl", fileUrl)
    				.queryParam("language", "English")
    				.queryParam("externalId", videoDetails.getExternalId())
    				.queryParam("description", videoDetails.getDescription())
    				.build();

    		System.out.println("\n\n API Request:  " + builder.toUriString() );
    		
    		ResponseEntity<String> result = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, String.class);
    		jsonResultBody = result.getBody();
    				
       }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return jsonResultBody;
	}
	
	
	public SummarizedInsights getBreakdownMetaData(String breakdownId)
	{
		String jsonResultBody = null;
		SummarizedInsights sentimentInsights = new SummarizedInsights();

		if(breakdownId != null)
		{
	        try
	        {
	
	    	    RestTemplate restTemplate = new RestTemplate();
	    	    
	    	    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	     
	    	    HttpHeaders headers = new HttpHeaders();
	    	    headers.setContentType(MediaType.APPLICATION_JSON);
	    	    headers.set("Ocp-Apim-Subscription-Key", videoIndexerkey);
	
	    		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	
	    		UriComponents builder = UriComponentsBuilder.newInstance().scheme("https")
	    				.host("videobreakdown.azure-api.net").path("/Breakdowns/Api/Partner/Breakdowns/" + breakdownId)
	    				.queryParam("language", "English")
	    				.build();
	
	    		System.out.println("\n\n API Request:  " + builder.toUriString() );
	    		
	    		ResponseEntity<BreakdownRoot> result = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, BreakdownRoot.class);
	    		jsonResultBody = result.getBody().toString();
	    		
	    		//extract Video sentiments
	    		sentimentInsights = result.getBody().getSummarizedInsights();

	       }
	        catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	        }
		}
		
		return sentimentInsights;
	}
	
 
	
	public String getPlayerToken(String breakdownId)
	{
	
		String accessToken = null;	
		String token = null;
		
		if(breakdownId != null)
		{
            try
            {

        	    RestTemplate restTemplate = new RestTemplate();
        	    
        	    //Todo
        	    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        	    HttpHeaders headers = new HttpHeaders();
        	    headers.setContentType(MediaType.APPLICATION_JSON);
        	    headers.set("Ocp-Apim-Subscription-Key", videoIndexerkey);

        		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        		UriComponents builder = UriComponentsBuilder.newInstance().scheme("https")
        				.host("videobreakdown.azure-api.net").path("/Breakdowns/Api/Partner/Breakdowns/" + breakdownId + "/GetAccessToken")
        				.queryParam("allowEdit", "True")
        				.build();
        		
        		ResponseEntity<String> result = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
        		accessToken = result.getBody().toString();
        		
        		token = accessToken.replaceAll("\"", "");
          		       				
           }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            
		}
		 return token;
	}
	
	
	public void detectFaceId(String breakdownId, String personGroupId)
	{
		List<Faces> faceList = new ArrayList<Faces>(); 
		
		SummarizedInsights sentimentInsights = new SummarizedInsights();
		
		sentimentInsights =  this.getBreakdownMetaData(breakdownId);
		faceList = this.parseFacesFromBreakdown(sentimentInsights);
		
		if(faceList != null )
		{
			for(int i=0; i < faceList.size(); i++)
			{
				UnknownPersonDTO unknownPersonDto = new UnknownPersonDTO();
				Faces face = new Faces();
				face = faceList.get(i);
				
				if( face.getName().trim().startsWith("Unknown #"))
				{
					
					String unknowFaceName = face.getName() + ".jpg";
					String url = face.getThumbnailFullUrl();
					
					String blobUrl = storageService.downloadImageToBlob(url, unknowFaceName);
					String jsonFaceBody = faceservice.detectFace(blobUrl);
					String faceId = faceservice.parseFaceIdFromDetect(jsonFaceBody);
					String jsonResultBody = faceservice.identifyFace(faceId, personGroupId);
					unknownPersonDto = faceservice.parseConfidenceFromIdentify(jsonResultBody);
					
					if(unknownPersonDto != null)
					{
						if(unknownPersonDto.getConfidence() != null)
						{
							String confidence = unknownPersonDto.getConfidence();
							float score = new Float(confidence).floatValue();
							if(score >= 0.5)
							{
								String jsonPersonBody = faceservice.getPerson(personGroupId, unknownPersonDto.getPersonId());
								String foundName = faceservice.parsePersonName(jsonPersonBody);							
								int breakdownFaceId = new Integer(face.getId()).intValue();
								this.updateKnownFace(breakdownId, breakdownFaceId, foundName);
							}
						}
					}
				}

			}
		}
	}  
	
	public void updateKnownFace(String breakdownId, int breakdownFaceId, String newFaceName)
	{
        try
        {

    	    RestTemplate restTemplate = new RestTemplate();
    	    
    	    HttpHeaders headers = new HttpHeaders();
    	    headers.set("Content-Type", "multipart/form-data");
    	    headers.set("Ocp-Apim-Subscription-Key", videoIndexerkey);

    		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

    		UriComponents builder = UriComponentsBuilder.newInstance().scheme("https")
    				.host("videobreakdown.azure-api.net").path("/Breakdowns/Api/Partner/Breakdowns/UpdateFaceName/" + breakdownId)
    				.queryParam("faceId", breakdownFaceId)
    				.queryParam("newName", newFaceName)
    				.build();

    		System.out.println("\n\n API Request in update Face:  " + builder.toUriString() );
    		
    		ResponseEntity<String> result = restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, entity, String.class);
    				
       }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            
        }
	}
	
	
	public List<Faces> parseFacesFromBreakdown(SummarizedInsights sentimentInsights)
	{
		 List<Faces> faceList = new ArrayList<Faces>(); 
		
		//Todo extract faces
		if(sentimentInsights != null)
		{
			
			faceList = sentimentInsights.getFaces();
			
		}
		
		return faceList;
	}

}



















