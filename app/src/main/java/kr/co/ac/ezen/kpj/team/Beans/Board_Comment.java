package kr.co.ac.ezen.kpj.team.Beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Administrator on 2018-02-14.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Board_Comment {
    int cmt_id;
    int id_board;
    String cmt_content;
    String cmt_name;
    String cmt_pw;
    long cmt_date;
    String cmt_ip;
}
