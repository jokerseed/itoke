package view;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Cinema;
import entity.Hall;
import entity.Movie;
import entity.Session;
import entity.Ticket;
import entity.User;
import util.ReadAndWrite;

public class MainView {
	Scanner scn=new Scanner(System.in);
	UserView uv=new UserView();
	AdminView av=new AdminView();
	public void mainView() {
		//初始化    往txt文件中线写入一个空的集合
		init();
		System.out.println("欢迎光临电影院管理系统");
		while(true) {
			System.out.println("1.user模式2.admin模式");
			int option=scn.nextInt();
			switch(option) {
			case 1:
				uv.userView();
				break;
			case 2:
				av.adminView();
				break;
			default:
				System.out.println("输入错误，重新输入");
				break;
			}
		}
	}
	public void init() {
		if(new ReadAndWrite<User>().readObject(new File("src\\source\\users.txt"))==null) {
			new ReadAndWrite<User>().writeObiect(new ArrayList<User>(), new File("src\\source\\users.txt"));
		}
		if(new ReadAndWrite<Movie>().readObject(new File("src\\source\\movies.txt"))==null) {
			new ReadAndWrite<Movie>().writeObiect(new ArrayList<Movie>(), new File("src\\source\\movies.txt"));
		}
		if(new ReadAndWrite<Cinema>().readObject(new File("src\\source\\cinemas.txt"))==null) {
			new ReadAndWrite<Cinema>().writeObiect(new ArrayList<Cinema>(), new File("src\\source\\cinemas.txt"));
		}
		if(new ReadAndWrite<Hall>().readObject(new File("src\\source\\halls.txt"))==null) {
			new ReadAndWrite<Hall>().writeObiect(new ArrayList<Hall>(), new File("src\\source\\halls.txt"));
		}
		if(new ReadAndWrite<Session>().readObject(new File("src\\source\\sessions.txt"))==null) {
			new ReadAndWrite<Session>().writeObiect(new ArrayList<Session>(), new File("src\\source\\sessions.txt"));
		}
		if(new ReadAndWrite<Ticket>().readObject(new File("src\\source\\tickets.txt"))==null) {
			new ReadAndWrite<Ticket>().writeObiect(new ArrayList<Ticket>(), new File("src\\source\\tickets.txt"));
		}
	}
}
