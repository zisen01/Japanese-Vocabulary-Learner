import java.util.*;
import java.lang.Integer;
public class StateResult{
	private int percentage;
	private ArrayList<Vocab> mistake_list;

	StateResult(int nquestion, int score, ArrayList<Vocab> mistakeList){
		this.percentage = calculatePercentage(nquestion, score);
		this.mistake_list = mistakeList;
	}

	private int calculatePercentage(int nquestion, int score){
		return (score*100)/nquestion;
	}
	// print analyzed result
	public void printResult(){
		//print score in percent
		System.out.println("Your score: "+ Integer.toString(percentage)+"%");
		//print mistake list if there are mistakes
		if (mistake_list.size()!=0){
			System.out.println();
			System.out.println("You got the following questions wrong:");
			for (Vocab v : this.mistake_list){
			System.out.println(v.getJapanese() + ": " + v.getDefinition());
			}	
		}

		System.out.println();
		printCheerfulLanguage();
	}
	private void printCheerfulLanguage(){
		if (this.percentage >= 80){
			System.out.println("Keep up the good work!");
			
		}else if (this.percentage >= 50 && this.percentage < 80){
			System.out.println("Try harder! You can do it!");

		}else{
			System.out.println("You should study harder.");
		}
	}
}
