package views;

import java.io.File;

import javax.swing.JFileChooser;

public class FChooser extends JFileChooser{

	private static final long serialVersionUID = 1L;

	public File getInformationFolder(){
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jFileChooser.setDialogTitle("Seleccionar Carpeta");
		jFileChooser.showOpenDialog(getRootPane());
		return jFileChooser.getSelectedFile();
	}
}
