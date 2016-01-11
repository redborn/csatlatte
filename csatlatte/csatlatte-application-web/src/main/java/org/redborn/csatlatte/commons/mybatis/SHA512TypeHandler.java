package org.redborn.csatlatte.commons.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.redborn.csatlatte.commons.security.SHA512;

/**
 * SHA512 암호화 처리를 합니다.
 * SELECT 할 경우 복호화가 되지 않습니다.
 * 
 * @author 최순열
 *
 */
public class SHA512TypeHandler extends BaseTypeHandler<String> {

	@Override
	public String getNullableResult(ResultSet resultSet, String columnLabel)
			throws SQLException {
		return resultSet.getString(columnLabel);
	}

	@Override
	public String getNullableResult(ResultSet resultSet, int columnIndex)
			throws SQLException {
		return resultSet.getString(columnIndex);
	}

	@Override
	public String getNullableResult(CallableStatement callableStatement, int parameterIndex)
			throws SQLException {
		return callableStatement.getString(parameterIndex);
	}

	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int parameterIndex,
			String value, JdbcType jdbcType) throws SQLException {
		preparedStatement.setString(parameterIndex, SHA512.encrypt(value));
	}

}
