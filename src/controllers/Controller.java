package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import models.Manager;
import views.MainWindow;

public class Controller implements ActionListener{
	
	private MainWindow mainWindow;
	private Manager manager;
	
	public Controller() {
		mainWindow = new MainWindow(this);
		manager = new Manager();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case SELECT_FOLDER:
			getFilesFolder(mainWindow.getInformationFolder());
			break;
		default:
			break;
		}
	}
	
	public void getFilesFolder(File file) {
		manager.getFilesFolder(file);
	}
}