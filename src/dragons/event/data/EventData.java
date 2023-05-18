package dragons.event.data;

import java.time.LocalDate;

import dragons.event.models.Event;

public interface EventData {
	
	public Event findNextEvent(LocalDate date);

}
