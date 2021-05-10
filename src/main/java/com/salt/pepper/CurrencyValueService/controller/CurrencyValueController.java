package com.salt.pepper.CurrencyValueService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.salt.pepper.CurrencyValueService.model.Currency;
import com.salt.pepper.CurrencyValueService.service.CurrencyValueService;

@RestController
public class CurrencyValueController {
	
	@Autowired
	private CurrencyValueService service;
	
	@GetMapping("/convert/from/{from}/to/{to}")
	public ResponseEntity<Currency> convert(@PathVariable String from , @PathVariable String to) {
		System.out.println("In controller from : "+from +" to :"+to);
		Currency curr = new Currency();
		curr.setFromCurrencyType(from);
		curr.setToCurrencyType(to);
		Currency updated = service.getCurrencyObject(curr);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updated);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Currency> saveCurrencyValue(@RequestBody Currency currency){
		service.saveCurrency(currency);
		return ResponseEntity.status(HttpStatus.CREATED).body(currency);
	}
}
