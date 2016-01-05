package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import entity.MyJFrame;


public class MainMenuView{
	
	public MainMenuView(MyJFrame mJfr,int Jfr_Xsize,int Jfr_Ysize)
	{
		
		int Jpn_Xsize=280;
		int Jpn_Ysize=200;
		int Jfr_Xlo=500;
		int Jfr_Ylo=200;
		final ImageIcon icon1 = new ImageIcon(".\\img\\kakao.jpg");
		
		mJfr.setJpn1(new JPanel());
		JButton jbt1=new JButton("새로하기");
		JButton jbt2=new JButton("이어하기");
		JButton jbt3=new JButton("종료");
		
		mJfr.getJfr().setBounds(Jfr_Xlo, Jfr_Ylo, Jfr_Xsize, Jfr_Ysize);
		mJfr.getJfr().setLayout(null);
		
		mJfr.getJpn1().setBounds((Jfr_Xsize-Jpn_Xsize)/2, (int)(Jfr_Ysize-Jpn_Ysize*1.5), Jpn_Xsize, Jpn_Ysize);
		mJfr.getJpn1().setLayout(new GridLayout(3,1));
		
		mJfr.setJpn2( new JPanel(){
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
                g.drawImage(icon1.getImage(), 0, 0, Jfr_Xsize, Jfr_Ysize, null);
               
               } 
        });
        
		mJfr.getJpn2().setBounds(0, 0, Jfr_Xsize, Jfr_Ysize);
		mJfr.getJpn2().setLayout(new BorderLayout());
		
		
		//mJfr.getBt1().setBackground(Color.white);
		//mJfr.getBt2().setBackground(Color.white);
		//mJfr.getBt3().setBackground(Color.white);

		mJfr.getJpn1().add(jbt1);
		mJfr.getJpn1().add(jbt2);
		mJfr.getJpn1().add(jbt3);
		
		mJfr.getJfr().add(mJfr.getJpn1());
		mJfr.getJfr().add(mJfr.getJpn2());
		
		mJfr.getJfr().setVisible(true);
		mJfr.getJfr().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mJfr.getJfr().setResizable(false); 
		jbt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mJfr.getJfr().remove(mJfr.getJpn1());
				mJfr.getJfr().remove(mJfr.getJpn2());
				mJfr.getJpn1().repaint();
				new NewGameView(mJfr,Jfr_Xsize, Jfr_Ysize, Jfr_Xlo, Jfr_Ylo);
			}
		});
		jbt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mJfr.getJfr().remove(mJfr.getJpn1());
				mJfr.getJfr().remove(mJfr.getJpn2());
				mJfr.getJpn1().repaint();
				
				new LoadGameView(mJfr,Jfr_Xsize, Jfr_Ysize,Jfr_Xlo, Jfr_Ylo);	
			}
		});
		jbt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mJfr.getJfr().remove(mJfr.getJpn1());
				mJfr.getJfr().remove(mJfr.getJpn2());
				System.exit(0);
			}
		});
		mJfr.getJfr().setVisible(true);
		mJfr.getJfr().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mJfr.getJfr().setResizable(false);
	}
	
	
}
