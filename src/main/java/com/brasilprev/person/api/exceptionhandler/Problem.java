package com.brasilprev.person.api.exceptionhandler;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Problem {

	@ApiModelProperty(example = "400", position = 1)
	private Integer status;
	
	@ApiModelProperty(example = " http://localhost:8080/invalid-data", position = 5)
	private String type;

	@ApiModelProperty(example = "The request contains invalid data", position = 10)
	private String title;
	
	@ApiModelProperty(example = "One or more invalid fields. Check your request and try again.", position = 15)
	private String detail;
	
	@ApiModelProperty(example = "2020-09-14T11:00:09-03:00", position = 25)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
	private OffsetDateTime timestamp;
	
}


