package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {

	private int id;
	private String jobDescription;
	private double minSalary;
	private double maxSalary;
	private int openPositionCount;
	private String cityName;
	private String jobPosition;
	private int employerId;
	private String workTimeTypeName;
	private String workTypeName;
	private String companyName;
	private String active;
}
