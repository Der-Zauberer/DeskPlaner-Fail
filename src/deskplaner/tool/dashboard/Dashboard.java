package deskplaner.tool.dashboard;

import deskplaner.util.Tool;

public class Dashboard extends Tool {

	public Dashboard() {
		super("Dashboard", 1);
		addDeskScene(new DashboardScene());
	}

}
