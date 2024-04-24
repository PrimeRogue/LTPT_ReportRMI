package GUI;
import entities.TaiKhoan;
import services.TaiKhoanService;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
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

public class frmQLTaiKhoan extends JPanel implements ActionListener {
    private final JTextField txtSearch;
    private final JButton btnThem;
    public static DefaultTableModel tblModel;
    public static JTable tblThemDichVu;
    private final TableRowSorter<TableModel> sorter;
    private final JButton btnCapNhat;

    public frmQLTaiKhoan() throws MalformedURLException, NotBoundException, RemoteException {
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
        btnThem = new JButton("Thêm Tài Khoản");
        btnThem.setBackground(color);
        btnThem.setForeground(Color.white);
        boxSearch.add(btnThem);
        boxMain.add(boxSearch);

        //table
        String column[] = {"Tên Tài Khoản", "Tên Nhân Viên", "Cấp Độ Quyền"};

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
            popupThemTaiKhoan gdThemTK = new popupThemTaiKhoan();
            gdThemTK.getContentPane().setBackground(Color.red);
            gdThemTK.setLocationRelativeTo(null);
            gdThemTK.setVisible(true);
        }
        if (o == btnCapNhat) {
            int row = tblThemDichVu.getSelectedRow();
            if (row != -1) {
                popupCapNhatTaiKhoan gdCapNhat = new popupCapNhatTaiKhoan();
                gdCapNhat.setLocationRelativeTo(null);
                gdCapNhat.txtten.setText((String) tblModel.getValueAt(row, 0));
                gdCapNhat.txtmk.setText((String) tblModel.getValueAt(row, 1));
                gdCapNhat.cbocapbac.setSelectedItem(tblModel.getValueAt(row, 2)); // Điều chỉnh dòng này
                gdCapNhat.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Chưa chọn dòng cập nhật");
            }
        }
    }

    public void showDataTable() throws MalformedURLException, NotBoundException, RemoteException {
		TaiKhoanService taiKhoanService = (TaiKhoanService) Naming.lookup("rmi://DESKTOP-O9GK1BR:8989/taiKhoanService");
        List<TaiKhoan> ds = taiKhoanService.getListNV();
        for (TaiKhoan p : ds) {
            String[] row = {p.getUserName(), p.getPassWord(), String.valueOf(p.getCapDoQuyen())};
            tblModel.addRow(row);
        }
        tblThemDichVu.setModel(tblModel);
    }
}
