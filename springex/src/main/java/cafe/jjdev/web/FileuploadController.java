package cafe.jjdev.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cafe.jjdev.web.service.BoardDao;
import cafe.jjdev.web.service.FileDao;
import cafe.jjdev.web.service.FileuploadService;

@Controller
public class FileuploadController {
	
	@Autowired
	private FileuploadService fileuploadService; 
	

	
	// file upload 폼
	@RequestMapping(value="/fileAdd", method = RequestMethod.GET)
	public String fileAdd() {
		return "fileAdd";
	}

	// file upload 액션 방법 1
	/*
	@RequestMapping(value="/fileAdd", method = RequestMethod.POST)
	public String fileAdd(@RequestParam(value="fileTitle") String fileTitle,
			MultipartFile file) {
		//파일을 폴더에 저자아는 로직
		return "";
	}
	*/
	
	// file upload 액션 방법 2
	@RequestMapping(value="/fileAdd", method = RequestMethod.POST)
	public String fileAdd(FileRequest fileRequest) {
		System.out.println(fileRequest + "--- file test ---");
		fileuploadService.fileupload(fileRequest);
		//파일을 폴더에 저자아는 로직
		//1.파일을 폴더에 저장
		//2. 저장된 파일의 이름과 파일제목을 filevo
		return "";
	}
}
