package kodlamaio.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "cvs")
@AllArgsConstructor
@NoArgsConstructor
public class CV {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@Column(name ="creation_date")
	@JsonFormat(pattern="yyyy/MM/dd")
	private Date creationDate;

	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<EducationInformation> educationInformations;

	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<JobExperience> jobExperiences;

	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<ForeignLanguage> foreignLanguages;

	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<Image> image;

	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<Link> link;

	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<SkillForCV> skillForCV;

	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<CoverLetter> coverLetters;
}
