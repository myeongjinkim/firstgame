package DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

import entity.AllChar;
import entity.Apeach;
import entity.Muji;
import entity.Tube;

public class CharSaveDAO {
	HashMap<String, String> hMap;
	public CharSaveDAO(AllChar myCh,int n)
	{
		hMap = new HashMap<String, String>();
		makeHashMap(myCh);
		save(n);
	}

	public CharSaveDAO() {
		// TODO Auto-generated constructor stub
	}


	void makeHashMap(AllChar myCh)
	{
		hMap.put("char", myCh.getName());
		hMap.put("lv", String.valueOf(myCh.getLevel()));
		hMap.put("nHp", String.valueOf(myCh.getNHp()));
		hMap.put("nMp", String.valueOf(myCh.getNMp()));
		hMap.put("nexe", String.valueOf(myCh.getNexe()));
		
	}
	public void save(int n)
	{

		FileWriter FWGangJwa;
		try
		{
			FWGangJwa= new FileWriter("Char"+n+".txt");
			FWGangJwa.write(hMap.get("char")+" ");
			FWGangJwa.write(hMap.get("lv")+" ");
			FWGangJwa.write(hMap.get("nHp")+" ");
			FWGangJwa.write(hMap.get("nMp")+" ");
			FWGangJwa.write(hMap.get("nexe")+" ");
			FWGangJwa.write("\r\n");
			FWGangJwa.close();
		} catch(Exception e)
		{
			System.out.println("저장하는 과정에서 문제가 생겼습니다.\n");
		}
	}
	public AllChar load(int n)
	{
		String fileName = "Char"+n+".txt";
		Scanner charScan = null;
		try {
			charScan = new Scanner(new File(fileName));
			String name = charScan.next();
			AllChar myCh;
			if(name.equals("어피치"))
			{
				myCh = new Apeach();
			}
			else if(name.equals("무지"))
			{
				myCh = new Muji();
			}
			else
			{
				System.out.println(name);
				myCh = new Tube();
			}
			myCh.setName(name);
			myCh.setLevel(Integer.valueOf(charScan.next()));
			myCh.setNHp(Integer.valueOf(charScan.next()));
			myCh.setNMp(Integer.valueOf(charScan.next()));
			myCh.setNexe(Integer.valueOf(charScan.next()));
			charScan.close();
			myCh.loadSet(myCh.getLevel());
			return myCh;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
		
	}
}
