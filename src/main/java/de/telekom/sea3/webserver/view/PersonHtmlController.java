package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.service.PersonService;

@Controller // Der Controller liefert HTML zurück - Aktuell nur für die size.html!!!
public class PersonHtmlController {
	// Hier als konstanter String, sollte eigentlich aus der HTML-Datei kommen. 
	private static final String HTMLTEMPLATE = "<!DOCTYPE html> <html lang='de'> "
			+ "<head> <meta charset='utf-8'> <meta name='viewport' content='width=device-width, initial-scale=1.0'> <title>Titel</title> </head> "
			+ "<body>size: %d </body> </html>";
	private PersonService personService;
	
	@Autowired
	public PersonHtmlController(PersonService personService) {
		super();
		System.out.println("PersonHtmlController instanziert: " + this.toString());
		System.out.println("PersonService: " + personService.toString());
		this.personService = personService;
	}

	// URL:"http://localhost:8222/size"
	@GetMapping("/size")
	@ResponseBody	// sagt spring Framework dass die Antwort in den Body gepackt werden soll und nicht über das Template
	public String getSize() {
		String string = String.format(HTMLTEMPLATE, personService.getSize());
		
		return string;
	}
	
	// URL:"http://localhost:8222/count"
	@GetMapping("/counter")  // Kein @ResponseBody, da es sonst den Weg über das Template verhindert
	public String getCount(Model model, 
			@RequestParam(value="name",
            required=false,
            defaultValue="Max") 
			String name
			) {
		
		model.addAttribute("fullname", name); // "fullname" ist der fullname im HTML und name ist der Wert
		String htmlFileName="count";
		return htmlFileName;
	}
	
	// URL:"http://localhost:8222/count"
	@GetMapping("/size2")  // Kein @ResponseBody, da es sonst den Weg über das Template verhindert
	public String getSize2(Model model) {
		model.addAttribute("size3", personService.getSize());
		return "size";
	}
	
	// URL:"http://localhost:8222/count"
	@GetMapping("/personen")  // Kein @ResponseBody, da es sonst den Weg über das Template verhindert
	public String getPersonen(Model model) {
		Personen personen = personService.getAllPersons();
		model.addAttribute("personenList", personen.getPersonen());
		return "personen";
	}
	
}
