package T;
public class Gen<A> {
	A obj;

	public A getObj() {
		return obj;
	}

	public void setObj(A obj) {
		this.obj = obj;
	}
	public static void main(String[] args) {
		Gen<String> gen = new Gen<>();
		gen.setObj("abc");
//		gen.setObj(10);		//�޷�ͨ������
		String str = gen.getObj();	//��������ת��
		//-----------------------------
		Gen gen2 = new Gen();//raw typeԭʼ����
		gen2.setObj("abc");
		gen2.setObj(10);	//����ͨ�����룬�Զ�װ�佫10ת��ΪInteger����
		Integer num = (Integer) gen2.getObj();//ʹ����ǿ������ת��
	}
}