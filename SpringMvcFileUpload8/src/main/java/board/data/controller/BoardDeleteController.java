package board.data.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.reboard.BoardDao;
import spring.mvc.reboard.BoardDto;

	@Controller
	public class BoardDeleteController {
		
		@Autowired
		BoardDao dao;
		
		@GetMapping("/board/deletepassform")
		public ModelAndView dpassform(
				@RequestParam String num,
				@RequestParam String currentPage)
		{
			ModelAndView model = new ModelAndView();
			
			model.addObject("num", num);
			model.addObject("currentPage", currentPage);
			
			model.setViewName("reboard/delpassform");
			return model;
		}
		
		@PostMapping("/board/deletepass")
		public String deletepass(
				@RequestParam int num,
				@RequestParam int pass,
				HttpSession session,
				@RequestParam int currentPage)
		
		{
			int check = dao.getCheckPass(num, pass);
			
			if(check==0)
			{
				return "reboard/passfail";
			}else {
				//해당번호에 해당하는 사진값 가져오기
				String photo=dao.getData(num).getPhoto();
				
				if(!photo.equals("no"))
				{
					String path = session.getServletContext().getRealPath("/WEB-INF/photo");
					System.out.println(path);
					
					File file = new File(path+"/"+photo);
					file.delete();
				}
			}
			
			dao.deleteReboard(num);
			
			return "redirect:list?currentPage="+currentPage;
		}
	
	}
	

