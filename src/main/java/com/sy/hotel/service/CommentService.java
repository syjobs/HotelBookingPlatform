package com.sy.hotel.service;

import com.sy.hotel.domain.Comment;
import com.sy.hotel.domain.RoomInfo;
import com.sy.hotel.dto.PageQueryResult;

/**
 * @Author liyuxiang-lhq
 * @Date 2018/4/13
 */
public interface CommentService {

    boolean add(Comment comment);

    boolean delete(Integer id);

    PageQueryResult<Comment> pageComment(RoomInfo room, Integer currentPage, Integer pageSize);
}
