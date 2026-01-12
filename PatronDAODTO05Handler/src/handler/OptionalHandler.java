package handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import mapper.Mapper;

public class OptionalHandler<T> implements Handler<Optional<T>> {
	private final Mapper<ResultSet,T> mapper;

	public OptionalHandler(Mapper<ResultSet,T> mapper) {
		super();
		this.mapper = mapper;
	}

	@Override
	public Optional<T> transform(ResultSet resultSet) {
		try {
			if (resultSet.next())
				return Optional.ofNullable(mapper.map(resultSet));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
}
