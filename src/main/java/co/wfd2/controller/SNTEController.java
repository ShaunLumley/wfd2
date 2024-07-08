package co.wfd2.controller;

import java.util.List;

//import org.apache.logging.log4j.core.Logger;
//import org.apache.
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.wfd2.controller.entity.SNTE;
import co.wfd2.service.SNTEService;

@Controller
@RequestMapping(path = "/snte")
public class SNTEController {
	

   static Logger logger = LogManager.getLogger(SNTEController.class.getName());

	private final SNTEService service;


	@Autowired
	public SNTEController(SNTEService service){
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String get(Model model) {
		logger.debug("Display all S&TE.");
		
		List<SNTE> response = SNTE.map(service.get());
		model.addAttribute("snte", response);

		return "snte";
		
	}

	
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public String get(@PathVariable("id") Integer id, Model model) {
		logger.debug("Display item id: " + id);

		SNTE response = SNTE.map(service.get(id));
		model.addAttribute("item", response);

		return "item";

	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/nsn/{nsn}")
	public String get(@PathVariable("nsn") String nsn, Model model) {
		logger.debug("Display item NSN: " + nsn);
		
		List<SNTE> response = SNTE.map(service.get(nsn));
		model.addAttribute("snte", response);

		return "snte";

	}
	
	@RequestMapping(method = RequestMethod.POST, path="/save")
	public String save(@ModelAttribute("item") SNTE sNTE) {
		logger.debug("Save item: " + sNTE.toString());
		
		service.save(sNTE.trace());
		return "redirect:/snte";
	}

	@RequestMapping(method = RequestMethod.GET, path="/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		logger.debug("Delete item id: " + id);
		
		service.delete(id);
		return "redirect:/snte";
	}
}
