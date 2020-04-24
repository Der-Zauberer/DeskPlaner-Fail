package deskplaner.tool.calendar;

import deskplaner.util.Tool;

public class Calendar extends Tool{

	public Calendar() {
		super("Calendar");
		addDeskScene(new CalendarScene());
	}

}
