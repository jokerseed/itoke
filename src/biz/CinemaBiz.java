package biz;

import entity.Cinema;

public interface CinemaBiz {
	public boolean addCinema(Cinema cinema);
	public boolean deleCinema(String name);
	public boolean update(Cinema cinemaOrigin,Cinema cinemaUpdate);
	public void find();
}
