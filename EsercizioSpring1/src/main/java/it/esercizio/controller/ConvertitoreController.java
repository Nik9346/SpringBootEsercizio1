package it.esercizio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class ConvertitoreController {

	@GetMapping
	public String convertitore(Model model, @RequestParam(name = "gradi", required = false) String gradiCelsius) {
		String errore;
		try {
			double gradi = Double.parseDouble(gradiCelsius);
			double gradiFahrenheit = (gradi * 1.8) + 32;
			double gradiKelvin = gradi + 273.15;
			String gradiFahrenheitString = Double.toString(gradiFahrenheit);
			String gradiKelvinString = Double.toString(gradiKelvin);
			model.addAttribute("gradiFahrenheitString", gradiFahrenheitString);
			model.addAttribute("gradiKelvinString", gradiKelvinString);
			model.addAttribute("showDiv",true);
			return "convertitore";
		} catch (Exception e) {
			if(e instanceof NumberFormatException) {
				errore = "i dati inseriti non sono corretti";
				model.addAttribute("datiErrati",errore);
				model.addAttribute("showDiv", false);
			}else {
				errore = "I dati sono mancanti";
				model.addAttribute("datiErrati", errore);
			}
			return "convertitore";
		}
	}
	
}
