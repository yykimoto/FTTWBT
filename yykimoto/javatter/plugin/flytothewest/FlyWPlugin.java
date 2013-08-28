package yykimoto.javatter.plugin.flytothewest;

import twitter4j.Twitter;
import twitter4j.TwitterException;

import com.orekyuu.javatter.plugin.ITweetListener;
import com.orekyuu.javatter.plugin.JavatterPlugin;
import com.orekyuu.javatter.util.TwitterUtil;
import com.orekyuu.javatter.view.IJavatterTab;
import com.orekyuu.javatter.view.MainWindowView;

public class FlyWPlugin extends JavatterPlugin implements ITweetListener {

	public boolean isFly;
	public int flyTimes;
	public int arroundTimes;
	public int city;
	public int engine = 10;
	public static City[] cities = { new City("名古屋", 61), new City("津", 74),
			new City("大津", 43), new City("大阪", 28), new City("神戸", 33),
			new City("加古川", 57), new City("小豆島", 37), new City("大都会岡山", 107),
			new City("今治", 60), new City("広島", 93), new City("山口", 84),
			new City("北九州", 55), new City("福岡", 36), new City("佐賀", 71),
			new City("長崎", 44), new City("天草", 101), new City("鹿児島", 125),
			new City("種子島", 45), new City("屋久杉", 243), new City("奄美", 301),
			new City("那覇", 286), new City("宮古島", 124), new City("石垣島", 124),
			new City("日本の西端", 154), new City("台北", 815), new City("香港", 870),
			new City("ハノイ", 870), new City("ヤンゴン", 976),
			new City("ニューデリー", 1095), new City("カラチ", 1638),
			new City("メッカ", 1239), new City("エルサレム", 414),
			new City("ニコシア", 916), new City("アテネ", 1052),
			new City("ヴェネツィア", 395), new City("ミラノ", 126),
			new City("トリノ", 178), new City("カンヌ", 305), new City("ジュネーヴ", 112),
			new City("リヨン", 392), new City("パリ", 344), new City("ロンドン", 287),
			new City("リバプール", 217), new City("ダブリン", 5125),
			new City("ニューヨーク", 2288), new City("ヒューストン", 2645),
			new City("Twitter本社", 3860), new City("ホノルル", 6149),
			new City("成田空港", 31), new City("千葉", 32), new City("東京", 28),
			new City("横浜", 21), new City("座間", 63), new City("富士山", 53),
			new City("静岡", 77), new City("浜松", 66), new City("豊田", 25) };
	FlyWView view = new FlyWView();
	public static Twitter twi;

	@Override
	public void init() {
		getSaveData().setDefaultValue("isfly", true);
		getSaveData().setDefaultValue("flytimes", 0);
		getSaveData().setDefaultValue("engine", 0);
		getSaveData().setDefaultValue("paris", 41);

		twi = twitter;
		addTweetListener(this);
		addMenuTab("FlyW", view);
		return;
	}

	@Override
	public String getPluginName() {
		return "FlyW";
	}

	@Override
	public String getVersion() {
		return "v1.0 Nagoya";
	}

	@Override
	protected IJavatterTab getPluginConfigViewObserver() {
		return new FlyWView();
	}

	public void incFlyTimes() {
		flyTimes++;
		getSaveData().setInt("flytimes", flyTimes);
		if (cities[city].interval == flyTimes) {
			city++;
			switch (city) {
			case 0:
				arroundTimes++;
				view.message(cities[city].name + "に到着しました。" + arroundTimes
						+ "回目の世界一周です。よっしゃよっしゃ #FlyWest");
				break;
			case 18:
				view.message(cities[city].name
						+ "に到着しました。よっしゃよっしゃ #FlyWest");
				view.message("エンジンを国内用から遠距離用1に切り替えました");
				engine = 40;
			case 24:
				view.message(cities[city].name
						+ "に到着しました。よっしゃよっしゃ #FlyWest");
				view.message("エンジンを遠距離用1から遠距離用2に切り替えました");
				engine = 100;
			case 34:
				view.message(cities[city].name
						+ "に到着しました。よっしゃよっしゃ #FlyWest");
				view.message("エンジンを国内用から遠距離用1に切り替えました");
				engine = 40;
			case 40:
				view.message("パリに到着しました。よっしゃよっしゃ。 ですが我々の旅はこれだけではありません。 さらに西へ向かい、名古屋を目指すのです #FlyWest");
			case 48:
				view.message(cities[city].name
						+ "に到着しました。よっしゃよっしゃ #FlyWest");
				view.message("エンジンを遠距離用2から国内用に切り替えました");

			case 31:
				view.message(cities[city].name
						+ "に到着しました。よっしゃよっしゃ #FlyWest");
				view.message((arroundTimes + 1) + "回目の千葉滋賀佐賀達成しました");
			default:
				view.message(cities[city].name
						+ "に到着しました。よっしゃよっしゃ #FlyWest");
			}
		}
	}

	@Override
	public String onTweet(String arg0) {
		for (int i = 0; i < getSaveData().getInt("engine"); i++) {

		}

		return arg0;
	}

	public static class City {
		String name;
		int interval;

		public City(String name, int interval) {
			this.name = name;
			this.interval = interval;
		}

	}

}
