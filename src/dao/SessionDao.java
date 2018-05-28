package dao;


public interface SessionDao {
	public boolean findMovieId(int movie_id);
	public boolean findCinemaId(int cinema_id);
	public boolean isGetHall(int cinema_id,int hall_id,String startTime);
	public int getMovieTime(int movie_id);
	public int getSeat(int hid,int cid);
}
