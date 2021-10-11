package miniProject.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import miniProject.entity.Board;

public class BoardService {
	//싱글톤 패턴
	private static BoardService service = new BoardService();
	private BoardService() {}
	public static BoardService getInstance() {
		return service;
	}
	
	//데이터를 저장할 Board 리스트 생성
	List<Board> list = new ArrayList<>();
	
	//전체 글 읽기(list)
	public List<Board> selectAll() {
		return list;
	}
	//글 읽기(bno를 기준으로 bno 리턴)
	public Board selectByBno(int bno) {
		for(Board board : list) {
			if(board.getBno() == bno) {
				return board;
			}
		}
		return null;
	}
	//글 쓰기
	public int write(Board board) {
		if(list.size()==0) {
			list.add(board);
			board.setBno(1);
		}
		else{
			list.add(board);
			board.setBno(list.get(list.size()-2).getBno()+1);
		}
		return board.getBno();
	}
	//글 삭제
	public boolean delete(String username) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getWriter().equals(username)) {
				list.remove(i+1);
				return true;
			}
		}
		return false;
	}
	//글 수정
	public boolean update(int bno, String username, String title, String content) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getBno() == bno) {
				if(list.get(i).getWriter().equals(username)) {
					list.get(i).setTitle(title);
					list.get(i).setContent(content);
					return true;
				}
			}
		}
		return false;
	}
	//조회수 Count
	public void veiwcount(int bno) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getBno() == bno) {
				list.get(i).setReadcnt(list.get(i).getReadcnt()+1);
			}
		}
	}
	//작성일자 리턴
	public String getWriteDate() {
		LocalDateTime writeDate = LocalDateTime.now();
		return writeDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
//	public boolean likeCount(int bno) {
//		for(int i=0; i<list.size(); i++) {
//			if(list.get(i).getBno() == username) {
//				list.get(i).setLike(i);
//				return true;
//			}
//		}
//		return false;
//	}
}
