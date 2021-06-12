package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_advertisements")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "JobAdvertisement" })
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "job_description", nullable = false)
	private String jobDescription;

	@Column(name = "min_salary", nullable = false)
	private double minSalary;

	@Column(name = "max_salary", nullable = false)
	private double maxSalary;

	@Column(name = "open_positon_count", nullable = false)
	private int openPositionCount;

	@Column(name = "last_apply_date", nullable = false)
	private Date lastApplyDate;

	@Column(name = "create_date", nullable = false)
	private Date publishDate;

	@Column(name = "is_active", nullable = false)
	private boolean isActive;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private Job jobPosition;

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

	public JobAdvertisement(String jobDescription, Double minSalary, Double maxSalary, int openPositionCount,
			Date lastApplyDate, Date createDate, boolean isActive) {
		this.jobDescription = jobDescription;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.openPositionCount = openPositionCount;
		this.lastApplyDate = lastApplyDate;
		this.publishDate = createDate;
		this.isActive = isActive;
	}

}
