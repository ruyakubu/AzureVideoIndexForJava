package com.video.demo.service;

import java.net.URI;
import org.springframework.web.multipart.MultipartFile;

import com.video.demo.DTO.FaceDTO;
import com.video.demo.DTO.VideoBreakDownDTO;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface BlobStorageService {

    void init();

    String storeVideo(VideoBreakDownDTO videoDetails);
    
    String storePhoto(MultipartFile file);
    
    String storePhoto(FaceDTO faceDto);
    
    String storeUnknownToBlob(String filename);
      
    String getBlobPhotoUrl(String filename);
    
    String getBlobVideoUrl(String filename);
    
    String getBlobUrl(String filename, String containerName);
    
    String downloadImageToBlob(String imageUrl, String filename); 
        
    void setBlobPhotoMetaData(String url, String key, String value);
    
    String getBlobPhotoByMetaData(String key, String value);
    
    String getFileNameFromBlobURI(URI uri, String containerName);
    
    Stream<Path> loadAll();
}
