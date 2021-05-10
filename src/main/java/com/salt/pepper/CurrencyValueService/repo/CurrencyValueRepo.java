package com.salt.pepper.CurrencyValueService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.salt.pepper.CurrencyValueService.model.Currency;

@Repository
public interface CurrencyValueRepo extends JpaRepository<Currency, Integer>{
	@Query("Select c from Currency c WHERE LOWER(c.fromCurrencyType)= LOWER(:fromCurrencyType) AND LOWER(c.toCurrencyType) = LOWER(:toCurrencyType)")
	public Currency getCurrencyFromType(@Param("fromCurrencyType") String fromCurrencyType,@Param("toCurrencyType") String toCurrencyType);
}
