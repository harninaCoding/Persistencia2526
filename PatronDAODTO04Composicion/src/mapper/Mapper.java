package mapper;

public interface Mapper<S, T> {
	public T map(S s);
}
