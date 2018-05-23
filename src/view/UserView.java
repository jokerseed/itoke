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
			System.out.println("1.用户登陆2.用户注册");
			int option=scn.nextInt();
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
		}else {
			System.out.println("登陆失败");
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
