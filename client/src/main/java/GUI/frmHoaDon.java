package GUI;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

public class frmHoaDon extends JPanel{
	private JTextField txtSearch;
	private JButton btnTXemChiTiet;
	private DefaultTableModel tblModel;
	private JTable tblHoaDon;
	private TableRowSorter<TableModel> sorter;
	private JDateChooser ngaySearch;

	public frmHoaDon()
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
		btnTXemChiTiet = new JButton("Xem chi tiết");
		btnTXemChiTiet.setBackground(color);
		btnTXemChiTiet.setForeground(Color.white);
		boxSearch.add(btnTXemChiTiet);
		boxMain.add(boxSearch);
		
		//table
		String column[] = { "Mã hóa đơn","Ngày lập","Tên nhân viên","Tổng tiền","Mã phòng đặt" };

		tblModel = new DefaultTableModel(null, column);
		tblHoaDon = new JTable(tblModel);
		sorter = new TableRowSorter<TableModel>(tblModel);
		tblHoaDon.setRowSorter(sorter);
		boxMain.add(Box.createVerticalStrut(20));
		boxMain.add(new JScrollPane(tblHoaDon));
		
		add(boxMain);
	}
}
