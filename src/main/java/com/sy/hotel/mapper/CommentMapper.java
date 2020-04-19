package com.sy.hotel.mapper;

import com.sy.hotel.domain.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sunyang
 * @date 2019/12/6
 * 评论的持久层接口
 */
public interface CommentMapper {

    int save(Comment comment);

    int delete(Integer id);

    List<Comment> listByUserId(Integer id);

    List<Comment> listByRoomInfoId(Integer id);

    int countByRoomInfoId(Integer roomInfoId);

    List<Comment> pageByRoomInfoId(
            @Param("roomInfoId") Integer roomInfoId,
            @Param("offset") Integer offset,
            @Param("pageSize") Integer pageSize);
}
