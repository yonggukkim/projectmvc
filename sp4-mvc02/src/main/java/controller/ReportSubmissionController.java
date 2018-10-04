package controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ReportSubmissionController {
	// final을 주면 상수화 시키겠다는 것
	// 초기화된 값을 변경되지 않도록 하는 것.
	private static final String filePath="C:\\Users\\kook7\\git\\projectmvc2\\sp4-mvc02\\src\\main\\webapp\\WEB-INF\\view\\report\\file";
	// 파일 객체 생성(파일을 읽어오거나 파일을 저장하기 위한 객체)
	File file = new File(filePath);
	@RequestMapping(value="/report/submission", method="RequestMethod.GET")
	public String form() {
		return "report/submissionForm";
	}
	@RequestMapping(value="/report/submitReport1", method="POST")
	public String submitReport1(@RequestParam("studentNumber") String studentNumber, @RequestParam("report") MultipartFile report) throws IOException {
		
	}
}
