package org.redborn.csatlatte.commons.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.redborn.csatlatte.commons.security.AES256;

/**
 * AES256 암/복호화 처리를 합니다.
 * 
 * @author 최순열
 *
 */
public class AES256TypeHandler extends BaseTypeHandler<String> {

	@Override
	public String getNullableResult(ResultSet resultSet, String columnLabel)
			throws SQLException {
		return AES256.decrypt(resultSet.getString(columnLabel));
	}

	@Override
	public String getNullableResult(ResultSet resultSet, int columnIndex)
			throws SQLException {
		return AES256.decrypt(resultSet.getString(columnIndex));
	}

	@Override
	public String getNullableResult(CallableStatement callableStatement, int parameterIndex)
			throws SQLException {
		return AES256.decrypt(callableStatement.getString(parameterIndex));
	}

	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int parameterIndex,
			String value, JdbcType jdbcType) throws SQLException {
		preparedStatement.setString(parameterIndex, AES256.encrypt(value));
	}
}
