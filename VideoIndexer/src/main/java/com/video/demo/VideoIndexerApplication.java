package com.video.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.video.demo.helper.StorageProperties;
import com.video.demo.service.BlobStorageService;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class VideoIndexerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoIndexerApplication.class, args);
	}
	
}
