import java.util.Scanner;
public class Exercise09 {
	public static void main(String[] args) {
		int studentNum = 0;
		int kor[] = null; // 각 학생 점수
		int math[] = null; // 각 학생 점수
		int eng[] = null;  // 각 학생 점수
		int sum[] = null;  // 각 학생의 총점
		double avg[] =null; // 각 학생의 평균
		int max[] = new int[3];  // 각 과목별 최고점
		int totKor;  // 각 과목의 총점
		int totEng;  // 각 과목의 총점
		int totMath; // 각 과목의 총점
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("1.학생수 | 2.국영수점수입력" 
					+ "| 3.학생별점수리스트 | 4.분석 | 5.종료");
			// 4. 분석
			// 국영수 각각의 평균
			// 각 학생의 총점 및 평균
			// 과목당 최고 점수
			System.out.print("선택> ");
			int choiceNum 
				= Integer.parseInt(sc.nextLine());

			switch(choiceNum){
				case 1 : 
					System.out.print("학생수 : ");
				    studentNum = 
						Integer.parseInt(sc.nextLine());
					kor = new int[studentNum];
					eng = new int[studentNum];
					math = new int[studentNum];
					break;
				case 2 : 
					for(int i = 0; i< studentNum ;i++){
						System.out.println("학생["+i+"] ");
						System.out.print("국어 : ");
						kor[i]=
						Integer.parseInt(sc.nextLine());
						System.out.print("영어 : ");
						eng[i]=
						Integer.parseInt(sc.nextLine());
						System.out.print("수학 : ");
						math[i]=
						Integer.parseInt(sc.nextLine());
					}
					break;
				case 3 : 
					for(int i =0; i<studentNum;i++){
					System.out.print("학생["+i+"] : ");
					System.out.print("국어 : " + kor[i]);
					System.out.print(", 영어 : " + eng[i]);
					System.out.print(", 수학 : " + math[i]);	
					System.out.println();
					}
					break;
				case 4 : 
					sum = new int[studentNum];
					avg = new double[studentNum];
					totKor =0;
					totEng =0;
					totMath =0;
					for(int i=0; i<studentNum;i++){
						max[0] = (max[0]<kor[i])?kor[i]
									:max[0];
						max[1] = (max[1]<eng[i])?eng[i]
									:max[1];
						max[2] = (max[2]<math[i])?math[i]
									:max[2];
						sum[i] += kor[i]+eng[i]+math[i];
						avg[i] = (double)sum[i] / 3 ;
						totKor +=  kor[i];
						totEng +=  eng[i];
						totMath += math[i];
					}
					System.out.println("국어 최고 점수는 : "
					                   + max[0]);
					System.out.println("영어 최고 점수는 : "
					                   + max[1]);
					System.out.println("수학 최고 점수는 : "
					                   + max[2]);
					System.out.println("국어 평점 점수는 : "
					                   + (double)totKor
										   /studentNum);
					System.out.println("영어 평점 점수는 : "
					                   + (double)totEng
										   /studentNum);
					System.out.println("수학 평점 점수는 : "
					                   + (double)totMath
										   /studentNum);
					for(int i=0; i<studentNum ; i++){
						System.out.println("학생["+i+"]"+
						"의 총점 : " 	+ sum[i] + ", 평균 : "+
                        avg[i]);
					}
					
					break;
				case 5 : 
					System.out.println("프로그램 종료");
					System.exit(0);
					break;
			}
		}
	}
}
