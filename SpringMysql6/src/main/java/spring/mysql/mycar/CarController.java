package spring.mysql.mycar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarController {
	
	@Autowired //해당클래스의 메서드를 자동으로 받아온다
	MyCarDao dao;
	
	@GetMapping("/kakao/list")
	public String list(Model model)
	{
		//dao로부터 총개수 가져오기
		int totalCount = dao.getTotalCount();
		
		//목록가져오기
		List<MyCarDto> list = dao.getAllCars();
		
		//request 에 저장
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("list",list);
		return "car/carlist";
	}
	//폼으로 가자
	@GetMapping("/kakao/writeform")
	public String carform()
	{
		return "car/writeform";
	}
	
	//insert
	@PostMapping("/kakao/write")
	public String insert(@ModelAttribute("dto") MyCarDto dto)
	{
		dao.insertCar(dto);
		return "redirect:list";
	}
	
	//delete
	@GetMapping("/kakao/delete")
	public String delete(String num)
	{
		dao.deleteCar(num);
		return "redirect:list";
	}
	//update form
	@GetMapping("/kakao/updateform")
	public ModelAndView updateform(@RequestParam("num") String num)
	{
		ModelAndView model = new ModelAndView();
		MyCarDto dto=dao.getData(num);
		
		model.addObject("dto", dto);
		model.setViewName("car/updateform");
		return model;
		
	}
	
	//update action
	@PostMapping("/kakao/update")
	public String update(@ModelAttribute("dto")MyCarDto dto)
	{
		dao.updateCar(dto);
	return "redirect:list";
	}
	
	
}
