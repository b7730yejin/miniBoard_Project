package miniProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Board {
	private int bno;
	private String title;
	private String writer;
	private String content;
	private int readcnt;
	private String writeDate;
	private int like;
}
