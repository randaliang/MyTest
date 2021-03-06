import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;

import jdk8.annotation.Apple;
import jdk8.annotation.FruitColor;
import jdk8.annotation.FruitName;
import jdk8.annotation.FruitProvider;

public class FruitInfoUtil {
	public static void getFruitInfo(Class<?> clazz) {

		String strFruitName = " 水果名称：";
		String strFruitColor = " 水果颜色：";
		String strFruitProvicer = "供应商信息：";

		Field[] fields = clazz.getDeclaredFields();
		AnnotatedType[] at = clazz.getAnnotatedInterfaces();
		System.out.println( "at.length" + at.length );

		for (Field field : fields) {
			if (field.isAnnotationPresent(FruitName.class)) {
				FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
				strFruitName = strFruitName + fruitName.value();
				System.out.println(strFruitName);
			} else if (field.isAnnotationPresent(FruitColor.class)) {
				FruitColor fruitColor = (FruitColor) field.getAnnotation(FruitColor.class);
				strFruitColor = strFruitColor + fruitColor.fruitColor().toString();
				System.out.println(strFruitColor);
			} else if (field.isAnnotationPresent(FruitProvider.class)) {
				FruitProvider fruitProvider = (FruitProvider) field.getAnnotation(FruitProvider.class);
				strFruitProvicer = " 供应商编号：" + fruitProvider.id() + " 供应商名称：" + fruitProvider.name() + " 供应商地址："
						+ fruitProvider.address();
				System.out.println(strFruitProvicer);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FruitInfoUtil.getFruitInfo(Apple.class);
		FruitInfoUtil.getFruitInfo( FruitName.class);

	}
}
