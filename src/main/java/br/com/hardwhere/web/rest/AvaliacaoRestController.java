package br.com.hardwhere.web.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
@RequestMapping(value = "/avaliacoes", produces = MediaType.APPLICATION_JSON_VALUE)
public class AvaliacaoRestController {

	
}
