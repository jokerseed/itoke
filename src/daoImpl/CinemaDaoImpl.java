package daoImpl;

import java.io.File;
import java.util.ArrayList;

import dao.CinemaDao;
import entity.Cinema;
import entity.Movie;
import util.ReadAndWrite;

public class CinemaDaoImpl implements CinemaDao{

	@Override
	public boolean findByCinemaName(String name) {
		boolean is=false;
		File f=new File("src\\source\\cinemas.txt");
		ArrayList<Cinema> array=new ReadAndWrite<Cinema>().readObject(f);
		for(Cinema m:array) {
			if(m.getName().equals(name)) {
				is=true;
				break;
			}
		}
		return is;
	}

}
