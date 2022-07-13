package dao;

import java.util.List;

import view.*;
import dao.*;
import service.*;
import util.*;
import vo.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrdersDao {
	/**
	 * ��ȡ������Orders
	 * @return
	 */
	
	public List<Orders> selectAllOrders() {
		List<Orders> oList=new ArrayList<>();
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			String sql="SELECT orders.o_no,users.u_name,dishes.g_name,dishes.g_price,orders.o_num,orders.o_time,orders.o_address,orders.o_num*dishes.g_price,orders.o_state FROM users,dishes,orders WHERE orders.u_no=users.u_no AND orders.g_no=dishes.g_no";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Orders o=new Orders();
				o.setO_no(rs.getInt(1));
				o.setU_name(rs.getString(2));
				o.setG_name(rs.getString(3));
				o.setG_price(rs.getInt(4));
				o.setO_num(rs.getInt(5));
				o.setO_time(rs.getString(6));
				o.setO_address(rs.getString(7));
				o.setO_totle(rs.getDouble(8));
				o.setO_state(rs.getInt(9));
				oList.add(o);
			}
			DBUtil.closeAll(conn, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oList;
	}
/**
 * ��ȡָ���û���Orders
 * @param user
 * @return
 */
	public List<Orders> selectMyOrders(String user) {
		List<Orders> oList=new ArrayList<>();
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			String sql="SELECT orders.o_no,users.u_name,dishes.g_name,dishes.g_price,orders.o_num,orders.o_time,orders.o_address,orders.o_num*dishes.g_price,orders.o_state FROM users,dishes,orders WHERE orders.u_no=users.u_no AND orders.g_no=dishes.g_no and users.u_name='"+user+"'";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Orders o=new Orders();
				o.setO_no(rs.getInt(1));
				o.setU_name(rs.getString(2));
				o.setG_name(rs.getString(3));
				o.setG_price(rs.getInt(4));
				o.setO_num(rs.getInt(5));
				o.setO_time(rs.getString(6));
				o.setO_address(rs.getString(7));
				o.setO_totle(rs.getDouble(8));
				o.setO_state(rs.getInt(9));
				oList.add(o);
			}
			DBUtil.closeAll(conn, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oList;
	}
	/**
	 * ����Ա��������Ϊ������
	 * @param id
	 */
	public void updateOrdersState(String id) {
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			String sql="update orders set o_state=1 where o_no="+id;
			stmt.executeUpdate(sql);
			DBUtil.closeAll(conn, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ��������Ų�ѯ
	 * @param id
	 * @return
	 */
	public Orders checkOrdersNo(String id) {
		Orders o=new Orders();
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			String sql="SELECT orders.o_no,users.u_name,dishes.g_name,dishes.g_price,orders.o_num,orders.o_time,orders.o_address,orders.o_num*dishes.g_price,orders.o_state FROM users,dishes,orders WHERE orders.u_no=users.u_no AND orders.g_no=dishes.g_no and orders.o_no="+id;
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				o.setO_no(rs.getInt(1));
				o.setU_name(rs.getString(2));
				o.setG_name(rs.getString(3));
				o.setG_price(rs.getInt(4));
				o.setO_num(rs.getInt(5));
				o.setO_time(rs.getString(6));
				o.setO_address(rs.getString(7));
				o.setO_totle(rs.getDouble(8));
				o.setO_state(rs.getInt(9));
			}
			DBUtil.closeAll(conn, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
/**
 * д���û�������Ϣ
 * @param dishesid ������Ʒ���
 * @param user ����������
 * @param num ��������
 * @param address ��ַ
 */
	public void insertUserOrders(String dishesid, String user,int num, String address) {
		int userNo=0;
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			//==========================
			/**
			 * ����user��Ӧ���
			 */
			String sql0="select u_no from users where u_name='"+user+"'";
			ResultSet rs=stmt.executeQuery(sql0);
			while(rs.next()) {
				userNo=rs.getInt(1);
			}
			//===========================

			String sql="insert into orders values (null,"+userNo+","+dishesid+","+num+",Sysdate(),'"+address+"',0)";
			stmt.executeUpdate(sql);
			DBUtil.closeAll(conn, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ��ѯ����ָ����Ʒ����
	 * @param dishesid
	 * @return
	 */
	public double checkOrderPrice(String dishesid,int num) {
		int price = 0;
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			String sql="select g_price from dishes where g_no="+dishesid;
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				price=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price*num;
	}
/**
 * ָ���û�ǩ��ָ������
 * @param user �û���
 * @param orderId Ҫǩ�յĶ������
 */
	public void updateUserOrderState(String user,String orderId) {
		int userNo=0;
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			//==========================
			/**
			 * ����user��Ӧ���
			 */
			String sql0="select u_no from users where u_name='"+user+"'";
			ResultSet rs=stmt.executeQuery(sql0);
			while(rs.next()) {
				userNo=rs.getInt(1);
			}
			//===========================
			String sql="update orders set o_state=2 where u_no="+userNo+" and o_no="+orderId;
			stmt.executeUpdate(sql);
			DBUtil.closeAll(conn, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
/**
 * ɾ��ָ��������¼
 * @param user
 * @param orderId
 */
	public void deleteOrders(String user, String orderId) {
		int userNo=0;
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			//==========================
			/**
			 * ����user��Ӧ���
			 */
			String sql0="select u_no from users where u_name='"+user+"'";
			ResultSet rs0=stmt.executeQuery(sql0);
			while(rs0.next()) {
				userNo=rs0.getInt(1);
			}
			//===========================
			String sql="delete from orders where u_no="+userNo+" and o_no="+orderId;
			stmt.executeUpdate(sql);
			DBUtil.closeAll(conn, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
/**
 * ��ѯָ���û��ı���Ƿ����Orders����
 * @param user
 * @param id
 * @return
 */
	public Orders checkUserOrdersNo(String user, String id) {
		Orders o=new Orders();
		int userNo=0;
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			//==========================
			/**
			 * ����user��Ӧ���
			 */
			String sql0="select u_no from users where u_name='"+user+"'";
			ResultSet rs0=stmt.executeQuery(sql0);
			while(rs0.next()) {
				userNo=rs0.getInt(1);
			}
			//===========================
			String sql="SELECT orders.o_no,users.u_name,dishes.g_name,dishes.g_price,orders.o_num,orders.o_time,orders.o_address,orders.o_num*dishes.g_price,orders.o_state FROM users,dishes,orders WHERE orders.u_no=users.u_no AND orders.g_no=dishes.g_no and orders.u_no="+userNo+" and o_no="+id;
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				o.setO_no(rs.getInt(1));
				o.setU_name(rs.getString(2));
				o.setG_name(rs.getString(3));
				o.setG_price(rs.getInt(4));
				o.setO_num(rs.getInt(5));
				o.setO_time(rs.getString(6));
				o.setO_address(rs.getString(7));
				o.setO_totle(rs.getDouble(8));
				o.setO_state(rs.getInt(9));
			}
			DBUtil.closeAll(conn, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
/**
 * ����Ա��ѯ�����ѽ��ܶ���
 * @return
 */
	public List<Orders> selectTaskOrders() {
		List<Orders> oList=new ArrayList<>();
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			String sql="SELECT orders.o_no,users.u_name,dishes.g_name,dishes.g_price,orders.o_num,orders.o_time,orders.o_address,orders.o_num*dishes.g_price,orders.o_state FROM users,dishes,orders WHERE orders.u_no=users.u_no AND orders.g_no=dishes.g_no and orders.o_state=0";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Orders o=new Orders();
				o.setO_no(rs.getInt(1));
				o.setU_name(rs.getString(2));
				o.setG_name(rs.getString(3));
				o.setG_price(rs.getInt(4));
				o.setO_num(rs.getInt(5));
				o.setO_time(rs.getString(6));
				o.setO_address(rs.getString(7));
				o.setO_totle(rs.getDouble(8));
				o.setO_state(rs.getInt(9));
				oList.add(o);
			}
			DBUtil.closeAll(conn, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oList;
	}
/**
 * ���ָ����ǩ�ն�������Ƿ������Orders����
 * @param id
 * @return
 */
	public Orders checkTaskOrdersNo(String id) {
		Orders o=new Orders();
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			String sql="SELECT orders.o_no,users.u_name,dishes.g_name,dishes.g_price,orders.o_num,orders.o_time,orders.o_address,orders.o_num*dishes.g_price,orders.o_state FROM users,dishes,orders WHERE orders.u_no=users.u_no AND orders.g_no=dishes.g_no and orders.o_state=0 and orders.o_no="+id;
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				o.setO_no(rs.getInt(1));
				o.setU_name(rs.getString(2));
				o.setG_name(rs.getString(3));
				o.setG_price(rs.getInt(4));
				o.setO_num(rs.getInt(5));
				o.setO_time(rs.getString(6));
				o.setO_address(rs.getString(7));
				o.setO_totle(rs.getDouble(8));
				o.setO_state(rs.getInt(9));
			}
			DBUtil.closeAll(conn, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
	
}
