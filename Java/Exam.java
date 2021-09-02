package entity;
import java.util.Arrays;
import java.util.Date;

public class Exam {
	int id;
	String code;
	String title;
	CategoryQuestion[] categorys;
	int duration;
	Account creator;
	Date createDate;
	Question[] questions;

	public Exam(int id, String code, String title, CategoryQuestion[] categorys, int duration, Account creator,
			Date createDate, Question[] questions) {
		super();
		this.id = id;
		this.code = code;
		this.title = title;
		this.categorys = categorys;
		this.duration = duration;
		this.creator = creator;
		this.createDate = createDate;
		this.questions = questions;
	}

	public Exam() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public CategoryQuestion[] getCategorys() {
		return categorys;
	}

	public void setCategorys(CategoryQuestion[] categorys) {
		this.categorys = categorys;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Account getCreator() {
		return creator;
	}

	public void setCreator(Account creator) {
		this.creator = creator;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Question[] getQuestions() {
		return questions;
	}

	public void setQuestions(Question[] questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Exam [id=" + id + ", code=" + code + ", title=" + title + ", categorys=" + Arrays.toString(categorys)
				+ ", duration=" + duration + ", creator=" + creator + ", createDate=" + createDate + ", questions="
				+ Arrays.toString(questions) + "]";
	}

}