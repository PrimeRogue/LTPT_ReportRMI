package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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

public class frmDatPhong extends JPanel implements ActionListener{
	private JTextField txtSearch;
	private JButton btnThem,btnXoa,btnXemChiTiet;
	private JTable tblDatPhong;
	private DefaultTableModel tblModel;
	private TableRowSorter<TableModel> sorter;
	public frmDatPhong()
	{
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
		btnThem = new JButton("Đặt phòng");
		btnThem.setBackground(color);
		btnThem.setForeground(Color.white);
		boxSearch.add(btnThem);
		boxMain.add(boxSearch);
		
		//table
		String column[] = { "Số phiếu đặt","Tên khách hàng","Ngày lập phiếu","Tên nhân viên" };

		tblModel = new DefaultTableModel(null, column);
		tblDatPhong = new JTable(tblModel);
		sorter = new TableRowSorter<TableModel>(tblModel);
		tblDatPhong.setRowSorter(sorter);
		boxMain.add(Box.createVerticalStrut(20));
		boxMain.add(new JScrollPane(tblDatPhong));
		
		boxMain.add(Box.createVerticalStrut(20));
		add(boxMain);
		btnThem.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o == btnThem)
		{
			popupDatPhong gdDatPhong = new popupDatPhong();
			gdDatPhong.setLocationRelativeTo(null);
			gdDatPhong.setVisible(true);
		}
		
	}
}
