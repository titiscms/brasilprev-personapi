package com.brasilprev.person.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

	SYSTEM_ERROR("/system-error", "The system has an error"),
	INVALID_DATA("/invalid-data", "The request contains invalid data"),
	RESOURCE_NOT_FOUND("/resource-not-found", "Resource not found");
	
	private String title;
	private String uri;
	
	ProblemType(String path, String title) {
		this.uri = "http://localhost:8080" + path;
		this.title = title;
	}
	
}
