package com.glinzac.mynotebook.page;

import java.io.File;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.glinzac.mynotebook.models.Response;
import com.glinzac.mynotebook.models.ResponseData;

@Service
public class PageService {
	
	static final String ROOT_PATH = "C:\\";
	static final String ROOT_FILE_NAME = "myNotebook";
	
	public ResponseData addPage(String section , String pageName) {
		File newFile = new File( ROOT_PATH + ROOT_FILE_NAME + "\\"+section+"\\"+pageName+".html");
		try {
			boolean status = newFile.createNewFile();
			if(status)
				return new ResponseData(new Response("FILE CREATED"),HttpStatus.CREATED);
			else
				return new ResponseData(new Response("ERROR"),HttpStatus.FORBIDDEN);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return new ResponseData(new Response("ERROR"),HttpStatus.FORBIDDEN);
	}
	
	

}
