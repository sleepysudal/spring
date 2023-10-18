package spring.mysql.carmember;

import java.util.List;

public interface CarMemberInter {
	
	//총 조회수
	public int getTotalCount();

	//insert
	void insertMember(CarMemberDto cardto);

	//all select
	List<CarMemberDto> getAllMembers();

	//delete
	void deleteMember(int num);

	//getdata
	CarMemberDto getData(int num);
	
	//update
	void updateMember(CarMemberDto cardto);
	
	
	
	
	
	
}
