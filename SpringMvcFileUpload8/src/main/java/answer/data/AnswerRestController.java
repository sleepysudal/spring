package answer.data;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerRestController {
	
	
	@Autowired
	AnswerDao adao;
	
	@GetMapping("/board/adelete")
	//0인지 1인지 구분만 하기떄문에 integer
	public HashMap<String,Integer>answerDelete(
			@RequestParam int idx,
			@RequestParam String pass)
	{
	int check=adao.getCheckPass(idx, pass);
	if (check==1)
	{
		adao.deleteAnswer(idx);
	}
	HashMap<String,Integer>map = new HashMap<String, Integer>();
	map.put("check", check); //{"check":1}
	
		
	return map;	
	}
}
