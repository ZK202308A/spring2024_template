package org.zerock.ex00.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.zerock.ex00.domain.BoardVO;
import org.zerock.ex00.mappers.BoardMapper;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    public Long register(BoardVO boardVO) {
        log.info("register......" + boardVO);

        boardMapper.insert(boardVO);

        return boardVO.getBno();

    }

    public BoardVO get(Long bno) {
        log.info("get......" + bno);

        return boardMapper.read(bno);
    }

    public boolean modify(BoardVO boardVO) {
        log.info("modify......" + boardVO);

        return boardMapper.update(boardVO) == 1;
    }

    public boolean remove(Long bno) {
        log.info("remove......" + bno);

        return boardMapper.delete(bno) == 1;
    }

    public java.util.List<BoardVO> getList() {
        log.info("getList......");

        return boardMapper.getList();
    }



}
