package com.salt.pepper.CurrencyValueService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.salt.pepper.CurrencyValueService.model.Currency;
import com.salt.pepper.CurrencyValueService.repo.CurrencyValueRepo;

@Service
public class CurrencyValueService {
	@Autowired
	private CurrencyValueRepo currencyValueRepo;
	@Autowired
	Environment environment;
	
	public Currency getCurrencyObject(Currency currency) {
		Currency updatedCur = currencyValueRepo.getCurrencyFromType(currency.getFromCurrencyType(),currency.getToCurrencyType());
		updatedCur.setInstance(environment.getProperty("server.port"));
		return updatedCur;
	}
	
	public void saveCurrency(Currency currency) {
		currencyValueRepo.save(currency);
	}
}
