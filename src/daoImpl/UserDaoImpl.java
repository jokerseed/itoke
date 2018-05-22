package daoImpl;

import java.io.File;
import java.util.ArrayList;

import dao.UserDao;
import entity.User;
import util.ReadAndWrite;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean findByNameAndPasswd(String name,String passwd) {
		boolean is=false;
		ArrayList<User> array=new ReadAndWrite<User>().readObject(new File("src\\source\\users.txt"));
		for(User u:array) {
			if(u.getName().equals(name)&&u.getPsswd().equals(passwd)) {
				is=true;
				break;
			}
		}
		return is;
	}

	@Override
	//ע���ʱ���ж��û����ظ�
	public boolean isLoopName(String name) {
		boolean is=false;
		ArrayList<User> array=new ReadAndWrite<User>().readObject(new File("src\\source\\users.txt"));
		for(User u:array) {
			if(u.getName().equals(name)) {
				is=true;
				break;
			}
		}
		return is;
	}

	@Override
	//����ע���user����,д��txt
	public void storeUser(String name, String passwd) {
		ArrayList<User> array=new ReadAndWrite<User>().readObject(new File("src\\source\\users.txt"));
		array.add(new User(name,passwd,0,0));
		new ReadAndWrite<User>().writeObiect(array, new File("src\\source\\users.txt"));
	}

}
