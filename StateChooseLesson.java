import java.lang.Object;
import java.io.File;
import java.util.*;

public class StateChooseLesson{
	private Scanner reader;
	StateChooseLesson(Scanner s){
		this.reader = s;
	}
	public String chooseLesson(){
		//https://stackoverflow.com/questions/21059085/how-can-i-create-a-file-in-the-current-users-home-directory-using-java
		String path = System.getProperty("user.home") + File.separator + "Jvocab_learner"+File.separator+"vocab_list";
		File customDir = new File(path);
		if (customDir.exists()) {
			;
		}
		else if (customDir.mkdirs()) {
			System.out.println(customDir + " was created");
			System.out.println("please download vocab_list file to this directory or create vocab_list files in this directory");
		} else {
    			System.out.println(customDir + " was not created");
			System.out.println("please report this error to zisenzhou@gmail.com or zisen@ualberta.ca");
		}
		//System.out.println(customDir);
		File[] listOfFiles = customDir.listFiles();
		//System.out.println(listOfFiles);
		ArrayList<String> listOfLessons = new ArrayList<String>();
		for (int i = 0; i < listOfFiles.length; i++){
			listOfLessons.add(listOfFiles[i].getName());
		}
		Collections.sort(listOfLessons);
		// Printing options
		System.out.println("Choose a lesson");
		for (int i = 0; i < listOfLessons.size(); i++){
			if ((i+1)%5==0){
				System.out.println(listOfLessons.get(i) + " ");
			}else{
			System.out.print(listOfLessons.get(i) + " ");
			}
		}
		System.out.println();
		//Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a lesson: ");
		while (true) {
			String n = this.reader.next();
			String lessonPath = path+File.separator+n;
			// File selected = new File("/Users/zisen/selfmadeApp/vocab_learner/vocab_lists/"+n);
			File selected = new File(lessonPath);
			if (selected.isFile()){
				return lessonPath;
			}else{
				System.out.println("Not a file!");
				continue;
			}
		}
	}
	public int chooseMode(){
		System.out.println();
		System.out.println("Please choose a mode:");
		System.out.println("0) jap->eng");
		System.out.println("1) eng->jap");
		while (true){
			try{
				int m = this.reader.nextInt();
				if (m>=0 && m<2){
					return m;
				}else{
					System.out.println("Please enter a legit number!");
					continue;
				}

			}catch(Exception e){
				String badAns = reader.next();
				System.out.println("Please enter a number!");
				continue;
			}

		}
	}
}
