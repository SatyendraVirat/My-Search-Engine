package springmvcsearch;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileUploadController {
	@RequestMapping("/fileform")
	public String showUploadForm() {
		String str=null;
		System.out.println(str.length());
		return "fileform";
	}
	
	@RequestMapping(path="/uploadimage" ,method=RequestMethod.POST)
	public String UploadFile(@RequestParam("profile") CommonsMultipartFile file,HttpSession s,Model m ) {
		System.out.println("UPLOAD");
		System.out.println(file.getSize());
		System.out.println(file.getName());
		System.out.println(file.getStorageDescription());
		System.out.println(file.getOriginalFilename());
		
		//Get the byte data
		byte[] data = file.getBytes();
		//We have to save this file to server
		String path=s.getServletContext().getRealPath("/")+"WEB-INF"+File.separator+"resources"+File.separator+"image"+File.separator+file.getOriginalFilename();
		System.out.println(path);
		try {
		FileOutputStream fos = new	FileOutputStream(path); 
		fos.write(data);
		fos.close();
		System.out.println("File Uploaded");
		m.addAttribute("msg","file uploaded successfully");
		m.addAttribute("filename",file.getOriginalFilename());
		}catch(IOException e) {
			System.out.println("Uploading ERROR............");
			m.addAttribute("msg","Uploading ERROR");
		}
		return "filesuccess";
	}

}
