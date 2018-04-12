package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Manager;
import views.MainWindow;

public class Controller implements ActionListener{

	private MainWindow mainWindow;
	private Manager manager;

	public Controller() {
		mainWindow = new MainWindow(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case SELECT_FOLDER:
			getFilesFolder();
			break;
		default:
			break;
		}
	}

	public void getFilesFolder() {
		manager = new Manager(mainWindow.getPathFile() + "", mainWindow.getTotalSize()*1024);
		manager.showTree();
		mainWindow.showTreeFile(manager.getRootTree());
	}
}