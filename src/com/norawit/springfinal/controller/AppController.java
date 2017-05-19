package com.norawit.springfinal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.norawit.springfinal.database.Pattern;
import com.norawit.springfinal.database.PatternJDBCTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class AppController {
	
	// Wired to PatternJDBCTemplate in AppConfig
	@Autowired
	private PatternJDBCTemplate patternJDBCTemplate;
	
	// Home Mapping
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String homePage() {
		return "home";
	}
	
	// Add new student get mapping
	@GetMapping(value = { "/addNewPattern"})
	public ModelAndView addNewStudentForm() {
		Pattern pattern = new Pattern();
		return new ModelAndView("addNewPattern", "pattern", pattern);
	}
	
	// Add new pattern post mapping
	@PostMapping(value = { "/addNewPattern"})
	public ModelAndView addNewStudentSubmit(@ModelAttribute("pattern") Pattern pattern) {
		boolean isValid = ( !pattern.getName().isEmpty() && !pattern.getGroup().isEmpty() && !pattern.getImplementation().isEmpty() ) ? true : false;
		if( isValid ) {
			pattern.setId(patternJDBCTemplate.listPatterns().size() + 1);
			System.out.println(pattern.toString());
			patternJDBCTemplate.create(pattern.getName(), pattern.getGroup(), pattern.getImplementation());
			return new ModelAndView("home", "message", "Succesfully Add New Pattern");
		}
		return new ModelAndView("addNewPattern", "message", "Invalid inputs!");
	}
	
	@GetMapping(value = { "/viewPatterns"})
	public ModelAndView studentsListPage(ModelMap model) {
		Map<String, List<Pattern>> patterns = new HashMap<String, List<Pattern>>();
		patterns.put("patterns", patternJDBCTemplate.listPatterns());
		for ( Pattern pattern : patternJDBCTemplate.listPatterns()) {
			System.out.println(pattern);
		}
		return new ModelAndView("viewPatterns", patterns);
	}
	
	@GetMapping("/editPattern/{id}")
	public ModelAndView editStudentPage(@PathVariable Integer id) {
		Pattern pattern = patternJDBCTemplate.getPattern(id);
		return new ModelAndView("editPattern", "pattern", pattern);
	}
	
	@PostMapping("/editPattern/{id}")
	public ModelAndView editStudentSubmit(@ModelAttribute Pattern pattern, ModelMap model) {
		System.out.println("Updating: " + pattern);
		patternJDBCTemplate.update(pattern.getId(), pattern.getName(), pattern.getGroup(), pattern.getImplementation());
		return studentsListPage(model.addAttribute("message", "Successfully edited pattern"));
	}
	
	@PostMapping("deletePattern/{id}")
	public ModelAndView deleteStudent(@PathVariable Integer id, ModelMap model) {
		System.err.println("[REMOVE] Pattern @ID " + id);
		patternJDBCTemplate.delete(id);
		return studentsListPage(model);
	}
	
}
