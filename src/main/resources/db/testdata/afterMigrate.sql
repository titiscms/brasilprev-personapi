SET foreign_key_checks = 0;

DELETE FROM customer;

SET foreign_key_checks = 1;

ALTER TABLE customer AUTO_INCREMENT = 1;

INSERT INTO customer 
(name, cpf, address_zip_code, address_address_line_1, address_number, address_address_line_2, address_region, address_city, address_province) 
VALUES
('Thiago Costa', '91415828024', '29032-311', 'Rua Sebastião Lúcio Cardoso', '940', 'apto 71/bloco 51', 'Jardim Planalto Verde', 'Cotia', 'São Paulo'),
('Joao Silva', '31085356094', '09600004', 'Avenida Senador Vergueiro', '142', '', 'Anchieta', 'São Bernardo do Campo', 'São Paulo'),
('Maria Aparecida', '40848634080', '08230413', 'Avenida Padre Gregório Mafra', '992', 'apto 118', 'Vila Taquari', 'São Paulo', 'São Paulo'),
('Ana Carvalho', '86334495011', '18046684', 'Rua Caetanina Passarelli Graziosi', '419', '', 'Jardim Eltonville', 'Sorocaba', 'São Paulo');