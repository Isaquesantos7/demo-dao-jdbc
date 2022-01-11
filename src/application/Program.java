package application;

import java.util.Date;
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
		
		System.out.println("\n=== Teste 2: findByDepartment ===");
		Department department = new Department(1, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for(Seller obj : list) 
		{
			System.out.println(obj);
		}
		
		System.out.println("\n=== Teste 3: findAll ===");
		List<Seller> obj = sellerDao.findAll();
		for(Seller x : obj)
		{
			System.out.println(x);
		}
		
		/*
		System.out.println("\n=== Teste 4: Insert ====");
		Seller newSeller = new Seller(null, "Bob Brown", "bobbrown@gmail.com", new Date(), 3500.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new id = " + newSeller.getId());
		*/
		System.out.println("\n=== Teste 5: UpdateSeller ====");
		seller = sellerDao.findById(2);
		seller.setName("Maria Eduarda");
		seller.setEmail("mariaeduarda@ig.com");
		sellerDao.update(seller);
		System.out.println("update completed!");
		
		
		System.out.println("\n=== Teste 6: DeleteById ====");
		sellerDao.deleteById(27);
		
	}
}
