package com.yedam.web.board.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.web.board.service.BoardService;
import com.yedam.web.board.service.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	//전체조회 : URI - boardList, RETURN - board/boardList
	//                                  : 모든 데이터의 게시글 번호, 제목, 작성자, 작성일(form -> 2023년07월17일)
	@GetMapping("/boardList")
	public String getBoardList(Model model) {
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/boardList";
	}
	
	//단건조회 : URI - boardInfo, RETURN - board/boardInfo
	//                                  : 번호, 제목, 작성자, 내용, 첨부, 작성일
    //                                  : 첨부이미지 webapp/resources
	@GetMapping("/boardInfo")
	public String getBoardInfo(BoardVO boardVO ,Model model) {
		model.addAttribute("board", boardService.getBoardInfo(boardVO));
		return "board/boardInfo";
	}
	
	//등록 - 페이지 : URI - boardInsert, RETURN - board/boardInsert
	@GetMapping("/boardInsert")
	public String boardInsertForm() {
		return "board/boardInsert";
	}
	
	//등록 - 처리 : URI - boardInsert, RETURN - 전체조회 다시 호출
	@PostMapping("/boardInsert")
	public String insertBoardInfo(BoardVO boardVO) {
		boardService.insertBoardInfo(boardVO);
		return "redirect:boardList";
	}
	
	//수정 - 페이지 : URI - boardUpdate, RETURN - board/boardUpdate
	@GetMapping("/boardUpdate")
	public String boardUpdateForm(BoardVO boardVO, Model model) {
		model.addAttribute("boardInfo", boardService.getBoardInfo(boardVO));
		return "board/boardUpdate";
	}
	
	//수정 - 처리 : URI - boardUpdate, RETURN - 수정대상, 성공여부 반환
	@PostMapping("/boardUpdate")
	@ResponseBody
	public Map<String, Object> updateBoardInfo(BoardVO boardVO) {
		boolean result = false;
		
		int boardNo = boardService.updateBoardInfo(boardVO);
		
		if(boardNo > -1) {
			result = true;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		map.put("boardInfo", boardVO);
		
		return map;
	}
	
	//삭제 - 처리 : URI - boardDelete, RETURN - 전체조회 다시 호출
	@GetMapping("/boardDelete")
	public String deleteBoardInfo(@RequestParam(name = "bno", defaultValue = "0") int boardNo) {
		boardService.deleteBoardInfo(boardNo);
		return "redirect:boardList";
	}
}	