import java.util.ArrayList;
import java.util.Scanner;

public class HouseholdAccounts {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> ary = new ArrayList<>();
		//レシートの枚数
		int receipt = 0;
			receipt = sc.nextInt();
			for (int i = 0; i < receipt; i++) {
				//入力するレシートの数は100件以下とする
				if (receipt >= 1 && 100 >= receipt) {
					Scanner sr = new Scanner(System.in);
					String line = sr.nextLine();
					//日付と金額を半角スペースで区切って配列に分割する
					String[] strs = line.split(" ");
					for (String s : strs) {
						ary.add(s);
					}
				} else {
					System.out.println("レシート件数が上限を越えています");
					break;
				}

			}
		//合計金額と付与ポイントを出力するメソッドを呼び出す
		point_output(ary, receipt);
	}
	/**
	 * 合計金額と付与ポイントを出力するメソッド
	 */
	public static void point_output(ArrayList<String> element, int Total_receipt) {
		System.out.println();
		System.out.println(Total_receipt);
		int total_price = 0;

		try {
			for (int n = 0; n < Total_receipt; n++) {
				if (n < Total_receipt) {
					String price = element.get(n * 2 + 1);
					int Purchase_price = Integer.parseInt(price);
					if (Purchase_price > 0 && Purchase_price < 10001) {
						total_price += Purchase_price;
					} else {
						System.out.println("金額が上限を超えています");
						break;
					}
				}
			}
			System.out.println(total_price);

		} catch (Exception e) {
			System.out.println("\n" + "入力が不適切です");
		}
		double point;
		double total_point = 0;
		try {
			for (int i = 0; i < Total_receipt ; i++) {
				if (i < Total_receipt) {
					String day = element.get(i * 2);
					String money = element.get(i * 2 + 1);
					int moneys = Integer.parseInt(money);
					int days = Integer.parseInt(day);
					if (days > 0 && days < 32) {
						double Purchase_price = Integer.parseInt(day);
								if(days == 3 || days == 13 || days == 30 || days == 31){
									point = moneys * 0.03;
								} else if(days == 5 || days == 15 || days == 25) {
									point = moneys * 0.05;
								} else {
									point = moneys * 0.01;
								}
								total_point += point;
								System.out.println(point);
					} else {
						System.out.println("日付が不適切です");
						break;
					}
				}
			}
			System.out.println("合計");
			System.out.println(total_point);
		} catch (Exception ee) {
			System.out.println("\n" + "入力が不適切です");
		}
	}
}
