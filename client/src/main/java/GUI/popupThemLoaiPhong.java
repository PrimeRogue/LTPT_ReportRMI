package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import entities.LoaiPhong;
import services.LoaiPhongService;

public class popupThemLoaiPhong extends JFrame implements ActionListener{
	private JTextField txtSoPhong;
	private JTextField txtTrangThai;
	private JTextField txtLoaiPhong;
	private JComboBox<String> cboLoaiPhong,cboTinhTrang;
	private JButton btnThem;
	private JButton btnBoQua;
    private final JTextField txtTenLoaiPhong;
    private final JTextField txtSoGiuong;
    private final JTextField txtGia;
	LoaiPhongService loaiPhongService = (LoaiPhongService) Naming.lookup("rmi://DESKTOP-O9GK1BR:8989/loaiPhongService");

	int count= loaiPhongService.getListLoaiPhong().size();
	public popupThemLoaiPhong() throws MalformedURLException, NotBoundException, RemoteException {
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.WHITE);
		// north
		JPanel pTop = new JPanel();
		JLabel lblTitle = new JLabel("Thêm loại phòng");
		lblTitle.setFont(new Font("Serif", Font.BOLD, 30));
		pTop.setLayout(new GridBagLayout());
		pTop.add(lblTitle);
		lblTitle.setForeground(Color.BLUE);
		pTop.setPreferredSize(new Dimension(0, 60));
		//add(pTop, BorderLayout.NORTH);
		pTop.setBackground(Color.white);
		panel.add(pTop, BorderLayout.NORTH);

		// center
		JPanel pCenter = new JPanel();
		Box boxInput = Box.createVerticalBox();
		
		Box BoxTenLoaiPhong = Box.createHorizontalBox();
		BoxTenLoaiPhong.add(Box.createHorizontalStrut(100));
		JLabel lblTenLoaiPhong = new JLabel("Tên Loại Phòng:");
		BoxTenLoaiPhong.add(lblTenLoaiPhong);
		txtTenLoaiPhong = new JTextField(20);
		txtTenLoaiPhong.setFont(new Font("Serif", Font.PLAIN, 16));
		BoxTenLoaiPhong.add(txtTenLoaiPhong);
		BoxTenLoaiPhong.add(Box.createHorizontalStrut(150));
		boxInput.add(BoxTenLoaiPhong);
		boxInput.add(Box.createVerticalStrut(20));

		Box BoxSoGiuong = Box.createHorizontalBox();
		BoxSoGiuong.add(Box.createHorizontalStrut(100));
		JLabel lblSoGiuong = new JLabel("Số Giường:");
		BoxSoGiuong.add(lblSoGiuong);
		txtSoGiuong = new JTextField(20);
		txtSoGiuong.setFont(new Font("Serif", Font.PLAIN, 16));
		BoxSoGiuong.add(txtSoGiuong);
		BoxSoGiuong.add(Box.createHorizontalStrut(150));
		boxInput.add(BoxSoGiuong);
		boxInput.add(Box.createVerticalStrut(20));

		Box BoxGia = Box.createHorizontalBox();
		BoxGia.add(Box.createHorizontalStrut(100));
		JLabel lblGia = new JLabel("Giá Ngày: ");
		BoxGia.add(lblGia);
		txtGia = new JTextField(20);
		txtGia.setFont(new Font("Serif", Font.PLAIN, 16));
		BoxGia.add(txtGia);
		BoxGia.add(Box.createHorizontalStrut(150));
		boxInput.add(BoxGia);
		boxInput.add(Box.createVerticalStrut(20));

		lblSoGiuong.setPreferredSize(lblTenLoaiPhong.getPreferredSize());
		lblGia.setPreferredSize(lblTenLoaiPhong.getPreferredSize());

		// bottom
		Color color = new Color(102, 204, 51);
		Box boxSouth = Box.createHorizontalBox();
		boxSouth.add(Box.createHorizontalStrut(200));
		btnThem = new JButton("Thêm");
		btnThem.setBackground(color);
		btnThem.setForeground(Color.white);
		boxSouth.add(btnThem);
		boxSouth.add(Box.createHorizontalStrut(10));
		btnBoQua = new JButton("Bỏ qua");
		btnBoQua.setBackground(Color.gray);
		btnBoQua.setForeground(Color.white);
		boxSouth.add(btnBoQua);
		boxInput.add(boxSouth);
		
		pCenter.add(boxInput);
		pCenter.setBackground(Color.white);
		//add(pCenter, BorderLayout.CENTER);
		panel.add(pCenter, BorderLayout.CENTER);
		add(panel);
		setUndecorated(true);
		getContentPane().setBackground(Color.WHITE);
		getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		setSize(500, 260);
		btnThem.addActionListener(this);
		btnBoQua.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o == btnBoQua)
		{
			dispose();
		}
		if(o == btnThem)
		{
			themLoaiPhong();
		}
		
	}
	
	public void themLoaiPhong()
	{
		try {
			count++;
			LoaiPhong p = new LoaiPhong(txtTenLoaiPhong.getText(),Integer.parseInt(txtSoGiuong.getText()),Float.parseFloat(txtGia.getText()));
                       
			String[] row  = {count+"",txtTenLoaiPhong.getText(),(String)txtSoGiuong.getText(),(String)txtGia.getText()};
                        frmQLLoaiPhong.tblModel=(DefaultTableModel) frmQLLoaiPhong.tblPhong.getModel();
			frmQLLoaiPhong.tblModel.addRow(row);
			if(loaiPhongService.addLoaiPhong(p))
			{
				JOptionPane.showMessageDialog(this, "Thêm thành công");
				dispose();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
