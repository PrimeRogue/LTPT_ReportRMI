package GUI;

import entities.Phong;
import services.PhongService;

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


public class frmQLPhong extends JPanel implements ActionListener{
	private JTextField txtSearch;
	private JButton btnThem;
	public static DefaultTableModel tblModel;
	private TableRowSorter<TableModel> sorter;
	public static JTable tblPhong;
	private JButton btnXoa;
	private JButton btnXemChiTiet;
	private JButton btnCapNhat;

	public frmQLPhong() throws MalformedURLException, NotBoundException, RemoteException {
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
		btnThem = new JButton("Thêm phòng");
		btnThem.setBackground(color);
		btnThem.setForeground(Color.white);
		boxSearch.add(btnThem);
		boxMain.add(boxSearch);
		
		//table
		String column[] = {"Mã phòng", "Số phòng","Tình trạng","Loại phòng" };

		tblModel = new DefaultTableModel(null, column);
		tblPhong = new JTable(tblModel);
		sorter = new TableRowSorter<TableModel>(tblModel);
		tblPhong.setRowSorter(sorter);
		boxMain.add(Box.createVerticalStrut(20));
		boxMain.add(new JScrollPane(tblPhong));
		
		boxMain.add(Box.createVerticalStrut(20));
		Box boxBtn = Box.createHorizontalBox();
		boxBtn.add(Box.createHorizontalStrut(980));
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
		
		if(o == btnThem)
		{
            popupThemPhong gdThemPhong = null;
            try {
                gdThemPhong = new popupThemPhong();
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            } catch (NotBoundException ex) {
                throw new RuntimeException(ex);
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
            gdThemPhong.setLocationRelativeTo(null);
			gdThemPhong.setVisible(true);
		}
		if(o == btnCapNhat)
		{
			int row = tblPhong.getSelectedRow();
			if(row != -1)
			{
                popupCapNhatPhong gdCapNhat = null;
                try {
                    gdCapNhat = new popupCapNhatPhong();
                } catch (MalformedURLException ex) {
                    throw new RuntimeException(ex);
                } catch (NotBoundException ex) {
                    throw new RuntimeException(ex);
                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                }
                gdCapNhat.setLocationRelativeTo(null);
				gdCapNhat.txtSoPhong.setText((String) tblModel.getValueAt(row, 1));
				gdCapNhat.cboTinhTrang.setSelectedItem((String)tblModel.getValueAt(row, 2));
				gdCapNhat.cboLoaiPhong.setSelectedItem((String)tblModel.getValueAt(row, 3));
				gdCapNhat.setVisible(true);
                                
                                
                                
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Chưa chọn dòng cập nhật");
			}
			
		}
	}
	
	public void showDataTable() throws MalformedURLException, NotBoundException, RemoteException {
		PhongService phongService = (PhongService) Naming.lookup("rmi://DESKTOP-O9GK1BR:8989/phongService");

		List<Phong> ds = (List<Phong>) phongService.getListPhong();
		for (Phong p : ds) {
			String[] row  = {Integer.toString(p.getMaPhong()),p.getSoPhong(),p.getTinhTrangPhong().getTinhTrang(),p.getLoaiPhong().getTenLoaiPhong()};
			tblModel.addRow(row);
		}
		tblPhong.setModel(tblModel);
	}
	
	
}
