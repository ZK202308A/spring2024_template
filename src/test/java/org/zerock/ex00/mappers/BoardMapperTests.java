package org.zerock.ex00.mappers;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.ex00.domain.BoardVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardMapperTests {

    @Autowired(required = false)
    BoardMapper boardMapper;

    @Test
    public void test1() {
        log.info(boardMapper.getClass().getName());
        log.info("--------------------------");

        boardMapper.getList().forEach(board -> log.info(board));
        log.info("--------------------------");
    }

    @Test
    public void testInsert() {

        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("새로 작성하는 글");
        boardVO.setContent("새로 작성하는 내용");
        boardVO.setWriter("newbie");

        boardMapper.insert(boardVO);

        log.info("BNO: "+boardVO.getBno());
    }

    @Test
    public void testDelete() {
        log.info("DELETE COUNT: "+boardMapper.delete(3L));
    }

    @Test
    public void testUpdate() {
        BoardVO boardVO = new BoardVO();
        boardVO.setBno(1L);
        boardVO.setTitle("수정된 제목");
        boardVO.setContent("수정된 내용");
        boardVO.setWriter("user00");

        int count = boardMapper.update(boardVO);
        log.info("UPDATE COUNT: "+count);
    }

}
