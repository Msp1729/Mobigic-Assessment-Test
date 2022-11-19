package com.metiit.mobigic.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import com.metiit.mobigic.Entity.File;
import com.metiit.mobigic.Entity.Users;
import com.metiit.mobigic.Repositery.FileRepository;
import com.metiit.mobigic.Repositery.UserDao;



@Service
public class FileServiceImpl implements IFileService {

	@Autowired
	private FileRepository fileRepository;

	@Autowired
	private UserDao userDao;

	@Override
	public File addFile(File file_add, String email) {

		try {

			Users users = userDao.findByEmail(email);

			File file = file_add;

			file.setUser(users);

		    file.setNameOfFile(file_add.getNameOfFile());
			
			file.setFileName(file_add.getFileName());
			

			return fileRepository.save(file);
		} catch (Exception e) {
			System.out.println("============================");
			System.out.println(e.getMessage());
			System.out.println("=============================");
		}
		return null;
	}

	public void imgUpload(MultipartFile file, String fileName, 
			String email) {

		Users users = userDao.findByEmail(email);
		File files = new File();
		files.setUser(users);
		String filename = org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename());

		if (filename.contains("..")) {
			System.out.println("not a valid file");
		}

		try {
			files.setNameOfFile(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		files.setFileName(fileName);
		fileRepository.save(files);

	}

	public List<File> allFiles() {
		return fileRepository.findAll();
	}

	@Override

	public void editFile(File file, Integer id) {
		try {
			File file1 = fileRepository.findByCustomId(id);
			System.out.println(file1.getFileName());
			file1.setFileName(file.getFileName());
			fileRepository.save(file1);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void deleteFile(Integer id) {
		fileRepository.deleteFile(id);

	}

	@Override
	public File getById(int id) {
		return fileRepository.findByCustomId(id);

	}


	@Override
	public List<File> findFileById(int id) {
		return fileRepository.fetchByFIdFile(id);
	}

}
