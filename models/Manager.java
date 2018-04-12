package models;

import java.io.File;

public class Manager {
	
	private File fatherFile;
	private Tree treeFiles;

	public Manager(String fatherPath, int sizeFile) {
		fatherFile = new File(fatherPath);
		treeFiles = new Tree(fatherFile, sizeFile);
		addToTree();
	}
	
	public Manager() {
		treeFiles = new Tree();
	}
	
	public void addToTree() {
		addToTree(fatherFile);
	}
	
	private void addToTree(File actual){
		treeFiles.addFiles(actual);
		if (actual.isDirectory()) {
			for (File file : actual.listFiles()) {
				addToTree(file);
			}
		}
	}
	
	public void showInformationFile(){
		showInformationFile(fatherFile, " ");
	}

	private void showInformationFile(File actual, String empty) {
//		System.out.println(empty + actual.getName());
		if (actual.isDirectory()) {
			for (File file : actual.listFiles()) {
				showInformationFile(file, empty + "		|"); 
			}
		}
	}

	public File getFatherFile() {
		return fatherFile;
	}
	
	public void showTree(){
		treeFiles.showTree();
	}
	
	public void setFileFather(File father){
		this.fatherFile = father;
		treeFiles = new Tree(father);
		addToTree();
	}
	
	public void setTotalSize(int totalSize){
		treeFiles.clearTree();
		treeFiles.setTotalSize(totalSize);
		addToTree();
	}
	
	public Node getRootTree(){
		return treeFiles.getRoot();
	}
	public Tree getFiles() {
		return treeFiles;
	}
}