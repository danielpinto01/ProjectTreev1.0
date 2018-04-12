package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import controllers.Controller;
import controllers.Events;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private JButton btnFolder;
	private ImageIcon imageBtnFolder;

	public MainWindow(Controller controller) {
		setTitle("Tree Manager");
		getContentPane().setBackground(Color.WHITE);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("src/images/Icon.png").getImage());
		setLayout(new BorderLayout());

		init(controller);

		setVisible(true);
	}

	public void init(Controller controller) {
		imageBtnFolder = new ImageIcon("src/images/Folder.png");
		btnFolder = new JButton(imageBtnFolder);
		btnFolder.setBackground(Color.GRAY);
		btnFolder.addActionListener(controller);
		btnFolder.setActionCommand(Events.SELECT_FOLDER.toString());
		add(btnFolder, BorderLayout.SOUTH);
	}

	public File getInformationFolder(){
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jFileChooser.setDialogTitle("Seleccionar Carpeta");
		int option = jFileChooser.showOpenDialog(this);
		if (option == JFileChooser.APPROVE_OPTION) {
			File[] fileList = jFileChooser.getSelectedFile().listFiles();
			for (File file : fileList) {
				System.out.println(file.getPath());
				getExtensionFile(file.getPath());
				getSizeFile(file.getPath());
				System.out.println(getExtensionFile(file.getPath()));
			}
		}
		return jFileChooser.getSelectedFile();
	}

	public String getExtensionFile(String filename) {
		File f = new File(filename);
		if (f == null || f.isDirectory()){
			return "Null - Folder";
		}else if (f.isFile()){
			int index = filename.lastIndexOf('.');
			if (index == -1) {
				return "";
			} else {
				return filename.substring(index + 1);
			}
		}else{
			return "Error";
		}
	}

	public void getSizeFile(String file) {
		DecimalFormat df = new DecimalFormat("#0.00");
		float size = new File(file).length();
		System.out.println("Size: " + df.format(size/1024000) + " Mb");
	}
}
