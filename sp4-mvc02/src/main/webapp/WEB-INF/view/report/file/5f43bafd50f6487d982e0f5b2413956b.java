import java.util.Scanner;
public class Exercise09 {
	public static void main(String[] args) {
		int studentNum = 0;
		int kor[] = null; // �� �л� ����
		int math[] = null; // �� �л� ����
		int eng[] = null;  // �� �л� ����
		int sum[] = null;  // �� �л��� ����
		double avg[] =null; // �� �л��� ���
		int max[] = new int[3];  // �� ���� �ְ���
		int totKor;  // �� ������ ����
		int totEng;  // �� ������ ����
		int totMath; // �� ������ ����
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("1.�л��� | 2.�����������Է�" 
					+ "| 3.�л�����������Ʈ | 4.�м� | 5.����");
			// 4. �м�
			// ������ ������ ���
			// �� �л��� ���� �� ���
			// ����� �ְ� ����
			System.out.print("����> ");
			int choiceNum 
				= Integer.parseInt(sc.nextLine());

			switch(choiceNum){
				case 1 : 
					System.out.print("�л��� : ");
				    studentNum = 
						Integer.parseInt(sc.nextLine());
					kor = new int[studentNum];
					eng = new int[studentNum];
					math = new int[studentNum];
					break;
				case 2 : 
					for(int i = 0; i< studentNum ;i++){
						System.out.println("�л�["+i+"] ");
						System.out.print("���� : ");
						kor[i]=
						Integer.parseInt(sc.nextLine());
						System.out.print("���� : ");
						eng[i]=
						Integer.parseInt(sc.nextLine());
						System.out.print("���� : ");
						math[i]=
						Integer.parseInt(sc.nextLine());
					}
					break;
				case 3 : 
					for(int i =0; i<studentNum;i++){
					System.out.print("�л�["+i+"] : ");
					System.out.print("���� : " + kor[i]);
					System.out.print(", ���� : " + eng[i]);
					System.out.print(", ���� : " + math[i]);	
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
					System.out.println("���� �ְ� ������ : "
					                   + max[0]);
					System.out.println("���� �ְ� ������ : "
					                   + max[1]);
					System.out.println("���� �ְ� ������ : "
					                   + max[2]);
					System.out.println("���� ���� ������ : "
					                   + (double)totKor
										   /studentNum);
					System.out.println("���� ���� ������ : "
					                   + (double)totEng
										   /studentNum);
					System.out.println("���� ���� ������ : "
					                   + (double)totMath
										   /studentNum);
					for(int i=0; i<studentNum ; i++){
						System.out.println("�л�["+i+"]"+
						"�� ���� : " 	+ sum[i] + ", ��� : "+
                        avg[i]);
					}
					
					break;
				case 5 : 
					System.out.println("���α׷� ����");
					System.exit(0);
					break;
			}
		}
	}
}
