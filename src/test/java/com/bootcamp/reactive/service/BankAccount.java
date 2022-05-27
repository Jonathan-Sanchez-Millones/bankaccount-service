package com.bootcamp.reactive.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.bootcamp.reactive.common.CustomerPersonal;
import com.bootcamp.reactive.controller.BankAccountController;
import com.bootcamp.reactive.dto.BankAccountDto;
import com.bootcamp.reactive.dto.CustomerDto;
import com.bootcamp.reactive.dto.OperationDto;
import com.bootcamp.reactive.entity.BankAccountAhorro;
import com.bootcamp.reactive.entity.BankAccountCorriente;
import com.bootcamp.reactive.entity.BankAccountPlazoFijo;
import com.bootcamp.reactive.service.BankAccountService;

import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@WebFluxTest(BankAccountService.class)
public class BankAccount {
	
	@MockBean
	BankAccountService service;
	
	@Autowired
	private WebTestClient webClient;
	
	@Test
	public void saveBankAccountPlazoFij() {
	
	CustomerDto customer =  new CustomerDto(null, null, null, 0, 0, null);
	List<BankAccountCorriente> bankcorriente = new ArrayList<>();
	bankcorriente.add(new BankAccountCorriente(null, 0, 0, 0, null));
	BankAccountAhorro ahorro = new BankAccountAhorro(null, 0, 0, 0, null);
	BankAccountPlazoFijo fijo = new BankAccountPlazoFijo(null, 0, 0, 0, null);
	
	Mono<BankAccountDto> custmer = Mono.just( new BankAccountDto(customer,bankcorriente,ahorro,fijo));
	
	Mono<CustomerPersonal> cliente= Mono.just(new CustomerPersonal(null, null, null, 0, 0, null, null, null));
	
	when(service.saveBankAccountPlazoFijo(custmer)).thenReturn(cliente);
		
		//webClient.post().uri("/bankaccount/plazofijo")
			//.body(Mono.just(custmer), CustomerPersonal.class).exchange().expectStatus().isOk();
	}
	
	@Test
	public void doOperationAhorro() {
		
		Mono<OperationDto> operation = Mono.just(new OperationDto(null, 0, 0));
		
		Mono<BankAccountAhorro> bankAhorr0 = Mono.just(new BankAccountAhorro(null, 0, 0, 0, null));
		
		when(service.doOperationAhorro(operation)).thenReturn(bankAhorr0);
	}
	
	@Test
	public void doOperationCorriente() {
		Mono<BankAccountCorriente> corrient= Mono.just(new BankAccountCorriente(null, 0, 0, 0, null));
		
		Mono<OperationDto> operation = Mono.just(new OperationDto(null, 0, 0));
		
		when(service.doOperationCorriente(operation)).thenReturn(corrient);
	}
	
	@Test
	public void doOperationPlazoFijo(){
		Mono<BankAccountPlazoFijo> plazofijo= Mono.just(new BankAccountPlazoFijo(null, 0, 0, 0, null));
		
		Mono<OperationDto> operation = Mono.just(new OperationDto(null, 0, 0));
		
		when(service.doOperationPlazoFijo(operation)).thenReturn(plazofijo);
	}
	

}
