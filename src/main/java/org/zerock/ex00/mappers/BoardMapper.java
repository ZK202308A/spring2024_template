package org.zerock.ex00.mappers;


/*

create table tbl_board(
    bno int auto_increment primary key,
    title varchar(200) not null,
    content text not null,
    writer varchar(50) not null,
    regdate timestamp default current_timestamp,
    updatedate timestamp default current_timestamp
);


insert into tbl_board(title, content, writer) values ('테스트 제목', '테스트 내용', 'user00');

insert into tbl_board (title, content, writer)  (select title, content,writer from tbl_board);



 */

import org.apache.ibatis.annotations.Select;
import org.zerock.ex00.domain.BoardVO;

public interface BoardMapper {



    //@Select("select * from tbl_board where bno > 0")
    java.util.List<BoardVO> getList();

    Long insert(BoardVO boardVO);

    BoardVO read(Long bno);

    int delete(Long bno);

    int update(BoardVO boardVO);
}
