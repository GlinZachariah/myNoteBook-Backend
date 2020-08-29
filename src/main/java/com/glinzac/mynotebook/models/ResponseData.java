package com.glinzac.mynotebook.models;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseData extends ResponseEntity<Response> {

	public ResponseData(Response body, HttpStatus status) {
		super(body, status);
	}

}
