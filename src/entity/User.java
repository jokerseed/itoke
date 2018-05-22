package entity;

import java.io.Serializable;

public class User implements Serializable{
	private int id;
	private String name;
	private String psswd;
	private int level;//vip等级
	private double balance;//用户账户余额
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
	public String getPsswd() {
		return psswd;
	}
	public void setPsswd(String psswd) {
		this.psswd = psswd;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public User(String name, String psswd, int level, double balance) {
		super();
		this.name = name;
		this.psswd = psswd;
		this.level = level;
		this.balance = balance;
	}
	
}
