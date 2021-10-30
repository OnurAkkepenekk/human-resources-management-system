package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceWithCvWithJobPositionDto {
	private String workPlaceName;

	private String jobPosition;

	private Date startDate;

	private String quitDate;
}
