package vo;

public class Dishes {
	private int g_no;
	private String g_name;
	private int g_price;
	private int g_like_num;
	private int g_state;
	
	public int getG_no() {
		return g_no;
	}
	public void setG_no(int g_no) {
		this.g_no = g_no;
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
	public int getG_like_num() {
		return g_like_num;
	}
	public void setG_like_num(int g_like_num) {
		this.g_like_num = g_like_num;
	}
	public int getG_state() {
		return g_state;
	}
	public void setG_state(int g_state) {
		this.g_state = g_state;
	}
	
	@Override
	public String toString() {
		String state;
		if(g_state==0) {
			state="������";
		}else {
			state="�¼�";
		}
		return "��Ʒ��ţ�" + g_no + "\t\t��Ʒ���ƣ�" + g_name + "\t\t��Ʒ�۸�" + g_price + "\t\t��������" + g_like_num + "\t"+state;
	}
	
	
}
