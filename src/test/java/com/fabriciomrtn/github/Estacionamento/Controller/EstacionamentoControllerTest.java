package com.fabriciomrtn.github.Estacionamento.Controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import com.fabriciomrtn.github.Estacionamento.DTO.EstacionamentoCreateDTO;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EstacionamentoControllerTest extends AbstractContainerBase{

	@LocalServerPort
	private int randomPort;

	@BeforeEach
	public void setUpTest() {
		System.out.println(randomPort);
		RestAssured.port = randomPort;
	}

	@Test
	void quandoUtilizarFindAllVerifiqueOResultado() {
		RestAssured.given()
		.when()
		.get("/parking")
		.then()
		.statusCode(HttpStatus.OK.value())
		.body("placa[0]", Matchers.equalTo("DMS-1111"));

	}

	@Test
	void quandoUtilizarCreateVerificaSeFoiCriadoObjeto() {
		var createDTO = new EstacionamentoCreateDTO();
		createDTO.setCor("VERMELHO");
		createDTO.setPlaca("FZO-1234");
		createDTO.setModelo("SUBARU");
		createDTO.setEstado("AM");
		
		RestAssured.given()
		.when()
		.contentType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
		.body(createDTO)
		.post("/parking")
		.then()
		.statusCode(HttpStatus.CREATED.value())
		.body("placa", Matchers.equalTo("FZO-1234"));
	}

}
