package com.brasilprev.person.api.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.brasilprev.person.api.assembler.CustomerModelAssembler;
import com.brasilprev.person.api.assembler.CustomerModelDisassembler;
import com.brasilprev.person.api.assembler.CustomerSummaryModelAssembler;
import com.brasilprev.person.domain.model.Address;
import com.brasilprev.person.domain.model.Customer;
import com.brasilprev.person.domain.repository.CustomerRepository;
import com.brasilprev.person.domain.service.CustomerRegistrationService;

import io.restassured.http.ContentType;

@WebMvcTest
public class CustomerControllerTest {

	@Autowired
	private CustomerController customerController;
	
	@MockBean
	private CustomerRepository customerRepository;
	
	@MockBean
	private CustomerRegistrationService customerRegistrationService;
	
	@MockBean
	private CustomerSummaryModelAssembler customerSummaryModelAssembler;
	
	@MockBean
	private CustomerModelAssembler customerModelAssembler;
	
	@MockBean
	private CustomerModelDisassembler customerModelDisassembler;

	@BeforeEach
	public void setup() {
		standaloneSetup(this.customerController);
	}
	
	@Test
	public void shouldReturnSuccess_WhenFindCustomerExist() {
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/customers/{customerId}", 1L)
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void shouldReturnCreated_WhenRecordCustomer() {
		Customer customer = createCustomer();
		
		given()
			.contentType(ContentType.JSON)
			.body(customer)
		.when()
			.post("/customers")
		.then()
			.statusCode(HttpStatus.CREATED.value());
	}
	
	@Test
	public void shouldReturnBadRequest_WhenRecordCustomerWithoudPropertyRequired() {
		Customer customer = new Customer();
		customer.setId(2L);
		customer.setName("Thiago");
		customer.setCpf("61957652870");
		
		given()
			.contentType(ContentType.JSON)
			.body(customer)
		.when()
			.post("/customers")
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value());
	}
	
	@Test
	public void shouldReturnSuccess_WhenUpdateCustomer() {
		Customer customer = createCustomer();
		
		given()
			.contentType(ContentType.JSON)
			.body(customer)
		.when()
			.put("/customers/{customerId}", customer.getId())
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void shouldReturnNoContent_WhenDeleteCustomer() {
		given()
			.accept(ContentType.JSON)
		.when()
			.delete("/customers/{customerId}", 1L)
		.then()
			.statusCode(HttpStatus.NO_CONTENT.value());
	}
		
	private Customer createCustomer() {
		Address address = new Address();
		address.setZipCode("11600975");
		address.setAddressLine_1("Rua Antônio Pereira da Silva");
		address.setNumber("935");
		address.setAddressLine_2("casa B");
		address.setRegion("Topolândia");
		address.setCity("São Sebastião");
		address.setProvince("São Paulo");
		
		Customer customer = new Customer();
		customer.setId(1L);
		customer.setName("Daniela Fernanda Larissa");
		customer.setCpf("81614123837");
		customer.setAddress(address);
		
		return customer;
	}

}