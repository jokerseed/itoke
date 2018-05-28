package bizImpl;


import biz.TicketBiz;
import daoImpl.TicketDaoImpl;

public class TicketBizImpl implements TicketBiz{
	TicketDaoImpl tdi=new TicketDaoImpl();
	public void viewCinemaIncome() {
		tdi.cinemaIncome();
	}
	public void viewMovieIncome() {
		tdi.movieIncome();
	}

}
