package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class popupDatPhong extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTitle;
	private JTextField txtSoPhong;
	private JTextField txtLoaiPhong;
	private JTextField txtSDTKH;
	private JButton btnThemKH;
	private JTextField txtNgayBatDau;
	private JTextField txtNgayKetThuc;
	private JTable tblThongTinPhong;
	private TableRowSorter<TableModel> sorter;
	private JButton btnChonPhong;
	private DefaultTableModel tblModelThongTinPhong;
	private DefaultTableModel tblModelPhongDaChon;
	private JTable tblPhongDaChon;
	private JButton btnLuu;
	private JButton btnHuy;
	private JTextField txtTenKH;
	private JDateChooser ngayBatDau;
	private JDateChooser ngayKetThuc;

	public popupDatPhong() {
		// north
		JPanel pTop = new JPanel();
		lblTitle = new JLabel("Đặt Phòng");
		lblTitle.setFont(new Font("Serif", Font.BOLD, 30));
		pTop.setLayout(new GridBagLayout());
		pTop.add(lblTitle);
		lblTitle.setForeground(Color.BLUE);
		pTop.setPreferredSize(new Dimension(0, 60));
		add(pTop, BorderLayout.NORTH);
		pTop.setBackground(Color.white);


		Box boxMain = Box.createVerticalBox();
		
		// pCenterTop
		Box boxCenterTop = Box.createHorizontalBox();
		JLabel lblThongTinP = new JLabel("Thông tin phòng");
		lblThongTinP.setFont(new Font("Serif", Font.BOLD, 20));
		boxCenterTop.add(lblThongTinP);
		boxCenterTop.add(Box.createHorizontalStrut(440));
		lblThongTinP.setForeground(Color.BLUE);

		JLabel lblThongTinKh = new JLabel("Thông tin khách hàng");
		lblThongTinKh.setFont(new Font("Serif", Font.BOLD, 20));
		boxCenterTop.add(lblThongTinKh);
		lblThongTinKh.setForeground(Color.BLUE);

		boxMain.add(boxCenterTop);
		
		boxMain.add(Box.createVerticalStrut(20));
		Box boxCenterThongTin = Box.createHorizontalBox();
		boxCenterThongTin.add(Box.createHorizontalStrut(30));
		JPanel panelTimKiem = new JPanel();
		TitledBorder titleBorder = new TitledBorder(BorderFactory.createTitledBorder("Tìm kiếm"));
		panelTimKiem.setBorder(new TitledBorder(titleBorder));
		panelTimKiem.setPreferredSize(new Dimension(500,75));
		Box boxTimKiem = Box.createVerticalBox();
		Box boxSoPhong = Box.createHorizontalBox();
		JLabel lblSoPhong = new JLabel("Số phòng:");
		boxSoPhong.add(lblSoPhong);
		boxSoPhong.add(Box.createHorizontalStrut(10));
		txtSoPhong = new JTextField(15);
		boxSoPhong.add(txtSoPhong);
		//boxSoPhong.add(Box.createHorizontalStrut(60));
		boxTimKiem.add(boxSoPhong);
		boxTimKiem.add(Box.createVerticalStrut(10));
		Box boxLoaiPhong = Box.createHorizontalBox();
		JLabel lblLoaiPhong = new JLabel("Loại phòng:");
		boxLoaiPhong.add(lblLoaiPhong);
		boxLoaiPhong.add(Box.createHorizontalStrut(5));
		txtLoaiPhong = new JTextField(15);
		boxLoaiPhong.add(txtLoaiPhong);
		//boxLoaiPhong.add(Box.createHorizontalStrut(60));
		boxTimKiem.add(boxLoaiPhong);
		panelTimKiem.add(boxTimKiem);

		boxCenterThongTin.add(panelTimKiem);
		
		boxCenterThongTin.add(Box.createHorizontalStrut(200));
		
		Box boxThongTinKH = Box.createVerticalBox();
		Box boxSdt = Box.createHorizontalBox();
		JLabel lblSDT = new JLabel("SĐT Khách hàng");
		boxSdt.add(lblSDT);
		boxSdt.add(Box.createHorizontalStrut(10));
		txtSDTKH = new JTextField(20);
		boxSdt.add(txtSDTKH);
		btnThemKH = new JButton("+");
		boxSdt.add(Box.createHorizontalStrut(10));
		boxSdt.add(btnThemKH);
		boxSdt.add(Box.createHorizontalStrut(80));
		boxThongTinKH.add(boxSdt);
		boxThongTinKH.add(Box.createVerticalStrut(10));
		Box boxTenKh = Box.createHorizontalBox();
		JLabel lblTenKH = new JLabel("Tên khách khàng");
		boxTenKh.add(lblTenKH);
		boxTenKh.add(Box.createHorizontalStrut(10));
		txtTenKH = new JTextField(25);
		boxTenKh.add(txtTenKH);
		txtTenKH.setEditable(false);
		boxTenKh.add(Box.createHorizontalStrut(80));
		boxThongTinKH.add(boxTenKh);
		boxThongTinKH.add(Box.createVerticalStrut(10));
		Box boxNgay = Box.createHorizontalBox();

		JLabel lblNgayBatDau = new JLabel("Ngày BĐ");
		boxNgay.add(lblNgayBatDau);
		boxNgay.add(Box.createHorizontalStrut(10));
		ngayBatDau = new JDateChooser();
		ngayBatDau.setDateFormatString("dd/MM/y");
		boxNgay.add(ngayBatDau);
		boxNgay.add(Box.createHorizontalStrut(10));
		JLabel lblKetThuc = new JLabel("Ngày KT");
		boxNgay.add(lblKetThuc);
		boxNgay.add(Box.createHorizontalStrut(10));
		ngayKetThuc = new JDateChooser();
		ngayKetThuc.setDateFormatString("dd/MM/y");
		boxNgay.add(ngayKetThuc);
		boxThongTinKH.add(boxNgay);
		boxCenterThongTin.add(boxThongTinKH);
		boxCenterThongTin.add(Box.createHorizontalStrut(30));
		
		boxMain.add(boxCenterThongTin);
		boxMain.add(Box.createVerticalStrut(20));
		// boxTable

		Box boxTable = Box.createHorizontalBox();

		// tableThongTinPhong
		String column[] = { "Số phòng", "Loại phòng" };
		tblModelThongTinPhong = new DefaultTableModel(null, column);
		tblThongTinPhong = new JTable(tblModelThongTinPhong);
		sorter = new TableRowSorter<TableModel>(tblModelThongTinPhong);
		tblThongTinPhong.setRowSorter(sorter);
		boxTable.add(Box.createHorizontalStrut(30));
		boxTable.add(new JScrollPane(tblThongTinPhong));
		boxTable.add(Box.createHorizontalStrut(30));
		btnChonPhong = new JButton(">>");
		boxTable.add(btnChonPhong);

		// tablePhongDaChon
		String column1[] = { "Số phòng", "Số người","Ngày bắt đầu" };
		tblModelPhongDaChon = new DefaultTableModel(null, column1);
		tblPhongDaChon = new JTable(tblModelPhongDaChon);
		boxTable.add(Box.createHorizontalStrut(30));
		boxTable.add(new JScrollPane(tblPhongDaChon));
		boxTable.add(Box.createHorizontalStrut(30));
		boxMain.add(boxTable);
		
		
		add(boxMain,BorderLayout.CENTER);
		boxMain.add(Box.createVerticalStrut(10));
		
		//pSouth
		Color color = new Color(102, 204, 51);
		Box boxSouth = Box.createHorizontalBox();
		boxSouth.add(Box.createHorizontalStrut(800));
		btnLuu  = new JButton("Lưu");
		btnLuu.setBackground(color);
		btnLuu.setForeground(Color.white);
		boxSouth.add(btnLuu);
		boxSouth.add(Box.createHorizontalStrut(10));
		btnHuy  = new JButton("Hủy");
		btnHuy.setBackground(Color.gray);
		btnHuy.setForeground(Color.white);
		boxSouth.add(btnHuy);
		boxMain.add(boxSouth);
		
		add(boxMain,BorderLayout.SOUTH);
		boxMain.add(Box.createVerticalStrut(10));
		setUndecorated(true);
		getRootPane().setBorder(BorderFactory.createMatteBorder(2,2, 2, 2, Color.black));
		btnHuy.addActionListener(this);
		
		setSize(1000,715);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o == btnHuy)
		{
			dispose();
		}
		
	}

}
