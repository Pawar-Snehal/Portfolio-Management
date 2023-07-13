package com.sjprogramming.empapp1;

import java.beans.Statement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDaoImpl implements EmployeeDaoIntrf {
	Connection con;
	private int parameterIndex;
	private int columnIndex;

	@Override
	public void createEmployee(Employee emp) {
		Connection con = DBConnection.createDBConnection();
		String query = "insert into employee values(?,?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(parameterIndex = 1, emp.getId());
			pstm.setString(parameterIndex = 2, emp.getName());
			pstm.setDouble(parameterIndex = 3, emp.getSalary());
			pstm.setInt(parameterIndex = 4, emp.getAge());
			int cnt = pstm.executeUpdate();
			if (cnt != 0)
				System.out.println("Employee Inserted Successfuly !!!");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void showAllEmployee() {
		con = DBConnection.createDBConnection();
		String query = "select * from employee";
		System.out.println("Employee Details :");
		System.out.println("---------------------------------");
		System.out.format("%s\t%s\t%s\t%s\n", "ID", "Name", "Salary", "Age");

		System.out.println("---------------------------------");
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				System.out.format("%d\t%s\t%f\t%d\n", result.getInt(columnIndex = 1), result.getString(columnIndex = 2),
						result.getDouble(columnIndex = 3), result.getInt(columnIndex = 4));
				System.out.println("---------------------------------");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void showEmployeeBasedOnId(int id) {
		con = DBConnection.createDBConnection();
		String query = "select * from employee where id=" + id;
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				System.out.format("%d\t%s\t%f\t%d\n", result.getInt(columnIndex = 1), result.getString(columnIndex = 2),
						result.getDouble(columnIndex = 3), result.getInt(columnIndex = 4));
				System.out.println("---------------------------------");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void updateEmployee(int id, String name) {
		con = DBConnection.createDBConnection();
		String query = "update employee set name=? where id=?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(parameterIndex = 1, name);
			pstm.setInt(parameterIndex = 2, id);
			pstm.executeUpdate();
			int cnt = pstm.executeUpdate();
			if (cnt != 0)
				System.out.println("Employee Details Updated Successfully !!");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void deleteEmployee(int id) {
		con=DBConnection.createDBConnection();
		String query="delete from employee where id=?";
		try {
			PreparedStatement pstm=con.prepareStatement(query);
			pstm.setInt(parameterIndex=1, id);
			int cnt=pstm.executeUpdate();
			if(cnt!=0)
				System.out.println("Employee Deleted the Successfully !!"+id);
		}catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
