package it.esercizio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.esercizio.service.ConvertitoreService;
import it.esercizio.service.ConvertitoreServiceImpl;


@Controller
@RequestMapping("/")
public class ConvertitoreController {
	private static ConvertitoreService convertitoreService = new ConvertitoreServiceImpl();

	@GetMapping
	public String convertitore(Model model, @RequestParam(name = "gradi", required = false) String gradiCelsius) {
		//Istanzio una variabile Stringa errore
		String errore;
		
		try {
			//calcolo i gradi in kelvin passando il parametro alla funzione del service
			String gradiKelvin = convertitoreService.convertiKelvin(gradiCelsius);
			//calcolo i gradi in Fahrenheit passando il parametro alla funzione del service
			String gradiFahrenheitString = convertitoreService.convertiFarhenheit(gradiCelsius);
			//Attribuisco al model i dati risultanti dai calcoli effettuati
			model.addAttribute("gradiFahrenheitString", gradiFahrenheitString);
			model.addAttribute("gradiKelvinString", gradiKelvin);
			//rendo disponibile i div per la visualizzazione dei calcoli in pagina impostanto la variabile showdiv su true
			model.addAttribute("showDiv",true);
			//passo il tutto al file convertitore.html
			return "convertitore";
		} catch (Exception e) {
			//Se l'errore è dato dall'impossibilità di calcolo numerico ad esempio input (ciao) al posto di numeri
			if(e instanceof NumberFormatException) {
				errore = "i dati inseriti non sono corretti";
				model.addAttribute("datiErrati",errore);
				//visualizzo il div relativo al messaggio di errore impostando la variabile showdiv su false
				model.addAttribute("showDiv", false);
			}else {
				//altrimenti imposto la variabile errore su dati mancanti
				errore = "I dati sono mancanti";
				//visualizzo il div relativo al messaggio di errore impostando la variabile showdiv su false
				model.addAttribute("datiErrati", errore);
			}
			//passo il tutto a convertitore.html
			return "convertitore";
		}
	}
	
}
