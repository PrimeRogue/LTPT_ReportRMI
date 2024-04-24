package GUI;
import com.toedter.calendar.JDateChooser;
import entities.NhanVien;
import services.NhanVienService;

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
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class popupThemNhanVien extends JFrame implements ActionListener{
    public JTextField txttenDichVu;
	public JTextField txtloaiDichVu;
	public JTextField txtdonGia;
	private JComboBox<String> cboloaiDichVu;
	private JButton btnThem;
	private JButton btnBoQua;
    public final JComboBox<String> cbogioitinh;
    public final JTextField txttencccd;
    public final JTextField txtsdt;
    public final JTextField txtdc;
//    private final JTextField txtqt;
    public final JTextField txtten;
	NhanVienService nhanVienService = (NhanVienService) Naming.lookup("rmi://DESKTOP-O9GK1BR:8989/nhanVienService");
	int count=nhanVienService.getListNV().size();
    public final JTextField txtluong;
    public final JTextField txtchucvu;
    JDateChooser dateChooser = new JDateChooser();
	public popupThemNhanVien() throws MalformedURLException, NotBoundException, RemoteException {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.WHITE);
		// north
		JPanel pTop = new JPanel();
		JLabel lblTitle = new JLabel("Nhập Thông Tin Nhân Viên");
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
                
                Box Boxsdt = Box.createHorizontalBox();
		Boxsdt.add(Box.createHorizontalStrut(100));
		JLabel lblsdt = new JLabel("Số Điện Thoại:");
		Boxsdt.add(lblsdt);
		txtsdt = new JTextField(20);
		txtsdt.setFont(new Font("Serif", Font.PLAIN, 16));
		Boxsdt.add(txtsdt);
		Boxsdt.add(Box.createHorizontalStrut(150));
		boxInput.add(Boxsdt);
		boxInput.add(Box.createVerticalStrut(10));
                
                Box BoxNgaySinh = Box.createHorizontalBox();
                BoxNgaySinh.add(Box.createHorizontalStrut(100));
                JLabel lblNgaySinh = new JLabel("Ngày Sinh:");
                BoxNgaySinh.add(lblNgaySinh);
                // Sử dụng JDateChooser thay vì JTextField
                
                dateChooser.setFont(new Font("Serif", Font.PLAIN, 20));
                BoxNgaySinh.add(dateChooser);
                BoxNgaySinh.add(Box.createHorizontalStrut(150));
                boxInput.add(BoxNgaySinh);
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
		
                Box Boxluong = Box.createHorizontalBox();
		Boxluong.add(Box.createHorizontalStrut(100));
		JLabel lblluong = new JLabel("Lương:");
		Boxluong.add(lblluong);
		txtluong = new JTextField(20);
		txtluong.setFont(new Font("Serif", Font.PLAIN, 16));
		Boxluong.add(txtluong);
		Boxluong.add(Box.createHorizontalStrut(150));
		boxInput.add(Boxluong);
		boxInput.add(Box.createVerticalStrut(10));
                
                Box Boxchucvu = Box.createHorizontalBox();
		Boxchucvu.add(Box.createHorizontalStrut(100));
		JLabel lblchucvu = new JLabel("Chức Vụ:");
		Boxchucvu.add(lblchucvu);
		txtchucvu = new JTextField(20);
		txtchucvu.setFont(new Font("Serif", Font.PLAIN, 16));
		Boxchucvu.add(txtchucvu);
		Boxchucvu.add(Box.createHorizontalStrut(150));
		boxInput.add(Boxchucvu);
		boxInput.add(Box.createVerticalStrut(10));
                
		lblten.setPreferredSize(lblsdt.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblsdt.getPreferredSize());
                lblgioiTinh.setPreferredSize(lblsdt.getPreferredSize());
                lblcccd.setPreferredSize(lblsdt.getPreferredSize());
                lbldc.setPreferredSize(lblsdt.getPreferredSize());
                lblluong.setPreferredSize(lblsdt.getPreferredSize());
                lblchucvu.setPreferredSize(lblsdt.getPreferredSize());
//                lblchucvu.setPreferredSize(lblten.getPreferredSize());


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
		setSize(500, 450);
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
                    themNV();
		}
		
	}

//    private void themNV() {
//        try {
//            
//            
//            boolean gt=true;
//            if(cbogioitinh.getSelectedItem().equals("nam"))
//                gt=true;
//            else
//                gt=false;
//           
//            String ngaySinhStr = dateChooser.getDateFormatString();
//           
//            NhanVien p = new NhanVien(txtten.getText(), txtsdt.getText(), txtdc.getText(), txttencccd.getText(), gt, txtchucvu.getText(), dateChooser.getDate(), Float.parseFloat(txtluong.getText()));
//            count++;
//            String[] row  = {count+"",txtten.getText(), ngaySinhStr, txtchucvu.getText(), (String)cbogioitinh.getSelectedItem(), txtdc.getText(), txtsdt.getText(), txttencccd.getText(), (txtluong.getText())};
//            frmQLNhanVien.tblModel = (DefaultTableModel) frmQLNhanVien.tblThemDichVu.getModel();
//            frmQLNhanVien.tblModel.addRow(row);
//            if(daoNV.addNV(p))
//            {
//                JOptionPane.showMessageDialog(this, "Thêm thành công");
//                dispose();
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(this, "Lỗi khi thêm dữ liệu vào cơ sở dữ liệu.");
//            }
//        } catch (Exception e) {
//                // TODO: handle exception
//        }
//    }
        private void themNV() {
            try {
                boolean gt = true;
                if (cbogioitinh.getSelectedItem().equals("nam")) {
                    gt = true;
                } else {
                    gt = false;
                }

                // Sử dụng getDate để lấy giá trị Date từ dateChooser
                Date ngaySinh = dateChooser.getDate();

                NhanVien p = new NhanVien(count,txtten.getText(), txtsdt.getText(), txtdc.getText(), txttencccd.getText(), gt, txtchucvu.getText(), ngaySinh, Float.parseFloat(txtluong.getText()));
                count++;
                
                String[] row = {count + "", txtten.getText(), ngaySinh.toString(), txtchucvu.getText(), (String) cbogioitinh.getSelectedItem(), txtdc.getText(), txtsdt.getText(), txttencccd.getText(), (txtluong.getText())};
                frmQLNhanVien.tblModel = (DefaultTableModel) frmQLNhanVien.tblThemDichVu.getModel();
                frmQLNhanVien.tblModel.addRow(row);
                if (nhanVienService.addNV(p)) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                    dispose();
                } else {
                   
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}
