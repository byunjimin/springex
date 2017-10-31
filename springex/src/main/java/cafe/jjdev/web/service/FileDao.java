package cafe.jjdev.web.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileDao {
	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	private final String NS2 = "cafe.jjdev.web.service.FileMapper";
	
	 public int insertFile(FileVo fileVo) {
	        return sqlSessionTemplate.insert(NS2+".insertFile", fileVo);
	    }
}
