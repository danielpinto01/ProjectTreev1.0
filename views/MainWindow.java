package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import controllers.Controller;
import controllers.Events;
import models.Node;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private JButton btnFolder;
	private ImageIcon imageBtnFolder;
	private TreeFile treeFile;
	private FChooser fChooser;

	public MainWindow(Controller controller) {
		setTitle("Tree Manager");
		getContentPane().setBackground(Color.WHITE);
		setSize(500, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("src/images/Icon.png").getImage());
		setLayout(new BorderLayout());

		fChooser = new FChooser();
		
		init(controller);

		setVisible(true);
	}

	public void init(Controller controller) {
		imageBtnFolder = new ImageIcon("src/images/Folder.png");
		btnFolder = new JButton(imageBtnFolder);
		btnFolder.setBackground(Color.WHITE);
		btnFolder.addActionListener(controller);
		btnFolder.setActionCommand(Events.SELECT_FOLDER.toString());
		btnFolder.setFocusable(false);
		add(btnFolder, BorderLayout.NORTH);
	}
	
	public void showTreeFile(Node root){
		treeFile = new TreeFile();
		treeFile.cleanTreeFile();
		treeFile.showTreeFile(root);
		add(new JScrollPane(treeFile), BorderLayout.CENTER);
	}
	
	public File getPathFile(){
		return fChooser.getInformationFolder();
	}
	
	public int getTotalSize(){
		return Integer.parseInt(JOptionPane.showInputDialog("Ingrese un tamaño base en Mb"));
	}
}
