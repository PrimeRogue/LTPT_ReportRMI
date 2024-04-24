package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class frmQLDichVu extends JPanel implements ActionListener{
	
	private JTextField txtSearch;
	private JButton btnThem;
	private DefaultTableModel tblModel;
	private TableRowSorter<TableModel> sorter;
	private JTable tblThemDichVu;
	private JButton btnXoa;
	private JButton btnCapNhat;
	
	
	public frmQLDichVu() {
		Color color = new Color(102, 204, 51);
		//pTop
		
		Box boxMain = Box.createVerticalBox();
		boxMain.add(Box.createVerticalStrut(35));
		Box boxSearch = Box.createHorizontalBox();
		txtSearch = new JTextField(20);
		Icon iconSearch = new ImageIcon("img\\search.png");
		JLabel lblIcon = new JLabel(iconSearch);
		boxSearch.add(txtSearch);
		boxSearch.add(lblIcon);
		boxSearch.add(Box.createHorizontalStrut(740));
		btnThem = new JButton("Thêm dich vu");
		btnThem.setBackground(color);
		btnThem.setForeground(Color.white);
		boxSearch.add(btnThem);
		boxMain.add(boxSearch);
		
		//table
		String column[] = { "Ma dich vu","Ten dich vu","Loại", "Don gia" };

		tblModel = new DefaultTableModel(null, column);
		tblThemDichVu = new JTable(tblModel);
		sorter = new TableRowSorter<TableModel>(tblModel);
		tblThemDichVu.setRowSorter(sorter);
		boxMain.add(Box.createVerticalStrut(20));
		boxMain.add(new JScrollPane(tblThemDichVu));
		
		boxMain.add(Box.createVerticalStrut(20));
		Box boxBtn = Box.createHorizontalBox();
		boxBtn.add(Box.createHorizontalStrut(1000));
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBackground(color);
		btnCapNhat.setForeground(Color.white);
		boxBtn.add(btnCapNhat);
		boxMain.add(boxBtn);
		add(boxMain);
		btnThem.addActionListener(this);
		btnCapNhat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o == btnThem)
		{
			popupThemDichVu gdThemDichVu = new popupThemDichVu();
			gdThemDichVu.getContentPane().setBackground( Color.red );
			gdThemDichVu.setLocationRelativeTo(null);
			gdThemDichVu.setVisible(true);
		}
		if(o == btnCapNhat)
		{
			popupCapNhatDichVu gdCapNhatDichVu = new popupCapNhatDichVu();
			gdCapNhatDichVu.getContentPane().setBackground( Color.yellow );
			gdCapNhatDichVu.setLocationRelativeTo(null);
			gdCapNhatDichVu.setVisible(true);
		}
		
	}
		

	
}
