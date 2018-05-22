package dao;

public interface UserDao {
	public boolean findByNameAndPasswd(String name,String passwd);
	public boolean isLoopName(String name);
	public void storeUser(String name,String passwd);
}
