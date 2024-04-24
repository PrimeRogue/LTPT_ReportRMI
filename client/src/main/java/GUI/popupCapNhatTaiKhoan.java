/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import entities.TaiKhoan;
import services.TaiKhoanService;

import static GUI.frmQLKhachHang.tblModel;

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

/**
 * @author ADMIN
 */
public class popupCapNhatTaiKhoan extends JFrame implements ActionListener {
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
    public final JTextField txtmk;
    public final JComboBox<String> cbocapbac;

    public popupCapNhatTaiKhoan() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        // north
        JPanel pTop = new JPanel();
        JLabel lblTitle = new JLabel("Cập nhật Tài Khoản");
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
                updateTK();
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            } catch (NotBoundException ex) {
                throw new RuntimeException(ex);
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    //	public void updateTK()
//	{
//            int row = frmQLTaiKhoan.tblThemDichVu.getSelectedRow();
//            TaiKhoanDAO daoTK = new TaiKhoanDAO();
//
//            TaiKhoan tk= new TaiKhoan(txtten.getText(),txtmk.getText(),Integer.parseInt((String)cbocapbac.getSelectedItem()));
//            if(daoTK.updateTK(tk))
//            {
//                    frmQLTaiKhoan.tblModel =(DefaultTableModel)frmQLTaiKhoan.tblThemDichVu.getModel();
//                    frmQLTaiKhoan.tblModel.setValueAt(txtten.getText(), row, 1);
//                    frmQLTaiKhoan.tblModel.setValueAt(txtmk.getText(), row, 2);
//                    frmQLTaiKhoan.tblModel.setValueAt(cbocapbac.getSelectedItem(), row, 3);
//                    JOptionPane.showMessageDialog(this, "Cập nhật thành công");
//
//            }
//            else
//            {
//                    JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
//            }
//	}
    public void updateTK() throws MalformedURLException, NotBoundException, RemoteException {
        int row = frmQLTaiKhoan.tblThemDichVu.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng để cập nhật");
            return;
        }

        TaiKhoanService taiKhoanService = (TaiKhoanService) Naming.lookup("rmi://DESKTOP-O9GK1BR:8989/taiKhoanService");


        TaiKhoan tk = new TaiKhoan(txtten.getText(), txtmk.getText(), Integer.parseInt(cbocapbac.getSelectedItem().toString())
        );
        if (taiKhoanService.updateNV(tk)) {
            // Cập nhật giá trị trong bảng
            frmQLTaiKhoan.tblModel.setValueAt(txtten.getText(), row, 1);
            frmQLTaiKhoan.tblModel.setValueAt(txtmk.getText(), row, 2);
            frmQLTaiKhoan.tblModel.setValueAt(cbocapbac.getSelectedItem(), row, 3);

            // Gọi lại setModel để cập nhật hiển thị
            frmQLTaiKhoan.tblThemDichVu.setModel(frmQLTaiKhoan.tblModel);

            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
    }

}
