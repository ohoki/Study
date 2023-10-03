package com.yedam.web.board.service;

import java.util.List;

public interface BoardService {
	//전체조회
	public List<BoardVO> getBoardList();
	
	//단건조회
	public BoardVO getBoardInfo(BoardVO boardVO);
	
	//등록 - 등록된 글 번호 반환 / 실패 : -1
	public int insertBoardInfo(BoardVO boardVO);
	
	//수정 - 수정된 글 번호 반환 / 실패 : -1
	public int updateBoardInfo(BoardVO boardVO);
	
	//삭제 - 삭제된 글 번호 반환 / 실패 : -1
	public int deleteBoardInfo(int boardNo);
}
