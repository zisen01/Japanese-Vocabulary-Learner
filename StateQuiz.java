import java.util.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.lang.Object;
import java.lang.Integer;

//package vocab;
//import vocab.Vocab;
public class StateQuiz{
	private String lessonPath;
	private ArrayList<Vocab> vocab_list;
	private ArrayList<Question> question_list = new ArrayList<Question>();
	private int num_questions;
	private int score = 0;
	private ArrayList<Vocab> mistake_list = new ArrayList<Vocab>();
	private int mode;

	StateQuiz(String n, int m){
		this.lessonPath = n;
		this.mode = m;
		get_vocab_list();
		generateQuestionList();

	}

	private void get_vocab_list(){
		ArrayList<Vocab> vlist = new ArrayList<Vocab>();
		try{
			BufferedReader reader = new BufferedReader(new FileReader(lessonPath));
			String line;
			String[] parts;
			while ((line = reader.readLine()) != null){
				parts = line.split("-");
				if (parts.length==0){
					continue;
				}
				String firstLangu = parts[0];
				String secondLangu = new String();
				for (int i = 1; i<parts.length; i++){
					secondLangu+=parts[i];
					if (i<parts.length-1){
						secondLangu+="-";
					}
				}
				if (this.mode == 0){
					// 0: first language -> second language
					Vocab v = new Vocab(firstLangu, secondLangu);
					vlist.add(v);
				}else if (this.mode == 1){
					// 1: second language -> frst language
					Vocab v = new Vocab(secondLangu, firstLangu);
					vlist.add(v);

				}
			}
			this.vocab_list = vlist;
		}catch (Exception e){
			System.err.format("Exception occurred trying to read '%s'.", this.lessonPath);
			e.printStackTrace();
		}
	}
	public void generateQuestionList(){
		Scanner reader = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter how many questions you want to do (0=>one for all):");
		while (true){
			try{
				int n = reader.nextInt();
				System.out.println();
				if(n==0){
					this.num_questions = this.vocab_list.size();
					genArbOneForAll();
					break;
				}else if (n>0){
					this.num_questions = n;
					genArbQuestions();
					break;
				}else{
					System.out.println("please enter a legit number!");
					continue;
				}
			}catch(Exception e){
				String badAns = reader.next();
				System.out.println("Not a interger!");
				continue;
			}
		}



	}

	public void genArbQuestions(){
		Random rand = new Random();
		// Generate question list
		ArrayList<Vocab> selected_options = new ArrayList<Vocab>();
		ArrayList<String> selected_options_English = new ArrayList<String>();
		for (int i = 0; i < this.num_questions; i++){
			int m = rand.nextInt(this.vocab_list.size());
			Question q = new Question(this.vocab_list.get(m));
			this.question_list.add(q);
		for (int a = 0; a <3; a++){
				m = rand.nextInt(this.vocab_list.size());
				if (selected_options_English.contains(this.vocab_list.get(m).getDefinition()) || (q.getAnswer()==this.vocab_list.get(m).getDefinition())){
					a = a-1;
				}else{
					selected_options.add(this.vocab_list.get(m));
					selected_options_English.add(this.vocab_list.get(m).getDefinition());
				}

			}
			for (Vocab v: selected_options){
				q.add_confusing_option(v);
			}
			selected_options.clear();
			selected_options_English.clear();
		}


	}


	//if file contain two words of same Japanese, one for all question list can not be generated, if contain two words of same English, one for all can be generated
	public void genArbOneForAll(){
		Random rand = new Random();
		// Generate question list
		ArrayList<String> title_list = new ArrayList<String>();
		ArrayList<Vocab> selected_options = new ArrayList<Vocab>();
		ArrayList<String> selected_options_English = new ArrayList<String>();
		for (int i = 0; i < this.vocab_list.size(); i++){
			int m = rand.nextInt(this.vocab_list.size());
			//for non-repeating vocab, maximum question possible is the number of total vocabs
			Vocab v = this.vocab_list.get(m);
			if (title_list.contains(v.getJapanese())){
				i = i-1;
			}else{
				Question q = new Question(this.vocab_list.get(m));
				this.question_list.add(q);
				title_list.add(v.getJapanese());
				//System.out.println(title_list);

				//generate confusing options for question
				for (int a = 0; a <3; a++){
					m = rand.nextInt(this.vocab_list.size());
					if (selected_options_English.contains(this.vocab_list.get(m).getDefinition()) || (q.getAnswer()==this.vocab_list.get(m).getDefinition())){
						a = a-1;
					}else{
						selected_options.add(this.vocab_list.get(m));
						selected_options_English.add(this.vocab_list.get(m).getDefinition());
					}

				}
				for (Vocab vocab: selected_options){
					q.add_confusing_option(vocab);
				}
				selected_options.clear();
				selected_options_English.clear();
			}

		}
		title_list.clear();

	}
	public void doQuiz(){
		Boolean b;
		for (int i = 0; i < this.num_questions; i++){
			System.out.print(Integer.toString(i+1)+"] ");
			b = this.question_list.get(i).doQuestion();
			if (b){
				this.score += 1;
			}else{
				Vocab mistake = new Vocab(this.question_list.get(i).getQuestion(), this.question_list.get(i).getAnswer());
				this.mistake_list.add(mistake);
			}
			System.out.println();
		}
	}
/*	public void recordMistake(Question q){
		//TODO: check if mistakeList file exist, if not then create
		Scanner scanner = new scanner(mistakeList);
		while(scanner.hasNextLine()){
			if(scanner.nextLine().startsWith(q.getQuestion())){
				//TODO: do not use scanner since it cannotedit the file
				System.out.println();
			}
		}
	}
*/


	public void set_lessonPath(String n){
		this.lessonPath = n;
	}

	public String get_lessonPath(){
		return this.lessonPath;
	}

	public int getNum_questions(){
		return this.num_questions;
	}
	public int getScore(){
		return this.score;
	}
	public ArrayList<Vocab> get_mistake_list(){
		return this.mistake_list;
	}
}
