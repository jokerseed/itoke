package view;

import java.util.Scanner;

import bizImpl.MovieBizImpl;
import entity.Movie;

public class AdminView {
	Scanner scn=new Scanner(System.in);
	MovieBizImpl mbi=new MovieBizImpl();
	public void adminView() {
		while(true) {
			adminLogin();
		}
	}
	public void adminLogin() {
		System.out.println("�������Ա�û���");
		String adminName=scn.next();
		System.out.println("�������Ա����");
		String adminPasswd=scn.next();
		if(adminName.equals("admin")&&adminPasswd.equals("joker")) {
			System.out.println("��½�ɹ�");
			adminOperation();
		}else {
			System.out.println("��½ʧ��");
		}
	}
	
	//����Ա����ѡ��
	public void adminOperation() {
		while(true) {
			System.out.println("1.�����Ӱ");
			int option=scn.nextInt();
			switch(option) {
			case 1:
				movieManager();
				break;
			default:
				System.out.println("���������������");
				break;
			}
		}
	}
	public void movieManager() {
		while(true) {
			System.out.println("1.���ӵ�Ӱ2.ɾ����Ӱ3.�޸ĵ�Ӱ4.���ҵ�Ӱ");
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
				System.out.println("���������������");
				break;
			}
		}
	}
	public void addMovie() {
		System.out.println("��Ӱ����");
		String name=scn.next();
		System.out.println("��Ӱ����");
		String detail=scn.next();
		System.out.println("��Ӱʱ��");
		int duration=scn.nextInt();
		System.out.println("��Ӱ����");
		String type=scn.next();
		if(mbi.addMovie(new Movie(name,detail,duration,type))) {
			System.out.println("��ӳɹ�");
		}else {
			System.out.println("���ʧ��");
		}
	}
	public void deleMovie() {
		System.out.println("��Ӱ����");
		String name=scn.next();
		if(mbi.deleMovie(name)) {
			System.out.println("ɾ���ɹ�");
		}else {
			System.out.println("ɾ��ʧ��");
		}
	}
	public void updateMovie() {
		System.out.println("��Ҫ�޸ĵĵ�Ӱ����");
		String name1=scn.next();
		System.out.println("�޸ĵ�Ӱ����");
		String name=scn.next();
		System.out.println("�޸ĵ�Ӱ����");
		String detail=scn.next();
		System.out.println("�޸ĵ�Ӱʱ��");
		int duration=scn.nextInt();
		System.out.println("�޸ĵ�Ӱ����");
		String type=scn.next();
		if(mbi.update(new Movie(name1), new Movie(name,detail,duration,type))) {
			System.out.println("�޸ĳɹ�");
		}else {
			System.out.println("�޸�ʧ��");
		}
	}
	public void findMovie() {
		mbi.find();
	}
}
