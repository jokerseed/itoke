package daoImpl;


import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;

import dao.TicketDao;
import entity.Cinema;
import entity.Income;
import entity.Income1;
import entity.Movie;
import entity.Session;
import entity.Ticket;
import util.ReadAndWrite;

public class TicketDaoImpl implements TicketDao{

	@Override
	public void cinemaIncome() {
		ArrayList<Income> array=new ArrayList<>();
		ArrayList<Cinema> arrayCinema=new ReadAndWrite<Cinema>().readObject(new File("src\\source\\cinemas.txt"));
		for(Cinema a:arrayCinema) {
			array.add(new Income(a.getId(),0));
		}
		ArrayList<Ticket> arrayTicket=new ReadAndWrite<Ticket>().readObject(new File("src\\source\\tickets.txt"));
		ArrayList<Session> arraySession=new ReadAndWrite<Session>().readObject(new File("src\\source\\sessions.txt"));
		for(Ticket t:arrayTicket) {
			double realPrice=t.getRealPrice();
			int sid=t.getSid();
			int cid=0;
			for(Session s:arraySession) {
				if(s.getId()==sid) {
					cid=s.getCid();
					break;
				}
			}
			for(Income a:array) {
				if(a.getCid()==cid) {
					a.setTotal(a.getTotal()+realPrice);
				}
			}
		}
		array.sort(new Comparator<Income>() {

			@Override
			public int compare(Income s1, Income s2) {
				// TODO Auto-generated method stub
				double temp=s2.getTotal()-s1.getTotal();
				if(temp>0) {
					return 1;
				}else if(temp==0) {
					return 0;
				}else {
					return -1;
				}
			}
			
		});
		for(Income a:array) {
			System.out.println(a);
		}
	}

	public void movieIncome() {
		ArrayList<Income1> array=new ArrayList<>();
		ArrayList<Movie> arrayMovie=new ReadAndWrite<Movie>().readObject(new File("src\\source\\movies.txt"));
		for(Movie a:arrayMovie) {
			array.add(new Income1(a.getId(),0));
		}
		ArrayList<Ticket> arrayTicket=new ReadAndWrite<Ticket>().readObject(new File("src\\source\\tickets.txt"));
		ArrayList<Session> arraySession=new ReadAndWrite<Session>().readObject(new File("src\\source\\sessions.txt"));
		for(Ticket t:arrayTicket) {
			double realPrice=t.getRealPrice();
			int sid=t.getSid();
			int mid=0;
			for(Session s:arraySession) {
				if(s.getId()==sid) {
					mid=s.getMovie_id();
					break;
				}
			}
			for(Income1 a:array) {
				if(a.getMid()==mid) {
					a.setTotal(a.getTotal()+realPrice);
				}
			}
		}
		array.sort(new Comparator<Income1>() {

			@Override
			public int compare(Income1 s1, Income1 s2) {
				// TODO Auto-generated method stub
				double temp=s2.getTotal()-s1.getTotal();
				if(temp>0) {
					return 1;
				}else if(temp==0) {
					return 0;
				}else {
					return -1;
				}
			}
			
		});
		for(Income1 a:array) {
			System.out.println(a);
		}
	}

	
}
