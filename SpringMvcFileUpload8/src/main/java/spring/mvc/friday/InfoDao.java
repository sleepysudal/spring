package spring.mvc.friday;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InfoDao implements InfoInter {
	
	@Autowired //sqlsession에 있는 메서드 그냥 쓸게!
	SqlSession session;
	
	//전체 개수
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("selectTotalCountOfMyInfo");
	}
	//값 넣기
	@Override
	public void insertMyInfo(InfoDto dto) {
		// TODO Auto-generated method stub
		session.insert("insertOfMyInfo", dto);
		
	}
//	//전체목록 불러오기
//	@Override
//	public List<InfoDto> getAllInfos() {
//		// TODO Auto-generated method stub
//		return session.selectList("selectOfMyInfo", session);
//	}
	
	//해당 넘에 맞는 값 불러오기
	@Override
	public InfoDto getData(String num) {
		// TODO Auto-generated method stub
		return session.selectOne("selectOneOfMyInfo", num);
	}
	//수정 하기
	@Override
	public void updateMyInfo(InfoDto dto) {
		// TODO Auto-generated method stub
		session.update("updateOneOfMyInfo", dto);
		
	}
	//삭제하기
	@Override
	public void deleteMyInfo(String num) {
		// TODO Auto-generated method stub
		session.delete("deleteOneOfMyInfo", num);
	}
	//검색하기
	@Override
	public List<InfoDto> getAllInfos(Map<String, String> map) {
		// TODO Auto-generated method stub
		return session.selectList("selectOfMyInfo",map);
	}
	
	

}
