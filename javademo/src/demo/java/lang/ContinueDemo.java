package demo.java.lang;

public class ContinueDemo {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// 循环中的continue，continue默认跳过本次循环
		for (int i = 1; i < 10; i++) {
			if (2 == i)
				continue;

			System.out.println("i " + i);
		}

		// 带标签的continue，continue跳过标签处的循环，但continue的标签块只能位于循环前，且不能加{}
		lable1: for (int i = 1; i < 10; i++) {
			lable2: for (int j = 1; j < 10; j++) {
				System.out.println("i,j:" + i + "," + j);

				if (2 == j) {
					continue lable1;
					// continue lable2;
				}
			}

			// 若continue lable1此处不会打印
			System.out.println("test");
		}
	}

}
