package com.inmetrics;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.inmetrics.model.Celular;
import com.inmetrics.model.Contratante;
import com.inmetrics.model.Contrato;
import com.inmetrics.repository.CelularRepository;
import com.inmetrics.repository.ContratanteRepository;
import com.inmetrics.repository.ContratoRepository;

@SpringBootApplication
public class InmetricsApplication implements CommandLineRunner{

	@Autowired
	private ContratanteRepository contratanteRepository;
	
	@Autowired
	private CelularRepository celularRepository;
	
	@Autowired
	private ContratoRepository contratoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(InmetricsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Contratantes
		Contratante contratante = new Contratante(1L, "RG 1809060507", 25, "21 9999-8888", 12);
		Contratante contratante2 = new Contratante(2L, "RG 231321321", 40, "21 8888 - 99999", 2);
		
		contratanteRepository.saveAll(Arrays.asList(contratante, contratante2));
		
		//Celulares
		Celular celular = new Celular(1L, "012345", "Samsung S10", "4500,00", 123, contratante);
		Celular celular2 = new Celular(2L, "012345", "Samsung S08", "2800,00", 456, contratante);
		
		celularRepository.saveAll(Arrays.asList(celular, celular2));
		
		//Contratos
		LocalDateTime mesPassado = LocalDateTime.now();
		Contrato  contrato = new Contrato(1L, mesPassado.minusDays(30), contratante);
		contratoRepository.saveAll(Arrays.asList(contrato));
		
	}
	

}
