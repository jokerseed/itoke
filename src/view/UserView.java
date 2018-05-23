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
			System.out.println("1.�û���½2.�û�ע��");
			int option=scn.nextInt();
			switch(option) {
			case 1:
				login();
				break;
			case 2:
				regist();
				break;
			default:
				System.out.println("���������������");
				break;
			}
		}
	}
	//��½
	//δ����û�����ո�����
	public void login() {
		System.out.println("�����û���");
		String name=scn.next();
		System.out.println("��������");
		String passwd=scn.next();
		if(ubi.login(name, passwd)) {
			System.out.println("��½�ɹ�");
		}else {
			System.out.println("��½ʧ��");
		}
	}
	//ע��
	public void regist() {
		System.out.println("�����û���");
		String name=scn.next();
		System.out.println("��������");
		String passwd=scn.next();
		if(ubi.regist(name, passwd)) {
			myUtil.refreshUserId();
			System.out.println("ע��ɹ�");
		}else {
			System.out.println("ע��ʧ��");
		}
	}
}
