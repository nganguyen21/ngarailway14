package entity;

import constant.PositionName;

public class Position {
	int id;
	PositionName name;

	public Position(int id, PositionName name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Position() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PositionName getName() {
		return name;
	}

	public void setName(PositionName name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + "]";
	}
}
