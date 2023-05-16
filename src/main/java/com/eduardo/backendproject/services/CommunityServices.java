package com.eduardo.backendproject.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.eduardo.backendproject.controllers.dto.ImagesDto;
import com.eduardo.backendproject.controllers.dto.MessageDto;

@Service
public class CommunityServices {
	
	public List <MessageDto> getCommMessages(int pages){
		return Arrays.asList(new MessageDto(1L,"primer mensaje"), 
				new MessageDto(2L, "segundo mensaje"));
	}
	
	public List <ImagesDto> getImages(int page){
		return Arrays.asList(new ImagesDto (1L,"imagen 1", null), 
				new ImagesDto(2L, "imagen 2", null));
	}
	
	public MessageDto postMessages(MessageDto messageDto){
		return new MessageDto(3L, "Nuevo mensaje");
	}
	
	public ImagesDto postImages (MultipartFile multipartFile, String titulo){
		return new ImagesDto(3L, "Nueva imagen", null);
	}

}
