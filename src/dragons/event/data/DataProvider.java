package dragons.event.data;

import java.time.LocalDate;
import java.util.ArrayList;

import dragons.event.models.Event;
import dragons.event.utility.ConsoleOutput;
import dragons.event.utility.DateConvertor;

public class DataProvider extends ConsoleOutput implements EventData {
	// This class is our event data source
	// An Array for Events can Store events.
	// We need a method to create object of events.
	// We need a method to find the event.
	private ArrayList<Event> events = new ArrayList<>();

	public DataProvider() {
		generateEventData();
	}

	private void generateEventData() {
		addEvent("MLK Day", "01/16/2023", true);
		addEvent("President's Day", "02/20/2023", true);
		addEvent("Women's Day", "03/08/2023", false);
		addEvent("April Fool Day", "04/01/2023", false);
		addEvent("Easter Sunday", "04/09/2023", false);
		addEvent("Mother's Day", "05/14/2023", false);
		addEvent("Memorial Day", "05/29/2023", true);
	}

	private void addEvent(String holidayName, String date, boolean isFedHoliday) {
		Event event = new Event(holidayName, date, isFedHoliday);
		events.add(event);
	}

	@Override
	public Event findNextEvent(LocalDate date) {
		// Using stream and lambda functions for filtering Collections.

		return events.stream()
		.filter(each -> DateConvertor.toLocalDate(each.getDate())
				.isAfter(date))
		.findFirst().orElse(null);

	}

}
