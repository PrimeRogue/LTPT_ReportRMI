package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class frmPhong extends JPanel {
	private DefaultTableModel model;
	private JTable table;
	private JTextField txtSearch;
	private ButtonGroup grpTrangThai, grpLoaiPhong, grpTinhTrang;
	private JRadioButton rdoPTrong;
	private JRadioButton rdoPDaDat;
	private JRadioButton rdoPDangThue;
	private JRadioButton rdoPTatCa;
	private JRadioButton rdoPDon;
	private JRadioButton rdoPDoi;
	private Component rdoPGDinh;
	private JRadioButton rdoPTatCaLP;
	private JRadioButton rdoDaDonDep;
	private JRadioButton rdoChDonDep;
	private JRadioButton rdoPSuaChua;
	private JRadioButton rdoPTatCaTT;
	private DefaultTableModel tblModel;
	private JTable tblPhong;
	private TableRowSorter<TableModel> sorter;

	/**
	 * Create the panel.
	 */
	public frmPhong() {
		
		
		Box boxMain = Box.createVerticalBox();
		JPanel pTop = new JPanel();
		boxMain.add(Box.createVerticalStrut(30));
		Box boxSearch = Box.createHorizontalBox();
		txtSearch = new JTextField(20);
		Icon iconSearch = new ImageIcon("img\\search.png");
		JLabel lblIcon = new JLabel(iconSearch);
		boxSearch.add(txtSearch);
		boxSearch.add(Box.createHorizontalStrut(20));
		boxSearch.add(lblIcon);
		pTop.add(boxSearch);
		boxMain.add(pTop);
		boxMain.add(Box.createVerticalStrut(30));
		
		Box boxCenter = Box.createHorizontalBox();
		// pCenter
		Box boxRdo = Box.createVerticalBox();
		JPanel pTrangThai = new JPanel();
		pTrangThai.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Trạng thái", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		grpTrangThai = new ButtonGroup();
		Box boxTrangThai = Box.createVerticalBox();
		rdoPTrong = new JRadioButton("Phòng trống");
		boxTrangThai.add(rdoPTrong);
		rdoPTrong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		grpTrangThai.add(rdoPTrong);

		rdoPDaDat = new JRadioButton("Phòng đã đặt");
		boxTrangThai.add(rdoPDaDat);
		rdoPDaDat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		grpTrangThai.add(rdoPDaDat);

		rdoPDangThue = new JRadioButton("Phòng đang thuê");
		boxTrangThai.add(rdoPDangThue);
		rdoPDangThue.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		grpTrangThai.add(rdoPDangThue);

		rdoPTatCa = new JRadioButton("Tất cả");
		boxTrangThai.add(rdoPTatCa);
		rdoPTatCa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		grpTrangThai.add(rdoPTatCa);
		pTrangThai.add(boxTrangThai);
		boxRdo.add(pTrangThai);
		
		JPanel pLoaiPhong = new JPanel();

		pLoaiPhong.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Loại phòng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		grpLoaiPhong = new ButtonGroup();
		Box boxLoaiPhong = Box.createVerticalBox();

		rdoPDon = new JRadioButton("Phòng đơn");
		boxLoaiPhong.add(rdoPDon);
		rdoPDon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		grpLoaiPhong.add(rdoPDon);

		rdoPDoi = new JRadioButton("Phòng đôi");
		boxLoaiPhong.add(rdoPDoi);
		rdoPDoi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		grpLoaiPhong.add(rdoPDoi);

		rdoPGDinh = new JRadioButton("Phòng gia đình");
		boxLoaiPhong.add(rdoPGDinh);
		rdoPGDinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		grpLoaiPhong.add((AbstractButton) rdoPGDinh);

		rdoPTatCaLP = new JRadioButton("Tất cả");
		boxLoaiPhong.add(rdoPTatCaLP);
		rdoPTatCaLP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		grpLoaiPhong.add(rdoPTatCaLP);

		pLoaiPhong.add(boxLoaiPhong);
		boxRdo.add(pLoaiPhong);
		
		
		JPanel pTinhTrang = new JPanel();

		pTinhTrang.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Tình trạng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		grpTinhTrang = new ButtonGroup();
		Box boxTinhTrang = Box.createVerticalBox();

		rdoDaDonDep = new JRadioButton("Đã dọn dẹp");
		boxTinhTrang.add(rdoDaDonDep);
		rdoDaDonDep.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		grpTinhTrang.add(rdoDaDonDep);

		rdoChDonDep = new JRadioButton("Chưa dọn dẹp");
		boxTinhTrang.add(rdoChDonDep);
		rdoChDonDep.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		grpTinhTrang.add(rdoChDonDep);

		rdoPSuaChua = new JRadioButton("Phòng sửa chữa");
		boxTinhTrang.add(rdoPSuaChua);
		rdoPSuaChua.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		grpTinhTrang.add(rdoPSuaChua);

		rdoPTatCaTT = new JRadioButton("Tất cả");
		boxTinhTrang.add(rdoPTatCaTT);
		rdoPTatCaTT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		grpTinhTrang.add(rdoPTatCaTT);

		pTinhTrang.add(boxTinhTrang);
		boxRdo.add(pTinhTrang);
		boxCenter.add(boxRdo);
		boxCenter.add(Box.createHorizontalStrut(40));
		
		
		String column[]={"Tên phòng","Loại phòng","Trạng thái","Tình trạng"}; 
		tblModel = new DefaultTableModel(null,column);
		tblPhong = new JTable(tblModel);
		sorter = new TableRowSorter<TableModel>(tblModel);
		tblPhong.setRowSorter(sorter);
		
		
		boxCenter.add(new JScrollPane(tblPhong));
		

		
		boxMain.add(boxCenter);		
		
		add(boxMain);
		
		
		
		
	
		 
	}

}
