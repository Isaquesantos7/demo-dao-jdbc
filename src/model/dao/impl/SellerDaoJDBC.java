package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbExceptions;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{
	private Connection conn = null;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller obj) {
		
	}
	
	@Override
	public void update(Seller obj) {
		
	}
	
	@Override
	public void deleteById(Integer id) {
	
	}
	
	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try 
		{
			String SQL = "SELECT seller.*, department.Name as DepName FROM seller INNER JOIN department"
					+ " ON seller.DepartmentId = department.Id"
					+ " WHERE seller.Id = ?";
			st = conn.prepareStatement(SQL);
			st.setInt(1, id);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				Department dep = instantiateDepartment(rs);
				Seller obj = instantiateSeller(rs, dep);				
				return obj;
			}
		}
		catch(SQLException e) 
		{
			throw new DbExceptions("Error: " + e.getMessage());
		}
		finally
		{
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return null;
	}
	
	private Department instantiateDepartment(ResultSet rs) throws SQLException{
		Department dep = new Department();
		
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		
		return dep;
	}
	
	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException{
		Seller obj = new Seller();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBirthDate(rs.getDate("BirthDate"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setDepartment(dep);
		
		return obj;
	}
	@Override
	public List<Seller> findAll(){
		return null;
	}
	
}
