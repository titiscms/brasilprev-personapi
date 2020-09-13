CREATE TABLE customer (
	id BIGINT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	cpf VARCHAR(11) NOT NULL,
	
	address_zip_code VARCHAR(10) NOT NULL,
	address_address_line_1 VARCHAR(255) NOT NULL,
	address_number VARCHAR(10) NOT NULL,
	address_address_line_2 VARCHAR(255),
	address_region VARCHAR(50) NOT NULL,
	address_city VARCHAR(40) NOT NULL,
	address_province VARCHAR(30) NOT NULL,
	
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;