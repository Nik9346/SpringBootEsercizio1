package it.esercizio.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertitoreServiceImpl implements ConvertitoreService {

	@Override
	public String convertiKelvin(String gradiCelsius) {
		// Sostituisco l'input ',' in '.' per evitare errori
		gradiCelsius = gradiCelsius.replace(',', '.');
		double gradi = Double.parseDouble(gradiCelsius);
		double gradiKelvin = gradi + 273.15;
		String gradiKelvinString = Double.toString(gradiKelvin);
		return gradiKelvinString;

	}

	@Override
	public String convertiFarhenheit(String gradiCelsius) {
		// Sostituisco l'input ',' in '.' per evitare errori
		gradiCelsius = gradiCelsius.replace(',', '.');
		double gradi = Double.parseDouble(gradiCelsius);
		double gradiFahrenheit = (gradi * 1.8) + 32;
		String gradiFahrenheitString = Double.toString(gradiFahrenheit);
		return gradiFahrenheitString;
	}

}
