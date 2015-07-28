package orz.yy.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import orz.yy.dao.EmpDao;
import orz.yy.entity.Emp;
import orz.yy.utils.DBUtils;

public class EmpDaoImpl implements EmpDao {

	
	public void addEmp(Emp emp) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into emp (ename,gender,age,salary,deptno,hireDate) values (?,?,?,?,?,?);";
		try {
			conn = DBUtils.getConnection();
			conn.setAutoCommit(false);
			conn.setSavepoint();
			ps = conn.prepareStatement(sql);
			ps.setObject(1, emp.getEname());
			ps.setObject(2, emp.getGender());
			ps.setObject(3, emp.getAge());
			ps.setObject(4, emp.getSalary());
			ps.setObject(5, emp.getDeptno());
			ps.setObject(6, emp.getHireDate());
			ps.executeUpdate();
			conn.commit();
			System.out.println("添加员工成功。。。");
		} catch (Exception e) {
			System.out.println("添加员工失败,开始回滚。。。");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(),e);
		} finally {
			DBUtils.freeConnection(conn);
		}

	}

	public void deleteById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from emp where empno = ?";
		try {
			conn = DBUtils.getConnection();
			conn.setAutoCommit(false);
			conn.setSavepoint();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			conn.commit();
			System.out.println("删除记录成功。。。");
		} catch (Exception e) {
			System.out.println("删除员工失败,开始回滚。。。");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(),e);
		} finally {
			DBUtils.freeConnection(conn);
		}

	}

	public List<Emp> findAll() {
		List<Emp> empList = new ArrayList<Emp>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from emp";
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Emp e = new Emp();
				e.setEmpno(rs.getInt("empno"));
				e.setEname(rs.getString("ename"));
				e.setGender(rs.getString("gender"));
				e.setAge(rs.getInt("age"));
				e.setSalary(rs.getDouble("salary"));
				e.setHireDate(rs.getDate("hiredate"));
				e.setDeptno(rs.getInt("deptno"));
				empList.add(e);
			}
		} catch (SQLException e) {
			System.out.println("数据库连接失败。。。");
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(),e);
		} finally {
			DBUtils.freeConnection(conn);
		}
		return empList;
	}

	public Emp findById(int id) {
		System.out.println(id);
		Emp emp = new Emp();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from emp where empno = ?";
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setGender(rs.getString("gender"));
				emp.setAge(rs.getInt("age"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setHireDate(rs.getDate("hiredate"));
				emp.setDeptno(rs.getInt("deptno"));
			}
		} catch (SQLException e) {
			System.out.println("数据库连接失败。。。");
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(),e);
		} finally {
			DBUtils.freeConnection(conn);
		}
		return emp;
	}

	public void updateEmpById(Emp emp, int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update emp set ename = ?, gender = ?, age = ?, salary = ?, deptno = ?, hireDate = ? where empno = ?";
		try {
			conn = DBUtils.getConnection();
			conn.setAutoCommit(false);
			conn.setSavepoint();
			ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getGender());
			ps.setInt(3, emp.getAge());
			ps.setDouble(4, emp.getSalary());
			ps.setInt(5, emp.getDeptno());
			ps.setObject(6, emp.getHireDate());
			ps.setInt(7, id);
			ps.executeUpdate();
			conn.commit();
			System.out.println("记录修改成功。。。");
		} catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("记录修改失败，回滚操作。。。");
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}

}
