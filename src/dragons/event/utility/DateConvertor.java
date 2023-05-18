package dragons.event.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConvertor {
	
	public static LocalDate toLocalDate(String date) {
		//How to Conver String to LocalDate object. 
		//First We need DateTimeFormatter of a pattern (MM/dd/yyyy);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		//Then LocalDate.parse()
		return LocalDate.parse(date, formatter);
	}

}
