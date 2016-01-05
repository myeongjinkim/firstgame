package view;

import entity.MyJFrame;

public class NewGameView {
	public NewGameView(MyJFrame mJfr, int Jfr_Xsize, int  Jfr_Ysize, int Jfr_Xlo, int Jfr_Ylo)
	{
		
		new SelectCharView(mJfr, Jfr_Xsize, Jfr_Ysize,Jfr_Xlo, Jfr_Ylo);
	
	}
}
