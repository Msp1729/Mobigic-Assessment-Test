package com.metiit.mobigic.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.metiit.mobigic.Entity.File;



public interface IFileService {

	public File addFile(File file_add, String email);

	public List<File> allFiles();

	public void editFile(File file, Integer id);

	public void deleteFile(Integer id);

	public File getById(int id);

	public List<File> findFileById(int id);

}
