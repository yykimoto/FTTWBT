package yykimoto.javatter.plugin.flytothewest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import twitter4j.TwitterException;

import com.orekyuu.javatter.account.TwitterManager;
import com.orekyuu.javatter.util.SaveData;
import com.orekyuu.javatter.util.TwitterUtil;
import com.orekyuu.javatter.view.IJavatterTab;

public class FlyWView implements IJavatterTab, ActionListener {

	SaveData sv;
	public TwitterUtil util;
	private int now = 0;
	view pane;

	public FlyWView() {
		util = new TwitterUtil();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public Component getComponent() {
		return new view();
	}

	public void nextNow(int i) {
		now = i;

	}

	public void message(String s) {
		try {
			util.tweet(FlyWPlugin.twi, s);
		} catch (TwitterException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public class view extends JPanel {
		JScrollPane citiesPane;

		public int paris = 41;

		public void reload() {
			citiesPane = new JScrollPane();
			citiesPane.setLayout(null);
			citiesPane.setBounds(0, 0, this.getWidth(), 30);
			for (int i = 0; i < paris; i++) {
				JLabel lab = new JLabel();
				System.out.println("ok");
				lab.setText(i == now ? FlyWPlugin.cities[i].name + "◀"
						: FlyWPlugin.cities[i].name);
				lab.setBounds(0, 15 * i, 100, 15);
				citiesPane.add(lab);
			}
		}

		public view() {
			this.setLayout(new BorderLayout());

			reload();
			this.add(citiesPane, BorderLayout.CENTER);

		}
	}
}
