package dao;


public interface UserDao {
	public boolean findByNameAndPasswd(String name,String passwd);
	public boolean isLoopName(String name);
	public void storeUser(String name,String passwd);
	public void getUser(String name, String passwd,double num);
	public void viewMovie();
	public void viewSeat(int sid);
	public void updateSession(int seat, int sid);
	public int getUserId(String name, String passwd);
	public int getUserLevel(String name, String passwd);
	public double getRealPrice(int sid,String name, String passwd);
	public void carryTicket(int uid, int sid, int seat, double realPrice);
	public boolean isMoney(double realPrice,String name,String passwd);
}
