package entity;

import constant.TypeName;

public class TypeQuestion {
	int id;
	TypeName name;

	public TypeQuestion(int id, TypeName name) {
		super();
		this.id = id;
		this.name = name;
	}

	public TypeQuestion() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TypeName getName() {
		return name;
	}

	public void setName(TypeName name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TypeQuestion [id=" + id + ", name=" + name + "]";
	}

}
