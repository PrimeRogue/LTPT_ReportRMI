package services;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entities.TrangThaiPhong;

public interface TrangThaiPhongService extends Remote {
    List<TrangThaiPhong> findAll() throws RemoteException;
}
