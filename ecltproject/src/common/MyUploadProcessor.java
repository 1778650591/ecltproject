package common;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bstek.dorado.uploader.UploadFile;
import com.bstek.dorado.uploader.annotation.FileResolver;

@Component
public class MyUploadProcessor {
     
	@Autowired
	private HttpSession session;
	
    @FileResolver
    public String process1(UploadFile file, Map<String, Object> parameter) {
    	String suffix = file.getMultipartFile().getOriginalFilename().substring(file.getMultipartFile().getOriginalFilename().lastIndexOf(".")+1);
    	file.setFileName(System.currentTimeMillis()+"."+suffix);
       try {
//    	   System.out.println(session.getServletContext().getRealPath(""));
    	   file.transferTo(new File(session.getServletContext().getRealPath("")+"/img/"+file.getFileName()));;
//            System.out.println("上传成功");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace(); 
        }
       System.out.println("图片名为"+file.getFileName());
        return file.getFileName();
    }
}

