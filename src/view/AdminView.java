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
			System.out.println("1.�����Ӱ2.����ӰԺ3.������");
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
				System.out.println("���������������");
				break;
			}
		}
	}
	private void hallManager() {
		while(true) {
			System.out.println("1.���ӳ���2.ɾ������3.�޸ĳ���4.���ҳ���");
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
				System.out.println("���������������");
				break;
			}
		}
	}
	public void cinemaManager() {
		while(true) {
			System.out.println("1.����ӰԺ2.ɾ��ӰԺ3.�޸�ӰԺ4.����ӰԺ");
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
				System.out.println("���������������");
				break;
			}
		}
	}
	private void findCinema() {
		cbi.find();
	}
	private void updateCinema() {
		System.out.println("��Ҫ�޸ĵ�ӰԺ����");
		String name1=scn.next();
		System.out.println("�޸�ӰԺ����");
		String name=scn.next();
		System.out.println("�޸�ӰԺ��ַ");
		String address=scn.next();
		if(cbi.update(new Cinema(name1), new Cinema(name,address))) {
			System.out.println("�޸ĳɹ�");
		}else {
			System.out.println("�޸�ʧ��");
		}
	}
	private void deleCinema() {
		System.out.println("ӰԺ����");
		String name=scn.next();
		if(cbi.deleCinema(name)) {
			System.out.println("ɾ���ɹ�");
		}else {
			System.out.println("ɾ��ʧ��");
		}
	}
	private void addCinema() {
		System.out.println("ӰԺ����");
		String name=scn.next();
		System.out.println("ӰԺ��ַ");
		String address=scn.next();
		if(cbi.addCinema(new Cinema(name,address))) {
			System.out.println("��ӳɹ�");
		}else {
			System.out.println("���ʧ��");
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
