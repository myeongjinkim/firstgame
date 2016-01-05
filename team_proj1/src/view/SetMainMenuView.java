package view;

import javax.swing.JFrame;

import entity.MyJFrame;

public class SetMainMenuView {
	public SetMainMenuView()
	{
		int Jfr_Xsize=800;
		int Jfr_Ysize=500;
		MyJFrame mJfr = new MyJFrame();
		mJfr.setJfr(new JFrame());
		new MainMenuView(mJfr, Jfr_Xsize,Jfr_Ysize);
	}
}
