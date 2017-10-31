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
	

	
	// file upload ��
	@RequestMapping(value="/fileAdd", method = RequestMethod.GET)
	public String fileAdd() {
		return "fileAdd";
	}

	// file upload �׼� ��� 1
	/*
	@RequestMapping(value="/fileAdd", method = RequestMethod.POST)
	public String fileAdd(@RequestParam(value="fileTitle") String fileTitle,
			MultipartFile file) {
		//������ ������ ���ھƴ� ����
		return "";
	}
	*/
	
	// file upload �׼� ��� 2
	@RequestMapping(value="/fileAdd", method = RequestMethod.POST)
	public String fileAdd(FileRequest fileRequest) {
		System.out.println(fileRequest + "--- file test ---");
		fileuploadService.fileupload(fileRequest);
		//������ ������ ���ھƴ� ����
		//1.������ ������ ����
		//2. ����� ������ �̸��� ���������� filevo
		return "";
	}
}
