package view;

import java.util.Scanner;

import bizImpl.CinemaBizImpl;
import bizImpl.MovieBizImpl;
import entity.Cinema;
import entity.Movie;

public class AdminView {
	Scanner scn=new Scanner(System.in);
	MovieBizImpl mbi=new MovieBizImpl();
	CinemaBizImpl cbi=new CinemaBizImpl();
	public void adminView() {
		while(true) {
			adminLogin();
		}
	}
	public void adminLogin() {
		System.out.println("输入管理员用户名");
		String adminName=scn.next();
		System.out.println("输入管理员密码");
		String adminPasswd=scn.next();
		if(adminName.equals("admin")&&adminPasswd.equals("joker")) {
			System.out.println("登陆成功");
			adminOperation();
		}else {
			System.out.println("登陆失败");
		}
	}
	
	//管理员操作选择
	public void adminOperation() {
		while(true) {
			System.out.println("1.管理电影2.管理影院3.管理场厅");
			int option=scn.nextInt();
			switch(option) {
			case 1:
				movieManager();
				break;
			case 2:
				cinemaManager();
				break;
			case 3:
				hallManager();
				break;
			default:
				System.out.println("输入错误，重新输入");
				break;
			}
		}
	}
	private void hallManager() {
		while(true) {
			System.out.println("1.增加场厅2.删除场厅3.修改场厅4.查找场厅");
			int option=scn.nextInt();
			switch(option) {
			case 1:
				//addHall();
				break;
			case 2:
				//deleHall();
				break;
			case 3:
				//updateHall();
				break;
			case 4:
				//findHall();
				break;
			default:
				System.out.println("输入错误，重新输入");
				break;
			}
		}
	}
	public void cinemaManager() {
		while(true) {
			System.out.println("1.增加影院2.删除影院3.修改影院4.查找影院");
			int option=scn.nextInt();
			switch(option) {
			case 1:
				addCinema();
				break;
			case 2:
				deleCinema();
				break;
			case 3:
				updateCinema();
				break;
			case 4:
				findCinema();
				break;
			default:
				System.out.println("输入错误，重新输入");
				break;
			}
		}
	}
	private void findCinema() {
		cbi.find();
	}
	private void updateCinema() {
		System.out.println("需要修改的影院名字");
		String name1=scn.next();
		System.out.println("修改影院名字");
		String name=scn.next();
		System.out.println("修改影院地址");
		String address=scn.next();
		if(cbi.update(new Cinema(name1), new Cinema(name,address))) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
	}
	private void deleCinema() {
		System.out.println("影院名字");
		String name=scn.next();
		if(cbi.deleCinema(name)) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
	}
	private void addCinema() {
		System.out.println("影院名字");
		String name=scn.next();
		System.out.println("影院地址");
		String address=scn.next();
		if(cbi.addCinema(new Cinema(name,address))) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
	}
	public void movieManager() {
		while(true) {
			System.out.println("1.增加电影2.删除电影3.修改电影4.查找电影");
			int option=scn.nextInt();
			switch(option) {
			case 1:
				addMovie();
				break;
			case 2:
				deleMovie();
				break;
			case 3:
				updateMovie();
				break;
			case 4:
				findMovie();
				break;
			default:
				System.out.println("输入错误，重新输入");
				break;
			}
		}
	}
	public void addMovie() {
		System.out.println("电影名字");
		String name=scn.next();
		System.out.println("电影详情");
		String detail=scn.next();
		System.out.println("电影时长");
		int duration=scn.nextInt();
		System.out.println("电影类型");
		String type=scn.next();
		if(mbi.addMovie(new Movie(name,detail,duration,type))) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
	}
	public void deleMovie() {
		System.out.println("电影名字");
		String name=scn.next();
		if(mbi.deleMovie(name)) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
	}
	public void updateMovie() {
		System.out.println("需要修改的电影名字");
		String name1=scn.next();
		System.out.println("修改电影名字");
		String name=scn.next();
		System.out.println("修改电影详情");
		String detail=scn.next();
		System.out.println("修改电影时长");
		int duration=scn.nextInt();
		System.out.println("修改电影类型");
		String type=scn.next();
		if(mbi.update(new Movie(name1), new Movie(name,detail,duration,type))) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
	}
	public void findMovie() {
		mbi.find();
	}
}
