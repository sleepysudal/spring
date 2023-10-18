package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController /*json처리 전용 컨트롤러*/
public class JsonTest2Controller {

	@GetMapping("/list2")
	
	public Map<String,String>list2()
	{
		Map<String, String>map = new HashMap<String, String>();
		
		map.put("sang","요가매트");
		map.put("price", "23000");
		map.put("color","화이트");
		
		return map;
	}
	@GetMapping("/list4") //object 는 어떤건 숫자고 어떤건 문자일때 사용한다 
	public Map<String, Object> list4(@RequestParam String name)
	{
		List<PhotoDto>list =new ArrayList<PhotoDto>();
		
		list.add(new PhotoDto("wow1","wow.jpeg"));
		list.add(new PhotoDto("wow2","wow2.jpeg"));
		list.add(new PhotoDto("wow3","wow3.jpeg"));
		list.add(new PhotoDto("wow4","1012ho.jpeg"));
		list.add(new PhotoDto("wow5","1012ho2.jpeg"));
		list.add(new PhotoDto("wow6","1012ho3.jpeg"));
		list.add(new PhotoDto("wow7","1012ho4.jpeg"));
		
		Map<String,Object>map = new HashMap<String, Object>();
		map.put("name", "없는메뉴");
		map.put("photo", "5.jpg");
		
		for(PhotoDto dto :list)
		{
			if(name.equals(dto.getName()))
			{
				map.put("name", dto.getName());
				map.put("photo", dto.getPhoto());
			}
		}
		
		return map;
	}
}
