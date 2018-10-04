package controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ReportSubmissionController {
	// final을 주면 상수화 시키겠다는 것
	// 초기화된 값을 변경되지 않도록 하는 것.
	private static final String filePath="C:\\Users\\HKEDU\\git\\projectmvc1\\sp4-mvc02\\src\\main\\webapp\\WEB-INF\\view\\report\\file\\";
	// 파일 객체 생성(파일을 읽어오거나 파일을 저장하기 위한 객체)
	File file = new File(filePath);
	@RequestMapping(value="/report/submission", method=RequestMethod.GET)
	public String form() {
		return "report/submissionForm";
	}
	@RequestMapping(value="/report/submitReport1", method=RequestMethod.POST)
	public String submitReport1(@RequestParam("studentNumber") String studentNumber, @RequestParam("report") MultipartFile report) throws IOException {
		String originalFile = report.getOriginalFilename(); // 저장된 파일명을 가져오는 것
		String originalFileExtension = originalFile.substring(originalFile.lastIndexOf(".")); // 파일명에서 확장자만 추출 하는 것
		// fileuploadtext.doc
		// lastIndexOf(".") ==> 14\
		// substring(14) ==> ".doc"
		String storedFileName = UUID.randomUUID().toString().replaceAll("-","")+originalFileExtension; // 문자를 랜덤으로 가져오는 것
		
		// 파일을 저장하기 위한 파일 객체 생성 
		file = new File(filePath + storedFileName);
		report.transferTo(file); // 파일 저장
		
		System.out.println(studentNumber + "가 업로드한 파일은 ");
		System.out.println(originalFile + "가 업로드 한 파일입니다.");
		System.out.println(storedFileName + "로 업로드 되었습니다.");
		System.out.println("파일사이즈는" + report.getSize());
		return "report/submissionComplete";
	}
}
