package com.lcsystem.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lcsystem.ordering.LCOrder;

@Controller
public class UploadController {
	private static final String UPLOADED_FOLDER = System.getProperty("user.dir").concat("\\temp\\");    

	@GetMapping("/")
	public String index() {
		return "upload";
	}

	@PostMapping("/upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws UnsupportedEncodingException {				
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Por favor, selecciona un archivo...");
		}else {
			try {
				String archivoDestino = UPLOADED_FOLDER + "\\" + file.getOriginalFilename();
				LCOrder.ordenar(archivoDestino, file.getBytes());
	
				redirectAttributes.addFlashAttribute("message", "Se ha cargado correctamente '" + file.getOriginalFilename() + "'");
				redirectAttributes.addFlashAttribute("correcto", "...");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return "redirect:/uploadStatus";
	}

	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}

}