package mapper;

import java.time.LocalDate;

public class String2LocalDateMapper implements Mapper<String, LocalDate> {

	@Override
	public LocalDate map(String s) {
		String[] split = s.split(" ");
		String[] split2 = split[0].split("/");
		return LocalDate.of(
				Integer.valueOf(split2[2]),
				Integer.valueOf(split2[1]), 
				Integer.valueOf(split2[0]));
	}

}
