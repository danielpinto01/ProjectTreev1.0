package models;

import java.io.File;

import javax.swing.JOptionPane;

public class Tree {

	private Node rootTree;
	private int rootSize;
	
	public Tree() {
		
	}

	public Tree(File root, int rootSize){
		this.rootSize = rootSize;
//		System.out.println(root);
		if (root.isDirectory()) {
			rootTree = new Node(root.getName());
		}else {
			JOptionPane.showMessageDialog(null, "Error");;
		}
	}
	
	public Tree(File root){
		if (root.isDirectory()) {
			rootTree = new Node(root.getName());
		}else {
			JOptionPane.showMessageDialog(null, "Error");;
		}
	}
	
	public void addFiles(File file) {
		if (!file.isDirectory()) {
			String extension = "";
			extension = file.getName().substring(file.getName().lastIndexOf("."));
			Node extNode = searchExtension(extension);
			if (extNode == null) {
				getExtension(extension);
				extNode = searchExtension(extension);
			}
			addExtension(extNode, file);
		}
	}
	
	public Node searchExtension(String extension) {
		for (Node actualNode : rootTree.getNodes()) {
			if (actualNode.getInformation().equals(extension)) {
				return actualNode;
			}
		}
		return null;
	}
	
	private void getExtension(String extension){
		Node newExtension = new Node(extension);
		newExtension.getNodes().add(new Node("Tamaño menor que: " + rootSize + "Kb"));
		newExtension.getNodes().add(new Node("Tamaño mayor que: " + rootSize + "Kb"));
		rootTree.getNodes().add(newExtension);
	}
	
	public void addExtension(Node extNode, File file){
		Node nodeSize;
		if (file.length() < rootSize) {
			nodeSize = extNode.getNodes().get(0);
			 
		}else {
			nodeSize = extNode.getNodes().get(1);
		}
		nodeSize.getNodes().add(new Node(file.getName()));
	}
	
	public void showTree() {
		showTree(rootTree, " ");
	}
	
	private void showTree(Node actualNode, String empty) {
//		System.out.println(empty + actualNode.getInformation());
		for (Node node : actualNode.getNodes()) {
			showTree(node, empty + "	|");
		}
	}
	
	public void clearTree() {
		rootTree.getNodes().clear();
	}
	
	public int getTotalRootSize() {
		return rootSize;
	}
	
	public Node getRoot() {
		return rootTree;
	}
	public void setRoot(Node rootTree) {
		this.rootTree = rootTree;
	}
	
	public void setTotalSize(int rootSize) {
		this.rootSize = rootSize;
	}
}