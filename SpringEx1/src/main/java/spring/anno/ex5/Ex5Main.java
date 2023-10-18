package spring.anno.ex5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex5Main {

   public static void main(String[] args) {
      // TODO Auto-generated method stub

      ApplicationContext app=new ClassPathXmlApplicationContext("annoContext4.xml");
      
      Fruit fruit=(KoreaFruit)app.getBean("kfruit"); //아이디
      fruit.writeFruitName();
      
      MyFruit myfruit=(MyFruit)app.getBean("myFruit"); //@Component 안할시 앞글자만 소문자 class명
      myfruit.writeFruit();
      
      
   }

}