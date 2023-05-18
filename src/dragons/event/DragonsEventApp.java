package dragons.event;

import java.time.LocalDate;
import java.time.Period;

import dragons.event.data.DataProviderTextFileSource;
import dragons.event.models.Event;
import dragons.event.utility.DateConvertor;

public class DragonsEventApp {
	
	public static void main(String[] args) {
		//Create object of Data Provider Class. 
		DataProviderTextFileSource dataProvider = new DataProviderTextFileSource();
		
		//We need to know what is today's date. 
		LocalDate todayDate = LocalDate.now();
		dataProvider.printMessage("Today's Date " + todayDate);
		//We need to find the event that is after todays date. 
		
		Event event= dataProvider.findNextEvent(todayDate);
		dataProvider.printEvent(event);
		
		//Using Class Period from java.time package. 
		// we can find days between to dates. 
		
		LocalDate eventDate = DateConvertor.toLocalDate(event.getDate());
		Period period= Period.between(todayDate, eventDate);
		dataProvider.printMessage("Month to next holliday " + period.getMonths());
		dataProvider.printMessage("Days to next holliday " + period.getDays());
		dataProvider.printMessage("Next Event on " + eventDate.getDayOfWeek().name());
	}
}
