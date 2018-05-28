package entity;

import java.io.Serializable;

public class Ticket implements Serializable{
	private int id;
	private int uid;
	private int sid;
	private int seat;
	private double realPrice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public double getRealPrice() {
		return realPrice;
	}
	public void setRealPrice(double realPrice) {
		this.realPrice = realPrice;
	}
	public Ticket(int uid, int sid, int seat, double realPrice) {
		super();
		this.uid = uid;
		this.sid = sid;
		this.seat = seat;
		this.realPrice = realPrice;
	}
	
}
