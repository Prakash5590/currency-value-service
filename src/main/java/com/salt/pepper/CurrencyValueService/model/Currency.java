package com.salt.pepper.CurrencyValueService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="Currency_Values")
public class Currency {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String fromCurrencyType;
	private String toCurrencyType;
	private int currencyValue;
	@Transient
	private int convertedValue;
	@Transient
	private String instance;
	
}
