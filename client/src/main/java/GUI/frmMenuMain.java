package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.*;
import javax.swing.border.Border;

public class frmMenuMain extends JFrame implements ActionListener,MouseListener{
	 private JButton btnTrangChu,btnPhong,btnDatPhong,btnHoaDon,btnQLKhachHang,btnQLPhong,btnQLLoaiPhong,
	 btnQLDichVu,btnQLLoaiDichVu,btnThongKe,btnTaiKhoan,btnNhanVien,btnTienNghi,btnChiTietTienNghi,btnLogout;
	 private JLabel lblTenDangNhap,lblChangeMenu;
	 Color colorEntered = new Color(203, 200, 200);
	 private CardLayout card;
	 private JPanel pCenter;
	 private frmTrangChu panelTrangChu;
	 private frmPhong panelPhong;
	 private frmDatPhong panelDatPhong;
	 private frmHoaDon panelHoaDon;
	 private frmQLKhachHang panelKhachHang;
	 private frmQLPhong panelQLPhong;
	 private frmQLLoaiPhong panelQLLoaiPhong;
	 private frmQLDichVu panelQLDichVu;
	 private frmQLLoaiDichVu panelQLLoaiDichVu;
	 private frmTienNghi panelTienNghi;
	 private frmChiTietTienNghi panelChiTietTienNghi;
	 private frmQLTaiKhoan panelQLTaiKhoan;
	 private frmQLNhanVien panelQLNhanVien;
	 private frmThongKe panelThongKe;
	 public frmMenuMain() throws MalformedURLException, NotBoundException, RemoteException {
			setSize(1400, 800);
			setLocationRelativeTo(null);
			//menu pTop
			JPanel pMenu = new  JPanel();
			pMenu.setBackground(Color.white);
			Box boxLogin = Box.createHorizontalBox();
			JPanel pInFoNV = new JPanel();
			Icon iconAvata = new ImageIcon("img\\male_user.png");
			JLabel lblIcon = new JLabel(iconAvata);
			Color color = new Color(102, 204, 51);
			pInFoNV.setBackground(color);
			lblTenDangNhap = new JLabel("Tên đăng nhập");
			lblTenDangNhap.setForeground(Color.white);
			lblChangeMenu = new JLabel("Trang chủ");
			lblChangeMenu.setForeground(Color.white);
			btnLogout = new JButton("Đăng xuất");
			btnLogout.setBackground(color);
			//Border emptyBorder = BorderFactory.createEmptyBorder();
			btnLogout.setBorderPainted(false);
			btnLogout.setForeground(Color.white);
			boxLogin.add(lblChangeMenu);
			boxLogin.add(Box.createHorizontalStrut(1050));
			boxLogin.add(lblIcon);
			boxLogin.add(Box.createHorizontalStrut(10));
			boxLogin.add(lblTenDangNhap);
			boxLogin.add(Box.createHorizontalStrut(20));
			boxLogin.add(btnLogout);
			pInFoNV.add(boxLogin);
			add(pInFoNV,BorderLayout.NORTH);
			btnTrangChu = new JButton("  Trang Chủ          ");
			btnTrangChu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnTrangChu.setIcon(new ImageIcon("img\\home.png"));
			btnTrangChu.setBackground(Color.white);
			btnTrangChu.setForeground(Color.black);
			btnTrangChu.setBorderPainted(false);
			btnTrangChu.setPreferredSize(new Dimension(230,60));
			btnTrangChu.addMouseListener(this);
			btnTrangChu.addActionListener(this);
			pMenu.add(btnTrangChu);
			
			btnPhong = new JButton("  Phòng                ");
			btnPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnPhong.setIcon(new ImageIcon("img\\room.png"));
			btnPhong.setBackground(Color.white);
			btnPhong.setForeground(Color.black);
			btnPhong.setBorderPainted(false);
			btnPhong.setPreferredSize(new Dimension(230,60));
			btnPhong.addMouseListener(this);
			btnPhong.addActionListener(this);
			pMenu.add(btnPhong);
			
			btnDatPhong = new JButton("  Đặt Phòng          ");
			btnDatPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnDatPhong.setIcon(new ImageIcon("img\\order.png"));
			btnDatPhong.setBackground(Color.white);
			btnDatPhong.setForeground(Color.black);
			btnDatPhong.setBorderPainted(false);
			btnDatPhong.setPreferredSize(new Dimension(230,60));
			btnDatPhong.addMouseListener(this);
			btnDatPhong.addActionListener(this);
			pMenu.add(btnDatPhong);
			
			btnHoaDon = new JButton("  Hóa đơn             ");
			btnHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnHoaDon.setIcon(new ImageIcon("img\\invoice.png"));
			btnHoaDon.setBackground(Color.white);
			btnHoaDon.setForeground(Color.black);
			btnHoaDon.setBorderPainted(false);
			btnHoaDon.setPreferredSize(new Dimension(230,60));
			btnHoaDon.addMouseListener(this);
			btnHoaDon.addActionListener(this);
			pMenu.add(btnHoaDon);
			
			
			btnQLKhachHang = new JButton("  QL khách hàng   ");
			btnQLKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnQLKhachHang.setIcon(new ImageIcon("img\\user.png"));
			btnQLKhachHang.setBackground(Color.white);
			btnQLKhachHang.setForeground(Color.black);
			btnQLKhachHang.setBorderPainted(false);
			btnQLKhachHang.setPreferredSize(new Dimension(230,60));
			btnQLKhachHang.addMouseListener(this);
			btnQLKhachHang.addActionListener(this);
			pMenu.add(btnQLKhachHang);
			
			
			
			btnQLPhong = new JButton("  QL phòng           ");
			btnQLPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnQLPhong.setIcon(new ImageIcon("img\\interior.png"));
			btnQLPhong.setBackground(Color.white);
			btnQLPhong.setForeground(Color.black);
			btnQLPhong.setBorderPainted(false);
			btnQLPhong.setPreferredSize(new Dimension(230,60));
			btnQLPhong.addMouseListener(this);
			btnQLPhong.addActionListener(this);
			pMenu.add(btnQLPhong);
			
			
			btnQLLoaiPhong = new JButton("  QL loại phòng   ");
			btnQLLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnQLLoaiPhong.setIcon(new ImageIcon("img\\hotel.png"));
			btnQLLoaiPhong.setBackground(Color.white);
			btnQLLoaiPhong.setForeground(Color.black);
			btnQLLoaiPhong.setBorderPainted(false);
			btnQLLoaiPhong.setPreferredSize(new Dimension(230,60));
			btnQLLoaiPhong.addMouseListener(this);
			btnQLLoaiPhong.addActionListener(this);
			pMenu.add(btnQLLoaiPhong);
			
			
			btnQLDichVu = new JButton("  QL dịch vụ         ");
			btnQLDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnQLDichVu.setIcon(new ImageIcon("img\\pizza.png"));
			btnQLDichVu.setBackground(Color.white);
			btnQLDichVu.setForeground(Color.black);
			btnQLDichVu.setBorderPainted(false);
			btnQLDichVu.setPreferredSize(new Dimension(230,60));
			btnQLDichVu.addMouseListener(this);
			btnQLDichVu.addActionListener(this);
			pMenu.add(btnQLDichVu);
			
			
			btnQLLoaiDichVu = new JButton("  QL loại dịch vụ  ");
			btnQLLoaiDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnQLLoaiDichVu.setIcon(new ImageIcon("img\\food_service.png"));
			btnQLLoaiDichVu.setBackground(Color.white);
			btnQLLoaiDichVu.setForeground(Color.black);
			btnQLLoaiDichVu.setBorderPainted(false);
			btnQLLoaiDichVu.setPreferredSize(new Dimension(230,60));
			btnQLLoaiDichVu.addMouseListener(this);
			btnQLLoaiDichVu.addActionListener(this);
			pMenu.add(btnQLLoaiDichVu);
			
			btnTienNghi = new JButton("  QL tiện nghi       ");
			btnTienNghi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnTienNghi.setIcon(new ImageIcon("img\\fan.png"));
			btnTienNghi.setBackground(Color.white);
			btnTienNghi.setForeground(Color.black);
			btnTienNghi.setBorderPainted(false);
			btnTienNghi.setPreferredSize(new Dimension(230,60));
			btnTienNghi.addMouseListener(this);
			btnTienNghi.addActionListener(this);
			pMenu.add(btnTienNghi);
			
			
			btnChiTietTienNghi = new JButton("  QL CT tiện nghi");
			btnChiTietTienNghi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnChiTietTienNghi.setIcon(new ImageIcon("img\\fan2.png"));
			btnChiTietTienNghi.setBackground(Color.white);
			btnChiTietTienNghi.setForeground(Color.black);
			btnChiTietTienNghi.setBorderPainted(false);
			btnChiTietTienNghi.setPreferredSize(new Dimension(230,60));
			btnChiTietTienNghi.addMouseListener(this);
			btnChiTietTienNghi.addActionListener(this);
			pMenu.add(btnChiTietTienNghi);
			
			
			
			btnTaiKhoan = new JButton("  QL tài khoản     ");
			btnTaiKhoan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnTaiKhoan.setIcon(new ImageIcon("img\\userlogin.png"));
			btnTaiKhoan.setBackground(Color.white);
			btnTaiKhoan.setForeground(Color.black);
			btnTaiKhoan.setBorderPainted(false);
			btnTaiKhoan.setPreferredSize(new Dimension(230,60));
			btnTaiKhoan.addMouseListener(this);
			btnTaiKhoan.addActionListener(this);
			pMenu.add(btnTaiKhoan);
			
			btnNhanVien = new JButton("  QL nhân viên     ");
			btnNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnNhanVien.setIcon(new ImageIcon("img\\employee.png"));
			btnNhanVien.setBackground(Color.white);
			btnNhanVien.setForeground(Color.black);
			btnNhanVien.setBorderPainted(false);
			btnNhanVien.setPreferredSize(new Dimension(230,60));
			btnNhanVien.addMouseListener(this);
			btnNhanVien.addActionListener(this);
			pMenu.add(btnNhanVien);
			
			btnThongKe = new JButton("  Thống kê            ");
			btnThongKe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnThongKe.setIcon(new ImageIcon("img\\pie_chart.png"));
			btnThongKe.setBackground(Color.white);
			btnThongKe.setForeground(Color.black);
			btnThongKe.setBorderPainted(false);
			btnThongKe.setPreferredSize(new Dimension(230,60));
			btnThongKe.addMouseListener(this);
			btnThongKe.addActionListener(this);
			pMenu.add(btnThongKe);
			
			
			pMenu.setLayout(new GridLayout(14,1));
			add(pMenu,BorderLayout.WEST);
			
			//center
			pCenter = new JPanel();
			pCenter.setBackground(Color.red);
			card = new CardLayout();
			pCenter.setLayout((LayoutManager) card);
			panelTrangChu = new frmTrangChu();
			panelPhong = new frmPhong();
			panelDatPhong = new frmDatPhong();
			panelHoaDon = new frmHoaDon();
			panelKhachHang = new frmQLKhachHang();
			panelQLPhong = new frmQLPhong();
			panelQLLoaiPhong = new frmQLLoaiPhong();
			panelQLDichVu = new frmQLDichVu();
			panelQLLoaiDichVu = new frmQLLoaiDichVu();
			panelTienNghi = new frmTienNghi();
			panelChiTietTienNghi = new frmChiTietTienNghi();
			panelQLTaiKhoan = new frmQLTaiKhoan();
			panelQLNhanVien = new frmQLNhanVien();
			panelThongKe = new frmThongKe();
			
			
			
			pCenter.add(panelTrangChu,"1");
			pCenter.add(panelPhong,"2");
			pCenter.add(panelDatPhong,"3");
			pCenter.add(panelHoaDon,"4");
			pCenter.add(panelKhachHang,"5");
			pCenter.add(panelQLPhong,"6");
			pCenter.add(panelQLLoaiPhong,"7");
			pCenter.add(panelQLDichVu,"8");
			pCenter.add(panelQLLoaiDichVu,"9");
			pCenter.add(panelQLTaiKhoan,"10");
			pCenter.add(panelQLNhanVien,"11");
			pCenter.add(panelThongKe,"12");
			pCenter.add(panelTienNghi,"13");
			pCenter.add(panelChiTietTienNghi,"14");
			card.show(pCenter, "1");
			add(pCenter,BorderLayout.CENTER);
			


			
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
//		Object o = e.getSource();
//		
//		if(o == btnTrangChu)
//		{
//			btnTrangChu.setBackground(colorEntered);
//		}
//		if(o == btnPhong)
//		{
//			btnPhong.setBackground(colorEntered);
//		}
//		if(o == btnDatPhong)
//		{
//			btnDatPhong.setBackground(colorEntered);
//		}
//		if(o == btnHoaDon)
//		{
//			btnHoaDon.setBackground(colorEntered);
//		}
//		if(o == btnQLKhachHang)
//		{
//			btnQLKhachHang.setBackground(colorEntered);
//		}
//		if(o == btnQLPhong)
//		{
//			btnQLPhong.setBackground(colorEntered);
//		}
//		if(o == btnQLLoaiPhong)
//		{
//			btnQLLoaiPhong.setBackground(colorEntered);
//		}
//		if(o == btnQLDichVu)
//		{
//			btnQLDichVu.setBackground(colorEntered);
//		}
//		if(o == btnQLLoaiDichVu)
//		{
//			btnQLLoaiDichVu.setBackground(colorEntered);
//		}
//		if(o == btnTienNghi)
//		{
//			btnTienNghi.setBackground(colorEntered);
//		}
//		if(o == btnChiTietTienNghi)
//		{
//			btnChiTietTienNghi.setBackground(colorEntered);
//		}
//		if(o == btnTaiKhoan)
//		{
//			btnTaiKhoan.setBackground(colorEntered);
//		}
//		if(o == btnNhanVien)
//		{
//			btnNhanVien.setBackground(colorEntered);
//		}
//		if(o == btnThongKe)
//		{
//			btnThongKe.setBackground(colorEntered);
//		}
		Object o = e.getSource();
		
		if(o == btnTrangChu)
		{
			btnTrangChu.setBackground(Color.yellow);
		}
		if(o == btnPhong)
		{
			btnPhong.setBackground(Color.yellow);
		}
		if(o == btnDatPhong)
		{
			btnDatPhong.setBackground(Color.yellow);
		}
		if(o == btnHoaDon)
		{
			btnHoaDon.setBackground(Color.yellow);
		}
		if(o == btnQLKhachHang)
		{
			btnQLKhachHang.setBackground(Color.yellow);
		}
		if(o == btnQLPhong)
		{
			btnQLPhong.setBackground(Color.yellow);
		}
		if(o == btnQLLoaiPhong)
		{
			btnQLLoaiPhong.setBackground(Color.yellow);
		}
		if(o == btnQLDichVu)
		{
			btnQLDichVu.setBackground(Color.yellow);
		}
		if(o == btnQLLoaiDichVu)
		{
			btnQLLoaiDichVu.setBackground(Color.yellow);
		}
		if(o == btnTienNghi)
		{
			btnTienNghi.setBackground(Color.yellow);
		}
		if(o == btnChiTietTienNghi)
		{
			btnChiTietTienNghi.setBackground(Color.yellow);
		}
		if(o == btnTaiKhoan)
		{
			btnTaiKhoan.setBackground(Color.yellow);
		}
		if(o == btnNhanVien)
		{
			btnNhanVien.setBackground(Color.yellow);
		}
		if(o == btnThongKe)
		{
			btnThongKe.setBackground(Color.yellow);
		}
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		Object o = e.getSource();
		
		if(o == btnTrangChu)
		{
			btnTrangChu.setBackground(Color.white);
		}
		if(o == btnPhong)
		{
			btnPhong.setBackground(Color.white);
		}
		if(o == btnDatPhong)
		{
			btnDatPhong.setBackground(Color.white);
		}
		if(o == btnHoaDon)
		{
			btnHoaDon.setBackground(Color.white);
		}
		if(o == btnQLKhachHang)
		{
			btnQLKhachHang.setBackground(Color.white);
		}
		if(o == btnQLPhong)
		{
			btnQLPhong.setBackground(Color.white);
		}
		if(o == btnQLLoaiPhong)
		{
			btnQLLoaiPhong.setBackground(Color.white);
		}
		if(o == btnQLDichVu)
		{
			btnQLDichVu.setBackground(Color.white);
		}
		if(o == btnQLLoaiDichVu)
		{
			btnQLLoaiDichVu.setBackground(Color.white);
		}
		if(o == btnTienNghi)
		{
			btnTienNghi.setBackground(Color.white);
		}
		if(o == btnChiTietTienNghi)
		{
			btnChiTietTienNghi.setBackground(Color.white);
		}
		if(o == btnTaiKhoan)
		{
			btnTaiKhoan.setBackground(Color.white);
		}
		if(o == btnNhanVien)
		{
			btnNhanVien.setBackground(Color.white);
		}
		if(o == btnThongKe)
		{
			btnThongKe.setBackground(Color.white);
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		
		if(o == btnTrangChu)
		{
		
			card.show(pCenter, "1");
			lblChangeMenu.setText("Trang chủ");
		}
		
		if(o == btnPhong)
		{
	
			card.show(pCenter, "2");
			lblChangeMenu.setText("Phòng");
		}
		
		if(o == btnDatPhong)
		{
		
			card.show(pCenter, "3");
			lblChangeMenu.setText("Đặt phòng");
		}
		
		if(o == btnHoaDon)
		{
		
			card.show(pCenter, "4");
			lblChangeMenu.setText("Hóa đơn");
		}
		if(o == btnQLKhachHang)
		{
		
			card.show(pCenter, "5");
			lblChangeMenu.setText("Khách hàng");
		}
		if(o == btnQLPhong)
		{
		
			card.show(pCenter, "6");
			lblChangeMenu.setText("QL Phòng");
		}
		if(o == btnQLLoaiPhong)
		{
		
			card.show(pCenter, "7");
			lblChangeMenu.setText("QL Loại Phòng");
		}
		if(o == btnQLDichVu)
		{
		
			card.show(pCenter, "8");
			lblChangeMenu.setText("Dịch Vụ");
		}
		if(o == btnQLLoaiDichVu)
		{
		
			card.show(pCenter, "9");
			lblChangeMenu.setText("Loại Dịch Vụ");
		}
		if(o == btnTienNghi)
		{
		
			card.show(pCenter, "13");
			lblChangeMenu.setText("Tiện nghi");
		}
		if(o == btnChiTietTienNghi)
		{
		
			card.show(pCenter, "14");
			lblChangeMenu.setText("Chi Tiết Tiện Nghi");
		}
		if(o == btnTaiKhoan)
		{
		
			card.show(pCenter, "10");
			lblChangeMenu.setText("Tài khoản");
		}
		if(o == btnNhanVien)
		{
		
			card.show(pCenter, "11");
			lblChangeMenu.setText("Nhân viên");
		}
		if(o == btnThongKe)
		{
		
			card.show(pCenter, "12");
			lblChangeMenu.setText("Thống kê");
		}
	}
}

	