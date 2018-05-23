package daoImpl;

import java.io.File;
import java.util.ArrayList;

import dao.MovieDao;
import entity.Movie;
import util.ReadAndWrite;

public class MovieDaoImpl implements MovieDao{

	@Override
	public boolean findByMovieName(String name) {
		boolean is=false;
		File f=new File("src\\source\\movies.txt");
		ArrayList<Movie> array=new ReadAndWrite<Movie>().readObject(f);
		for(Movie m:array) {
			if(m.getName().equals(name)) {
				is=true;
				break;
			}
		}
		return is;
	}

}
