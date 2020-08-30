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
		File currentFolder = new File( ROOT_PATH + ROOT_FILE_NAME + "\\"+name);
		boolean status = currentFolder.mkdir();
		if(status)
			System.out.println( name + " Folder Created");
		else {
			System.out.println("ERROR CREATING "+ name +" FOLDER");
			return new ResponseData(new Response("ERROR"),HttpStatus.FORBIDDEN);
		}
		return new ResponseData(new Response("CREATED"),HttpStatus.CREATED);
	}
	
	
	
	public ResponseData getSectionDetails() {
		File file = new File( ROOT_PATH + ROOT_FILE_NAME );
		if(!file.exists()) {
			boolean status = file.mkdir();
			if(status) {
				System.out.println("Root Folder Created");
				return new ResponseData(new Response("EMPTY"),HttpStatus.OK);
			}else
				System.out.println("ERROR CREATING ROOT FOLDER");
		}else {
			String[] filesList = file.list();
			if(filesList.length == 0) {
				return new ResponseData(new Response("EMPTY"),HttpStatus.OK);
			}else {
				Response response = new Response("NOT EMPTY");
				response.setPayLoad(filesList);
				return new ResponseData(response,HttpStatus.OK);
			}
			
		}
		return new ResponseData(new Response("ERROR"),HttpStatus.FORBIDDEN);
	}
	
	
	public ResponseData deleteSection(String sectionName) {
		File file = new File( ROOT_PATH + ROOT_FILE_NAME +"\\"+ sectionName);
		System.out.println(ROOT_PATH + ROOT_FILE_NAME +"\\"+ sectionName);
		String[] entries = file.list();
		if(entries.length > 0) {
			for(String s: entries){
			    File currentFile = new File(file.getPath(),s);
			    boolean status = currentFile.delete();
			    if(!status)
			    	return new ResponseData(new Response("ERROR"),HttpStatus.FORBIDDEN);
			}
		}
		boolean folder = file.delete();
		if(!folder)
			return new ResponseData(new Response("ERROR"),HttpStatus.FORBIDDEN);
		else
			return new ResponseData(new Response("DELETED"),HttpStatus.OK);
		
	}
	
	public ResponseData renameSection(String oldName,String newName) {
		File oldfile = new File( ROOT_PATH + ROOT_FILE_NAME +"\\"+ oldName);
		File newfile = new File( ROOT_PATH + ROOT_FILE_NAME +"\\"+ newName);
		boolean folder = oldfile.renameTo(newfile);
//		System.out.println(oldfile + "\n"+newfile);
		if(!folder)
			return new ResponseData(new Response("ERROR"),HttpStatus.FORBIDDEN);
		else
			return new ResponseData(new Response("RENAMED"),HttpStatus.OK);
		
	}

}
