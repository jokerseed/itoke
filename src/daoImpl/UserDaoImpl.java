package daoImpl;

import java.io.File;
import java.util.ArrayList;

import dao.UserDao;
import entity.Movie;
import entity.Session;
import entity.Ticket;
import entity.User;
import util.MyUtil;
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
	//注册的时候判断用户名重复
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
	//存贮注册的user对象,写入txt
	public void storeUser(String name, String passwd) {
		ArrayList<User> array=new ReadAndWrite<User>().readObject(new File("src\\source\\users.txt"));
		array.add(new User(name,passwd,0,0,0));
		new ReadAndWrite<User>().writeObiect(array, new File("src\\source\\users.txt"));
	}

	@Override
	public void getUser(String name, String passwd,double num) {
		ArrayList<User> array=new ReadAndWrite<User>().readObject(new File("src\\source\\users.txt"));
		for(User u:array) {
			if(u.equals(new User(name,passwd))) {
				u.setBalance(u.getBalance()+num);
				u.setTotal(u.getTotal()+num);
				if(u.getTotal()>=100&&u.getTotal()<500) {
					u.setLevel(1);
				}else {
					u.setLevel(2);
				}
			}
		}
	}

	@Override
	public void viewMovie() {
		ArrayList<Movie> array=new ReadAndWrite<Movie>().readObject(new File("src\\source\\movies.txt"));
		for(Movie m:array) {
			System.out.println(m);
		}
	}

	public void viewSession(int mid) {
		ArrayList<Session> array=new ReadAndWrite<Session>().readObject(new File("src\\source\\sessions.txt"));
		for(Session m:array) {
			if(m.getMovie_id()==mid) {
				System.out.println(m);
			}
		}
	}

	public void viewSeat(int sid) {
		ArrayList<Session> array=new ReadAndWrite<Session>().readObject(new File("src\\source\\sessions.txt"));
		for(Session m:array) {
			if(m.getId()==sid) {
				String[] str=m.getStr();
				for(int i=0;i<str.length;i++) {
					if(i%5!=0) {
						System.out.print(str[i]+" ");
					}else {
						System.out.println();
						System.out.print(str[i]+" ");
					}
				}
			}
		}
	}

	public void updateSession(int seat, int sid) {
		ArrayList<Session> array=new ReadAndWrite<Session>().readObject(new File("src\\source\\sessions.txt"));
		for(Session m:array) {
			if(m.getId()==sid) {
				String[] str=m.getStr();
				str[seat]="-";
				m.setStr(str);
				m.setRemain(m.getRemain()-1);
			}
		}
		new ReadAndWrite<Session>().writeObiect(array, new File("src\\source\\sessions.txt"));
	}

	public int getUserId(String name, String passwd) {
		ArrayList<User> array=new ReadAndWrite<User>().readObject(new File("src\\source\\users.txt"));
		int id=0;
		for(User u:array) {
			if(new User(name,passwd).equals(u)) {
				id=u.getId();
			}
		}
		return id;
	}

	public double getRealPrice(int sid,String name, String passwd) {
		ArrayList<Session> array=new ReadAndWrite<Session>().readObject(new File("src\\source\\sessions.txt"));
		double realPrice=0;
		for(Session s:array) {
			if(s.getId()==sid) {
				double price=s.getPrice();
				int level=getUserLevel(name,passwd);
				switch(level) {
				case 0:
					realPrice=price;
					break;
				case 1:
					realPrice=price*0.8;
					break;
				case 2:
					realPrice=price*0.5;
					break;
				}
			}
		}
		return realPrice;
	}

	@Override
	public int getUserLevel(String name, String passwd) {
		ArrayList<User> array=new ReadAndWrite<User>().readObject(new File("src\\source\\users.txt"));
		int level=0;
		for(User u:array) {
			if(new User(name,passwd).equals(u)) {
				level=u.getLevel();
			}
		}
		return level;
	}

	public void carryTicket(int uid, int sid, int seat, double realPrice) {
		ArrayList<Ticket> array=new ReadAndWrite<Ticket>().readObject(new File("src\\source\\tickets.txt"));
		array.add(new Ticket(uid,sid,seat,realPrice));
		new ReadAndWrite<Ticket>().writeObiect(array, new File("src\\source\\tickets.txt"));
		new MyUtil().refreshTicketId();
	}

	public String getLatestWatchType(String name, String passwd) {
		ArrayList<Ticket> array=new ReadAndWrite<Ticket>().readObject(new File("src\\source\\tickets.txt"));
		int uid=getUserId(name,passwd);
		Ticket temp=null;
		for(Ticket t:array) {
			if(t.getUid()==uid) {
				temp=t;
			}
		}
		ArrayList<Session> array1=new ReadAndWrite<Session>().readObject(new File("src\\source\\sessions.txt"));
		int mid=0;
		for(Session s:array1) {
			if(s.getId()==temp.getSid()) {
				mid=s.getMovie_id();
			}
		}
		ArrayList<Movie> array2=new ReadAndWrite<Movie>().readObject(new File("src\\source\\movies.txt"));
		String type=null;
		for(Movie m:array2) {
			if(m.getId()==mid) {
				type=m.getType();
			}
		}
		return type;
	}

	public void viewMovie(String type) {
		ArrayList<Movie> array=new ReadAndWrite<Movie>().readObject(new File("src\\source\\movies.txt"));
		for(Movie m:array) {
			if(m.getType().equals(type)) {
				System.out.println(m);
			}
		}
	}

	public boolean isMoney(double realPrice,String name,String passwd) {
		boolean is=true;
		int uid=getUserId(name,passwd);
		ArrayList<User> array=new ReadAndWrite<User>().readObject(new File("src\\source\\users.txt"));
		for(User u:array) {
			if(u.getId()==uid) {
				if(u.getBalance()>=realPrice) {
					is=true;
				}
			}
		}
		return is;
	}

}
