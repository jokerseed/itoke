package biz;


public interface UserBiz {
	public boolean login(String name,String passed);//µÇÂ½
	public boolean regist(String name,String passwd);//×¢²á
	public boolean charge(String name,String passwd,double num);
	public void getAllMovie();
	public void getAllSession(int mid);
	public void getAllSeat(int sid);
	public void refreshSeat(int seat,int sid);
	public boolean cal(int sid,String name, String passwd,int seat);
	public int getUid(String name,String passwd);
	public void findYouLike(String name, String passwd);
}
