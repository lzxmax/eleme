package dao;

import java.sql.Statement;

import view.*;
import dao.*;
import service.*;
import util.*;
import vo.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	
	public Users selectByNamePass(String user,String pwd) {
		Users u=new Users();
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			String sql="select * from users where u_name='"+user+"' and u_pwd='"+pwd+"'";
			ResultSet rs=stmt.executeQuery(sql);

			while(rs.next()){
				u.setU_no(rs.getInt(1));
				u.setU_name(rs.getString(2));
				u.setU_pwd(rs.getString(3));
				u.setU_tell(rs.getString(4));
				u.setU_role(rs.getInt(5));
				u.setU_money(rs.getDouble(6));

			}
			DBUtil.closeAll(conn, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	public Users selectByName(String user) {
		Users u=new Users();
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			String sql=" select * from users where u_name= ' "  + user+" ' "   ;
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				u.setU_no(rs.getInt(1));
				u.setU_name(rs.getString(2));
				u.setU_pwd(rs.getString(3));
				u.setU_tell(rs.getString(4));
				u.setU_role(rs.getInt(5));
				u.setU_money(rs.getDouble(6));

			}
			DBUtil.closeAll(conn, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
	public void insertUsers(String user,String pass,long tell) {
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			String sql="insert into users values ( null , '"+user+"' , '"+pass+"' ,  '"+String.valueOf(tell)+"'  ,1,0)";
			stmt.executeUpdate(sql);
			DBUtil.closeAll(conn, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public double selectByMoney(String name) {
		double money=0;
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			String sql="select u_money from users where u_name='"+name+"'";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				money=rs.getDouble(1);
			}
			DBUtil.closeAll(conn, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return money;
	}
	/**
	 * Ïû·Ñ½ð¶î
	 * @param spendMoney
	 */
	public void updateMoney(String user,double spendMoney) {
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			String sql="update users set u_money=(u_money-"+spendMoney+") where u_name='"+user+"'";
			stmt.executeUpdate(sql);
			DBUtil.closeAll(conn, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateUserMoney(String user, double rechargeMoney) {
		try {
			Connection conn=DBUtil.getconn();
			Statement stmt=conn.createStatement();
			String sql="update users set u_money=(u_money+"+rechargeMoney+") where u_name='"+user+"'";
			stmt.executeUpdate(sql);
			DBUtil.closeAll(conn, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
