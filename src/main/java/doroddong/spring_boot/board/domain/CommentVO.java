package doroddong.spring_boot.board.domain;

import lombok.Data;

import java.util.Date;

@Data
public class CommentVO {
    private int cno;
    private int bno;
    private String content;
    private String writer;
    private Date reg_date;
}
