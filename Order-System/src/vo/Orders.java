package vo;

public class Orders {
	private int o_no;
	private String u_name;
	private String g_name;
	private int g_price;
	private int o_num;
	private String o_time;
	private String o_address;
	private double o_totle;
	private int o_state;
	public int getO_no() {
		return o_no;
	}
	public void setO_no(int o_no) {
		this.o_no = o_no;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public double getG_price() {
		return g_price;
	}
	public void setG_price(int g_price) {
		this.g_price = g_price;
	}
	public int getO_num() {
		return o_num;
	}
	public void setO_num(int o_num) {
		this.o_num = o_num;
	}
	public String getO_time() {
		return o_time;
	}
	public void setO_time(String o_time) {
		this.o_time = o_time;
	}
	public String getO_address() {
		return o_address;
	}
	public void setO_address(String o_address) {
		this.o_address = o_address;
	}
	public double getO_totle() {
		return o_totle;
	}
	public void setO_totle(double o_totle) {
		this.o_totle = o_totle;
	}
	public int getO_state() {
		return o_state;
	}
	public void setO_state(int o_state) {
		this.o_state = o_state;
	}
	@Override
	public String toString() {
		String state;
		if(o_state==0) {
			state="�̼��ѽӵ�";
		}else if(o_state==1) {
			state="�����С�����";
		}else {
			state="�����";
		}
		return "\t������ţ�" + o_no + "\t�û�����" + u_name + "\t������" + g_name + "\t���ۣ�" + g_price
				+ "\t������" + o_num + "\t�Ͳ�ʱ�䣺" + o_time + "\t�Ͳ͵ص㣺" + o_address + "\t�ܼۣ�" + o_totle
				+ "\t"+state;
	}
	
	
}
