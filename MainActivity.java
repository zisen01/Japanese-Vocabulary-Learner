import java.util.Scanner;

public class MainActivity{
	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		while(true){
			StateChooseLesson s1 = new StateChooseLesson(reader);
			String path = s1.chooseLesson();
			if (path!=null){
				int mode = s1.chooseMode();
				StateQuiz s2 = new StateQuiz(path, mode);
				s2.doQuiz();
				StateResult s3 = new StateResult(s2.getNum_questions(), s2.getScore(), s2.get_mistake_list());
				s3.printResult();
				System.out.println();
				int m = askContinue(reader);
				if (m == 1){
					continue;
				}else{
					break;
				}
			}else{
				break;
			}

		}
		reader.close();
	}
	private static int askContinue(Scanner reader){
		while (true){
			System.out.println("Continue? (1->y/0->n)");
			try{
				int n = reader.nextInt();
				if (n == 1){
					return 1;
				}else if (n == 0){
					return 0;
				}else{
					continue;
				}
			}catch(Exception e){
				System.out.println("Please enter a number!");
				return -1;
			}

		}
	}
}
