package bizImpl;

import java.io.File;

import biz.HallBiz;
import daoImpl.HallDaoImpl;
import entity.Hall;
import util.MyUtil;
import util.add_dele_up_find;

public class HallBizImpl implements HallBiz{
	HallDaoImpl hdi=new HallDaoImpl();
	@Override
	public boolean addHall(Hall hall) {
		boolean is=false;
		//判断重复添加(halls.txt中没有找到重复，还有判断cid是否存在)
		if(!hdi.findByHallNameAndCid(hall.getName(),hall.getCid())&&hdi.findCidFromCinema(hall.getCid())) {
			//添加
			File f=new File("src\\source\\halls.txt");
			new add_dele_up_find<Hall>().add(hall, f);
			new MyUtil().refreshHallId(); 
			is=true;
		}
		return is;
	}

	@Override
	public boolean deleHall(String name, int cid) {
		boolean is=false;
		if(hdi.findByHallNameAndCid(name,cid)) {
			File f=new File("src\\source\\halls.txt");
			new add_dele_up_find<Hall>().dele(new Hall(name,cid), f);
			new MyUtil().refreshHallId(); 
			is=true;
		}
		return is;
	}

	@Override
	public boolean update(Hall hallOrigin, Hall HallUpdate) {
		boolean is=false;
		if(hdi.findByHallNameAndCid(hallOrigin.getName(),hallOrigin.getCid())) {
			//添加
			File f=new File("src\\source\\halls.txt");
			new add_dele_up_find<Hall>().update(hallOrigin, HallUpdate, f);
			new MyUtil().refreshHallId();
			is=true;
		}
		return is;
	}

	@Override
	public void find() {
		File f=new File("src\\source\\halls.txt");
		new add_dele_up_find<Hall>().find(f);
	}
	
}
