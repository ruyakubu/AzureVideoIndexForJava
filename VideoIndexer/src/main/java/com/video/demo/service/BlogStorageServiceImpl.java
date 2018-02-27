package com.video.demo.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Calendar;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import java.io.FileInputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;
import java.net.URI;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.video.demo.DTO.FaceDTO;
import com.video.demo.DTO.VideoBreakDownDTO;
import com.video.demo.helper.StorageException;
import com.video.demo.helper.StorageFileNotFoundException;
import com.video.demo.helper.StorageProperties;

import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.blob.*;

@Service
public class BlogStorageServiceImpl implements BlobStorageService {
	
    public static final String storageConnectionString =
    		"DefaultEndpointsProtocol=https;"
    		+ "AccountName=<Enter-Your-Storage-Account-Name>;"
    		+ "AccountKey=<Enter-Your-Storage-Account-Key>;"
    		+ "EndpointSuffix=core.windows.net";

    private static final String unknownBlobImageContainer = "unknowns";
    private static final String blobImageContainer = "photos";
    private static final String blobVideoContainer = "videos";
    
	private static final String localFilePath = "<Enter-Your-Local-File-Path>";
    private Path rootLocation;
    
    @Autowired
    private VideoIndexService videoUploadService;
    
    @Autowired
    public BlogStorageServiceImpl(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }
    
    
    @Override
    public String storeVideo(VideoBreakDownDTO videoDetails) {
    	
    	String fileUrl = null;
    	
		try {
			CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionString);
            CloudBlobClient serviceClient = account.createCloudBlobClient();

            // Container name must be lower case.
            //CloudBlobContainer container = serviceClient.getContainerReference(blobImageContainer);
            CloudBlobContainer container = serviceClient.getContainerReference(blobVideoContainer);
            container.createIfNotExists();
            
            MultipartFile file = videoDetails.getFile();
            String filename = StringUtils.cleanPath(file.getOriginalFilename());
            
            // Define the path to a local file.
            final String filePath = "<Enter-Your-Local-File-Path>" + filename;
            

            // Upload an image file.
            CloudBlockBlob blob = container.getBlockBlobReference(filename);
            File sourceFile = new File(filePath);
            blob.upload(new FileInputStream(sourceFile), sourceFile.length());
            fileUrl = getBlobVideoUrl(filename);

        }
        catch (FileNotFoundException fileNotFoundException) {
            System.out.print("FileNotFoundException encountered: ");
            System.out.println(fileNotFoundException.getMessage());
            System.exit(-1);
        }
        catch (StorageException storageException) {
            System.out.print("StorageException encountered: ");
            System.out.println(storageException.getMessage());
            System.exit(-1);
        }
        catch (Exception e) {
            System.out.print("Exception encountered: ");
            System.out.println(e.getMessage());
            System.exit(-1);
        }
		
		return fileUrl;
    }

    
    @Override
    public String storePhoto(FaceDTO faceDto) {
    	
    	String fileUrl = null;
    	
		try {
			CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionString);
            CloudBlobClient serviceClient = account.createCloudBlobClient();

            // Container name must be lower case.
            //CloudBlobContainer container = serviceClient.getContainerReference(blobImageContainer);
            CloudBlobContainer container = serviceClient.getContainerReference(blobImageContainer);
            container.createIfNotExists();
            
            MultipartFile file = faceDto.getFile();
            String path = StringUtils.cleanPath(file.getOriginalFilename());
            File sourceFile = new File(path);
            String filename = sourceFile.getName();
     
            // Define the path to a local file.
            final String filePath = "<Enter-Your-Local-File-Path>" + filename;
            
            System.out.println("file name: " + filename);
            System.out.println("file path: " + filePath);  
            
            // Upload an image file.
            CloudBlockBlob blob = container.getBlockBlobReference(filename);
            File imagePath = new File(filePath);
            blob.upload(new FileInputStream(imagePath), imagePath.length());
            //fileUrl = getBlobUrl(filename);
            fileUrl = blob.getUri().toString();

        }
        catch (FileNotFoundException fileNotFoundException) {
            System.out.print("FileNotFoundException encountered: ");
            System.out.println(fileNotFoundException.getMessage());
            System.exit(-1);
        }
        catch (StorageException storageException) {
            System.out.print("StorageException encountered: ");
            System.out.println(storageException.getMessage());
            System.exit(-1);
        }
        catch (Exception e) {
            System.out.print("Exception encountered: ");
            System.out.println(e.getMessage());
            System.exit(-1);
        }
		
		return fileUrl;
    } 
    
   
    
    @Override
    public String storePhoto(MultipartFile file) {
    	
    	String fileUrl = null;
    	
		try {
			CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionString);
            CloudBlobClient serviceClient = account.createCloudBlobClient();

            // Container name must be lower case.
            CloudBlobContainer container = serviceClient.getContainerReference(blobImageContainer);
            container.createIfNotExists();
            
            String path = StringUtils.cleanPath(file.getOriginalFilename());
            File sourceFile = new File(path);
            String filename = sourceFile.getName();
     
            // Define the path to a local file.
            final String filePath = "<Enter-Your-Local-File-Path>" + filename;
            
            // Upload an image file.
            CloudBlockBlob blob = container.getBlockBlobReference(filename);
            File imagePath = new File(filePath);
            blob.upload(new FileInputStream(imagePath), imagePath.length());
            fileUrl = blob.getUri().toString();

        }
        catch (FileNotFoundException fileNotFoundException) {
            System.out.print("FileNotFoundException encountered: ");
            System.out.println(fileNotFoundException.getMessage());
            System.exit(-1);
        }
        catch (StorageException storageException) {
            System.out.print("StorageException encountered: ");
            System.out.println(storageException.getMessage());
            System.exit(-1);
        }
        catch (Exception e) {
            System.out.print("Exception encountered: ");
            System.out.println(e.getMessage());
            System.exit(-1);
        }
		
		return fileUrl;
    }
    
    
    @Override
    public String getBlobVideoUrl(String filename)
    {
    	String fileUrl = null;
    	
    	try
    	{
    	    // Retrieve storage account from connection-string.
    	    CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

    	    // Create the blob client.
    	    CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

    	    // Retrieve reference to a previously created container.
    	    CloudBlobContainer container = blobClient.getContainerReference(blobVideoContainer);
    	    
    	    // Get blob file within the container and output the URI 
    	    if( container.getBlockBlobReference(filename).exists())
    	    {
    	    	CloudBlockBlob blobItem = container.getBlockBlobReference(filename); 
    	    	fileUrl = blobItem.getUri().toString();
    	    	System.out.println("This is outside the loop" + blobItem.getUri().toString());
    	    }
    	
    	}
    	catch (Exception e)
    	{
    	    // Output the stack trace.
    	    e.printStackTrace();
    	}
    	
    	  return fileUrl;
    }
    
    
    @Override
    public String getBlobPhotoUrl(String filename)
    {
    	String fileUrl = null;
    	
    	try
    	{
    	    // Retrieve storage account from connection-string.
    	    CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

    	    // Create the blob client.
    	    CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

    	    // Retrieve reference to a previously created container.
    	    CloudBlobContainer container = blobClient.getContainerReference(blobImageContainer);
    	    
    	    
    	    // Get blob file within the container and output the URI 
    	    if( container.getBlockBlobReference(filename).exists())
    	    {
    	    	CloudBlockBlob blobItem = container.getBlockBlobReference(filename); 
    	    	fileUrl = blobItem.getUri().toString();
    	    }
    	         	
    	}
    	catch (Exception e)
    	{
    	    // Output the stack trace.
    	    e.printStackTrace();
    	}
    	
    	  return fileUrl;
    }
    
    
    @Override
    public String getBlobUrl(String filename, String containerName)
    {
    	String fileUrl = null;
    	
    	try
    	{
    	    // Retrieve storage account from connection-string.
    	    CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

    	    // Create the blob client.
    	    CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

    	    // Retrieve reference to a previously created container.
    	    CloudBlobContainer container = blobClient.getContainerReference(containerName);
    	    
    	    
    	    // Get blob file within the container and output the URI 
    	    if( container.getBlockBlobReference(filename).exists())
    	    {
    	    	CloudBlockBlob blobItem = container.getBlockBlobReference(filename); 
    	    	fileUrl = blobItem.getUri().toString();
    	    }
    	         	
    	}
    	catch (Exception e)
    	{
    	    // Output the stack trace.
    	    e.printStackTrace();
    	}
    	
    	  return fileUrl;
    }
    
    
    @Override
    public void setBlobPhotoMetaData(String url, String key, String value)
    {
    	HashMap<String, String > metadata = new HashMap<String, String>();
    	metadata.put(key, value);
    	
    	try
    	{
    	    // Retrieve storage account from connection-string.
    	    CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);
    	    

            Calendar now = Calendar.getInstance();
            now.add(Calendar.HOUR, 24);
    	    
    	    // Create a new access policy for the account.
    	    SharedAccessAccountPolicy policy = new SharedAccessAccountPolicy();
    	    policy.setPermissions(EnumSet.of(SharedAccessAccountPermissions.READ, SharedAccessAccountPermissions.WRITE, SharedAccessAccountPermissions.LIST, SharedAccessAccountPermissions.CREATE));
    	    policy.setServices(EnumSet.of(SharedAccessAccountService.BLOB));
    	    policy.setResourceTypes(EnumSet.of(SharedAccessAccountResourceType.SERVICE));
    	    policy.setProtocols(SharedAccessProtocols.HTTPS_ONLY);
    	    policy.setSharedAccessExpiryTime(now.getTime());
    	  
    	    storageAccount.generateSharedAccessSignature(policy);
    	    

    	    // Create the blob client.
    	    CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
    	    
       	    // Retrieve reference to a previously created container.
    	    CloudBlobContainer container = blobClient.getContainerReference(blobImageContainer);
    	    
    	    for (ListBlobItem blobItem : container.listBlobs()) {

    	    	String blobItemUrl = blobItem.getUri().toString().trim();
        	    if( blobItemUrl.equals( url.trim()) )
        	    {
        	    	String fName = getFileNameFromBlobURI(blobItem.getUri(), blobImageContainer);
        	    	if (blobItem instanceof CloudBlockBlob) {
            	    	CloudBlockBlob blob = container.getBlockBlobReference(fName); 

	        	    	blob.setMetadata(metadata);
	        	    	blob.uploadMetadata();
	        	    	blob.uploadProperties();
        	    	}
        	    }
    	    }
    	    

    	       	
    	}
    	catch (Exception e)
    	{
    	    // Output the stack trace.
    	    e.printStackTrace();
    	}
    }
    
    @Override
    public String getBlobPhotoByMetaData(String key, String value)
    {
    	String fileUrl = null;
    	HashMap<String, String > metadata = new HashMap<String, String>();

    	try
    	{
    	    // Retrieve storage account from connection-string.
    	    CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

    	    // Create the blob client.
    	    CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
    	    
       	    // Retrieve reference to a previously created container.
    	    CloudBlobContainer container = blobClient.getContainerReference(blobImageContainer);
    	    
    	    for (ListBlobItem blobItem : container.listBlobs()) {

    	    	String fName = getFileNameFromBlobURI(blobItem.getUri(), blobImageContainer);
    	    	if (blobItem instanceof CloudBlockBlob) {

        	    	CloudBlockBlob blob = container.getBlockBlobReference(fName); 
        	    	blob.downloadAttributes();
        	    	metadata = blob.getMetadata();
        	    	if(metadata != null)
        	    	{
        	    		if( (metadata.containsKey(key.trim())) && (metadata.containsValue(value.trim())) )
        	    		{
        	    			fileUrl = blob.getUri().toString();
        	    		}
        	    	}
      	    	  
        	    }
    	    }
       	 }
    	catch (Exception e)
    	{
    	    // Output the stack trace.
    	    e.printStackTrace();
    	}
    	
    	return fileUrl;
    }
    
    public String getFileNameFromBlobURI(URI uri, String containerName)
    {
        String urlStr = uri.toString();
        String keyword = "/"+containerName+"/";
        int index = urlStr.indexOf(keyword) + keyword.length();
        String filePath = urlStr.substring(index);
        return filePath;
    }



    
    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        }
        catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }
    
    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(path -> this.rootLocation.relativize(path));
        }
        catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }

    }
    
    @Override
	public  String downloadImageToBlob(String imageUrl, String filename) {
		
		String filePath = localFilePath.concat(filename);
		String blobUrl = null;
		
		try {
			
			URL url = new URL(imageUrl);
			InputStream is = url.openStream();
			OutputStream os = new FileOutputStream(filePath);
		
	
			byte[] b = new byte[2048];
			int length;
	
			while ((length = is.read(b)) != -1) {
				os.write(b, 0, length);
			}
	
			is.close();
			os.close();
			blobUrl = this.storeUnknownToBlob(filename);
		}
        catch (IOException e) {
        	
            throw new StorageException("Could not initialize storage", e);
        }
        
        return blobUrl;
	}
	
    @Override
	public String storeUnknownToBlob(String filename)
	{
		String filePath = localFilePath.concat(filename);
		String blobUrl = null;
		
        try
        {
			CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionString);
            CloudBlobClient serviceClient = account.createCloudBlobClient();

            CloudBlobContainer container = serviceClient.getContainerReference(unknownBlobImageContainer);
            container.createIfNotExists();
                  
            // Upload an image file
            File sourceFile = new File(filePath);
            CloudBlockBlob blob = container.getBlockBlobReference(filename);
            blob.upload(new FileInputStream(sourceFile), sourceFile.length());   
            blobUrl = getBlobUrl(filename, unknownBlobImageContainer);
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.out.print("FileNotFoundException encountered: ");
            System.out.println(fileNotFoundException.getMessage());
            System.exit(-1);
        }
        catch (StorageException storageException) {
            System.out.print("StorageException encountered: ");
            System.out.println(storageException.getMessage());
            System.exit(-1);
        }
        catch (Exception e) {
            System.out.print("Exception encountered: ");
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        
        return blobUrl;
	}

    

}
