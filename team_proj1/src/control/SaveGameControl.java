package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entity.AllChar;
import entity.MyJFrame;

public class SaveGameControl implements ActionListener {

	public SaveGameControl(MyJFrame mJfr, AllChar myCh, int Jfr_Xsize, 
			int Jfr_Ysize, int jfr_Xlo, int jfr_Ylo, int myX, int myY) {
		// TODO Auto-generated constructor stub
		
		
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
