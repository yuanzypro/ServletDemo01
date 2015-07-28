package orz.yy.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import orz.yy.dao.EmpDao;
import orz.yy.entity.Emp;
import orz.yy.impl.EmpDaoImpl;
import orz.yy.utils.DBUtils;

public class Test01 {

	/**
	 * 测试插入时间的Emp对象
	 */
	@Test
	public void testAddEmpAllInfo(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2008);
		cal.set(Calendar.MONTH, 5);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date date = new Date(cal.getTimeInMillis());
		EmpDao dao = new EmpDaoImpl();
		Emp emp = dao.findById(1);
		emp.setEname("小宝");
		emp.setAge(23);
		emp.setHireDate(date);
		Emp e = emp;
		dao.addEmp(e);
		List<Emp> list = dao.findAll();
		for (Emp ee : list) {
			System.out.println(ee.toString());
		}
	}
	
	/**
	 * 根据指定id修改记录
	 */
	//@Test
	public void testUpdate(){
		EmpDao dao = new EmpDaoImpl();
		Emp emp = new Emp();
		emp.setEname("小龙包");
		emp.setGender("女");
		emp.setAge(48);
		emp.setSalary(88888);
		emp.setDeptno(500);
		dao.updateEmpById(emp, 7);
		emp = dao.findById(7);
		System.out.println(emp.toString());
	}
	
	
	/**
	 * 根据指定id查询记录
	 */
	//@Test
	public void testFindById(){
		EmpDao dao = new EmpDaoImpl();
		Emp e = dao.findById(9);
		System.out.println(e.toString());
	}
	
	/**
	 * 根据指定id删除数据
	 */
	//@Test
	public void testDeleteImpl(){
		EmpDao dao = new EmpDaoImpl();
		dao.deleteById(5);
		
	}
	
	/**
	 * 测试EmpDao实现类empDaoImpl
	 * 查询emp表所有信息
	 */
	//@Test
	public void testEmpDaoImpl(){
		List<Emp> empList = null;
		EmpDao dao = new EmpDaoImpl();
		empList = dao.findAll();
		for (Emp emp : empList) {
			System.out.println(emp.toString());
		}
	}
	
	/**
	 * 测试DBUtils工具类中用于数据库连接的方法
	 */
	//@Test
	public void testJDBC(){
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
			for (Emp emp : empList) {
				System.out.println(emp.toString());
			}
		} catch (SQLException e) {
			System.out.println("初始化数据库连接失败。。。");
			e.printStackTrace();
		} finally{
			if(conn != null){
				DBUtils.freeConnection(conn);
			}
		}
	}
	
}











