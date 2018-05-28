package entity;

public class Income1 {
	private int mid;
	private double total;
	public Income1(int mid, int total) {
		super();
		this.mid = mid;
		this.total = total;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Income1 [mid=" + mid + ", total=" + total + "]";
	}
	
}
