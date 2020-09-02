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
			if(status) {
				System.out.println( pageName+" created in folder "+section);
				return new ResponseData(new Response("FILE CREATED"),HttpStatus.CREATED);
			}	
			else
				return new ResponseData(new Response("ERROR"),HttpStatus.FORBIDDEN);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return new ResponseData(new Response("ERROR"),HttpStatus.FORBIDDEN);
	}
	
	
	public ResponseData deletePage(String section , String pageName) {
		File newFile = new File( ROOT_PATH + ROOT_FILE_NAME + "\\"+section+"\\"+pageName+".html");
		boolean status = newFile.delete();
		if(status) {
			System.out.println( pageName+" deleted in folder "+section);
			return new ResponseData(new Response("FILE DELETED"),HttpStatus.OK);
		}	
		
		return new ResponseData(new Response("ERROR"),HttpStatus.FORBIDDEN);
	}
	
	public ResponseData editPage(String section , String oldName, String newName) {
		File oldFile = new File( ROOT_PATH + ROOT_FILE_NAME + "\\"+section+"\\"+oldName+".html");
		File newFile = new File( ROOT_PATH + ROOT_FILE_NAME + "\\"+section+"\\"+newName+".html");
		boolean status = oldFile.renameTo(newFile);
		if(status) {
			System.out.println( oldName+" renamed to "+newName+" in folder "+section);
			return new ResponseData(new Response("FILE RENAMED"),HttpStatus.OK);
		}	
		
		return new ResponseData(new Response("ERROR"),HttpStatus.FORBIDDEN);
	}
	
	public ResponseData getPages(String section) {
		File file = new File( ROOT_PATH + ROOT_FILE_NAME + "\\"+section);
		String[] entries = file.list();
		
		if(entries.length == 0) {
			return new ResponseData(new Response("EMPTY"),HttpStatus.OK);
		}else {
			Response response = new Response("NOT EMPTY");
			String[] result = new String[entries.length];
			for(int i=0;i<entries.length;i++) {
				result[i] = entries[i].substring(0, entries[i].length()-5);
			}
			response.setPayLoad(result);
			return new ResponseData(response,HttpStatus.OK);
		}	
	}
	
	
	
	
	

}
