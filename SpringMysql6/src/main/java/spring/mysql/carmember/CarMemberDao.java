package spring.mysql.carmember;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarMemberDao implements CarMemberInter {

	@Autowired
	private SqlSession session;
	
	
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("getTotalCountOfCarMember");
	}
	//인서트
	@Override
	public void insertMember(CarMemberDto cardto)
	{
		session.insert("insertOfMymember", cardto);
	}

	//전체목록
	@Override
	public List<CarMemberDto>getAllMembers()
	{
		return session.selectList("getAllListOfMymember");
	}
	//삭제
	@Override
	public void deleteMember(int num)
	{
		session.delete("deleteOfMymember", num);
	}
	//값 받아오기 getdata
	@Override
	public CarMemberDto getData(int num)
	{
		return session.selectOne("selectOfMymember", num);
	}
	//update
	@Override
	public void updateMember(CarMemberDto cardto)
	{
		session.update("updateOfMymember", cardto);
	}
}
