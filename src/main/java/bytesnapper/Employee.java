package bytesnapper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author ByteSnapper
 *
 */
@Entity
@Table(name = "EMP")
public class Employee {
	@Id
	@Column(name = "EMP_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(targetEntity = Department.class)
	@JoinColumn(name = "DEPT_ID", referencedColumnName = "DEPT_ID")
	private Department dept;

	@Column(name = "EMP_NAME")
	private String name;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Department getDept() {
		return dept;
	}

}
