package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import command.ReportCommand;
import service.ReportService;

@Controller
public class ReportSubmissionController1 {
	private ReportService reportService;

	@Autowired
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}
	@RequestMapping(value="/report/submission1", method=RequestMethod.GET)
	public String form(ReportCommand reportCommand) {
		
		return "report/submissionForm1";
	}
	@RequestMapping(value="/report/submitReport2", method=RequestMethod.POST)
	public String submitReport2(ReportCommand reportCommand, HttpServletRequest request,Model model) throws IOException {
		boolean result = reportService.fileupload(reportCommand, model);
		if(result==false) {
			System.out.println("파일이 저장되지 않았습니다.");
			return "report/submissionForm1";
		}
		return "report/submissionComplete";
	}
	@RequestMapping(value="/report/submitReport3", method=RequestMethod.POST)
	public String submitReport3(MultipartHttpServletRequest multirequest, Model model) throws IOException{
		ReportCommand reportCommand = new ReportCommand();
		reportCommand.setStudentNumber(multirequest.getParameter("studentNumber"));
		reportCommand.setReport(multirequest.getFile("report"));
		boolean result = reportService.fileupload(reportCommand, model);
		if(result == false) {
			System.out.println("파일이 저장되지 않았습니다.");
			return "report/submissionForm2";
		}
		System.out.println("파일 정상적으로 저장되었습니다.");
		return "report/submissionComplete";
	}
	@RequestMapping(value="/report/submitReport2", method=RequestMethod.GET)
	public String form1() {
		return "report/submissionForm2";
	}
}
