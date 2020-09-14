package com.brasilprev.person.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerSummaryModel {

	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "Thiago Costa")
	private String name;
	
	@ApiModelProperty(example = "80477649009")
	private String cpf;
	
}
