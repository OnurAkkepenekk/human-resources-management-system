package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationInformationDto {

	private String name;

	private String surname;

	private String university;

	private String universityDepartment;

	private Date startDate;

	private Date graduateDate;
}
