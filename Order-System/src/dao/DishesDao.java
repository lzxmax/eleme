package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import view.*;
import dao.*;
import service.*;
import util.*;
import vo.*;

public class DishesDao {
	/**
	 * ???????????dishes???????§Þ??
	 * @return
	 */
	public List<Dishes> selectAllDishes() {
		List<Dishes> dishes=new ArrayList<>();
		ResultSet rs = null;
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			String sql="select * from dishes";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Dishes d=new Dishes();
				d.setG_no(rs.getInt(1));
				d.setG_name(rs.getString(2));
				d.setG_price(rs.getInt(3));
				d.setG_like_num(rs.getInt(4));
				d.setG_state(rs.getInt(5));
				dishes.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dishes;
		
	}
	/**
	 * ???????????dishes???????????
	 * @return
	 */
	public List<Dishes> selectAllsDishes() {
		List<Dishes> dishes=new ArrayList<>();
		ResultSet rs = null;
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			String sql="select * from dishes where g_state=0";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Dishes d=new Dishes();
				d.setG_no(rs.getInt(1));
				d.setG_name(rs.getString(2));
				d.setG_price(rs.getInt(3));
				d.setG_like_num(rs.getInt(4));
				d.setG_state(rs.getInt(5));
				dishes.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dishes;
		
	}
	/**
	 * ????????§Õ??dishes????
	 * @param name
	 * @param price
	 */
	public void insertDishes(String name,int price) {
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			String sql="insert into dishes values (null,'"+name+"',"+price+",0,0)";
			stmt.executeUpdate(sql);
			DBUtil.closeAll(conn, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 System.out.println("????????!");
			e.printStackTrace();
		}
	}
	/**
	 * ??dishes???§Ñ?????????????????
	 * @param name
	 * @return
	 */
	public Dishes selectDishesBYName(String name) {
		Dishes d=new Dishes();
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			String sql="select * from dishes where g_name='"+name+"'";
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				d.setG_no(rs.getInt(1));
				d.setG_name(rs.getString(2));
				d.setG_price(rs.getInt(3));
				d.setG_like_num(rs.getInt(4));
				d.setG_state(rs.getInt(5));
			}
			DBUtil.closeAll(conn, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	/**
	 * ???dishes???§Ñ??????????g_state?????
	 * @param id
	 */
	public void updateDishes(String id) {
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			String sql="update dishes set g_state=1-g_state where g_no="+id;
			stmt.executeUpdate(sql);
			DBUtil.closeAll(conn, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 System.out.println("????????!");
			e.printStackTrace();
		}
	}
	/**
	 * ??dishes???§Ñ????????????????
	 * @param id
	 */
	public void deleteDishes(String id) {
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			String sql="update dishes set g_state=1 where g_no="+id;
			stmt.executeUpdate(sql);
			DBUtil.closeAll(conn, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("????????!");
			e.printStackTrace();
		}
	}
/**
 * ??dishes???§ß?g_like_num??1
 * @param dishesId
 */
	public void updateDishesLikeNum(String dishesId) {
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			String sql="update dishes set g_like_num=(g_like_num+1) where g_no="+dishesId;
			stmt.executeUpdate(sql);
			DBUtil.closeAll(conn, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("????????!");
			e.printStackTrace();
		}
	}
	/**
	 * ??dishes???§Ó???????????????
	 * @param dishesId
	 * @return
	 */
	public Dishes checkDishesNoIsExist(String dishesId) {
		Dishes d=new Dishes();
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			String sql="select * from dishes where g_no="+dishesId;
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				d.setG_no(rs.getInt(1));
				d.setG_name(rs.getString(2));
				d.setG_price(rs.getInt(3));
				d.setG_like_num(rs.getInt(4));
				d.setG_state(rs.getInt(5));
			}
			DBUtil.closeAll(conn, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
}
