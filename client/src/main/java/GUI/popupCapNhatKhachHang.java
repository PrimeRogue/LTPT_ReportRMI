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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class popupCapNhatKhachHang extends JFrame implements ActionListener {
    public static JTextField txtSoPhong;
    public static JTextField txtTrangThai;
    public static JTextField txtLoaiPhong;
    public static JComboBox<String> cboLoaiPhong, cboTinhTrang;
    private JButton btnThem;
    private JButton btnBoQua;
    private JButton btnCapNhat;
    public static JTextField txtqt;
    public static JTextField txtsdt;
    public static JTextField txtdc;
    public static JTextField txttencccd;
    public static JComboBox<String> cbogioitinh;
    public static JTextField txtten;

    public popupCapNhatKhachHang() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        // north
        JPanel pTop = new JPanel();
        JLabel lblTitle = new JLabel("Cập nhật khách hàng");
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
        setSize(500, 400);
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
                updateKH();
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            } catch (NotBoundException ex) {
                throw new RuntimeException(ex);
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void updateKH() throws MalformedURLException, NotBoundException, RemoteException {
        int row = frmQLKhachHang.tblThemDichVu.getSelectedRow();
        KhachHangService khachHangService = (KhachHangService) Naming.lookup("rmi://DESKTOP-O9GK1BR:8989/khachHangService");

        String gioiTinh = (String) frmQLKhachHang.tblThemDichVu.getValueAt(row, 6);
        boolean gt = true;
        if (gioiTinh.equalsIgnoreCase("nữ"))
            gt = false;

        String maKH = (String) frmQLKhachHang.tblThemDichVu.getValueAt(row, 0);
        KhachHang kh = new KhachHang(Integer.parseInt(maKH), txtten.getText(), gt, txttencccd.getText(), txtsdt.getText(), txtdc.getText(), txtqt.getText());
        if (khachHangService.capNhatKhachHang(kh)) {
            frmQLKhachHang.tblModel = (DefaultTableModel) frmQLKhachHang.tblThemDichVu.getModel();
            frmQLKhachHang.tblModel.setValueAt(txtten.getText(), row, 1);
            frmQLKhachHang.tblModel.setValueAt(txttencccd.getText(), row, 2);
            frmQLKhachHang.tblModel.setValueAt(txtsdt.getText(), row, 3);
            frmQLKhachHang.tblModel.setValueAt(txtdc.getText(), row, 4);
            frmQLKhachHang.tblModel.setValueAt(cbogioitinh.getSelectedItem(), row, 5);
            frmQLKhachHang.tblModel.setValueAt(txtqt.getText(), row, 6);

            JOptionPane.showMessageDialog(this, "Cập nhật thành công");

        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
    }

}
