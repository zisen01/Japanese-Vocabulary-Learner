//package vocab;

public class Vocab{
	private String japanese;
	private String definition;

	Vocab(String jap, String def){
		this.japanese = jap;
		this.definition = def;
	}

	public String getJapanese(){
		return this.japanese;
	}

	public String getDefinition(){
		return this.definition;
	}
}
