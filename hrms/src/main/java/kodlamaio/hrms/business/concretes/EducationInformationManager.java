package kodlamaio.hrms.business.concretes;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationInformationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationInformationDao;
import kodlamaio.hrms.entities.concretes.EducationInformation;
import kodlamaio.hrms.entities.dtos.EducationInformationDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EducationInformationManager implements EducationInformationService {

	private final EducationInformationDao educationInformationDao;

	@Override
	public Result add(EducationInformation educationInformation) {
		this.educationInformationDao.save(educationInformation);
		return new SuccessResult("Eğitim bilgileri Eklendi");
	}

	@Override
	public DataResult<List<EducationInformationDto>> getEducationInformationsByUserId(int candidateId) {
		return new SuccessDataResult<List<EducationInformationDto>>(this.educationInformationDao.getEducationInformations(candidateId));
	}

}
