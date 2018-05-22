package view;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import entity.User;
import util.ReadAndWrite;

public class MainView {
	Scanner scn=new Scanner(System.in);
	UserView uv=new UserView();
	AdminView av=new AdminView();
	public void mainView() {
		//��ʼ��    ��txt�ļ�����д��һ���յļ���
		init();
		System.out.println("��ӭ���ٵ�ӰԺ����ϵͳ");
		while(true) {
			System.out.println("1.userģʽ2.adminģʽ");
			int option=scn.nextInt();
			switch(option) {
			case 1:
				uv.userView();
				break;
			case 2:
				av.adminView();
				break;
			default:
				System.out.println("���������������");
				break;
			}
		}
	}
	public void init() {
		new ReadAndWrite<User>().writeObiect(new ArrayList<User>(), new File("src\\source\\users.txt"));
	}
}
