package com.adorno.mappers;

public interface MyMapper<T,S> {
	public S map(T t);
}
