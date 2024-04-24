package services;

import entities.TrangThaiPhong;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface TrangThaiPhongService extends Remote {
    List<TrangThaiPhong> findAll() throws RemoteException;
}
