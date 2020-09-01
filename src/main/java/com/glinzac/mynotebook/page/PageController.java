package com.glinzac.mynotebook.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.glinzac.mynotebook.models.RequestModel;
import com.glinzac.mynotebook.models.ResponseData;

@RestController
public class PageController {
	
	@Autowired
	PageService service;
	
	
//	addNewPage
	/**
	 * add a new page into folder
	 * @param model
	 * @return
	 */
	public ResponseData addNewPage(@RequestBody RequestModel model) {
		String section = model.getValue().get("sectionName").asText();
		String fileName = model.getValue().get("pageName").asText();
		return service.addPage(section,fileName);
	}
	
//	editPage
//	getAllPages
//	deletePage

}
