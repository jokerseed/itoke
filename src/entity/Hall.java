package entity;

import java.io.Serializable;

public class Hall implements Serializable{
	private int id;
	private String name;
	private int cid;
	private int capacity;
	public Hall(String name, int cid) {
		super();
		this.name = name;
		this.cid = cid;
	}
	public Hall(String name, int cid, int capacity) {
		super();
		this.name = name;
		this.cid = cid;
		this.capacity = capacity;
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
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	@Override
	public String toString() {
		return "Hall [id=" + id + ", name=" + name + ", cid=" + cid + ", capacity=" + capacity + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hall other = (Hall) obj;
		if (cid != other.cid)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
