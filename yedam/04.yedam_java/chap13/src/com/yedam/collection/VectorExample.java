package com.yedam.collection;

import java.util.List;
import java.util.Vector;

public class VectorExample {

	public static void main(String[] args) {
		//ArrayList와 동일하지만 쓰레드 사용 방법이 다르다. (Vector -> 멀티 쓰레드)
		List<Board> vector = new Vector<>();
		
		Board board = new Board("제목1", "내용1", "글쓴이1");
		
		vector.add(board);
		vector.add(new Board("제목2", "내용2", "글쓴이2"));
		vector.add(new Board("제목3", "내용3", "글쓴이3"));
		vector.add(new Board("제목4", "내용4", "글쓴이4"));
		vector.add(new Board("제목5", "내용5", "글쓴이5"));
		
		for(int i=0; i<vector.size(); i++) {
			Board board2 = vector.get(i);
			System.out.println(board2.subject + "\t" + board2.content + "\t" + vector.get(i).writer); //호출할 때 두가지 방법이 있음
		}
		
		System.out.println("======================");
		
		vector.remove(2);
		
		for(Board board2 : vector) {
			System.out.println(board2.subject + "\t" + board2.content + "\t" + board2.writer);
		}
	}

}
