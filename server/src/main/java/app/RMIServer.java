package app;
import services.*;
import services.impl.*;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.security.Policy;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RMIServer {
	public static void main(String[] args) throws RemoteException, NamingException {
		// TODO Auto-generated method stub
		Hashtable<String, String> env = new Hashtable<>();
		env.put("java.security.Policy", "rmi/rmi.policy");
		
		Context context = new InitialContext(env);


		PhongService phongService = new PhongServiceImpl();
		TinhTrangPhongService tinhTrangPhongService = new TinhTrangPhongServiceImpl();
		TaiKhoanService taiKhoanService = new TaiKhoanServiceImpl();
		NhanVienService nhanVienService = new NhanVienServiceImpl();
		LoaiPhongService loaiPhongService = new LoaiPhongServiceImpl();
		KhachHangService khachHangService = new KhachHangServiceImpl();
		TrangThaiPhongService trangThaiPhongService = new TrangThaiPhongServiceImpl();

		LocateRegistry.createRegistry(8989);
		context.bind("rmi://DESKTOP-O9GK1BR:8989/khachHangService", khachHangService);
		context.bind("rmi://DESKTOP-O9GK1BR:8989/phongService", phongService);
		context.bind("rmi://DESKTOP-O9GK1BR:8989/tinhTrangPhongService", tinhTrangPhongService);
		context.bind("rmi://DESKTOP-O9GK1BR:8989/taiKhoanService", taiKhoanService);
		context.bind("rmi://DESKTOP-O9GK1BR:8989/nhanVienService", nhanVienService);
		context.bind("rmi://DESKTOP-O9GK1BR:8989/loaiPhongService", loaiPhongService);
		context.bind("rmi://DESKTOP-O9GK1BR:8989/trangThaiPhongService", trangThaiPhongService);

		System.out.println("Server running on PORT:8989....");
		
	}

}
