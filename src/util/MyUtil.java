package util;

import java.io.File;
import java.util.ArrayList;

import entity.Cinema;
import entity.Hall;
import entity.Movie;
import entity.Session;
import entity.Ticket;
import entity.User;

public class MyUtil {
	//更新user的id
	public void refreshUserId() {
		File f=new File("src\\source\\users.txt");
		ArrayList<User> array=new ReadAndWrite<User>().readObject(f);
		for(User u:array) {
			u.setId(array.indexOf(u));
		}
		new ReadAndWrite<User>().writeObiect(array, f);
	}
	//更新movie的id
	public void refreshMovieId() {
		File f=new File("src\\source\\movies.txt");
		ArrayList<Movie> array=new ReadAndWrite<Movie>().readObject(f);
		for(Movie m:array) {
			m.setId(array.indexOf(m));
		}
		new ReadAndWrite<Movie>().writeObiect(array, f);
	}
	//更新cinema的id
	public void refreshCinemaId() {
		File f=new File("src\\source\\cinemas.txt");
		ArrayList<Cinema> array=new ReadAndWrite<Cinema>().readObject(f);
		for(Cinema m:array) {
			m.setId(array.indexOf(m));
		}
		new ReadAndWrite<Cinema>().writeObiect(array, f);
	}
	//更新hall的cid
	public void refreshHallCid(String name) {
		File f=new File("src\\source\\cinemas.txt");
		File f1=new File("src\\source\\halls.txt");
		ArrayList<Cinema> array=new ReadAndWrite<Cinema>().readObject(f);
		ArrayList<Hall> array1=new ReadAndWrite<Hall>().readObject(f1);
		int index=array.indexOf(new Cinema(name));
		for(int i=index;i<array.size();i++) {
			for(Hall h:array1) {
				if(h.getCid()==array.get(i).getId()) {
					h.setCid(array.get(i).getId()-1);
				}
			}
		}
	}
	public void refreshHallId() {
		File f=new File("src\\source\\halls.txt");
		ArrayList<Hall> array=new ReadAndWrite<Hall>().readObject(f);
		for(Hall m:array) {
			m.setId(array.indexOf(m));
		}
		new ReadAndWrite<Hall>().writeObiect(array, f);
	}
	//返回上一层
	public boolean getBack() {
		boolean is=false;
		
		return is;
	}
	public void refreshSessionId() {
		File f=new File("src\\source\\sessions.txt");
		ArrayList<Session> array=new ReadAndWrite<Session>().readObject(f);
		for(Session m:array) {
			m.setId(array.indexOf(m));
		}
		new ReadAndWrite<Session>().writeObiect(array, f);
	}
	public void refreshTicketId() {
		File f=new File("src\\source\\tickets.txt");
		ArrayList<Ticket> array=new ReadAndWrite<Ticket>().readObject(f);
		for(Ticket m:array) {
			m.setId(array.indexOf(m));
		}
		new ReadAndWrite<Ticket>().writeObiect(array, f);
	}
}
