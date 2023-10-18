package spring.mysql.mycar;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyCarDao {
	
	@Autowired
	private SqlSession session;
	
	String namespace ="spring.mvc.mycar.MyCarDao";
	
	
	public int getTotalCount()
	{
		return session.selectOne(namespace+".getTotalCountOfMyCar"); //mycar.getTotalCountOfMyCar 이렇게 해도 안겹치고 잘됨
	}
	//insert
	public void insertCar(MyCarDto dto)
	{
		session.insert("insertOfMycar", dto);
		
	}
	//전체목록
	public List<MyCarDto>getAllCars()
	{
		return session.selectList("getAllListOfMyCar");
	}
	//delete
	public void deleteCar(String num)
	{
		session.delete("deleteOfMycar",num);
	}
	//update getdata
	public MyCarDto getData(String num)
	{
		return session.selectOne("selectOneOfMycar", num);
	}
	
	//update action
	public void updateCar(MyCarDto dto)
	{
		session.update("updateOfmycar",dto);
	}
}
