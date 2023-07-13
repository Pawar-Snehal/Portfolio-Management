package com.sjprogramming.empapp1;

public interface EmployeeDaoIntrf {
	
	//create employee
	public void createEmployee(Employee emp);
	
	//show all employee
	public void showAllEmployee();
	
	//show employee based on id
	public void showEmployeeBasedOnId(int id);
	
	//update employee
	public void updateEmployee(int id,String name);
	
	//delete employees
	public void deleteEmployee(int id);
	

}
