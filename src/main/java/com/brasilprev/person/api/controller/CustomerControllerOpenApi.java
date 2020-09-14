package com.brasilprev.person.api.controller;

import java.util.List;

import com.brasilprev.person.api.exceptionhandler.Problem;
import com.brasilprev.person.api.model.CustomerModel;
import com.brasilprev.person.api.model.CustomerSummaryModel;
import com.brasilprev.person.api.model.input.CustomerInputModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Costumers")
public interface CustomerControllerOpenApi {
	
	@ApiOperation("Listing all customers")
	public List<CustomerSummaryModel> list();
		
	@ApiOperation("Finding a customer by id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Customer nof found", response = Problem.class)
	})
	public CustomerModel find(
			@ApiParam(value = "customer identification", example = "1", required = true) 
			Long customerId);
	
	@ApiOperation("Recording a costumer")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Successfully registered customer"),
		@ApiResponse(code = 404, message = "Customer nof found", response = Problem.class)
	})
	public CustomerModel save(
			@ApiParam(name = "body", value = "Representation of a new customer", required = true) 
			CustomerInputModel customerInputModel);
	
	@ApiOperation("Updating a customer by id")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Customer successfully updated"),
		@ApiResponse(code = 404, message = "Customer nof found", response = Problem.class)
	})
	public CustomerModel update(
			@ApiParam(value = "customer identification", example = "1", required = true) 
			Long customerId, 
			@ApiParam(name = "body", value = "Representation of a customer with new data", required = true) 
			CustomerInputModel customerInputModel);
	
	@ApiOperation("Deleting a customer by id")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Customer successfully deleted"),
		@ApiResponse(code = 404, message = "Customer nof found", response = Problem.class)
	})
	public void delete(
			@ApiParam(value = "customer identification", example = "1", required = true)
			Long customerId);
	
}
