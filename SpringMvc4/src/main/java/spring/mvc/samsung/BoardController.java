package spring.mvc.samsung;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board") //중간경로를 이렇게 하면 편하지만 board 한개만 가능하다
public class BoardController {
	
		@GetMapping("/form1")
		public String form1() 
		{
			return "board/writeform";
		}
		
		@PostMapping("/process")
		public ModelAndView process1(@RequestParam String name, 
				@RequestParam String date,
				@RequestParam String gender,
				/*@RequestParam(defaultValue = "행복한 하루 보내세요")String msg)*/
				/* required=true 가 기본값, 항목이 없어도 에러가 안나게 하려면 false*/
				@RequestParam(required = false)String msg,
				@RequestParam(defaultValue="1") int currentPage ) 
		{
			ModelAndView model = new ModelAndView();
			
			model.addObject("name", name);
			model.addObject("date", date);
			model.addObject("gender", gender);
			model.addObject("msg", msg);
			model.addObject("currentPage", currentPage);
			
			model.setViewName("board/result");
			
			return model;
		}
		@GetMapping("/result2")
		public String result2(Model model)
		{
			model.addAttribute("myimg1", "../image/op9.jpeg");
			model.addAttribute("myimg2", "../image/rightarrow.png");
			return "board/result2";
		}
}
