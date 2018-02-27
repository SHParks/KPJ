package kr.co.ac.ezen.kpj.team.Beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Administrator on 2018-02-26.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ItemList {
    int id;
    String code;
    String title;
    String content;
}
