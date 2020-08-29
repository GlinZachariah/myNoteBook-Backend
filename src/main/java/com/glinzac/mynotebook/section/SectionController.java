package com.glinzac.mynotebook.section;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinzac.mynotebook.models.RequestModel;
import com.glinzac.mynotebook.models.ResponseData;

@RestController
@RequestMapping(path = "/section")
public class SectionController {
	
	@Autowired
	SectionService service;


	/**
	 * add a new section
	 * @param model
	 * @return
	 */
	@PostMapping(path = "/addNewSection")
	public ResponseData addNewSection(@RequestBody RequestModel model) {
		return service.saveNewSection(model.value.toString());
	}
//	getSection
	
	/** 
	 * get all the existing section details
	 * @return
	 */
	@GetMapping("/getSectionDetails")
	public ResponseData getSectionDetails() {
		return service.getSectionDetails();
	}
//	deleteSection
	
	/**
	 * @param model
	 * @return
	 */
	@PostMapping("/deleteSection")
	public ResponseData deleteSection(@RequestBody RequestModel model) {
		return service.deleteSection(model.getValue().toString());
	}
//	editSection
	
	
}
