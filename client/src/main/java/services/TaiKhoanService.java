package services;

import entities.TaiKhoan;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface TaiKhoanService extends Remote {
    List<TaiKhoan> getListNV() throws RemoteException;
    boolean addNV(TaiKhoan taiKhoan) throws RemoteException;
    boolean updateNV(TaiKhoan taiKhoan) throws RemoteException;
}
