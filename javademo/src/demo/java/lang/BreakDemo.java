package demo.java.lang;

public class BreakDemo {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// 循环中的break，break默认跳出本层循环
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (2 == j)
					break;

				System.out.println("i,j " + i + "," + j);
			}
		}

		// 带标签的break，break跳出标签块，多条语句加{}
		lable1: {
			for (int i = 1; i < 10; i++) {
				System.out.println(i);
				if (i == 5) {
					System.out.println("break lable1");
					break lable1;
				}
			}
			System.out.println("lable1");
		}

		// 带标签的break，break跳出标签块
		lable2: for (int i = 1; i < 10; i++) {
			lable3: for (int j = 1; j < 10; j++) {
				System.out.println("i,j:" + i + "," + j);

				if (j == 2) {
					System.out.println("break");
					break lable2; // 跳出标签块lable2
					// break lable3; //跳出标签块lable3
				}
			}

			System.out.println("test");
		}
	}

}
