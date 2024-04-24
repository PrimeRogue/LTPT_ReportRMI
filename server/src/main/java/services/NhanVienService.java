package services;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entities.NhanVien;

public interface NhanVienService extends Remote {
    List<NhanVien> getListNV() throws RemoteException;
    boolean addNV(NhanVien nhanVien) throws RemoteException;
    boolean updateNV(NhanVien nhanVien) throws RemoteException;
}
