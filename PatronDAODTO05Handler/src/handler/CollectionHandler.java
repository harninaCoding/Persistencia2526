package handler;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import mapper.Mapper;

public class CollectionHandler<R> implements Handler <Collection<R>>{
	private final Mapper<ResultSet,R> mapper;
	
	public CollectionHandler(Mapper<ResultSet,R> mapper) {
		super();
		this.mapper = mapper;
	}

	@Override
	public Collection<R> transform(ResultSet resultSet) {
		ArrayList<R> arrayList=new ArrayList<R>();
		try {
			while (resultSet.next()) {
				arrayList.add((R) mapper.map(resultSet));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayList;
	}
		
}
