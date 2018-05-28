package entity;

import java.io.Serializable;
import java.util.Date;

public class Session implements Serializable{
	private int id;
	private int hid;
	private int cid;
	private int movie_id;
	private String time;
	private double price;
	private int remain;
	private String[] str;
	public Session(int hid, int cid, int movie_id, String time, double price, int remain) {
		super();
		this.hid = hid;
		this.cid = cid;
		this.movie_id = movie_id;
		this.time = time;
		this.price = price;
		this.remain = remain;
		this.str=new String[remain];
		for(int i=0;i<remain;i++) {
			str[i]="+";
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getRemain() {
		return remain;
	}
	public void setRemain(int remain) {
		this.remain = remain;
	}
	@Override
	public String toString() {
		return "Session [id=" + id + ", hid=" + hid + ", cid=" + cid + ", movie_id=" + movie_id + ", time=" + time
				+ ", price=" + price + ", remain=" + remain + "]";
	}
	public String[] getStr() {
		return str;
	}
	public void setStr(String[] str) {
		this.str = str;
	}
	
}
