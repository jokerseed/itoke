package util;

import java.io.File;
import java.util.ArrayList;

public class add_dele_up_find<T> {
	public void add(T temp,File f) {
		ArrayList<T> array=new ReadAndWrite<T>().readObject(f);
		array.add(temp);
		new ReadAndWrite<T>().writeObiect(array, f);
	}
	public void dele(T temp,File f) {
		ArrayList<T> array=new ReadAndWrite<T>().readObject(f);
		array.remove(temp);
		new ReadAndWrite<T>().writeObiect(array, f);
	}
	public void update(T tempOrigin,T tempUpdate,File f) {
		ArrayList<T> array=new ReadAndWrite<T>().readObject(f);
		int index=array.indexOf(tempOrigin);
		array.set(index, tempUpdate);
		new ReadAndWrite<T>().writeObiect(array, f);
	}
	public void find(File f) {
		ArrayList<T> array=new ReadAndWrite<T>().readObject(f);
		for(T t:array) {
			System.out.println(t);
		}
	}
}
