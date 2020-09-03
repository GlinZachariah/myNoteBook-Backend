package com.glinzac.mynotebook.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinzac.mynotebook.models.RequestModel;
import com.glinzac.mynotebook.models.ResponseData;

@RestController
@RequestMapping(path = "/editor")
public class EditorController {
	
	@Autowired
	EditorService service;
	
	@GetMapping(path = "/getFile/{section}/{page}")
	public ResponseData getFile(@PathVariable String section, @PathVariable String page) {
		return service.getFile(section,page);
	}

	@PutMapping(path="/updateFile")
	public ResponseData editFile(@RequestBody RequestModel model) {
		String sectionName = model.getValue().get("section").asText();
		String pageName = model.getValue().get("page").asText();
		String data = model.getValue().get("data").asText();
		return service.updateFile(sectionName,pageName, data);
	}
}
