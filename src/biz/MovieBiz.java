package biz;

import entity.Movie;

public interface MovieBiz {
	public boolean addMovie(Movie movie);
	public boolean deleMovie(String name);
	public boolean update(Movie movieOrigin,Movie movieUpdate);
	public void find();
}
