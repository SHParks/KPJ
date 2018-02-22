package kr.co.ac.ezen.kpj.team.Beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Administrator on 2018-02-13.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Board_Item {
    int id;
    String title;
    String content;
    String name;
    String pw;
    long writedate;
    String ip;
    int views;
}
