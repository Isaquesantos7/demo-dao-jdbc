package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.entities.Department;
import model.entities.Seller;

public class Program{
	public static void main(String []args) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Department obj = new Department(1,"Books");
		
		Seller seller = new Seller(1, "Isaque santos", "isaquesantos.1998@gmail.com", sdf.parse("27/03/1999"), 2000.0, obj);
		System.out.println(seller);
	}
}
