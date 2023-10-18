package spring.mvc.munje;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.data.dto.InfoDto;

@Controller
@RequestMapping("/info")
public class InfoController {
	@GetMapping("/form1")
	public String form1()
	{
		return "info/infoForm";
	}
	/*
	 @getmapping("/form1")
	 public modelandview start()
	 {
	 modelandview model = new modelandview();
	 
	 model.setviewname("info/infoForm");
	 return model;
	 
	 }
	 */
	
	@PostMapping("/process")
	public String process(@ModelAttribute("dto")InfoDto dto)
	{
		
		return "info/infoWrite";
	}
	
}
