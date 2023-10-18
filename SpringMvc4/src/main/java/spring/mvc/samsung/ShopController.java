package spring.mvc.samsung;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.data.dto.ShopDto;

@Controller
public class ShopController {
	
	@GetMapping("/shop/list")
	public String result3()
	{
		return "shop/list";
	}
	
	@GetMapping("/shop/form2")
	public String form2()
	{
		return "shop/shopForm";
	}
	
	@PostMapping("/shop/process2")
	public String process2(@ModelAttribute("dto") ShopDto dto)
	
	{
		return "shop/shopResult";
	}
	
	@GetMapping("/shop/form3")
	public String form3()
	{
		return "shop/mapForm";
	}
	@PostMapping("/shop/process3")
	public ModelAndView process3(@RequestParam Map<String, String>map)
	{
		ModelAndView model = new ModelAndView();
		
		String name=map.get("name");
		String java = map.get("java");
		String spring = map.get("spring");
		String jquery = map.get("jquery");
		
		
		
		model.addObject("name", name);
		model.addObject("spring", spring);
		model.addObject("java", java);
		model.addObject("jquery", jquery);
	
		
		model.setViewName("shop/mapResult");
		
		return model;
	}
	
	
	
	
}
