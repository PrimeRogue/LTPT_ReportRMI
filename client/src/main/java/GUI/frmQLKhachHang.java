package GUI;

import entities.KhachHang;
import entities.Phong;
import services.KhachHangService;

import static GUI.frmQLPhong.tblModel;
import static GUI.frmQLPhong.tblPhong;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class frmQLKhachHang extends JPanel implements ActionListener {

    private final JTextField txtSearch;
    private final JButton btnThem;
    public static DefaultTableModel tblModel;
    public static JTable tblThemDichVu;
    private final TableRowSorter<TableModel> sorter;
    private final JButton btnCapNhat;

    public frmQLKhachHang() throws MalformedURLException, NotBoundException, RemoteException {
        Color color = new Color(102, 204, 51);
        //pTop

        Box boxMain = Box.createVerticalBox();
        boxMain.add(Box.createVerticalStrut(35));
        Box boxSearch = Box.createHorizontalBox();
        txtSearch = new JTextField(20);
        Icon iconSearch = new ImageIcon("img\\search.png");
        JLabel lblIcon = new JLabel(iconSearch);
        boxSearch.add(txtSearch);
        boxSearch.add(lblIcon);
        boxSearch.add(Box.createHorizontalStrut(740));
        btnThem = new JButton("Thêm Khách Hàng");
        btnThem.setBackground(color);
        btnThem.setForeground(Color.white);
        boxSearch.add(btnThem);
        boxMain.add(boxSearch);

        //table
        String column[] = {"Mã khách hàng", "Tên khách hàng", "cccd", "sdt", "Địa chỉ", "Giới tính", "Quốc Tịch"};

        tblModel = new DefaultTableModel(null, column);
        tblThemDichVu = new JTable(tblModel);
        sorter = new TableRowSorter<TableModel>(tblModel);
        tblThemDichVu.setRowSorter(sorter);
        boxMain.add(Box.createVerticalStrut(20));
        boxMain.add(new JScrollPane(tblThemDichVu));

        boxMain.add(Box.createVerticalStrut(20));
        Box boxBtn = Box.createHorizontalBox();
        boxBtn.add(Box.createHorizontalStrut(1000));
        btnCapNhat = new JButton("Cập nhật");
        btnCapNhat.setBackground(color);
        btnCapNhat.setForeground(Color.white);
        boxBtn.add(btnCapNhat);
        boxMain.add(boxBtn);
        add(boxMain);
        btnThem.addActionListener(this);
        btnCapNhat.addActionListener(this);
        showDataTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o == btnThem) {
            popupThemKhachHang gdThemKhachHang = null;
            try {
                gdThemKhachHang = new popupThemKhachHang();
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            } catch (NotBoundException ex) {
                throw new RuntimeException(ex);
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
            gdThemKhachHang.getContentPane().setBackground(Color.red);
            gdThemKhachHang.setLocationRelativeTo(null);
            gdThemKhachHang.setVisible(true);
        }
        if (o == btnCapNhat) {
            int row = tblThemDichVu.getSelectedRow();
            if (row != -1) {
                popupCapNhatKhachHang gdCapNhat = new popupCapNhatKhachHang();
                gdCapNhat.setLocationRelativeTo(null);
                gdCapNhat.txtten.setText((String) tblModel.getValueAt(row, 1));
                gdCapNhat.txttencccd.setText((String) tblModel.getValueAt(row, 2));
                gdCapNhat.txtsdt.setText((String) tblModel.getValueAt(row, 3));
                gdCapNhat.txtdc.setText((String) tblModel.getValueAt(row, 4));
                gdCapNhat.cbogioitinh.setSelectedItem((String) tblModel.getValueAt(row, 5));
                gdCapNhat.txtqt.setText((String) tblModel.getValueAt(row, 6));
                gdCapNhat.setVisible(true);


            } else {
                JOptionPane.showMessageDialog(this, "Chưa chọn dòng cập nhật");
            }
        }

    }
    public void showDataTable() throws MalformedURLException, NotBoundException, RemoteException {
        KhachHangService khachHangService = (KhachHangService) Naming.lookup("rmi://DESKTOP-O9GK1BR:8989/khachHangService");
        List<KhachHang> ds = (List<KhachHang>) khachHangService.getListKH();
        for (KhachHang p : ds) {
            String gt = "";
            if (p.isGioiTinh())
                gt = "nam";
            else
                gt = "nữ";
            String[] row = {Integer.toString(p.getMaKH()), p.getTenKH(), p.getCCCD(), p.getSDT(), p.getDiaChi(), gt, p.getQuocGia()};
            tblModel.addRow(row);
        }
        tblThemDichVu.setModel(tblModel);
    }
}

