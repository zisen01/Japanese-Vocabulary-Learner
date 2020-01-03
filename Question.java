import java.lang.Integer;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Question{
	private String question;
	private String answer;
	private List<String> confusingOptions = new ArrayList<String>();
	private int answerID;

	Question(Vocab v){
		this.question = v.getJapanese();
		this.answer = v.getDefinition();
		this.confusingOptions.add(this.answer);
	}

	public void add_confusing_option(Vocab v){
		this.confusingOptions.add(v.getDefinition());
	}

	public Boolean doQuestion(){
		//System.out.println(this.confusingOptions);
		shuffleArray();
		//System.out.println(this.confusingOptions);
		findAnswerID();
		//System.out.println(this.answerID);
		printQuestion();

		int n = getAnswerInput();
		if (n==this.answerID){
			System.out.println("Correct");
			return true;
		}else{
			System.out.println("Wrong");
			System.out.println("Answer:"+this.answer);
			return false;
		}

	}

	public void shuffleArray(){
		Collections.shuffle(confusingOptions);
	}


	private void findAnswerID(){
		if (this.confusingOptions.contains(this.answer)){
			this.answerID = this.confusingOptions.indexOf(this.answer);
		}else{
			System.out.println("Unexpected error: answer does not exist in option list");
			return;
		}
	}

	private void printQuestion(){
		System.out.println("Choose the correct definition for:"+this.question);
		for (int i=0; i<this.confusingOptions.size(); i++){
			System.out.println(" " + Integer.toString(i)+") "+this.confusingOptions.get(i));

		}
	}

	private int getAnswerInput(){
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a number:");
		//TODO: what if user type negative number?
		while (true){
			try {
				int n = reader.nextInt();
				if ((n >= 0) && (n<=3)){
					return n;
				}else{
					System.out.println("Please enter a legit number!");
					continue;
				}
			}catch(Exception e){
				// if the entry is not a number, let the scanner pass it and print message. so the program can wait to recrive next entry.
				String badAns = reader.next();
				System.out.println("Please enter a number!");
				continue;
			}
		}

	}
	public String getQuestion(){
		return this.question;
	}
	public String getAnswer(){
		return this.answer;
	}
}
