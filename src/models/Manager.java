package models;

import java.io.File;

public class Manager {

	public Manager() {

	}

	public void getFilesFolder(File file) {
		File[] fileList = file.listFiles();
		for (File files : fileList) {
			System.out.println("Manager" + files.getPath());
		}
	}	
}