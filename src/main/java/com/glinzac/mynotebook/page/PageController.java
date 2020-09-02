package com.glinzac.mynotebook.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinzac.mynotebook.models.RequestModel;
import com.glinzac.mynotebook.models.ResponseData;

@RestController
@RequestMapping(value = "/page")
public class PageController {
	
	@Autowired
	PageService service;
	
	
	/**
	 * add a new page into folder
	 * @param model
	 * @return
	 */
	@PostMapping("/addPage")
	public ResponseData addNewPage(@RequestBody RequestModel model) {
		String section = model.getValue().get("sectionName").asText();
		String fileName = model.getValue().get("pageName").asText();
		return service.addPage(section,fileName);
	}
	
	/**
	 * rename the page in a section
	 * @param model
	 * @return
	 */
	@PutMapping("/editPage")
	public ResponseData renamePage(@RequestBody RequestModel model) {
		String section = model.getValue().get("sectionName").asText();
		String oldName = model.getValue().get("oldName").asText();
		String newName = model.getValue().get("newName").asText();
		return service.editPage(section, oldName, newName);
	}
	
	
	
	/**
	 * get all the pages in a section
	 * @param model
	 * @return
	 */
	@GetMapping("/getPages/{section}")
	public ResponseData getAllPages(@PathVariable String section) {
		return service.getPages(section);
	}
	
	
	/**
	 * delete a page in a section
	 * @param section
	 * @param fileName
	 * @return
	 */
	@DeleteMapping("/deletePage/{section}/{fileName}")
	public ResponseData deletePage(@PathVariable String section, @PathVariable String fileName) {
		return service.deletePage(section, fileName);
	}

}
