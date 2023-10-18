package spring.mvc.friday;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
//@RequestMapping("/info") 중간경로를 이렇게 하면 편하지만 info 한개만 가능하다
public class InfoController {
	
	@Autowired
	InfoInter inter;
	
	@GetMapping("/info/list")
	public ModelAndView list(@RequestParam(defaultValue="name") String title,
			@RequestParam(required=false) String search)
	{
		ModelAndView model = new ModelAndView();
		
		int totalCount = inter.getTotalCount();
		
		System.out.println(title+","+search);
		
		Map<String,String >map = new HashMap<String,String>();
		map.put("search", search);
		map.put("title", title);
		
		List<InfoDto>list = inter.getAllInfos(map);
		
		//modelandview 쓸때는이렇게
		model.addObject("totalCount", totalCount);
		model.addObject("list", list);
		
		model.setViewName("info/infolist");
		return model; 
	}
	/*
	@GetMapping("/info/list")
	   public String getToalCount(Model model, @RequestParam(defaultValue = "name") String title,
	         @RequestParam(required = false) String search) {
	      
	      //List<InfoDto> list = inter.getAllInfos();
	      
	      System.out.println(title+","+search);
	      
	      Map<String, String> map = new HashMap<String, String>();
	      map.put("search", search);
	      map.put("title", title);
	      
	      List<InfoDto> list = inter.getAllInfos(map);
	      
	      model.addAttribute("count", inter.getTotalCount());
	      model.addAttribute("list", list);
	      //model.addAttribute("search", search);
	      //model.addAttribute("title", title);
	      //굳이 add 안해줘도 됨
	      
	      return "info/infolist";
	   }
	*/
	
	/*
	@GetMapping("/info/list")
	public ModelAndView list()
	{
		ModelAndView model = new ModelAndView();
		int totalCount = inter.getTotalCount();
		model.addObject("totalCount",totalCount);
		
		//model.addAttribute("totalCount",inter.getTotalCount() );
		
		return("info/infolist"); 
	}
	*/
	
	//addform 으로 이동
	@GetMapping("/info/addform")
	public String addform()
	{
		return("info/addform");
	}
	
	//insert
	@PostMapping("/info/insert")
	public String insert(@ModelAttribute InfoDto dto,
			@RequestParam MultipartFile upload,
			HttpSession session)
	{
		String path=session.getServletContext().getRealPath("/resources/image/");
		System.out.println(path);
		
		//현재 날짜와 시간이용해서 파일명에 저장
		SimpleDateFormat sdf= new  SimpleDateFormat("yyyyMMddHHmmss");
		
		String photo="";
		
		//사진선택을 안했을 경우 no...
		if(upload.getOriginalFilename().equals(""))
			photo="no";
		else {
			
			String fName=upload.getOriginalFilename();
			fName=sdf.format(new Date())+"_"+fName;
			photo=fName;
			
			//업로드
			//맥에서는 슬래시 한번 윈도우는 역슬래시 두번
			try {
				upload.transferTo(new File(path+"/"+photo));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		//dto의 photo 에 넣기
		dto.setPhoto(photo);
		
		//insert
		inter.insertMyInfo(dto);
		
		
		return "redirect:list";
	}
	//업데이트 폼 가기
	@GetMapping("/info/uform")
	public String uform(@RequestParam String num,Model model)
	{
		
		InfoDto dto = inter.getData(num);
		model.addAttribute("dto", dto);
		return "info/updateform";
	}
	//업데이트 하기
	@PostMapping("/info/update")
	public String update(@ModelAttribute InfoDto dto, 
			@RequestParam MultipartFile upload,
			HttpSession session)
	{
		String path = session.getServletContext().getRealPath("/resources/image/");
		System.out.println(path);
		
		//현재 날짜와 시간이용해서 파일명에 저장
		SimpleDateFormat sdf= new  SimpleDateFormat("yyyyMMddHHmmss");
		
		
		String photo = inter.getData(dto.getNum()).getPhoto(); //업로드시 가상경로에 지워질 사진지정
		
		String photoname; //dto에 담을 변수
		
		//사진 선택 안할 경우 null
		if(upload.getOriginalFilename().equals(""))
			photoname=null;
		else {
			photoname=upload.getOriginalFilename();
			photoname=sdf.format(new Date())+"_"+photoname;
			
		}
		
		//업로드
		try {
			upload.transferTo(new File(path+"/"+photoname));
			
			File file = new File(path+"/"+photo);
			file.delete();
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//dto의 photo에 업로드 한 photoname 넣어주기
		dto.setPhoto(photoname);
		
		//update
		inter.updateMyInfo(dto);
		
		return "redirect:list";
	}
	//삭제하기
	@GetMapping("info/delete")
	public String delete(@RequestParam String num,
			HttpSession session)
	{
		//해당번호에 해당하는 사진값 가져오기
		String photo=inter.getData(num).getPhoto();
		
		if(!photo.equals("no"))
		{
			String path = session.getServletContext().getRealPath("/resources/image/");
			System.out.println(path);
			
			File file = new File(path+"/"+photo);
			file.delete();
		}
		//db 삭제
		inter.deleteMyInfo(num);
	
		return "redirect:list";
	}
	
	
}
