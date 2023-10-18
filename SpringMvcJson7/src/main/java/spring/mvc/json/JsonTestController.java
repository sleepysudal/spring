package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonTestController {
	
	@GetMapping("/list1")
	@ResponseBody //json처리후 브라우저로 출력(일반 컨트롤러일 경우)
	public Map<String,String>list1()
	{
		Map<String, String>map = new HashMap<String, String>();
		
		map.put("name","장순영");
		map.put("hp", "010-222-3333");
		map.put("addr","수원시 팔달구");
		
		return map;
	}
	@GetMapping("/list3") //어노테이션 respnsebody는 여기쓰나 위에 쓰나 상관없음
	public @ResponseBody List<PhotoDto> list3()
	{
		List<PhotoDto>list =new ArrayList<PhotoDto>();
		
		list.add(new PhotoDto("wow1","wow.jpeg"));
		list.add(new PhotoDto("wow2","wow2.jpeg"));
		list.add(new PhotoDto("wow3","wow3.jpeg"));
		list.add(new PhotoDto("wow4","1012ho.jpeg"));
		list.add(new PhotoDto("wow5","1012ho2.jpeg"));
		list.add(new PhotoDto("wow6","1012ho3.jpeg"));
		list.add(new PhotoDto("wow7","1012ho4.jpeg"));
		
		return list;
	}
}
