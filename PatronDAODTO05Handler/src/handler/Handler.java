package handler;

import java.sql.ResultSet;

public interface Handler<T> {
	T transform(ResultSet resultSet);
}
