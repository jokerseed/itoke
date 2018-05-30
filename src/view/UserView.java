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
			System.out.println("0.������һ��1.�û���½2.�û�ע��");
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
			userOption(name,passwd);
		}else {
			System.out.println("��½ʧ��");
		}
	}
	private void userOption(String name,String passwd) {
		while(true) {
			System.out.println("0.������һ��1.����ϲ��2.��Ʊ3.��ֵ");
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
				System.out.println("���������������");
				break;
			}
		}
	}
	private void gussYouLike(String name, String passwd) {
		ubi.findYouLike(name,passwd);
	}
	private void buyTicket(String name, String passwd) {
		ubi.getAllMovie();
		System.out.println("ѡ���Ӱid");
		int mid=scn.nextInt();
		ubi.getAllSession(mid);
		System.out.println("ѡ�񳡴�id");
		int sid=scn.nextInt();
		ubi.getAllSeat(sid);
		System.out.println("ѡ����λ(�������ң���������������0��ʼ)");
		int seat=scn.nextInt();
		ubi.refreshSeat(seat,sid);
		if(ubi.cal(sid,name, passwd,seat)) {
			System.out.println("��Ʊ�ɹ�");
		}else {
			System.out.println("��Ʊʧ��");
		}
		
		
	}
	private void charge(String name,String passwd) {
		System.out.println("������Ҫ��ֵ�Ľ��");
		double num=scn.nextDouble();
		if(ubi.charge(name, passwd,num)) {
			System.out.println("��ֵ�ɹ�");
		}else {
			System.out.println("��ֵʧ��");
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
