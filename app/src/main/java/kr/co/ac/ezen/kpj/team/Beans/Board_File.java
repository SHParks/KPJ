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
public class Board_File {
    int file_id;
    String file_name;
    String type_board;
    int id_item;
}
