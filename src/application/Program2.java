package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	public static void main(String []args) {
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n=== Test 1: findAll ===");
		List<Department> list = departmentDao.findAll();
		for(Department x : list) {
			System.out.println(x);
		}
		
		System.out.println("\n=== Test 2: findById ===");
		Department dep = new Department(6, null);
		System.out.println(departmentDao.findById(dep.getId()));
		
		/*
		System.out.println("\n=== Test 3: insert department ===");
		dep = new Department(null, "People");
		departmentDao.insert(dep);
		System.out.println("Insert completed!");
		 */
		
		System.out.println("\n=== Test 4: Update department ===");
		dep = new Department(null, "Television");
		dep.setId(6);
		departmentDao.update(dep);
		System.out.println("Update completed!");
		
		System.out.println("\n=== Test 5: Delete department ===");
		departmentDao.deleteById(15);
		System.out.println("Delete Completed!");
	}
}
