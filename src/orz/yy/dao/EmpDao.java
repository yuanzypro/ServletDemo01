package orz.yy.dao;

import java.util.List;

import orz.yy.entity.Emp;

public interface EmpDao {

	/*查询所有emp*/
	public List<Emp> findAll();
	
	/*通过工号进行查询*/
	public Emp findById(int id);
	
	/*添加emp*/
	public void addEmp(Emp emp);
	
	/*删除指定工号的emp*/
	public void deleteById(int id);
	
	/*修改指定emp的信息*/
	public void updateEmpById(Emp emp,int id);
	
	
}










