package reflect;

public class Point {

	private int x;
	public int y;
	
	private String s1 ="ball";
	public String s2="hubin";
	public String s3="zhangxiaoxiang";
	//做实验而已，字段不可能是 public 的
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public String getS1() {
		return s1;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}
	
}