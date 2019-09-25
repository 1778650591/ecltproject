package common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.bstek.dorado.uploader.UploadProcessor;

public class MyUploadProcessor implements UploadProcessor {

	@Override
	public Object process(MultipartFile arg0, HttpServletRequest arg1,
			HttpServletResponse arg2) {
		System.out.println("图片上传成功！");
		return null;
	}

}
