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
@Table(name = "tb_job")
public class UserJob {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "j_id")
	private Integer jobid; 
	
	private String jobname;
	
	@Temporal(TemporalType.DATE)
	private Date createDate;

	

	public Integer getJobid() {
		return jobid;
	}

	public void setJobid(Integer jobid) {
		this.jobid = jobid;
	}

	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public UserJob(Integer jobid, String jobname, Date createDate) {
		super();
		this.jobid = jobid;
		this.jobname = jobname;
		this.createDate = createDate;
	}

	public UserJob(String jobname, Date createDate) {
		super();
		this.jobname = jobname;
		this.createDate = createDate;
	}

	public UserJob(Integer jobid) {
		super();
		this.jobid = jobid;
	}

	public UserJob() {
		super();
	}

	@Override
	public String toString() {
		return "UserJob [jobid=" + jobid + ", jobname=" + jobname + ", createDate=" + createDate + "]";
	}

	
	
	
	

}
