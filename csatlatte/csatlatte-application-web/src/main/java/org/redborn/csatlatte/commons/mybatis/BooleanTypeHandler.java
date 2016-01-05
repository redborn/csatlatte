package org.redborn.csatlatte.commons.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * Java java.lang.Boolean과 DBMS의 숫자형을 handler 처리 합니다.
 * 1일 경우 true, 0일 경우 false로 처리 합니다.
 * 
 * @author 최순열
 *
 */
public class BooleanTypeHandler extends BaseTypeHandler<Boolean> {

	@Override
	public Boolean getNullableResult(ResultSet resultSet, String columnLabel)
			throws SQLException {
		return resultSet.getInt(columnLabel) == 1;
	}

	@Override
	public Boolean getNullableResult(ResultSet resultSet, int columnIndex)
			throws SQLException {
		return resultSet.getInt(columnIndex) == 1;
	}

	@Override
	public Boolean getNullableResult(CallableStatement callableStatement, int parameterIndex)
			throws SQLException {
		return callableStatement.getInt(parameterIndex) == 1;
	}

	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int parameterIndex,
			Boolean value, JdbcType jdbcType) throws SQLException {
		preparedStatement.setInt(parameterIndex, value ? 1 : 0);
	}

}
