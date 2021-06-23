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

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "education_informations")
@AllArgsConstructor
@NoArgsConstructor
public class EducationInformation {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "start_date")
	private Date startDate;

	@Nullable
	@Column(name = "graduate_date")
	private Date graduateDate;
	
	@ManyToOne()
	@JoinColumn(name = "university_id")
	private University university;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private UniversityDepartment universityDepartment;
	
	@ManyToOne()
	@JoinColumn(name = "cv_id")
	private CV cv;
}
