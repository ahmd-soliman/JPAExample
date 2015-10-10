package bytesnapper;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;


/**
 * 
 * @author ByteSnapper
 *
*/
public class MainClass {

	public static void main(String[] args) {
	
		ByteSnapperJpa jpaHandler = new ByteSnapperJpa();

		Department it = jpaHandler.createDepartment("IT");
		Department acc = jpaHandler.createDepartment("Accounting");
		Department hr = jpaHandler.createDepartment("HR");
		Department admin = jpaHandler.createDepartment("Administration");
		/*it.setId(1L);
		acc.setId(2L);
		hr.setId(3L);
		admin.setId(4L)*/;


		jpaHandler.addDepartment(it);
		jpaHandler.addDepartment(acc);
		jpaHandler.addDepartment(hr);
		jpaHandler.addDepartment(admin);
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -496);
		Date ahmedHiringDate=calendar.getTime();
		calendar.add(Calendar.DATE, -100);	
		Date aliHiringDate=calendar.getTime();	
		calendar.add(Calendar.DATE, -1200);
		Date fatimaHiringDate=calendar.getTime();
		calendar.add(Calendar.DATE, 1100);
		Date hodaHiringDate=calendar.getTime();

		Employee ahmed = jpaHandler.createEmployee("Ahmed Hosni", it,ahmedHiringDate);
		Employee ali = jpaHandler.createEmployee("Ali Nour",acc,aliHiringDate);
		Employee fatima = jpaHandler.createEmployee("Fatima Mohamed", it,fatimaHiringDate);
		Employee hoda = jpaHandler.createEmployee("Hoda Hassan", hr,hodaHiringDate);

		jpaHandler.addEmployee(ahmed);
		jpaHandler.addEmployee(ali);
		jpaHandler.addEmployee(fatima);
		jpaHandler.addEmployee(hoda);

		Query empListQuery = jpaHandler.getEntityManager().createNativeQuery(
				"SELECT E.* FROM EMP E,DEPT D WHERE E.DEPT_ID=D.DEPT_ID", Employee.class);

		List<Employee> employeeList = empListQuery.getResultList();

		System.out.println("List of Entity Data Types: ");

		for (Employee emp : employeeList) {
			System.out.print("Name: " + emp.getName()
			+", ID: " + emp.getId()
			+", Dept: " + emp.getDept().getName()
			+", Hiring Date: "+emp.getHiringDate()+"\n");

		}
		System.out.println("\n -----------------------------------------------");

		Query stringListResult = jpaHandler.getEntityManager().createNativeQuery(
				"SELECT E.EMP_NAME FROM EMP E,DEPT D WHERE E.DEPT_ID=D.DEPT_ID AND E.DEPT_ID");

		List<String> empNames = stringListResult.getResultList();

		// Getting Result without passing class to createNativeQuery

		System.out.println("\nList of String Data Types:\n");

		for (String name : empNames) {
			System.out.println("Emp name : " + name);
		}
		
		

		Query dateListResult = jpaHandler.getEntityManager().createNativeQuery(
				"SELECT E.HIRING_DATE FROM EMP E,DEPT D WHERE E.DEPT_ID=D.DEPT_ID AND E.DEPT_ID");

		List<Date> empHiringDates = dateListResult.getResultList();

		// Getting Result without passing class to createNativeQuery

		System.out.println("\nList of Date Data Types:\n");

		for (Date date : empHiringDates) {
			System.out.println("Emp Hiring : " + date);
		}

	}

}
