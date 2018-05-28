package daoImpl;

import java.io.File;
import java.util.ArrayList;

import dao.SessionDao;
import entity.Cinema;
import entity.Hall;
import entity.Movie;
import entity.Session;
import util.ReadAndWrite;

public class SessionDaoImpl implements SessionDao{
	public boolean findMovieId(int movie_id) {
		boolean is=false;
		File f= new File("src\\source\\movies.txt");
		ArrayList<Movie> array=new ReadAndWrite<Movie>().readObject(f);
		for(Movie m:array) {
			if(m.getId()==movie_id) {
				is=true;
				break;
			}
		}
		return is;
	}

	@Override
	public boolean findCinemaId(int cinema_id) {
		boolean is=false;
		File f= new File("src\\source\\cinemas.txt");
		ArrayList<Cinema> array=new ReadAndWrite<Cinema>().readObject(f);
		for(Cinema m:array) {
			if(m.getId()==cinema_id) {
				is=true;
				break;
			}
		}
		return is;
	}

	@Override
	public boolean isGetHall(int cinema_id,int hall_id, String startTime) {
		boolean is=false;
		int temp=0;
		File f= new File("src\\source\\halls.txt");
		ArrayList<Hall> array=new ReadAndWrite<Hall>().readObject(f);
		for(Hall h:array) {
			if(h.getId()==hall_id&&h.getCid()==cinema_id) {
				temp++;
			}
		}
		//System.out.println(temp);
		File f1= new File("src\\source\\sessions.txt");
		ArrayList<Session> array1=new ReadAndWrite<Session>().readObject(f1);
		if(array1.size()==0) {
			temp++;
		}else {
			for(Session s:array1) {
				if(s.getHid()==hall_id&&s.getCid()==cinema_id) {
					String[] str1=startTime.split(",");
					String[] str2=s.getTime().split(",");
					//ÓÐÎÊÌâ
					int dur=getMovieTime(s.getCid());
					int x=dur/60;
					int y=dur%60;
					str2[3]=String.valueOf(Integer.parseInt(str2[3])+x);
					str2[4]=String.valueOf(Integer.parseInt(str2[4])+y);
					if(Integer.parseInt(str2[4])>=60) {
						
					}
					for(int i=0;i<6;i++) {
						if(Integer.parseInt(str1[i])>Integer.parseInt(str2[i])) {
							temp++;
							break;
						}
					}
				}else {
					temp++;
				}
			}
		}
		//System.out.println(temp);
		if(temp==2) {
			is=true;
		}
		return is;
	}

	@Override
	public int getMovieTime(int movie_id) {
		File f= new File("src\\source\\movies.txt");
		ArrayList<Movie> array=new ReadAndWrite<Movie>().readObject(f);
		int temp=0;
		for(Movie m:array) {
			if(movie_id==m.getId()) {
				temp=m.getDuration();
			}
		}
		return temp;
	}

	@Override
	public int getSeat(int hid,int cid) {
		File f= new File("src\\source\\halls.txt");
		ArrayList<Hall> array=new ReadAndWrite<Hall>().readObject(f);
		int temp=0;
		for(Hall h:array) {
			if(h.getId()==hid&&h.getCid()==cid) {
				temp=h.getCapacity();
			}
		}
		return temp;
	}
}
