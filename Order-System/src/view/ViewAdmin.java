package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import view.*;
import dao.*;
import service.*;
import util.*;
import vo.*;

public class ViewAdmin implements Num{
	Scanner in=new Scanner(System.in);
	DishesService ds=new DishesService();
	OrdersService os=new OrdersService();
	public void viewAdmin() {
		System.out.println("***********************************");
		System.out.println("*                                 *");
		System.out.println("*       ��ӭ�������û����Աϵͳ       *");
		System.out.println("*                                 *");
		System.out.println("***********************************");
		System.out.println("*        1.�鿴�˵���Ϣ              *");
		System.out.println("*        2.¼���Ʒ                 *");
		System.out.println("*        3.�޸Ĳ�Ʒ                 *");
		System.out.println("*        4.�鿴�˿Ͷ���              *");
		System.out.println("*        5.ɾ���˵�                 *");
		System.out.println("*        6.���Ͳ˵�                 *");
		System.out.println("*        7.������һ��               *");
		System.out.println("***********************************");
		System.out.println(" ����������Ҫ�ķ���");

		String index=in.nextLine();
		switch (index) {
		case "1":
			showMenu();
			break;
		case "2":
			setMenu();
			break;
		case "3":
			updateDishes();
			break;
		case "4":
			showOrders();
			break;
		case "5":
			deleteDishes();
			break;
		case "6":
			sendOrders();
			break;
		case "7":
			View view=new View();
			view.admin();
			break;

		default:
			break;
		}
		viewAdmin();
	}
/**
 * �鿴�˵��б�
 */
	public void showMenu() {
		List<Dishes> d=ds.queryAll();
		for(int i=0;i<d.size();i++) {
			System.out.println(d.get(i));
		}
	}
	/**
	 * ¼���Ʒ 
	 */
	public void setMenu() {
		System.out.println("�������Ʒ���ƣ�");
		String name=in.nextLine();
		System.out.println("�������Ʒ�۸�");
		int price=in.nextInt();

		int index=ds.setDishes(name, price);
		switch (index) {
		case Success:
			System.out.println("¼��ɹ���");
			break;
		case Exist:
			System.out.println("��Ʒ�Ѵ��ڣ�");
			break;
		case None:
			System.out.println("error��");
			break;

		default:
			break;
		}
	}
	/**
	 * �޸Ĳ�Ʒ
	 */
	public void updateDishes() {
		showMenu();
		System.out.println("�������޸ĵĲ�Ʒ��ţ�");
		String id=in.nextLine();
		int index=ds.updateDishes(id);
		switch (index) {
		case Success:
			System.out.println("�޸ĳɹ���");
			break;
		case NumError:
			System.out.println("��Ʒ��Ų����ڣ����������룡");
			updateDishes();
			break;

		default:
			break;
		}
	}
	/**
	 * ɾ����Ʒ
	 */
	public void deleteDishes() {
		showMenu();
		System.out.println("������Ҫɾ���Ĳ�Ʒ��ţ�");
		String id=in.nextLine();
		int index=ds.deleteDishes(id);
		switch (index) {
		case Success:
			System.out.println("ɾ���ɹ���");
			break;
		case NumError:
			System.out.println("��Ʒ��Ų����ڣ����������룡");
			deleteDishes();
			break;

		default:
			break;
		}
	}

	/**
	 * �鿴�˿Ͷ���
	 */
	public void showOrders() {
		List<Orders> o=os.showOrders();
		for(int i=0;i<o.size();i++) {
			System.out.println(o.get(i));
		}
	}
	/**
	 * ���Ͳ˵�
	 */
	public void sendOrders() {
		List<Orders> o=os.showTaskOrders();
		for(int i=0;i<o.size();i++) {
			System.out.println(o.get(i));
		}
		System.out.println("���������Ͷ�����ţ�");
		String id=in.nextLine();
		if(os.sendOrders(id)==Success) {
			System.out.println(id+" ���������С�����");
		}else {
			System.out.println(id+"�����Ų����ڣ�");
		}
	}
}
