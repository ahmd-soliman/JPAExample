package bytesnapper;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;

/**
 * 
 * @author ByteSnapper
 *
 */

public class ByteSnapperJpa {

	private EntityManager entityManager;

	public ByteSnapperJpa() {
		EntityManagerFactory factory;
		factory = Persistence.createEntityManagerFactory("myCompnay");
		entityManager = factory.createEntityManager();
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public EntityTransaction getTranstAction() {
		return this.entityManager.getTransaction();
	}

	public void addEmployee(Employee empToSave) {
		try {
			this.getTranstAction().begin();
			entityManager.persist(empToSave);
			this.getEntityManager().merge(empToSave);
			this.getTranstAction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addDepartment(Department deptToSave) {
		try {
			this.getTranstAction().begin();
			entityManager.persist(deptToSave);
			this.getEntityManager().merge(deptToSave);
			this.getTranstAction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Employee createEmployee(String name, Department dept) {
		Employee emp = new Employee();
		emp.setName(name);
		emp.setDept(dept);
		return emp;

	}
	
	

	public Employee createEmployee(String name, Department dept,Date hiringDate) {
		Employee emp = new Employee();
		emp.setName(name);
		emp.setDept(dept);
		emp.setHiringDate(hiringDate);
		return emp;

	}

	public Department createDepartment(String name) {
		Department dept = new Department();
		dept.setName(name);
		return dept;

	}

}