package application;

import java.text.ParseException;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program{
	public static void main(String []args) throws ParseException{
		SellerDao sellerDao =  DaoFactory.createSellerDao();		
		
		
		System.out.println("=== Teste 1: findByID ===");
		Seller seller = sellerDao.findById(5);
		System.out.println(seller);
		
		System.out.println("");
		System.out.println("=== Teste 2: findByDepartment ===");
		Department department = new Department(1, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for(Seller obj : list) 
		{
			System.out.println(obj);
		}
	}
}
