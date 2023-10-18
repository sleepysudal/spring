package spring.di.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext2.xml");
		
		//MyInfo 생성후 확인
		MyInfo m1 = (MyInfo)context.getBean("my");
		System.out.println(m1.toString());
		System.out.println(m1);
		
		//Person
		Person p1 = (Person)context.getBean("person");
		p1.writeData();
		
		
		

	}

}
