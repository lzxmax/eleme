package view;

import java.util.Scanner;

import view.*;
import dao.*;
import service.*;
import util.*;
import vo.*;

public class View implements Num{
	
	Scanner in=new Scanner(System.in);
	String user;
	String pass;
	UserService us=new UserService();
	public void admin() {
		
		System.out.println("****************************************");
		System.out.println("*                                      *");
		System.out.println("*                                      *");
		System.out.println("*          ��ӭ�������ûϵͳ              *");
		System.out.println("*                                      *");
		System.out.println("*                                      *");
		System.out.println("****************************************");
		System.out.println("       1��½           2ע��          3�˳�");
		System.out.println("****************************************");
		
		String index=in.nextLine();
		switch (index) {
		case "1":
			//��½
			login();
			break;
		case "2":
			//ע��
			register();
			break;
		case "3":
			//�˳�
			System.exit(1);
			break;

		default:
			break;
		}
		
	}
	/**
	 * �û���¼
	 */
	public void login() {
		System.out.println("�������û�����");
		user=in.nextLine();
		System.out.println("���������룺");
		pass=in.nextLine();
		
		switch (us.login(user, pass)) {
		case Admin:
			System.out.println("����Ա��¼�ɹ�!!");
			ViewAdmin vAdmin=new ViewAdmin();
			vAdmin.viewAdmin();
			break;
		case User:
			System.out.println("�û���¼�ɹ�!!");
			ViewUser vUser=new ViewUser();
			vUser.viewUser(user);
			break;
		case UserWrong:
			System.out.println("�˻�������!!");
			login();
			break;
		case PassWrong:
			System.out.println("�������!!");
			login();
			break;

		default:
			break;
		}
	}
	/**
	 * �û�ע��
	 */
	public void register() {
		
		System.out.println("�������û�����");
		String user=in.nextLine();
		System.out.println("���������룺");
		String pass=in.nextLine();
		System.out.println("�������ֻ��ţ�");
		String tell=in.nextLine();
		
		switch (us.register(user,pass,tell)) {
		case Success:
			System.out.println("ע��ɹ���");
			admin();
			break;
		case Exist:
			System.out.println("�˻��Ѵ��ڣ�");
			register();
			break;
		case Passerror:
			System.out.println("���벻����");
			register();
			break;
		case Tellerror:
			System.out.println("�绰���벻��ȷ��");
			register();
			break;
		default:
			break;
		}
	}
}
