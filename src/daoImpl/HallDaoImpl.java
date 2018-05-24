package daoImpl;

import java.io.File;
import java.util.ArrayList;

import dao.HallDao;
import entity.Cinema;
import entity.Hall;
import util.ReadAndWrite;

public class HallDaoImpl implements HallDao{

	@Override
	public boolean findByHallName(String name, int cid) {
		boolean is=false;
		File f=new File("src\\source\\halls.txt");
		ArrayList<Hall> array=new ReadAndWrite<Hall>().readObject(f);
		for(Hall m:array) {
			if(m.getName().equals(name)&&m.getCid()==cid) {
				is=true;
				break;
			}
		}
		return is;
	}

}
