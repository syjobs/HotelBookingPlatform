package com.sy.hotel.service.impl;

import com.sy.hotel.domain.Comment;
import com.sy.hotel.domain.RoomInfo;
import com.sy.hotel.dto.PageQueryResult;
import com.sy.hotel.mapper.CommentMapper;
import com.sy.hotel.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author liyuxiang-lhq
 * @Date 2018/4/13
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean add(Comment comment) {
        return commentMapper.save(comment) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        return commentMapper.delete(id) == 1;
    }

    @Override
    public PageQueryResult<Comment> pageComment(RoomInfo room, Integer currentPage, Integer pageSize) {
        Integer totalRecords = commentMapper.countByRoomInfoId(room.getId());
        currentPage = currentPage == null ? 1 : currentPage;
        pageSize = pageSize == null ? 10 : pageSize;
        List<Comment> commentList = commentMapper.pageByRoomInfoId(room.getId(), (currentPage - 1) * pageSize, pageSize);
        int totalPages = (totalRecords - 1) / pageSize + 1;
        return new PageQueryResult<>(currentPage, pageSize, totalRecords, totalPages, commentList);
    }
}
