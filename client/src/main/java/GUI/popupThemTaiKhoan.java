package GUI;
import entities.TaiKhoan;
import services.TaiKhoanService;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
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
public class popupThemTaiKhoan extends JFrame implements ActionListener{
    private JTextField txttenDichVu;
	private JTextField txtloaiDichVu;
	private JTextField txtdonGia;
	private JComboBox<String> cboloaiDichVu;
	private JButton btnThem;
	private JButton btnBoQua;
    private final JTextField txtten;
    private final JTextField txtmk;
    private final JTextField txtma;
    private final JComboBox<String> cbocapbac;
    private final JTextField txtTenNV;
	
	public popupThemTaiKhoan() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.WHITE);
		// north
		JPanel pTop = new JPanel();
		JLabel lblTitle = new JLabel("Nhập Thông Tin Tài Khoản");
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
		JLabel lblten = new JLabel("Tên Tài Khoản:");
		Boxten.add(lblten);
		txtten = new JTextField(20);
		txtten.setFont(new Font("Serif", Font.PLAIN, 16));
		Boxten.add(txtten);
		Boxten.add(Box.createHorizontalStrut(150));
		boxInput.add(Boxten);
		boxInput.add(Box.createVerticalStrut(10));
                
                Box Boxmk = Box.createHorizontalBox();
		Boxmk.add(Box.createHorizontalStrut(100));
		JLabel lblmk = new JLabel("Mật Khẩu:");
		Boxmk.add(lblmk);
		txtmk = new JTextField(20);
		txtmk.setFont(new Font("Serif", Font.PLAIN, 16));
		Boxmk.add(txtmk);
		Boxmk.add(Box.createHorizontalStrut(150));
		boxInput.add(Boxmk);
		boxInput.add(Box.createVerticalStrut(10));
                
                Box Boxma = Box.createHorizontalBox();
		Boxma.add(Box.createHorizontalStrut(100));
		JLabel lblma = new JLabel("Mã Nhân Viên:");
		Boxma.add(lblma);
		txtma = new JTextField(20);
		txtma.setFont(new Font("Serif", Font.PLAIN, 16));
		Boxma.add(txtma);
		Boxma.add(Box.createHorizontalStrut(150));
		boxInput.add(Boxma);
		boxInput.add(Box.createVerticalStrut(10));
                
                Box BoxtenNV = Box.createHorizontalBox();
		BoxtenNV.add(Box.createHorizontalStrut(100));
		JLabel lbltenNV = new JLabel("Tên Nhân Viên:");
		BoxtenNV.add(lbltenNV);
		txtTenNV = new JTextField(20);
		txtTenNV.setFont(new Font("Serif", Font.PLAIN, 16));
		BoxtenNV.add(txtTenNV);
		BoxtenNV.add(Box.createHorizontalStrut(150));
		boxInput.add(BoxtenNV);
		boxInput.add(Box.createVerticalStrut(10));
                
                Box Boxcapbac = Box.createHorizontalBox();
                Boxcapbac.add(Box.createHorizontalStrut(100));
                JLabel lblcapbac = new JLabel("Cấp Bậc Quyền: ");
                Boxcapbac.add(lblcapbac);
                DefaultComboBoxModel<String> gioiTinhModel = new DefaultComboBoxModel<>();
                gioiTinhModel.addElement("1");
                gioiTinhModel.addElement("2");
                gioiTinhModel.addElement("3");
                cbocapbac = new JComboBox<>(gioiTinhModel);
                Boxcapbac.add(cbocapbac);
                Boxcapbac.add(Box.createHorizontalStrut(150));
                boxInput.add(Boxcapbac);
                boxInput.add(Box.createVerticalStrut(10));

                
		lblten.setPreferredSize(lblcapbac.getPreferredSize());
		lblmk.setPreferredSize(lblcapbac.getPreferredSize());
                lblma.setPreferredSize(lblcapbac.getPreferredSize());
                lbltenNV.setPreferredSize(lblcapbac.getPreferredSize());

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
                    themTK();
		}
		
	}

    private void themTK() {
        try {
			TaiKhoanService taiKhoanService = (TaiKhoanService) Naming.lookup("rmi://DESKTOP-O9GK1BR:8989/taiKhoanService");
            TaiKhoan p = new TaiKhoan(txtten.getText(),txtmk.getText(),(Integer)cbocapbac.getSelectedItem());
            String[] row  = {txtten.getText(),txtTenNV.getText(),(String)cbocapbac.getSelectedItem()};
            frmQLTaiKhoan.tblModel = (DefaultTableModel) frmQLTaiKhoan.tblThemDichVu.getModel();
            frmQLTaiKhoan.tblModel.addRow(row);
            if(taiKhoanService.addNV(p))
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
