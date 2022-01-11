package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbExceptions;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{
	Connection conn = null;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Department obj) {
		
	}
	
	@Override
	public void update(Department obj) {
		
	}
	
	@Override
	public void deleteById(Integer id) {
		
	}
	
	@Override
	public Department findById(Integer id) {
		return null;
	}
	
	@Override
	public List<Department> findAll(){
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try
		{
			String SQL = "SELECT * FROM department";
			st = conn.prepareStatement(SQL);
			rs = st.executeQuery();
			
			List<Department> list = new ArrayList<>();
			while(rs.next()) {
				Department dep = instantiateStatement(rs);
				list.add(dep);
			}
			return list;
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
	}
	
	public Department instantiateStatement(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("Id"));
		dep.setName(rs.getString("Name"));
		return dep;
	}
}
