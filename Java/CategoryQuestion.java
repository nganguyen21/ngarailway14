package entity;

public class CategoryQuestion {
	int id;
	String name;

	public CategoryQuestion(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public CategoryQuestion() {
		super();
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

	@Override
	public String toString() {
		return "CategoryQuestion [id=" + id + ", name=" + name + "]";
	}

}