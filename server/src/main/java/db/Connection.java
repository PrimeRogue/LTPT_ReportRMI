package db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connection {
	private static Connection instance;
	private EntityManagerFactory emf;

	private Connection() {
		// TODO Auto-generated constructor stub
		this.emf = Persistence.createEntityManagerFactory("BuiTranThienAn_NguyenThiHongVan_Server");

	}

	public static Connection getInstance() {
		if (instance == null) {
			instance = new Connection();
		}
		return instance;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}

}
