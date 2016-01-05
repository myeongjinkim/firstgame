package entity;

public class Apeach extends AllChar implements MyChar{
	
	int x,y;
	public Apeach()
	{
		hp=level*100;
		mp=level*50;
		name="¾îÇÇÄ¡";
		attack=level*5;
	}
	public void setLevel(int level)
	{
		this.level = level;
		hp=level*100;
		nhp=hp;
		mp=level*50;
		nmp=mp;
		attack=level*5;
		mexe=level*10;
		nexe=0;
	}
	

	@Override
	public int getMX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void setMX(int x) {
		// TODO Auto-generated method stub
		this.x=x;
	}

	@Override
	public int getMY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setMY(int y) {
		// TODO Auto-generated method stub
		this.y=y;
	}
}
