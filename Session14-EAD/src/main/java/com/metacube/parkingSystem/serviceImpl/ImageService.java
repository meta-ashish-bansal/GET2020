package com.metacube.parkingSystem.serviceImpl;

import org.springframework.stereotype.Service;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

	public void saveImage(MultipartFile imageFile, int empId) throws Exception {
		String folder = "C:\\Users\\Jitendra\\Documents\\workspace-spring-tool-suite-4-4.5.1.RELEASE\\MetacubeParkingSystem\\src\\main\\resources\\static\\images\\";
		byte[] bytes = imageFile.getBytes();
		Path path = Paths.get(folder + empId + ".png");
		Files.write(path, bytes);
	}


}
