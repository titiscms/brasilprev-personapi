package com.brasilprev.person.api.exceptionhandler;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Problem {

	private Integer status;
	
	private String type;

	private String title;
	
	private String detail;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
	private OffsetDateTime timestamp;
	
}


