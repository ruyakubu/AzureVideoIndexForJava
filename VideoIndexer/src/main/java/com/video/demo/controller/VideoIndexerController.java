package com.video.demo.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.video.demo.service.FaceService;

import com.video.demo.domain.BreakdownRoot;
import com.video.demo.domain.SummarizedInsights;
import com.video.demo.domain.Faces;
import com.video.demo.helper.StorageFileNotFoundException;
import com.video.demo.service.BlobStorageService;
import com.video.demo.service.VideoIndexService;


import java.util.List;
import java.util.ArrayList;
import com.video.demo.DTO.BreakTokenDTO;
import com.video.demo.DTO.BreakdownMetaDataDTO;
import com.video.demo.DTO.VideoBreakDownDTO;

@Controller
public class VideoIndexerController {

    private final BlobStorageService storageService;
	
	@Autowired
	private VideoIndexService videoIndexService;

    @Autowired
    public VideoIndexerController(BlobStorageService storageService) {
        this.storageService = storageService;
    }

    //Display Video Upload Form
    @RequestMapping(method = RequestMethod.GET, value="/")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(VideoIndexerController.class,
                        "serveFile", path.getFileName().toString()).build().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }
    
    //Handle Video Upload file and input data
    @PostMapping("/")    @RequestMapping(method = RequestMethod.POST, value="/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam String name,
    		  @RequestParam String description, @RequestParam(value = "privacy", required = true) String[] privacy, @RequestParam String externalId,
            RedirectAttributes redirectAttributes) {
    	
    		System.out.println("privacy value " + privacy[0]);
    		
    		String jsonResultBody = null;
    	
    		VideoBreakDownDTO videoDetails = new VideoBreakDownDTO();
    		
    		videoDetails.setName(name);
    		videoDetails.setDescription(description);
    		videoDetails.setPrivacy(privacy[0]);
    		videoDetails.setExternalId(externalId);
    		videoDetails.setFile(file);
    	
    		String fileUrl = storageService.storeVideo(videoDetails);
    		jsonResultBody = videoIndexService.upload(fileUrl, videoDetails);
        
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");
           
        redirectAttributes.addFlashAttribute("json", "Here is your Breakdown ID:  " + jsonResultBody);

        return "redirect:/";
    }

    
    
    //Display some metadata from all the Faces found in your video
    @RequestMapping(method = RequestMethod.GET, value="/breakdown/{id}")
    public String getVideoBreakdown(@PathVariable String id, Model model) {
    	
		List<Faces> faceList = new ArrayList<Faces>(); 
		SummarizedInsights sentimentInsights = new SummarizedInsights();
		
		sentimentInsights =  videoIndexService.getBreakdownMetaData(id);
		faceList = videoIndexService.parseFacesFromBreakdown(sentimentInsights);

		model.addAttribute("faces", faceList);
        return "faces";
 
    } 
    
    
    //Display Video and Insights into your video
    @RequestMapping(method = RequestMethod.GET, value="/player/{id}")
    public String getVideoPlayer(@PathVariable String id, Model model) {

    		String token =  videoIndexService.getPlayerToken(id);

	        model.addAttribute("breakdownId", id);
	        model.addAttribute("token", token);
	        				
            return "playerinsight";
    }     
    
    
    
    //Find Unknown face match
    @RequestMapping(method = RequestMethod.GET, value="/updateUnknown/{id}/{groupId}")
    public String getVideoUpdatePlayer(@PathVariable String id, @PathVariable String groupId, Model model) {

    		videoIndexService.detectFaceId(id,groupId);
    		String token =  videoIndexService.getPlayerToken(id);

	        model.addAttribute("breakdownId", id);
	        model.addAttribute("token", token);
	        				
            return "playerinsight";
     
    }   
    

    
    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }


}
