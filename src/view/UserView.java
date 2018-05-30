package view;

import java.util.Scanner;

import bizImpl.UserBizImpl;
import util.MyUtil;

public class UserView {
	Scanner scn=new Scanner(System.in);
	UserBizImpl ubi=new UserBizImpl();
	MyUtil myUtil=new MyUtil();
	public void userView() {
		while(true) {
			System.out.println("0.返回上一层1.用户登陆2.用户注册");
			int option=scn.nextInt();
			if(option==0) {
				break;
			}
			switch(option) {
			case 1:
				login();
				break;
			case 2:
				regist();
				break;
			default:
				System.out.println("输入错误，重新输入");
				break;
			}
		}
	}
	//登陆
	//未解决用户输入空格问题
	public void login() {
		System.out.println("输入用户名");
		String name=scn.next();
		System.out.println("输入密码");
		String passwd=scn.next();
		if(ubi.login(name, passwd)) {
			System.out.println("登陆成功");
			userOption(name,passwd);
		}else {
			System.out.println("登陆失败");
		}
	}
	private void userOption(String name,String passwd) {
		while(true) {
			System.out.println("0.返回上一层1.猜你喜欢2.购票3.充值");
			int option=scn.nextInt();
			if(option==0) {
				break;
			}
			switch(option) {
			case 1:
				gussYouLike(name,passwd);
				break;
			case 2:
				buyTicket(name,passwd);
				break;
			case 3:
				charge(name,passwd);
				break;	
			default:
				System.out.println("输入错误，重新输入");
				break;
			}
		}
	}
	private void gussYouLike(String name, String passwd) {
		ubi.findYouLike(name,passwd);
	}
	private void buyTicket(String name, String passwd) {
		ubi.getAllMovie();
		System.out.println("选择电影id");
		int mid=scn.nextInt();
		ubi.getAllSession(mid);
		System.out.println("选择场次id");
		int sid=scn.nextInt();
		ubi.getAllSeat(sid);
		System.out.println("选择座位(从左往右，从行往下数，从0开始)");
		int seat=scn.nextInt();
		ubi.refreshSeat(seat,sid);
		if(ubi.cal(sid,name, passwd,seat)) {
			System.out.println("订票成功");
		}else {
			System.out.println("订票失败");
		}
		
		
	}
	private void charge(String name,String passwd) {
		System.out.println("输入你要充值的金额");
		double num=scn.nextDouble();
		if(ubi.charge(name, passwd,num)) {
			System.out.println("充值成功");
		}else {
			System.out.println("充值失败");
		}
	}
	//注册
	public void regist() {
		System.out.println("输入用户名");
		String name=scn.next();
		System.out.println("输入密码");
		String passwd=scn.next();
		if(ubi.regist(name, passwd)) {
			myUtil.refreshUserId();
			System.out.println("注册成功");
		}else {
			System.out.println("注册失败");
		}
	}
}
