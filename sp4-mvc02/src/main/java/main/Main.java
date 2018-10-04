package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import exception.AlreadyExistingMemberException;
import exception.MemberNotFoundException;
import service.ChangePasswordService;
import service.MemberInfoPrinter;
import service.MemberListPrinter;
import service.MemberRegisterService;
import spring.RegisterRequest;

public class Main {
	private static ApplicationContext ctx = null;
	public static void main(String[] args) 
				throws Exception{
		// TODO Auto-generated method stub
/*		ctx = 
	new AnnotationConfigApplicationContext(aaa.class);*/
		String [] str = {"classpath:spring-connect.xml","classpath:spring-member.xml"};
		ctx = new GenericXmlApplicationContext(
				str);
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while(true) {
			System.out.println("명령어를 입력하세요:");
			String command = reader.readLine();
			if(command.startsWith("new ")) {
				processNewCommand(command.split(" "));
			}else if(command.startsWith("list")) {
				processListCommand();
			}else if(command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
			}else if(command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다.");
				System.exit(0);
			}else if(command.equalsIgnoreCase("help")) {
				printHelp();
			}else if(command.startsWith("info ")) {
				   processInfoCommand(command.split(" "));
			}
		}
	}
	private static void processInfoCommand(String[] arg) {
		MemberInfoPrinter infoPrinter = 
				ctx.getBean("infoPrinter",
						MemberInfoPrinter.class);
		infoPrinter.printMemberInfo(arg[1]);
	}
	private static void printHelp() {
		System.out.println();
		System.out.println("명령어 사용법:");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비번 변경비번");
		System.out.println("list");
		System.out.println("info 이메일");
		System.out.println("version");
		System.out.println();
	}
	private static void processChangeCommand(String[] arg){
		ChangePasswordService pwdSvc =
				ctx.getBean("pwdSvc",
						ChangePasswordService.class);
		try {
			pwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호를 변경했습니다.\n");
		}catch(MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일입니다.\n");
		}catch(Exception e) {
			System.out.println("이메일과 암호가 일치하지 않습니다.\n");
		}
	}
	
	private static void processListCommand() {
		MemberListPrinter listPrinter =
				ctx.getBean("listPrinter",
						MemberListPrinter.class);
		listPrinter.printAll();
	}
	private static void processNewCommand(String[] arg) {
		MemberRegisterService regSvc  =
				ctx.getBean("regSvc",
						MemberRegisterService.class);
		RegisterRequest req = 
				new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		// RegisterRequest에 비밀번호 비교하는 메소드
		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호와 확인이 일치하지 않습니다.\n");
			return;
		}
		try {
			regSvc.regist(req);
			System.out.println("등록했습니다.\n");
		}catch(AlreadyExistingMemberException e) {
			System.out.println("이미 존재하는 이메일입니다.\n");
		}
	}
}
