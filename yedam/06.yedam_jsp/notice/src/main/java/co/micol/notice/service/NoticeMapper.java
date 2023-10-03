package co.micol.notice.service;

import java.util.List;

//Mybatis 사용을 위한 인터페이스
public interface NoticeMapper {
	List<NoticeVO> noticeSelectList();     //전체조회
	NoticeVO noticeSelect(NoticeVO vo);    //한명조회
	int noticeInsert(NoticeVO vo);         //입력
	int noticeUpdate(NoticeVO vo);         //수정
	int noticeDelete(NoticeVO vo);         //삭제
}
