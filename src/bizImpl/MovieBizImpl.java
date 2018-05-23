package bizImpl;

import java.io.File;

import biz.MovieBiz;
import daoImpl.MovieDaoImpl;
import entity.Movie;
import util.MyUtil;
import util.add_dele_up_find;

public class MovieBizImpl implements MovieBiz{
	MovieDaoImpl mdi=new MovieDaoImpl();
	@Override
	public boolean addMovie(Movie movie) {
		boolean is=false;
		//判断重复添加
		if(!mdi.findByMovieName(movie.getName())) {
			//添加
			File f=new File("src\\source\\movies.txt");
			new add_dele_up_find<Movie>().add(movie, f);
			new MyUtil().refreshMovieId();
			is=true;
		}
		return is;
	}
	@Override
	public boolean deleMovie(String name) {
		boolean is=false;
		if(mdi.findByMovieName(name)) {
			File f=new File("src\\source\\movies.txt");
			new add_dele_up_find<Movie>().dele(new Movie(name), f);
			new MyUtil().refreshMovieId();
			is=true;
		}
		return is;
	}
	@Override
	public boolean update(Movie movieOrigin,Movie movieUpdate) {
		boolean is=false;
		if(mdi.findByMovieName(movieOrigin.getName())) {
			//添加
			File f=new File("src\\source\\movies.txt");
			new add_dele_up_find<Movie>().update(movieOrigin, movieUpdate, f);
			new MyUtil().refreshMovieId();
			is=true;
		}
		return is;
	}
	@Override
	public void find() {
		File f=new File("src\\source\\movies.txt");
		new add_dele_up_find<Movie>().find(f);
	}

}
