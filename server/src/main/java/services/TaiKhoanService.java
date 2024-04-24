package services;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entities.TaiKhoan;

public interface TaiKhoanService extends Remote {
    List<TaiKhoan> getListNV() throws RemoteException;
    boolean addNV(TaiKhoan taiKhoan) throws RemoteException;
    boolean updateNV(TaiKhoan taiKhoan) throws RemoteException;
}
