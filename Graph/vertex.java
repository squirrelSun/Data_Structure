package Graph;

//∂•µ„¿‡
public class vertex {

	private String value;
	public boolean visited; 

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public vertex(String value) {
		super();
		this.value = value;
	}

	public String toString() {
		return value;
	}
	
	
	
}
