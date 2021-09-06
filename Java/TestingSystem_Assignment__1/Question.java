package entity;
import java.util.Date;

public class Question {
	int id;
	String content;
	CategoryQuestion category;
	TypeQuestion question;
	Account creator;
	Date createDate;

	public Question(int id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	public Question() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", content=" + content + "]";
	}

}
