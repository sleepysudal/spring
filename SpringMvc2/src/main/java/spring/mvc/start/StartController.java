package spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {
	
	//start.jsp로 가기위한 메소드(forward)
	@GetMapping("/") //pom.xml에서 버전 5.2.9로 바꾸기
	public String start(Model model) {
		
		//Model: reqpuest에 데이터를 저장하기위한 인터페이스
		//서블릿에서 하던 request.setAttribute와 같다
		
		model.addAttribute("name", "김영환");
		model.addAttribute("country", "서울시 강남구");
		
		return "start"; //WEB-INF/day1005/start.jsp
	}
}