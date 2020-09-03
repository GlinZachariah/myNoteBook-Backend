package com.glinzac.mynotebook.editor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.glinzac.mynotebook.models.Response;
import com.glinzac.mynotebook.models.ResponseData;

@Service
public class EditorService {
	
	static final String ROOT_PATH = "C:\\";
	static final String ROOT_FILE_NAME = "myNotebook";

	public ResponseData getFile(String sectionName, String pageName) {
		String data = "";
		File fileData = new File( ROOT_PATH + ROOT_FILE_NAME + "\\"+sectionName+"\\"+pageName+".html");
		try {
			Scanner scan = new Scanner(fileData);
			while(scan.hasNextLine()) {
				data += scan.nextLine();
			}
			Response response = new Response("DATA FOUND");
			response.setPayLoad(data);
			scan.close();
			return new ResponseData(response,HttpStatus.OK);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new ResponseData(new Response("ERROR"),HttpStatus.FORBIDDEN);
	}

	public ResponseData updateFile(String sectionName, String pageName, String data) {
		File fileData = new File( ROOT_PATH + ROOT_FILE_NAME + "\\"+sectionName+"\\"+pageName+".html");
		try {
			FileWriter fileOps = new FileWriter(fileData);
			fileOps.write(data);
			fileOps.close();
			return new ResponseData(new Response("UPDATED"),HttpStatus.OK);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return new ResponseData(new Response("ERROR"),HttpStatus.FORBIDDEN);
	}
}