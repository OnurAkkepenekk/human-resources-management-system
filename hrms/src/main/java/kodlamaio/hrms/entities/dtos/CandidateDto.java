package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDto {
	private int id;
	private String email;
	private String firstName;
	private String lastName;
	private String gender;
	private String identityNumber;
	private Date birthDate;
}

