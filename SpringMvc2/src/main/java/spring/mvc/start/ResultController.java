package spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResultController {

   //@GetMapping("/apple/list.do") //list뒤에 .do나 다른 확장자를 붙히던 다호출됨
   @GetMapping("/apple/list")
   public String result1(Model model)
   {
      model.addAttribute("name", "올리버쌤");
      model.addAttribute("country", "미국");
      return "result1";
   }
   
   @GetMapping("/banana/insert")
   public ModelAndView banana()
   {
      //ModelAndView 는 request에 저장하기 위한 Model과
      //포워드 하기위한 View를 합쳐놓은 클래스입니다.
      ModelAndView mview=new ModelAndView();
      
      //request에 저장
      mview.addObject("java", 88);
      mview.addObject("spring", 99);
      
      //포워드할 jsp파일지정
      mview.setViewName("result2");
      
      return mview; 
   }
   
   @GetMapping("/orange/delete")
   public ModelAndView orange()
   {
      ModelAndView mview=new ModelAndView();
      
      mview.addObject("name", "이성신");
      mview.addObject("price", "3000000원");
      mview.addObject("color", "새까만");
   
      mview.setViewName("result3");
      
      return mview; 
   }
   
   @GetMapping("/shop/detail")
   public String resImage()
   {
      
      return "result4";
   }
   
   @GetMapping("/board/insert/data")
   public String imageImage()
   {
      
      return "result5";
   }
   
   
}
