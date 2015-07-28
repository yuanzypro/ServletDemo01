package orz.yy.entity;

import java.util.Date;

public class Emp {

	private int empno;
	private String ename;
	private String gender;
	private int age;
	private double salary;
	private Date hireDate;
	private int deptno;

	public Emp() {
		super();
	}

	public Emp(int empno, String ename, String gender, int age, double salary,
			Date hireDate, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.gender = gender;
		this.age = age;
		this.salary = salary;
		this.hireDate = hireDate;
		this.deptno = deptno;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empno;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (empno != other.empno)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", gender="
				+ gender + ", age=" + age + ", salary=" + salary
				+ ", hireDate=" + hireDate + ", deptno=" + deptno + "]";
	}

}
