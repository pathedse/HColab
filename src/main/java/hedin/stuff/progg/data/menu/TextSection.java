package hedin.stuff.progg.data.menu;

public class TextSection extends MenuSection {
	
	private String header;
	private String text;
	
	public TextSection(String header, String text){
		this.header = header;
		this.text = text;
	}

	public String getHeader() {
		return header;
	}

	public String getText() {
		return text;
	}
}
