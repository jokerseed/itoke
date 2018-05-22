package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ReadAndWrite<T>{
	//–¥»Î
	public void writeObiect(ArrayList<T> array,File f) {
		ObjectOutputStream oos = null;
		try {
			oos=new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(array);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//∂¡»°
	public ArrayList<T> readObject(File f) {
		ObjectInputStream ois=null;
		ArrayList<T> array=null;
		try {
			ois=new ObjectInputStream(new FileInputStream(f));
			array=(ArrayList<T>)ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return array;
	}
}
