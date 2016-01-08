package entity;

public class AllChar {
	String name="∏ÛΩ∫≈Õ";
	int level;
	int hp=level*10;
	int nhp;
	int nmp;
	int mp=level*5;
	int attack=level;
	int mexe=level*10;
	int nexe;
	boolean isAttack=false;
	boolean isSkill=false;
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getLevel() {return level;}
	public void loadSet(int level)
	{
		hp=level*10;
		mp=level*5;
		attack=level*10;
		mexe=level*10;
	}
	public void setLevel(int level)
	{
		this.level = level;
		hp=level*10;
		nhp=hp;
		mp=level*5;
		nmp=mp;
		attack=level*10;
		nexe=0;
		mexe=level*10;
	}
	public void levelUp()
	{
		level++;
		hp=level*100;
		nhp=hp;
		nmp=mp;
		mp=level*50;
		attack=level*5;
		mexe=level*10;
		nexe=0;
	}
	public int getHp() {return hp;}
	public int getNHp() {return nhp;}
	public void setNHp(int nhp) {this.nhp= nhp;}
	
	public int getNMp() {return nmp;}
	public void setNMp(int nmp) {this.nmp= nmp;}
	
	public int getMp() {return mp;}
	public int getAttack() {return attack;}
	public void attacked(int Aatk)
	{
		nhp=nhp-Aatk;
	}
	public int getMexe() {return mexe;}
	public void setMexe(int mexe) {this.mexe = mexe;}
	public int getNexe() {return nexe;}
	public void setNexe(int nexe) {this.nexe = nexe;}
	
	public boolean getIsSkill() {return isSkill;}
	public void setIsSkill(boolean isSkill) {this.isSkill = isSkill;}
	
	public boolean getIsAttack() {return isAttack;}
	public void setIsAttack(boolean isAttack) {this.isAttack = isAttack;}
	
}
