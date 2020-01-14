package com.itheima.handler;

import com.sun.xml.internal.ws.encoding.DataHandlerDataSource;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DateHandler extends BaseTypeHandler<Date> {
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        preparedStatement.setLong(i, date.getTime());
    }

    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        System.out.println("要转换的字段："+s);
        long timestamp = resultSet.getLong(s);
        return new Date(timestamp);
    }

    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        System.out.println("要转换的字段："+i);

        long timestamp = resultSet.getLong(i);
        return new Date(timestamp);
    }

    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        System.out.println("要转换的字段："+i);
        long timestamp = callableStatement.getLong(i);
        return new Date(timestamp);
    }
}
