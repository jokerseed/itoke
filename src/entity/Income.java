package entity;

public class Income {
	private int cid;
	private double total;
	public Income(int cid, double total) {
		super();
		this.cid = cid;
		this.total = total;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Income [cid=" + cid + ", total=" + total + "]";
	}
	
}
