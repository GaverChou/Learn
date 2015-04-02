package reflect;

import java.lang.reflect.Field;

//need another bean Point
public class ReflectTest {
	
	public static void main(String[] args) throws Exception {
		
		Point pt1 = new Point(3,5);
		
		//get all fields
		Field[] fields = pt1.getClass().getDeclaredFields(); 
		
		for(Field field : fields ) {
			//我说的是String 类型的字段，当然要选择一下
			//if(field.getType().equals(String.class)) {
			//字节码都是一份的，干什么用equals啊
//			System.out.println(field.getType());
			field.setAccessible(true);
			Object oldValue = field.get(pt1);
			System.out.println(oldValue);
//			if(field.getType()== String.class) {
//				field.setAccessible(true);
//				String oldValue = (String)field.get(pt1);
//				String newValue = oldValue.replace('b', 'a');
//				//改 对象的字段
//				field.set(pt1, newValue);
//				
//			}
		}
		
//		System.out.println(pt1.getS1());
//		System.out.println(pt1.s2);
//		System.out.println(pt1.s3);
		
		//aall
		//huain
		//zhangxiaoxiang

	}
}