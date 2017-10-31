package cafe.jjdev.web.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cafe.jjdev.web.FileRequest;

@Service
public class FileuploadService {
	
	@Autowired	
	private FileDao fileDao;
	
	public int fileupload(FileRequest fileRequest) {
		MultipartFile file = fileRequest.getFile();
		String fileName = file.getOriginalFilename();
		int pos = fileName.lastIndexOf("."); //파일에서 점의 위치
		String ext = fileName.substring(pos+1); //확장자 이름을 알고싶다
		System.out.println(ext);
		
		UUID uuid = UUID.randomUUID();
		String name = uuid.toString();
		name = name.replaceAll("-", "");
		System.out.println("name : "+name);
		System.out.println(name+"."+ext);
		
		File destFile = new File("c:/upload/"+name+"."+ext);
		try {
			file.transferTo(destFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		FileVo fileVo = new FileVo();
		fileVo.setFileTitle(fileRequest.getFileTitle());
		fileVo.setFilePath("c:/upload/"+name+"."+ext);
		
		//실제 파일을 폴더에 저장
		//FileRequest -> FileVo 
		//FileDao.insertFile() 메서드 호출

		return fileDao.insertFile(fileVo);
		
	}

}
