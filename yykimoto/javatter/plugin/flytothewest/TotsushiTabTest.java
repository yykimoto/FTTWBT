package yykimoto.javatter.plugin.flytothewest;

import java.awt.BorderLayout;
import java.awt.Container;

import org.junit.Test;
import javax.swing.*;

@SuppressWarnings("serial")
public class TotsushiTabTest extends JFrame {

	public TotsushiTabTest() {
		Container cont = getContentPane();
		cont.add(BorderLayout.CENTER, new FlyWView().getComponent());
	}

	@Test
	public void test() {
		new TotsushiTabTest().setVisible(true);
		//for(;;);
	}

}
