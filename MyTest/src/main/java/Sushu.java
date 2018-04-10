
public class Sushu {

	public static void main(String[] args) {

		int i = 3;
		
//		
//		int[] arr = { 6, 3, 8, 2, 9, 1 };
//		System.out.println("排序前数组为：");
//		for (int num : arr) {
//			System.out.print(num + " ");
//		}
//		for (int i = 0; i < arr.length - 1; i++) {// 外层循环控制排序趟数
//			for (int j = 0; j < arr.length - 1 - i; j++) {// 内层循环控制每一趟排序多少次
//				if (arr[j] > arr[j + 1]) {
//					int temp = arr[j];
//					arr[j] = arr[j + 1];
//					arr[j + 1] = temp;
//				}
//			}
//		}
//		System.out.println();
//		System.out.println("排序后的数组为：");
//		for (int num : arr) {
//			System.out.print(num + " ");
//		}
	}

	public static void main1(String args[]) {
		// Sushu s1 = new Sushu();
		// s1.main();
		int COUNT = 11;
		int x[] = { 33, 332, 22, 10, 8, 9, 3, 2, 4, 7, 6, 5, 1, 0, 12, 13, 15, 18, 19, 20 };
		System.out.println("length" + x.length);
		int i, j;
		int s = 0;
		for (i = 0; i < 20 - 1; i++) {
			for (j = 0; j < 20 - i - 1; j++) {
				if (x[j] > x[j + 1]) {
					s = x[j];
					x[j] = x[j + 1];
					x[j + 1] = s;
				}
			}
		}

		for (int m : x) {
			System.out.println(m);
		}
	}

	void main() {
		int i = 0;
		int cou = 0;
		for (i = 100; i < 300; i++) {
			if (isSushu(i) == 1) {
				cou++;
				if (cou != 0 && cou % 5 == 0) {
					System.out.println(i);
				} else {
					System.out.print(i + " ");
				}

			}
		}
	}

	int isSushu(int n) {
		int temp = 0;
		for (temp = 2; temp < n; temp++) {
			if (n % temp == 0) {
				return 0;
			}
		}
		return 1;
	}

}
