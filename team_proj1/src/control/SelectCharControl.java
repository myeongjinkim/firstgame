package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entity.MyJFrame;

public class SelectCharControl implements ActionListener{

	
	public SelectCharControl(MyJFrame mJfr, int Jfr_Xsize, int  Jfr_Ysize, int Jfr_Xlo, int Jfr_Ylo)
	{
		
		
	}

	public void notView(MyJFrame mJfr) {
		// TODO Auto-generated method stub
		mJfr.getJfr().setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
