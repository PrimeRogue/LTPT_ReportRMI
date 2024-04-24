package GUI;

import entities.LoaiPhong;
import services.LoaiPhongService;

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

public class popupCapNhatLoaiPhong extends JFrame implements ActionListener {
    public static JTextField txtSoPhong;
    public JTextField txtTrangThai;
    public JTextField txtLoaiPhong;
    public static JComboBox<String> cboLoaiPhong, cboTinhTrang;
    private JButton btnThem;
    private JButton btnBoQua;
    private JButton btnCapNhat;
    public JTextField txtTenLoaiPhong;
    public JTextField txtSoGiuong;
    public JTextField txtGia;

    public popupCapNhatLoaiPhong() {
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

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object o = e.getSource();
        if (o == btnBoQua) {
            dispose();
        }
        if (o == btnCapNhat) {
            try {
                updateLoaiPhong();
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            } catch (NotBoundException ex) {
                throw new RuntimeException(ex);
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void updateLoaiPhong() throws MalformedURLException, NotBoundException, RemoteException {
        int row = frmQLLoaiPhong.tblPhong.getSelectedRow();
        LoaiPhongService loaiPhongService = (LoaiPhongService) Naming.lookup("rmi://DESKTOP-O9GK1BR:8989/loaiPhongService");

        String maPhong = (String) frmQLLoaiPhong.tblPhong.getValueAt(row, 0);
        LoaiPhong p = new LoaiPhong(Integer.parseInt(maPhong), txtTenLoaiPhong.getText(), Integer.parseInt(txtSoGiuong.getText()), Float.parseFloat(txtGia.getText()));
        if (loaiPhongService.updateLoaiPhong(p)) {
            frmQLLoaiPhong.tblModel = (DefaultTableModel) frmQLLoaiPhong.tblPhong.getModel();
            frmQLLoaiPhong.tblModel.setValueAt(txtTenLoaiPhong.getText(), row, 1);
            frmQLLoaiPhong.tblModel.setValueAt(txtSoGiuong.getText(), row, 2);
            frmQLLoaiPhong.tblModel.setValueAt(txtGia.getText(), row, 3);
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
    }

}
