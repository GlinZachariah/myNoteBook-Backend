package com.glinzac.mynotebook.section;

import java.io.File;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.glinzac.mynotebook.models.Response;
import com.glinzac.mynotebook.models.ResponseData;

@Service
public class SectionService {
	
	 static final String ROOT_PATH = "C:\\";
	 static final String ROOT_FILE_NAME = "myNotebook";

	 

	public ResponseData saveNewSection(String name) {
		File file = new File( ROOT_PATH + ROOT_FILE_NAME );
		if(!file.exists()) {
			boolean status = file.mkdir();
			if(status)
				System.out.println("Root Folder Created");
			else
				System.out.println("ERROR CREATING ROOT FOLDER");
		}
		File currentFolder = new File( ROOT_PATH + ROOT_FILE_NAME + "\\"+name);
		boolean status = currentFolder.mkdir();
		if(status)
			System.out.println( name + " Folder Created");
		else
			System.out.println("ERROR CREATING "+ name +" FOLDER");
		return new ResponseData(new Response("CREATED"),HttpStatus.ACCEPTED);
	}

}
