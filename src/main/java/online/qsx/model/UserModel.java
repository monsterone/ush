package online.qsx.model;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_user")
public class UserModel {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "u_id")
	private Integer id;

	private String name;
 
	private String password;
		
	private String email;
	
	private Boolean  sex;
	
	@Temporal(TemporalType.DATE) 
	private Date birthday;
	
	
	
	@Temporal(TemporalType.DATE)
	private Date createDate;

	// 特殊属性
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "j_id")
	private  UserJob uesrJob;
   
	
	// 特殊属性
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "h_id")
	private UserHobby userHobby;


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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	

	public Boolean getSex() {
		return sex;
	}


	public void setSex(Boolean sex) {
		this.sex = sex;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public UserJob getUesrJob() {
		return uesrJob;
	}


	public void setUesrJob(UserJob uesrJob) {
		this.uesrJob = uesrJob;
	}


	public UserHobby getUserHobby() {
		return userHobby;
	}


	public void setUserHobby(UserHobby userHobby) {
		this.userHobby = userHobby;
	}


	public UserModel(Integer id, String name, String password, String email, Boolean sex, Date birthday,
			Date createDate) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.sex = sex;
		this.birthday = birthday;
		this.createDate = createDate;
	}


	public UserModel(String name, String password, String email, Boolean sex, Date birthday, Date createDate) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.sex = sex;
		this.birthday = birthday;
		this.createDate = createDate;
	}
	
	


	public UserModel(Integer id, String name, String password, String email, Boolean sex, Date birthday,
			Date createDate, UserJob uesrJob, UserHobby userHobby) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.sex = sex;
		this.birthday = birthday;
		this.createDate = createDate;
		this.uesrJob = uesrJob;
		this.userHobby = userHobby;
	}
   
	

	public UserModel(String name, String password, String email, Boolean sex, Date birthday, Date createDate,
			UserJob uesrJob, UserHobby userHobby) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.sex = sex;
		this.birthday = birthday;
		this.createDate = createDate;
		this.uesrJob = uesrJob;
		this.userHobby = userHobby;
	}


	public UserModel(Integer id) {
		super();
		this.id = id;
	}


	public UserModel() {
		super();
	}

	
	

	
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", sex=" + sex
				+ ", birthday=" + birthday + ", createDate=" + createDate + "]";
	}


	
	
	
	
	

	
	
	
	
	

	
}
