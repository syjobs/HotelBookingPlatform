package com.yang.hrms.service;

import com.yang.hrms.domain.Comment;
import com.yang.hrms.domain.RoomInfo;
import com.yang.hrms.dto.PageQueryResult;

/**
 * @Author liyuxiang-lhq
 * @Date 2018/4/13
 */
public interface CommentService {

    boolean add(Comment comment);

    boolean delete(Integer id);

    PageQueryResult<Comment> pageComment(RoomInfo room, Integer currentPage, Integer pageSize);
}
