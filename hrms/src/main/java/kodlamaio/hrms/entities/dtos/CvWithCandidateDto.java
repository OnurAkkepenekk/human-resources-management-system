package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvWithCandidateDto {

	private int Id;
	private String identityNumber;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private int birthYear;
}
