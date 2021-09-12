package com.ktb;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
public class MyTypeHandler extends BaseTypeHandler<String> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        if(parameter.equals("男")){
            ps.setInt(i,1);    //在被转换的位置上设置数值
        }else if(parameter.equals("女")){
            ps.setInt(i,0);
        }
        System.out.println(ps);
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int i = rs.getInt(columnName);    //通过名称获取被转化类型的值
        if(i==0){
            return "女";
        }else
            return "男";
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int i = rs.getInt(columnIndex);    //通过位置获取被转化类型的值
        if(i==0){
            return "女";
        }else
            return "男";
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
