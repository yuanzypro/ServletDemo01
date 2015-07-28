package orz.yy.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orz.yy.dao.EmpDao;
import orz.yy.entity.Emp;
import orz.yy.impl.EmpDaoImpl;

public class ActionServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		EmpDao dao = new EmpDaoImpl();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		
		//获取请求资源路径
		String uri = request.getRequestURI();
		System.out.println("uri= " + uri);
		String action = uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));
		System.out.println("action= " + action);
		
		if(("list").equals(action)){//员工信息列表
			try {
				List<Emp> empList = dao.findAll();
				request.setAttribute("empList", empList);
				request.getRequestDispatcher("listEmp2.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		} else if(("add").equals(action)){//添加员工
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String age = request.getParameter("age");
			String salary = request.getParameter("salary");
			String deptno = request.getParameter("deptno");
			String hireDate = request.getParameter("hireDate");
			
			//把用户输入的时间字符串转换成java.util.date格式的时间
			String dateTrans[] = hireDate.trim().split("/");		//切割用户输入的字符串
			int year = Integer.parseInt(dateTrans[0]);
			int month = Integer.parseInt(dateTrans[1])-1;
			int day = Integer.parseInt(dateTrans[2]);
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.MONTH,month);
			cal.set(Calendar.DAY_OF_MONTH, day);
			//用户输入的字符串已经转化为Date格式的时间
			Date date = new Date(cal.getTimeInMillis());
			
			Emp emp = new Emp();
			emp.setEname(name);
			emp.setGender(gender);
			emp.setAge(Integer.parseInt(age));
			emp.setSalary(Double.parseDouble(salary));
			emp.setDeptno(Integer.parseInt(deptno));
			emp.setHireDate(date);
			try {
				dao.addEmp(emp);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		} else if(("del").equals(action)){//删除员工
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("要删除的员工ID是：" + id);
			try {
				dao.deleteById(id);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		} else if(("load").equals(action)){
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("要修改信息的员工ID是:" + id);
			try {
				Emp emp = dao.findById(id);
				request.setAttribute("emp", emp);
				request.setAttribute("id", id);
				request.getRequestDispatcher("updateEmp.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException();
			}
		} else if(("modify").equals(action)){
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("ename");
			String gender = request.getParameter("gender");
			String age = request.getParameter("age");
			String salary = request.getParameter("salary");
			String deptno = request.getParameter("deptno");
			String hireDate = request.getParameter("hireDate");
			
			//把用户输入的时间字符串转换成java.util.date格式的时间
			String dateTrans[] = hireDate.trim().split("/");		//切割用户输入的字符串
			int year = Integer.parseInt(dateTrans[0]);
			int month = Integer.parseInt(dateTrans[1])-1;
			int day = Integer.parseInt(dateTrans[2]);
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.MONTH,month);
			cal.set(Calendar.DAY_OF_MONTH, day);
			//用户输入的字符串已经转化为Date格式的时间
			Date date = new Date(cal.getTimeInMillis());
			
			Emp emp = new Emp();
			emp.setEname(name);
			emp.setGender(gender);
			emp.setAge(Integer.parseInt(age));
			emp.setSalary(Double.parseDouble(salary));
			emp.setDeptno(Integer.parseInt(deptno));
			emp.setHireDate(date);
			try {
				dao.updateEmpById(emp, id);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException();
			}
		}
		
		
		
	}
}
