package bytesnapper;

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

		jpaHandler.addDepartment(it);
		jpaHandler.addDepartment(acc);
		jpaHandler.addDepartment(hr);
		jpaHandler.addDepartment(admin);

		Employee ahmed = jpaHandler.createEmployee("Ahmed Hosni", it);
		Employee ali = jpaHandler.createEmployee("Ali Nour", it);
		Employee fatima = jpaHandler.createEmployee("Fatima Mohamed", it);
		Employee hoda = jpaHandler.createEmployee("Hoda Hassan", it);

		jpaHandler.addEmployee(ahmed);
		jpaHandler.addEmployee(ali);
		jpaHandler.addEmployee(fatima);
		jpaHandler.addEmployee(hoda);

		Query empListQuery = jpaHandler.getEntityManager().createNativeQuery(
				"SELECT E.* FROM EMP E,DEPT D WHERE E.DEPT_ID=D.DEPT_ID", Employee.class);

		List<Employee> employeeList = empListQuery.getResultList();

		System.out.println("List of Entity Data Types: ");

		for (Employee emp : employeeList) {
			System.out.println("Name: " + emp.getName());
			System.out.println("ID: " + emp.getId());
			System.out.println("Dept: " + emp.getDept().getName());
		}
		System.out.println("\n -----------------------------------------------");

		Query stringListResult = jpaHandler.getEntityManager().createNativeQuery(
				"SELECT E.EMP_NAME FROM EMP E,DEPT D WHERE E.DEPT_ID=D.DEPT_ID ");

		List<String> empNames = stringListResult.getResultList();

		// Getting Result without passing class to createNativeQuery

		System.out.println("\nList of String Data Types:\n");

		for (String name : empNames) {
			System.out.println("Emp name : " + name);
		}

	}

}
