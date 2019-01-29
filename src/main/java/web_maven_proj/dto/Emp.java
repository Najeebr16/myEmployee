package web_maven_proj.dto;

public class Emp {
public String name;
public int emp_id;
public double salary;
public Emp(String name, int emp_id, double salary) {
	this.name = name;
	this.emp_id = emp_id;
	this.salary = salary;
}
public Emp()
{
	
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getEmp_id() {
	return emp_id;
}
public void setEmp_id(int emp_id) {
	this.emp_id = emp_id;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}






}
