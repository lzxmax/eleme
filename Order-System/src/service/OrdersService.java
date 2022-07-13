package service;

import java.util.List;

import view.*;
import dao.*;
import service.*;
import util.*;
import vo.*;

import java.util.ArrayList;

public class OrdersService implements Num{
	
	UserService us=new UserService();
	/**
	 * ��ѯ���ж���
	 * @return
	 */
	public List<Orders> showOrders() {
		OrdersDao od=new OrdersDao();
		return od.selectAllOrders();
	}
	/**
	 * ��ѯ���û�����
	 * @param user
	 * @return
	 */
	public List<Orders> showMyOrders(String user) {
		OrdersDao od=new OrdersDao();
		return od.selectMyOrders(user);
	}
	/**
	 * ����Ա�����ѽ��ܶ���
	 * @param id 
	 * @return
	 */
	public int sendOrders(String id) {
		OrdersDao od=new OrdersDao();
		if(checkTaskOrderNo(id)) {
			od.updateOrdersState(id);
			return Success;
		}else {
			return NotExist;
		}
	}
	/**
	 * �����ж����м�鶩���Ƿ����
	 * @param id
	 * @return
	 */
	
	public boolean checkOrderNo(String id) {
		OrdersDao od=new OrdersDao();
		Orders o=od.checkOrdersNo(id);
		int di=Integer.parseInt(id);
		if(di==o.getO_no()) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * �û�����
	 * @param dishesid ��Ʒ���
	 * @param user �����û�
	 * @param num ��������
	 * @param address ���͵�ַ	
	 * @return intֵ
	 */
	public int orderDishes(String dishesid, String user,int num, String address) {
		UserDao ud=new UserDao();
		OrdersDao od=new OrdersDao();
		if(od.checkOrderPrice(dishesid,num)>us.showMoney(user)) {
			return Moneyless;
		}else {
			od.insertUserOrders(dishesid,user,num,address);
			ud.updateMoney(user, od.checkOrderPrice(dishesid,num));
			return Success;
		}
	}
/**
 * �û�ǩ�������еĶ���
 * @param user
 * @param id
 * @return
 */
	public int updateUserOrderState(String user,String id) {
		Orders o=new Orders();
		OrdersDao od=new OrdersDao();
		o=od.checkUserOrdersNo(user,id);
		int no=Integer.parseInt(id);
		if(no==o.getO_no() && o.getO_state()==1) {
			od.updateUserOrderState(user,id);
			return Success;
		}else {
			return NumError;
		}
	}
/**
 * �û�ȡ������
 * @param user
 * @param orderId
 * @return
 */
	public int cancelOrders(String user, String orderId) {
		Orders o=new Orders();
		OrdersDao od=new OrdersDao();
		o=od.checkUserOrdersNo(user,orderId);
		int di=Integer.parseInt(orderId);
		if(di==o.getO_no()) {
			od.deleteOrders(user,orderId);
			return Success;
		}else {
			return NumError;
		}
	}
	/**
	 * ����δ���͵Ķ���
	 * @return
	 */
	public List<Orders> showTaskOrders() {
		OrdersDao od=new OrdersDao();
		return od.selectTaskOrders();
	}
	/**
	 * ��δ�����б��м�鶩���Ƿ����
	 * @param id
	 * @return
	 */
	public boolean checkTaskOrderNo(String id) {
		OrdersDao od=new OrdersDao();
		Orders o=od.checkTaskOrdersNo(id);
		int i=Integer.parseInt(id);
		if(i == o.getO_no()) {
			return true;
		}else {
			return false;
		}
	}
}
