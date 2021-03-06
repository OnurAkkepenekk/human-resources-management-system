package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvert);

	DataResult<List<JobAdvertisementDto>> getAll();

	Result increaseClickCount(int id);

	DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByCreateDate();

	DataResult<List<JobAdvertisement>> finfByIsActiveTrueAndEmployer_Id(int employerId);

	DataResult<JobAdvertisement> findByIdAndEmployer_Id(int jobadvertisement, int employerId);

	DataResult<JobAdvertisementDto> findById(int id);

	DataResult<List<JobAdvertisementDto>> searchJobAdvertisement(int cityId, int jobId, int workTimeTypeId,
			int workTypeId, String orderBy, String orderDirection);
}
