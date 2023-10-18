package spring.mvc.friday;

import java.util.List;
import java.util.Map;

public interface InfoInter {
	
	//토탈카운트
	public int getTotalCount();
	
	//인서트
	public void insertMyInfo(InfoDto dto);
	
	//전체목록불러오기
	//public List<InfoDto>getAllInfos();
	
	//특정 데이터 불러오기
	public InfoDto getData(String num);
	
	//업데이트 하기
	public void updateMyInfo(InfoDto dto);
	
	//삭제하기
	public void deleteMyInfo(String num);
	
	//검색하기
	public List<InfoDto>getAllInfos(Map<String, String >map);
	
}
