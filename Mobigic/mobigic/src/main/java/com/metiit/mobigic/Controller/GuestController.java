package com.metiit.mobigic.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.metiit.mobigic.Entity.File;
import com.metiit.mobigic.Service.IFileService;



@CrossOrigin
@RestController
@RequestMapping(path = "/file")
public class GuestController {

	@Autowired
	private IFileService iFileService;



	@PostMapping("/add-file/{email}")
	public File addNewFile(@RequestBody File file, @PathVariable String email) {
		return iFileService.addFile(file, email);
	}


	@DeleteMapping("/deleteFile/{id}")
	public ResponseEntity<?> deleteFile(@PathVariable Integer id) {
		iFileService.deleteFile(id);
		return ResponseEntity.ok("File Deleted");
	}



	@GetMapping("/showFiles/{id}")
	public List<File> farmeraddedProduct(@PathVariable int id) {
		return iFileService.findFileById(id);
	}



}
