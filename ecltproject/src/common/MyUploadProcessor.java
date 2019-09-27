package common;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.bstek.dorado.uploader.UploadProcessor;

public class MyUploadProcessor implements UploadProcessor {

	@Override
	public String process(MultipartFile file, HttpServletRequest arg1,
			HttpServletResponse arg2) {
//		System.err.println("getOriginalFilename:"+file.getOriginalFilename());
//		System.err.println("getName:"+file.getName());
//		System.err.println("getContentType:"+file.getContentType());
//		
//		try {
//			file.transferTo(new File("./target/upload/"+file.getOriginalFilename()));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		System.out.println("图片上传成功！");
		return file.getName();
	}

}
