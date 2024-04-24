package GUI;
import entities.KhachHang;
import services.KhachHangService;

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
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class popupThemKhachHang extends JFrame implements ActionListener{
    private JTextField txttenDichVu;
	private JTextField txtloaiDichVu;
	private JTextField txtdonGia;
	private JComboBox<String> cboloaiDichVu;
	private JButton btnThem;
	private JButton btnBoQua;
    private final JComboBox<String> cbogioitinh;
    private final JTextField txttencccd;
    private final JTextField txtsdt;
    private final JTextField txtdc;
    private final JTextField txtqt;
    private final JTextField txtten;
	KhachHangService khachHangService = (KhachHangService) Naming.lookup("rmi://DESKTOP-O9GK1BR:8989/khachHangService");
	int count=khachHangService.getListKH().size();;
	public popupThemKhachHang() throws MalformedURLException, NotBoundException, RemoteException {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.WHITE);
		// north
		JPanel pTop = new JPanel();
		JLabel lblTitle = new JLabel("Nhập Thông Tin Khách Hàng");
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
		
		Box Boxten = Box.createHorizontalBox();
		Boxten.add(Box.createHorizontalStrut(100));
		JLabel lblten = new JLabel("Họ tên:");
		Boxten.add(lblten);
		txtten = new JTextField(20);
		txtten.setFont(new Font("Serif", Font.PLAIN, 16));
		Boxten.add(txtten);
		Boxten.add(Box.createHorizontalStrut(150));
		boxInput.add(Boxten);
		boxInput.add(Box.createVerticalStrut(10));
                
                Box BoxGioiTinh = Box.createHorizontalBox();
                BoxGioiTinh.add(Box.createHorizontalStrut(100));
                JLabel lblgioiTinh = new JLabel("Giới Tính: ");
                BoxGioiTinh.add(lblgioiTinh);
                DefaultComboBoxModel<String> gioiTinhModel = new DefaultComboBoxModel<>();
                gioiTinhModel.addElement("Nam");
                gioiTinhModel.addElement("Nữ");
                cbogioitinh = new JComboBox<>(gioiTinhModel);
                BoxGioiTinh.add(cbogioitinh);
                BoxGioiTinh.add(Box.createHorizontalStrut(150));
                boxInput.add(BoxGioiTinh);
                boxInput.add(Box.createVerticalStrut(10));

                Box Boxcccd = Box.createHorizontalBox();
		Boxcccd.add(Box.createHorizontalStrut(100));
		JLabel lblcccd = new JLabel("CCCD:");
		Boxcccd.add(lblcccd);
		txttencccd = new JTextField(20);
		txttencccd.setFont(new Font("Serif", Font.PLAIN, 16));
		Boxcccd.add(txttencccd);
		Boxcccd.add(Box.createHorizontalStrut(150));
		boxInput.add(Boxcccd);
		boxInput.add(Box.createVerticalStrut(10));
                
                Box Boxcsdt = Box.createHorizontalBox();
		Boxcsdt.add(Box.createHorizontalStrut(100));
		JLabel lblsdt = new JLabel("SDT:");
		Boxcsdt.add(lblsdt);
		txtsdt = new JTextField(20);
		txtsdt.setFont(new Font("Serif", Font.PLAIN, 16));
		Boxcsdt.add(txtsdt);
		Boxcsdt.add(Box.createHorizontalStrut(150));
		boxInput.add(Boxcsdt);
		boxInput.add(Box.createVerticalStrut(10));
                
                 Box Boxdc = Box.createHorizontalBox();
		Boxdc.add(Box.createHorizontalStrut(100));
		JLabel lbldc = new JLabel("DC:");
		Boxdc.add(lbldc);
		txtdc = new JTextField(20);
		txtdc.setFont(new Font("Serif", Font.PLAIN, 16));
		Boxdc.add(txtdc);
		Boxdc.add(Box.createHorizontalStrut(150));
		boxInput.add(Boxdc);
		boxInput.add(Box.createVerticalStrut(10));
		
                Box Boxqt = Box.createHorizontalBox();
		Boxqt.add(Box.createHorizontalStrut(100));
		JLabel lblqt = new JLabel("Quốc Tịch:");
		Boxqt.add(lblqt);
		txtqt = new JTextField(20);
		txtqt.setFont(new Font("Serif", Font.PLAIN, 16));
		Boxqt.add(txtqt);
		Boxqt.add(Box.createHorizontalStrut(150));
		boxInput.add(Boxqt);
		boxInput.add(Box.createVerticalStrut(10));
                
		lblten.setPreferredSize(lblqt.getPreferredSize());
		lblgioiTinh.setPreferredSize(lblqt.getPreferredSize());
                lblcccd.setPreferredSize(lblqt.getPreferredSize());
                lblsdt.setPreferredSize(lblqt.getPreferredSize());
                lbldc.setPreferredSize(lblqt.getPreferredSize());

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
		setSize(500, 350);
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
			themKH();
		}
		
	}

    private void themKH() {
        try {
            
            
            boolean gt=true;
            if(cbogioitinh.getSelectedItem().equals("nam"))
                gt=true;
            else
                gt=false;
            KhachHang p = new KhachHang(txtten.getText(),gt,txttencccd.getText(),txtsdt.getText(),txtdc.getText(),txtqt.getText());
            
            count++;
            String[] row  = {count+"",txtten.getText(),txttencccd.getText(),txtsdt.getText(),txtdc.getText(),(String)cbogioitinh.getSelectedItem(),txtqt.getText()};
            frmQLKhachHang.tblModel = (DefaultTableModel) frmQLKhachHang.tblThemDichVu.getModel();
            frmQLKhachHang.tblModel.addRow(row);
            if(khachHangService.themKhachHang(p))
            {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Lỗi khi thêm dữ liệu vào cơ sở dữ liệu.");
            }
        } catch (Exception e) {
                // TODO: handle exception
        }
    }
}
