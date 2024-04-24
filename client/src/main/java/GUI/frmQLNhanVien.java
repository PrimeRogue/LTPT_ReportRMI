package GUI;

import entities.NhanVien;
import services.NhanVienService;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class frmQLNhanVien extends JPanel implements ActionListener {

    private final JTextField txtSearch;
    private final JButton btnThem;
    public static DefaultTableModel tblModel;
    public static JTable tblThemDichVu;
    private final TableRowSorter<TableModel> sorter;
    private final JButton btnCapNhat;

    public frmQLNhanVien() throws MalformedURLException, NotBoundException, RemoteException {
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
        btnThem = new JButton("Thêm Nhân Viên");
        btnThem.setBackground(color);
        btnThem.setForeground(Color.white);
        boxSearch.add(btnThem);
        boxMain.add(boxSearch);

        //table
        String column[] = {"Mã NV", "Tên NV", "Ngày Sinh", "Chức Vụ", "Giới tính", "Địa chỉ", "sdt", "cccd", "Lương"};

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
            popupThemNhanVien gdThem = null;
            try {
                gdThem = new popupThemNhanVien();
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            } catch (NotBoundException ex) {
                throw new RuntimeException(ex);
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
            gdThem.getContentPane().setBackground(Color.red);
            gdThem.setLocationRelativeTo(null);
            gdThem.setVisible(true);
        }
        if (o == btnCapNhat) {


            int row = tblThemDichVu.getSelectedRow();
            if (row != -1) {
                try {
                    popupCapNhatNhanVien gdCapNhat = new popupCapNhatNhanVien();
                    gdCapNhat.setLocationRelativeTo(null);

                    gdCapNhat.txtten.setText((String) tblModel.getValueAt(row, 1));
                    String ngaySinhStr = (String) tblModel.getValueAt(row, 2);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng của ngày tháng
                    Date ngaySinh = sdf.parse(ngaySinhStr);
                    gdCapNhat.dateChooser.setDate(ngaySinh);
                    gdCapNhat.txtchucvu.setText((String) tblModel.getValueAt(row, 3));
                    gdCapNhat.cbogioitinh.setSelectedItem((String) tblModel.getValueAt(row, 4));
                    gdCapNhat.txtdc.setText((String) tblModel.getValueAt(row, 5));
                    gdCapNhat.txtsdt.setText((String) tblModel.getValueAt(row, 6));

                    gdCapNhat.txttencccd.setText((String) tblModel.getValueAt(row, 7));
                    gdCapNhat.txtluong.setText(tblModel.getValueAt(row, 8).toString());
                    gdCapNhat.setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(frmQLNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Chưa chọn dòng cập nhật");
            }
        }
    }

    public void showDataTable() throws MalformedURLException, NotBoundException, RemoteException {
		NhanVienService nhanVienService = (NhanVienService) Naming.lookup("rmi://DESKTOP-O9GK1BR:8989/nhanVienService");

		List<NhanVien> ds = nhanVienService.getListNV();
        for (NhanVien p : ds) {
            String gt = "";
            if (p.isGioiTinh())
                gt = "nam";
            else
                gt = "nữ";
            LocalDateTime ngaySinh = p.getNgaySinh();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String ngaySinhStr = sdf.format(ngaySinh);

            String[] row = {Integer.toString(p.getMaNV()), p.getTenNV(), ngaySinhStr, p.getChucVu(), gt, p.getDiaChi(), p.getSDT(), p.getCCCD(), Float.toString((float) p.getLuong())};
            tblModel.addRow(row);
        }
        tblThemDichVu.setModel(tblModel);
    }
}

