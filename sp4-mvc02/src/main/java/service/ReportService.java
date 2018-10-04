package service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import command.ReportCommand;
import spring.BoaderFile;
import spring.MemberDao;

public class ReportService {
	private static final String filePath="C:\\Users\\HKEDU\\git\\projectmvc1\\sp4-mvc02\\src\\main\\webapp\\WEB-INF\\view\\report\\file\\";
	private File file = new File(filePath); 
	private String originalFile = null; // 웹페이지로 부터 넘어온 파일명
	private String originalFileExtension = null; // 파일명에서 확장자만 저장
	private String storedFileName = null; // 파일을 새로운 이름으로 저장
	private String studentNumber = null;
	private MultipartFile report = null;
	private MemberDao memberDao;
	private BoaderFile boaderFile;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public boolean fileupload(ReportCommand reportCommand, Model model) throws IOException{
		System.out.println("야이씨!!!!");
		studentNumber = reportCommand.getStudentNumber();
		System.out.println(studentNumber);
		report = reportCommand.getReport();
		System.out.println(report);
		originalFile = report.getOriginalFilename();
		System.out.println(originalFile);
		originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
		storedFileName = UUID.randomUUID().toString().replaceAll("-", "")+originalFileExtension;
		System.out.println(storedFileName);
		file = new File(filePath + storedFileName);
		System.out.println(file);
		try {
			report.transferTo(file);
			boaderFile = new BoaderFile(studentNumber, report.getSize(), originalFile, storedFileName);
			int i = memberDao.fileInsert(boaderFile);
			if(i == 0 ) System.out.println("저장되지 않았습니다.");
			System.out.println("저장됨");
			model.addAttribute("boaderFile",boaderFile);
			return true;
		}catch(IOException e) {
			return false;
		}
	}
}
