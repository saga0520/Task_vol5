import java.util.ArrayList;
import java.util.Scanner;

/**
 *家計簿をつけるクラス
 * ・合計購入金額
 * ・合計ポイント
 */
public class HouseholdAccounts {
	public static void main(String[] args) {
		int receiptNumber = 0;
		int point = 0;
		int total_point = 0;
		int total_price = 0;
		Scanner sc = new Scanner(System.in);
		ArrayList<String> aryList = new ArrayList<>();
		receiptNumber = sc.nextInt();

		try {

			//入力したレシート枚数を読み込む
			for (int i = 0; i < receiptNumber; i++) {

				//入力するレシート枚数は100件以下とする
				if (receiptNumber >= 1 && 100 >= receiptNumber) {
					Scanner sr = new Scanner(System.in);
					String line = sr.nextLine();

					//行に入力する日付と購入金額を半角スペースで区切って配列に分割する
					String[] strs = line.split(" ");
						for (String s : strs) {
							aryList.add(s);
						}
				} else {
					System.out.println("レシート枚数が上限を超えています");
					System.exit(0);
				}
			}

			//配列に格納した購入金額をレシート枚数分だけ読み込み加算する
			for (int n = 0; n < receiptNumber; n++) {
				if (n < receiptNumber) {
					String price = aryList.get(n * 2 + 1);
					int Purchase_price = Integer.parseInt(price);

					//一回の購入購入金額の上限は10,000円以下とする
					if (Purchase_price > 0 && Purchase_price <= 10000) {
						total_price += Purchase_price;
					} else {
						System.out.println("購入金額が上限を超えています");
						System.exit(0);
					}
				}
			}

			//配列に格納した日付をレシート枚数分だけ読み込む
			for (int i = 0; i < receiptNumber ; i++) {
				if (i < receiptNumber) {
					String day = aryList.get(i * 2);
					String money = aryList.get(i * 2 + 1);
					int moneys = Integer.parseInt(money);
					int days = Integer.parseInt(day);

					//日付は1～31までとする
					if (days > 0 && days < 32) {
						int Purchase_price = Integer.parseInt(day);

								//3のつく日と5のつく日とそれ以外の日ごとのポイントを加算
								if(days == 3 || days == 13 || days == 30 || days == 31){
									point = (int) (moneys * 0.03);
								} else if(days == 5 || days == 15 || days == 25) {
									point = (int) (moneys * 0.05);
								} else {
									point = (int) (moneys * 0.01);
								}
								total_point += point;
					} else {
						System.out.println("日付が不適切です");
						System.exit(0);
					}
				}
			}

		//合計購入金額と合計ポイントを出力
		System.out.println();
		System.out.println(total_price + "円");
		System.out.println(total_point + "ポイント");
		System.out.println();

		} catch (Exception ee) {
			System.out.println("\n" + "入力が不適切です");
		}
	}
}
