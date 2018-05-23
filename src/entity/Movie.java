package entity;

import java.io.Serializable;

public class Movie implements Serializable{
	private int id;
	private String name;
	private String detail;
	private int duration;//∑÷÷”
	private String type;
	public Movie(String name, String detail, int duration, String type) {
		super();
		this.name = name;
		this.detail = detail;
		this.duration = duration;
		this.type = type;
	}
	
	public Movie(String name) {
		super();
		this.name = name;
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", detail=" + detail + ", duration=" + duration + ", type=" + type
				+ "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
