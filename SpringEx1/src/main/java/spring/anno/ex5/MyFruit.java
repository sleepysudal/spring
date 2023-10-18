package spring.anno.ex5;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //("")이름안주면 밑에 클래스명 앞만 소문자로 바뀌어서 상속
public class MyFruit {
	
	//@Autowired
	//정확하게 bean의 이름으로 주입하려면?
	@Resource(name="tfruit")
	Fruit fruit;
	
	public void writeFruit() {
		System.out.println("내가 좋아하는 과일은 ** ");
		fruit.writeFruitName();
	}
	
}
