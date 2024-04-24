package services;
import entities.KhachHang;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface KhachHangService extends Remote {

    List<KhachHang> getListKH() throws RemoteException;

    boolean themKhachHang(KhachHang khachHang) throws RemoteException;
    boolean capNhatKhachHang(KhachHang khachHang) throws RemoteException;
}
