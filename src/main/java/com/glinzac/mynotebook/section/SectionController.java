package com.glinzac.mynotebook.section;

import org.springframework.beans.factory.annotation.Autowired;
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
	 * add a new Section
	 * @return ResponseData
	 */
	@PostMapping(path = "/addNewSection")
	public ResponseData addNewSection(@RequestBody RequestModel model) {
		return service.saveNewSection(model.value.toString());
	}
//	getSection
//	editSection
}
