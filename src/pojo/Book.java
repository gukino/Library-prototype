package pojo;

public class Book {
	private int id;
	private String name;
	private String type;
	private String description;
	private String state;

	public Book(int id, String name, String type, String description, String state) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.description = description;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
