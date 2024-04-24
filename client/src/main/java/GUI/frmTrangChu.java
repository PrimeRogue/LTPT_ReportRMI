package GUI;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class frmTrangChu extends JPanel{
	public frmTrangChu()
	{
		JLabel lbl = new JLabel("Trang chủ");
		setBackground(Color.red);
		add(lbl);
	}
}
