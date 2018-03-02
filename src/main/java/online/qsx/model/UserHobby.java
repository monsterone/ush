package online.qsx.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_hobby")
public class UserHobby {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "h_id")
	private Integer id; 
	
	private String name;
	
	@Temporal(TemporalType.DATE)
	private Date createDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public UserHobby(Integer id, String name, Date createDate) {
		super();
		this.id = id;
		this.name = name;
		this.createDate = createDate;
	}

	public UserHobby(String name, Date createDate) {
		super();
		this.name = name;
		this.createDate = createDate;
	}
	
	

	public UserHobby(String name) {
		super();
		this.name = name;
	}

	public UserHobby(Integer id) {
		super();
		this.id = id;
	}

	public UserHobby() {
		super();
	}

	@Override
	public String toString() {
		return "UserHobby [id=" + id + ", name=" + name + ", createDate=" + createDate + "]";
	}
	
	
	
}
