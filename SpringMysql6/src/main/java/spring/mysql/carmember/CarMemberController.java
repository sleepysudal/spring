package spring.mysql.carmember;

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
public class CarMemberController {
	
	@Autowired
	CarMemberInter inter;
	
	@GetMapping("/member/list")
	public String memberStart(Model model) 
	{
		//갯수 가져오기
		int count = inter.getTotalCount();
		
		//목록 가져오기
		List<CarMemberDto> list = inter.getAllMembers();
		
		//request에 저장
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		
		return "carmember/memberlist";
	}
	//addform으로 이동
	@GetMapping("/member/addform")
	public String addform()
	{
		return "carmember/addform";
	}
	
	//insert
	@PostMapping("/member/add")
	public String insert(@ModelAttribute("cardto")CarMemberDto cardto)
	{
		inter.insertMember(cardto);
		return "redirect:list";
	}
	//delete
	@GetMapping("/member/delete")
	public String delete(int num)
	{
		inter.deleteMember(num);
		return "redirect:list";
	}
	//수정용 getdata
	@GetMapping("/member/updateform")
	public ModelAndView updateform(@RequestParam("num") int num)
	{
		ModelAndView model = new ModelAndView();
		CarMemberDto cardto= inter.getData(num);
		
		model.addObject("cardto", cardto);
		model.setViewName("carmember/updateform");
		
		return model;
	}
	
	//update
	@PostMapping("/member/update")
	public String update(@ModelAttribute("cardto")CarMemberDto cardto)
	{
		inter.updateMember(cardto);
		return "redirect:list";
	}
}
