package com.eduardo.backendproject.controllers;

import java.awt.Image;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.message.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.eduardo.backendproject.controllers.dto.ImagesDto;
import com.eduardo.backendproject.controllers.dto.MessageDto;
import com.eduardo.backendproject.services.CommunityServices;

@RestController
@RequestMapping("/v1.0/community")
public class CommunityController {
	
	
	private final CommunityServices communityServices;
	
	public CommunityController (CommunityServices communityServices) {
		this.communityServices = communityServices;
	}
	
	@GetMapping("/messages")
	public ResponseEntity <List<MessageDto>> getCommunityMessages(
			@RequestParam(value="page", defaultValue = "0") int page) {
		return ResponseEntity.ok(communityServices.getCommMessages(page));
	}
	
	
	@GetMapping("/imagenes")
	public ResponseEntity<List<ImagesDto>> getCommunityImagenes(
			@RequestParam(value="page",defaultValue = "0") int page) {
		return ResponseEntity.ok(communityServices.getImages(page));
		
	}
	
	@PostMapping("/messages")
	public ResponseEntity<MessageDto> postMessages(@RequestBody MessageDto messageDto) {
		return  ResponseEntity.created(URI.create("/v1.0/community/messages"))
				.body(communityServices.postMessages(messageDto));
	}
	
	@PostMapping("/imagenes")
	public ResponseEntity<ImagesDto> postImagenes(@RequestParam MultipartFile file, 
			@RequestParam(value="title") String title ) {
		return  ResponseEntity.created(URI.create("/v1.0/community/images"))
				.body(communityServices.postImages(file, title));
	}
	
}
