package GUI;

import entities.LoaiPhong;
import entities.Phong;
import entities.TinhTrangPhong;
import services.LoaiPhongService;
import services.PhongService;
import services.TinhTrangPhongService;

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

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class popupCapNhatPhong extends JFrame implements ActionListener {
	public static JTextField txtSoPhong;
	private JTextField txtTrangThai;
	private JTextField txtLoaiPhong;
	public static JComboBox<String> cboLoaiPhong, cboTinhTrang;
	private JButton btnThem;
	private JButton btnBoQua;
	private JButton btnCapNhat;

	public popupCapNhatPhong() throws MalformedURLException, NotBoundException, RemoteException {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.WHITE);
		// north
		JPanel pTop = new JPanel();
		JLabel lblTitle = new JLabel("Cập nhật phòng");
		lblTitle.setFont(new Font("Serif", Font.BOLD, 30));
		pTop.setLayout(new GridBagLayout());
		pTop.add(lblTitle);
		lblTitle.setForeground(Color.BLUE);
		pTop.setPreferredSize(new Dimension(0, 60));
		// add(pTop, BorderLayout.NORTH);
		pTop.setBackground(Color.white);
		panel.add(pTop, BorderLayout.NORTH);

		// center
		JPanel pCenter = new JPanel();
		Box boxInput = Box.createVerticalBox();

		Box BoxsoPhong = Box.createHorizontalBox();
		BoxsoPhong.add(Box.createHorizontalStrut(100));
		JLabel lblSoPhong = new JLabel("Số phòng:");
		BoxsoPhong.add(lblSoPhong);
		txtSoPhong = new JTextField(20);
		txtSoPhong.setFont(new Font("Serif", Font.PLAIN, 16));
		BoxsoPhong.add(txtSoPhong);
		BoxsoPhong.add(Box.createHorizontalStrut(150));
		boxInput.add(BoxsoPhong);
		boxInput.add(Box.createVerticalStrut(20));

		Box BoxtrangThai = Box.createHorizontalBox();
		BoxtrangThai.add(Box.createHorizontalStrut(100));
		JLabel lblTrangThai = new JLabel("Trạng thái:");
		BoxtrangThai.add(lblTrangThai);
		cboTinhTrang = new JComboBox<String>();
		BoxtrangThai.add(cboTinhTrang);
		BoxtrangThai.add(Box.createHorizontalStrut(150));
		boxInput.add(BoxtrangThai);
		boxInput.add(Box.createVerticalStrut(20));

		Box BoxloaiPhong = Box.createHorizontalBox();
		BoxloaiPhong.add(Box.createHorizontalStrut(100));
		JLabel lblLoaiPhong = new JLabel("Loại phòng: ");
		BoxloaiPhong.add(lblLoaiPhong);
		cboLoaiPhong = new JComboBox<String>();
		BoxloaiPhong.add(cboLoaiPhong);
		BoxloaiPhong.add(Box.createHorizontalStrut(150));
		boxInput.add(BoxloaiPhong);
		boxInput.add(Box.createVerticalStrut(20));

		lblSoPhong.setPreferredSize(lblLoaiPhong.getPreferredSize());
		lblTrangThai.setPreferredSize(lblLoaiPhong.getPreferredSize());

		// bottom
		Color color = new Color(102, 204, 51);
		Box boxSouth = Box.createHorizontalBox();
		boxSouth.add(Box.createHorizontalStrut(200));
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBackground(color);
		btnCapNhat.setForeground(Color.white);
		boxSouth.add(btnCapNhat);
		boxSouth.add(Box.createHorizontalStrut(10));
		btnBoQua = new JButton("Bỏ qua");
		btnBoQua.setBackground(Color.gray);
		btnBoQua.setForeground(Color.white);
		boxSouth.add(btnBoQua);
		boxInput.add(boxSouth);

		pCenter.add(boxInput);
		pCenter.setBackground(Color.white);
		// add(pCenter, BorderLayout.CENTER);
		panel.add(pCenter, BorderLayout.CENTER);
		add(panel);
		setUndecorated(true);
		getContentPane().setBackground(Color.WHITE);
		getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		setSize(500, 260);
		btnBoQua.addActionListener(this);
		btnCapNhat.addActionListener(this);
		loadCBOLoaiPhong();
		loadCBOTinhTrangPhong();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o == btnBoQua) {
			dispose();
		}
		if(o == btnCapNhat)
		{
            try {
                updatePhong() ;
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            } catch (NotBoundException ex) {
                throw new RuntimeException(ex);
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
        }
	}
	public void updatePhong() throws MalformedURLException, NotBoundException, RemoteException {
			int row = frmQLPhong.tblPhong.getSelectedRow();
		PhongService phongService = (PhongService) Naming.lookup("rmi://DESKTOP-O9GK1BR:8989/phongService");

		TinhTrangPhong ttp = new TinhTrangPhong((String)cboTinhTrang.getSelectedItem());
			LoaiPhong lp = new LoaiPhong((String)cboLoaiPhong.getSelectedItem());
                        
			String maPhong = (String) frmQLPhong.tblPhong.getValueAt(row, 0);
			Phong p = new Phong(Integer.parseInt(maPhong),txtSoPhong.getText(),ttp,lp);
			if(phongService.capNhatPhong(p))
			{
				frmQLPhong.tblModel = (DefaultTableModel) frmQLPhong.tblPhong.getModel();
				frmQLPhong.tblModel.setValueAt(txtSoPhong.getText(), row, 1);
				frmQLPhong.tblModel.setValueAt(cboTinhTrang.getSelectedItem(), row, 2);
				frmQLPhong.tblModel.setValueAt(cboLoaiPhong.getSelectedItem(), row, 3);
				JOptionPane.showMessageDialog(this, "Cập nhật thành công");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
			}
	}
	private void loadCBOLoaiPhong() throws MalformedURLException, NotBoundException, RemoteException {
		LoaiPhongService loaiPhongService = (LoaiPhongService) Naming.lookup("rmi://DESKTOP-O9GK1BR:8989/loaiPhongService");

		List<LoaiPhong> ds = (List<LoaiPhong>) loaiPhongService.getListLoaiPhong();
		for (LoaiPhong lp : ds) {
			cboLoaiPhong.addItem(lp.getTenLoaiPhong());
		}
	}

	private void loadCBOTinhTrangPhong() throws MalformedURLException, NotBoundException, RemoteException {
		TinhTrangPhongService tinhTrangPhongService = (TinhTrangPhongService) Naming.lookup("rmi://DESKTOP-O9GK1BR:8989/tinhTrangPhongService");

		List<TinhTrangPhong> ds = (List<TinhTrangPhong>) tinhTrangPhongService.getListTTP();
		for (TinhTrangPhong tt : ds) {
			cboTinhTrang.addItem(tt.getTinhTrang());
		}
	}
}
