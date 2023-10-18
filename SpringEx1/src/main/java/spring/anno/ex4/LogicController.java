package spring.anno.ex4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("logic") //id가 logic 이 된다
public class LogicController {
	
	@Autowired //자동주입
	//정확한 빈의 아이디로 주입 _ 모호성이 있는 경우에는 @Resource(name="MyDao")
	DaoInter daoInter;
	
	public LogicController(MyDao dao) {
		this.daoInter=dao;
	}
	//insert 
	public void insert(String str) {
		daoInter.insertData(str);
	}
	//delete
	public void delete(String num) {
		daoInter.deleteData(num);
	}
}
