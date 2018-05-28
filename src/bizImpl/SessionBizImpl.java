package bizImpl;


import java.io.File;
import java.util.ArrayList;

import biz.SessionBiz;
import daoImpl.SessionDaoImpl;
import entity.Session;
import util.MyUtil;
import util.ReadAndWrite;

public class SessionBizImpl implements SessionBiz{
	SessionDaoImpl sdi=new SessionDaoImpl();
	@Override
	public boolean addSession(int movie_id, int cinema_id, int hall_id, String startTime, double price) {
		boolean is=false;
		if(sdi.findMovieId(movie_id)&&sdi.findCinemaId(cinema_id)&&sdi.isGetHall(cinema_id, hall_id, startTime)) {
			File f=new File("src\\source\\sessions.txt");
			ArrayList<Session> array=new ReadAndWrite<Session>().readObject(f);
			array.add(new Session(hall_id,cinema_id,movie_id,startTime,price,sdi.getSeat(hall_id, cinema_id)));
			new ReadAndWrite<Session>().writeObiect(array, f);
			new MyUtil().refreshSessionId();
			is=true;
		}
		return is;
	}

}
