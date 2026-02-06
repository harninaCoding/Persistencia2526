package com.adorno.mappers;

public interface Mapper<T, S> {
	public T mapToEntity(S s);
	public S mapToDTO(T t);
}
