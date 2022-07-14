package view;
//visual layout of bidirectional test can depend on
import java.util.List;
import java.util.Scanner;

import view.*;
import dao.*;
import service.*;
import util.*;
import vo.*;

public class ViewUser implements Num{
	int nice=0;
	Scanner in=new Scanner(System.in);
	DishesService ds=new DishesService();
	OrdersService os=new OrdersService();
	UserService us=new UserService();
	public void viewUser(String user) {
		System.out.println("***********************************");
		System.out.println("*                                 *");
		System.out.println("*       ��ӭ�������û�û�ϵͳ         *");
		System.out.println("*                                 *");
		System.out.println("***********************************");
		System.out.println("*       1.�鿴��Ʒ��Ϣ               *");
		System.out.println("*      2.��Ҫ����                   *");
		System.out.println("*      3.�鿴����                   *");
		System.out.println("*      4.ǩ�ն���                   *");
		System.out.println("*      5.ȡ������                   *");
		System.out.println("*      6.��Ҫ����                   *");
		System.out.println("*      7.��ֵ                      *");
		System.out.println("*      8.������һ��                 *");
		System.out.println("***********************************");
		System.out.println(" ����������Ҫ�ķ���");
		String index=in.next();
		switch (index) {
			case "1":
				showMenu();
				break;
			case "2":
				orderDishes(user);
				break;
			case "3":
				showMyOrders(user);
				break;
			case "4":
				doneDeal(user);
				break;
			case "5":
				cancelOrders(user);
				break;
			case "6":
				give666();
				break;
			case "7":
				recharge(user);
				break;
			case "8":
				View view=new View();
				view.admin();
				break;

			default:
				break;
		}
		viewUser(user);
	}

	/**
	 * ��ʾ���в�Ʒ
	 */
	public void showMenu() {
		List<Dishes> d=ds.querysAll();
		for(int i=0;i<d.size();i++) {
			System.out.println(d.get(i));
		}
	}
	/**
	 * ��Ҫ����
	 * @param user
	 */
	private void orderDishes(String user) {
		List<Dishes> d=ds.queryAll();
		for(int i=0;i<d.size();i++) {
			System.out.println(d.get(i));
		}
		OrdersDao od=new OrdersDao();

		System.out.println("�����빺��Ĳ�Ʒ��ţ�");
		String dishesid = in.next();
		System.out.println("�����붩��������");
		int num=in.nextInt();
		while(num<1 || num>200) {
			System.out.println("��������ȷ��������");
			num=in.nextInt();
		}
		System.out.println("�������Ͳ͵ص㣺");
		String address=in.next();
		int index=os.orderDishes(dishesid,user,num,address);
		switch (index) {
			case Success:
				System.out.println("�µ��ɹ��������˻��۳�"+od.checkOrderPrice(dishesid, num));
				break;
			case Moneyless:
				System.out.println("�˻����㣬��ʣ"+us.showMoney(user)+"Ԫ!");
				break;

			default:
				break;
		}
	}
	/**
	 * �鿴�˿Ͷ���
	 */
	public void showMyOrders(String user) {
		List<Orders> o=os.showMyOrders(user);
		for(int i=0;i<o.size();i++) {
			System.out.println(o.get(i));
		}
	}

	/**
	 * ǩ�ն���
	 * @param user
	 */
	public void doneDeal(String user) {
		showMyOrders(user);
		System.out.println("���������յ��Ķ������룺");
		String orderId=in.next();
		int index=os.updateUserOrderState(user,orderId);
		switch (index) {
			case Success:
				System.out.println("��ǩ�գ�");
				break;
			case NumError:
				System.out.println("���޷�ǩ�ձ��Ϊ"+orderId+"�Ķ�����¼������������");
				doneDeal(user);
				break;

			default:
				break;
		}
	}
	/**
	 * ȡ������
	 * @param user
	 */
	public void cancelOrders(String user) {
		showMyOrders(user);
		System.out.println("������ȡ��������ţ�");
		String orderId=in.next();
		int index=os.cancelOrders(user,orderId);
		switch (index) {
			case Success:
				System.out.println("ȡ���ɹ���");
				break;
			case NumError:
				System.out.println("δ�ҵ��ö��������������룺");
				cancelOrders(user);
				break;

			default:
				break;
		}
	}

	/**
	 * ����
	 */
	public void give666() {
		showMenu();
		System.out.println("������Ҫ���޵Ĳ�Ʒ��ţ�");
		String dishesId=in.next();
		int index=ds.niceShoot(dishesId);
		switch (index) {
			case Success:
				System.out.println("���޳ɹ�����л����֧�֣�");
				nice++;
				break;
			case NumError:
				System.out.println("������ı�Ų����ڣ����������룺");
				give666();
				break;

			default:
				break;
		}
	}
	/**
	 * ��ֵ
	 * @param user
	 */
	public void recharge(String user) {
		System.out.println("������Ҫ��ֵ�������ϵͳֻ֧��20,50,100Ԫ��");
		double rechargeMoney=in.nextDouble();
		int index=us.recharge(user,rechargeMoney);
		switch (index) {
			case Success:
				System.out.println("��ֵ�ɹ���");
				break;
			case RechargeError:
				System.out.println("��ֵʧ�ܣ�");
				break;
			default:
				break;
		}
	}
}