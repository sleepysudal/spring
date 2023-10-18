package spring.anno.ex6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mysql")
public class MysqlController {
	
	@Autowired
	TestDao tdao;
	
	
	public void insert(String name) {
		tdao.insert(name);
	}
	
	public void delete(String num) {
		tdao.delete(num);
	}
	public void select(String irum) {
		tdao.select(irum);
	}
	
}
