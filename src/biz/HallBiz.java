package biz;

import entity.Cinema;
import entity.Hall;

public interface HallBiz {
	public boolean addHall(Hall hall);
	public boolean deleHall(String name,int cid);
	public boolean update(Hall hallOrigin,Hall HallUpdate);
	public void find();
}
