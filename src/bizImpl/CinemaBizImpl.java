package bizImpl;

import java.io.File;

import biz.CinemaBiz;
import daoImpl.CinemaDaoImpl;
import entity.Cinema;
import entity.Movie;
import util.MyUtil;
import util.add_dele_up_find;

public class CinemaBizImpl implements CinemaBiz{
	CinemaDaoImpl cdi=new CinemaDaoImpl();
	@Override
	public boolean addCinema(Cinema cinema) {
		boolean is=false;
		//判断重复添加
		if(!cdi.findByCinemaName(cinema.getName())) {
			//添加
			File f=new File("src\\source\\cinemas.txt");
			new add_dele_up_find<Cinema>().add(cinema, f);
			new MyUtil().refreshCinemaId();
			is=true;
		}
		return is;
	}

	@Override
	public boolean deleCinema(String name) {
		boolean is=false;
		if(cdi.findByCinemaName(name)) {
			File f=new File("src\\source\\cinemas.txt");
			new add_dele_up_find<Cinema>().dele(new Cinema(name), f);
			new MyUtil().refreshCinemaId();
			is=true;
		}
		return is;
	}

	@Override
	public boolean update(Cinema cinemaOrigin, Cinema cinemaUpdate) {
		boolean is=false;
		if(cdi.findByCinemaName(cinemaOrigin.getName())) {
			//添加
			File f=new File("src\\source\\cinemas.txt");
			new add_dele_up_find<Cinema>().update(cinemaOrigin, cinemaUpdate, f);
			new MyUtil().refreshCinemaId();
			is=true;
		}
		return is;
	}

	@Override
	public void find() {
		File f=new File("src\\source\\cinemas.txt");
		new add_dele_up_find<Cinema>().find(f);
	}

}
