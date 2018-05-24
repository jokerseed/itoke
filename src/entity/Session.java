package entity;

import java.io.Serializable;
import java.util.Date;

public class Session implements Serializable{
	private int id;
	private int hid;
	private int cid;
	private int movie_id;
	private Date time;
	private double price;
	private int remain;
}
