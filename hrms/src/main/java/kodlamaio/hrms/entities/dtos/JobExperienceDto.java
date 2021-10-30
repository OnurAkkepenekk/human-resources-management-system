package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceDto {
		
	private String firstName;

	private String lastName;

	private String workPlaceName;

	private String jobPosition;

	private Date startDate;

	private String quitDate;
}
