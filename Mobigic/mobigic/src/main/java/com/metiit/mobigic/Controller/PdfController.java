package com.metiit.mobigic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.metiit.mobigic.Dto.FileUploadHelper;
import com.metiit.mobigic.Entity.File;
import com.metiit.mobigic.Service.IFileService;



@RestController
@CrossOrigin
public class PdfController {

	@Autowired
	private FileUploadHelper fileUploadHelper;

	@Autowired
	private IFileService ifileService;

	

	@PostMapping("/upload/{email}/{file_id}")
	public ResponseEntity<String> uploadFile(@PathVariable int file_id, @PathVariable String email,
			@RequestParam("file") MultipartFile pdffile) {
		System.out.println(pdffile.getOriginalFilename());
		// validation
		try {
			if (pdffile.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain file");
			}

			if (!pdffile.getContentType().equals("application/pdf")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only pdf file allowed");
			}

			boolean status = fileUploadHelper.uploadFile(pdffile);
			if (status) {

				File product = ifileService.getById(file_id);
				System.out.println(product.getF_Id());
				String pdfUrl = ("/pdf/" + pdffile.getOriginalFilename());
				System.out.println(pdffile.getOriginalFilename());
				///product.setNameOfFile(pdfUrl);
				ifileService.addFile(product, email);
				return ResponseEntity.ok("File is successfully uploaded");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong! try again");
	}

	

}
