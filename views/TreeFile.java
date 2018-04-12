package views;

import java.awt.BorderLayout;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import models.Node;

public class TreeFile extends JTree{

	private static final long serialVersionUID = 1L;
	private DefaultMutableTreeNode defaultMutableTreeNode;
	private DefaultTreeModel defaultTreeModel;

	public TreeFile() {
		setSize(500, 500);
		setLayout(new BorderLayout());
	}
	
	private void showTreeFile(Node root, DefaultMutableTreeNode jRoot) {
		if (root != null) {
			DefaultMutableTreeNode jNode = new DefaultMutableTreeNode(root.getInformation());
			jRoot.add(jNode);
			for (Node actual : root.getNodes()) {
				showTreeFile(actual, jNode);
			}
		}
	}

	public void showTreeFile(Node root){
		cleanTreeFile();
		if (root != null) {
			defaultMutableTreeNode = new DefaultMutableTreeNode(root.getInformation());
			defaultTreeModel = new DefaultTreeModel(defaultMutableTreeNode);
			setModel(defaultTreeModel);
			for (Node actual : root.getNodes()) {
				showTreeFile(actual, defaultMutableTreeNode);
			}
		}
	}

	public void cleanTreeFile(){
		revalidate();
		repaint();
		defaultMutableTreeNode = null;
		defaultTreeModel = null;
		removeAll();
	}
}
