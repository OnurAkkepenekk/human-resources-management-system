package kodlamaio.hrms.business.concretes;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.adapters.cloudinaryAdapter.CloudinaryAdapter;
import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImageManager implements ImageService {
	private final ImageDao imageDao;

	@Override
	public Result add(MultipartFile file) throws IOException {
		var result = CloudinaryAdapter.uploadImage(file);
		return new SuccessResult(result.getData().toString());
	}
}
