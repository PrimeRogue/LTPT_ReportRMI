package services;

import entities.TinhTrangPhong;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface TinhTrangPhongService extends Remote {
    public List<TinhTrangPhong> getListTTP() throws RemoteException;

}
