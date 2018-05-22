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

}
