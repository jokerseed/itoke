package util;

import java.io.File;
import java.util.ArrayList;

import entity.Movie;
import entity.User;

public class MyUtil {
	//更新user的id
	public void refreshUserId() {
		File f=new File("src\\source\\users.txt");
		ArrayList<User> array=new ReadAndWrite<User>().readObject(f);
		for(User u:array) {
			u.setId(array.indexOf(u));
		}
		new ReadAndWrite<User>().writeObiect(array, f);
	}
	//更新movie的id
	public void refreshMovieId() {
		File f=new File("src\\source\\movies.txt");
		ArrayList<Movie> array=new ReadAndWrite<Movie>().readObject(f);
		for(Movie m:array) {
			m.setId(array.indexOf(m));
		}
		new ReadAndWrite<Movie>().writeObiect(array, f);
	}
}
