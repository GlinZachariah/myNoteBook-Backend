package com.glinzac.mynotebook.models;

import com.fasterxml.jackson.databind.JsonNode;

public class RequestModel {
	public String key;
	public JsonNode value;
	
	public String getKey() {
		return key;
	}
	public JsonNode getValue() {
		return value;
	}
	
	

}
