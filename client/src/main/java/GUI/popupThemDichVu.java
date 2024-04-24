package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class popupThemDichVu extends JFrame implements ActionListener {
	
	private JTextField txttenDichVu;
	private JTextField txtloaiDichVu;
	private JTextField txtdonGia;
	private JComboBox<String> cboloaiDichVu;
	private JButton btnThem;
	private JButton btnBoQua;
	
	public popupThemDichVu() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.WHITE);
		// north
		JPanel pTop = new JPanel();
		JLabel lblTitle = new JLabel("Nhap thong tin dich vu");
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
		
		Box BoxtenDichVu = Box.createHorizontalBox();
		BoxtenDichVu.add(Box.createHorizontalStrut(100));
		JLabel lbltenDichVu = new JLabel("Ten dich vu:");
		BoxtenDichVu.add(lbltenDichVu);
		txttenDichVu = new JTextField(20);
		txttenDichVu.setFont(new Font("Serif", Font.PLAIN, 16));
		BoxtenDichVu.add(txttenDichVu);
		BoxtenDichVu.add(Box.createHorizontalStrut(150));
		boxInput.add(BoxtenDichVu);
		boxInput.add(Box.createVerticalStrut(20));

		Box BoxdonGia = Box.createHorizontalBox();
		BoxdonGia.add(Box.createHorizontalStrut(100));
		JLabel lbldonGia = new JLabel("donGia:");
		BoxdonGia.add(lbldonGia);
		txtdonGia = new JTextField(20);
		txtdonGia.setFont(new Font("Serif", Font.PLAIN, 16));
		BoxdonGia.add(txtdonGia);
		BoxdonGia.add(Box.createHorizontalStrut(150));
		boxInput.add(BoxdonGia);
		boxInput.add(Box.createVerticalStrut(20));

		Box BoxloaiDichVu = Box.createHorizontalBox();
		BoxloaiDichVu.add(Box.createHorizontalStrut(100));
		JLabel lblloaiDichVu = new JLabel("Loai dich vu: ");
		BoxloaiDichVu.add(lblloaiDichVu);
		cboloaiDichVu = new JComboBox<String>();
		BoxloaiDichVu.add(cboloaiDichVu);
		BoxloaiDichVu.add(Box.createHorizontalStrut(150));
		boxInput.add(BoxloaiDichVu);
		boxInput.add(Box.createVerticalStrut(20));

		lbltenDichVu.setPreferredSize(lblloaiDichVu.getPreferredSize());
		lbldonGia.setPreferredSize(lblloaiDichVu.getPreferredSize());

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
		
		
	}
	

}
