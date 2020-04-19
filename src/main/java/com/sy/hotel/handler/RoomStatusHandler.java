package com.sy.hotel.handler;

import com.sy.hotel.enums.RoomStatus;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author sunyang
 * @date 2018/1/8
 * 房型状态-数据库 转换器
 */
@MappedJdbcTypes(JdbcType.TINYINT)
@MappedTypes(RoomStatus.class)
public class RoomStatusHandler implements TypeHandler<RoomStatus> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, RoomStatus roomStatus, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,roomStatus.ordinal());
    }

    @Override
    public RoomStatus getResult(ResultSet resultSet, String s) throws SQLException {
        return RoomStatus.values()[resultSet.getInt(s)];
    }

    @Override
    public RoomStatus getResult(ResultSet resultSet, int i) throws SQLException {
        return RoomStatus.values()[resultSet.getInt(i)];
    }

    @Override
    public RoomStatus getResult(CallableStatement callableStatement, int i) throws SQLException {
        return RoomStatus.values()[callableStatement.getInt(i)];
    }
}
