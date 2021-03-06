package view;

import java.util.Scanner;

import bizImpl.CinemaBizImpl;
import bizImpl.HallBizImpl;
import bizImpl.MovieBizImpl;
import bizImpl.SessionBizImpl;
import bizImpl.TicketBizImpl;
import entity.Cinema;
import entity.Hall;
import entity.Movie;

public class AdminView {
	Scanner scn=new Scanner(System.in);
	MovieBizImpl mbi=new MovieBizImpl();
	CinemaBizImpl cbi=new CinemaBizImpl();
	HallBizImpl hbi=new HallBizImpl();
	SessionBizImpl sbi=new SessionBizImpl();
	TicketBizImpl tbi=new TicketBizImpl();
	public void adminView() {
		while(true) {
			System.out.println("0.返回上一层(按任意键继续)");
			int option =scn.nextInt();
			if(option==0) {
				break;
			}
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
			System.out.println("0.返回上一层1.管理电影2.管理影院3.管理场厅4.管理场次5.查看效益");
			int option=scn.nextInt();
			if(option==0) {
				break;
			}
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
			case 4:
				SessionManager();
				break;
			case 5:
				fingIncome();
				break;
			default:
				System.out.println("输入错误，重新输入");
				break;
			}
		}
	}
	private void fingIncome() {
		while(true) {
			System.out.println("0.返回上一层1.电影票房2.影院盈利");
			int option=scn.nextInt();
			if(option==0) {
				break;
			}
			switch(option) {
			case 1:
				movieIncome();
				break;
			case 2:
				cinemaIncome();
				break;
			default:
				System.out.println("输入错误，重新输入");
				break;
			}
		}
	}
	private void cinemaIncome() {
		tbi.viewCinemaIncome();
	}
	private void movieIncome() {
		tbi.viewMovieIncome();
	}
	private void SessionManager() {
		while(true) {
			System.out.println("0.返回上一层1.增加场次");
			int option=scn.nextInt();
			if(option==0) {
				break;
			}
			switch(option) {
			case 1:
				addSession();
				break;
			default:
				System.out.println("输入错误，重新输入");
				break;
			}
		}
	}
	private void addSession() {
		System.out.println("输入电影");
		int movie_id=scn.nextInt();
		System.out.println("输入电影院");
		int cinema_id=scn.nextInt();
		System.out.println("输入场厅");
		int hall_id=scn.nextInt();
		System.out.println("输入播放时间(如2018,5,12,19,25,00分别是年月日时分秒)");
		String startTime=scn.next();
		
		//System.out.println(startTime);
		
		System.out.println("输入票价");
		double price=scn.nextDouble();
		if(sbi.addSession(movie_id, cinema_id, hall_id, startTime, price)) {
			System.out.println("添加场次成功");
		}else {
			System.out.println("添加场次失败");
		}
	}
	private void hallManager() {
		while(true) {
			System.out.println("0.返回上一层1.增加场厅2.删除场厅3.修改场厅4.查找场厅");
			int option=scn.nextInt();
			if(option==0) {
				break;
			}
			switch(option) {
			case 1:
				addHall();
				break;
			case 2:
				deleHall();
				break;
			case 3:
				updateHall();
				break;
			case 4:
				findHall();
				break;
			default:
				System.out.println("输入错误，重新输入");
				break;
			}
		}
	}
	private void updateHall() {
		System.out.println("需要修改的场厅名字");
		String name1=scn.next();
		System.out.println("需要修改的场厅所属影院");
		int cid1=scn.nextInt();
		System.out.println("场厅名字");
		String name=scn.next();
		System.out.println("场厅所属影院");
		int cid=scn.nextInt();
		System.out.println("场厅容量");
		int capacity=scn.nextInt();
		if(hbi.update(new Hall(name1,cid1), new Hall(name,cid,capacity))) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
	}
	private void findHall() {
		hbi.find();
	}
	private void deleHall() {
		System.out.println("场厅名字");
		String name=scn.next();
		System.out.println("场厅所属影院");
		int cid=scn.nextInt();
		if(hbi.deleHall(name, cid)) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
	}
	private void addHall() {
		System.out.println("场厅名字");
		String name=scn.next();
		System.out.println("场厅所属影院");
		int cid=scn.nextInt();
		System.out.println("场厅容量");
		int capacity=scn.nextInt();
		if(hbi.addHall(new Hall(name,cid,capacity))) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
	}
	public void cinemaManager() {
		while(true) {
			System.out.println("0.返回上一层1.增加影院2.删除影院3.修改影院4.查找影院");
			int option=scn.nextInt();
			if(option==0) {
				break;
			}
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
			System.out.println("0.返回上一层1.增加电影2.删除电影3.修改电影4.查找电影");
			int option=scn.nextInt();
			if(option==0) {
				break;
			}
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
