package bytesnapper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author ByteSnapper
 *
 */
@Entity
@Table(name="DEPT")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DEPT_ID")
	private Long  id;
	
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

	


}
