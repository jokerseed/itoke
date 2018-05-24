package dao;

public interface HallDao {
	public boolean findByHallNameAndCid(String name,int cid);
	public boolean findCidFromCinema(int cid);
}
