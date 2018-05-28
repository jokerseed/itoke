package bizImpl;


import biz.UserBiz;
import daoImpl.UserDaoImpl;

public class UserBizImpl implements UserBiz{
	UserDaoImpl udi=new UserDaoImpl();

	@Override
	public boolean login(String name,String passwd) {
		boolean is=udi.findByNameAndPasswd(name, passwd);
		return is;
	}

	@Override
	public boolean regist(String name,String passwd) {
		boolean is=false;
		if(!udi.isLoopName(name)) {
			is=true;
			udi.storeUser(name, passwd);
		}
		return is;
	}

	@Override
	public boolean charge(String name, String passwd,double num) {
		boolean is=false;
		udi.getUser(name, passwd, num);
		is=true;
		return is;
	}

	@Override
	public void getAllMovie() {
		udi.viewMovie();
	}

	@Override
	public void getAllSession(int mid) {
		udi.viewSession(mid);
	}

	@Override
	public void getAllSeat(int sid) {
		udi.viewSeat(sid);
	}

	public void refreshSeat(int seat,int sid) {
		udi.updateSession(seat,sid);
	}

	public boolean cal(int sid,String name, String passwd,int seat) {
		boolean is=false;
		double realPrice=udi.getRealPrice(sid,name,passwd);
		if(udi.isMoney(realPrice,name,passwd)) {
			udi.carryTicket(getUid(name,passwd),sid,seat,realPrice);
			is=true;
		}
		return is;
	}

	@Override
	public int getUid(String name, String passwd) {
		return udi.getUserId( name,  passwd);
	}

	public void findYouLike(String name, String passwd) {
		String type=udi.getLatestWatchType(name,passwd);
		udi.viewMovie(type);
	}

	

}
