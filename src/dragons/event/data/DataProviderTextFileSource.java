package dragons.event.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dragons.event.models.Event;
import dragons.event.utility.ConsoleOutput;
import dragons.event.utility.DateConvertor;

public class DataProviderTextFileSource extends ConsoleOutput implements EventData {
	
	private ArrayList<Event> events;
	
	public DataProviderTextFileSource() {
		this.events = new ArrayList<>(); 
		generateData();
	}
	
	private void generateData() {
		//Path to text file. 
		String filePath = System.getProperty("user.dir") + "/src/dragons/event/data/2023_events.txt";
		try {
			//Reading text files and return list of String for each line. 
			Path path = Paths.get(filePath);
			List<String> lines = Files.readAllLines(path);
			for(String line : lines) {
				addEvent(line);
			}
		}catch(IOException e) {
			System.out.println("File Not found");
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}
	
	private void addEvent(String line) {
		String[] splitedLine = line.split(",");
		String holidayName = splitedLine[0];
		String date = splitedLine[1];
		boolean isFedHoliday = (splitedLine[2].contains("Federal Holiday")) ? true : false;
		Event event = new Event(holidayName, date, isFedHoliday);
		events.add(event);
	}

	@Override
	public Event findNextEvent(LocalDate date) {
		return events.stream()
				.filter(each -> DateConvertor.toLocalDate(each.getDate())
						.isAfter(date))
				.findFirst().orElse(null);
	}

}
