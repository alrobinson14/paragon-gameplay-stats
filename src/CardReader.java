package deckBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// This class will be able to read in both the upgrade card CSV and the equipment card CSV

public class CardReader 
{
	public ArrayList<Card> loadCards() 
	{
		ArrayList<Card> allCards = new ArrayList<Card>();
		BufferedReader cardReader = null;
		
		try 
		{
			cardReader = new BufferedReader(new FileReader("C:\\Temp\\Upgrades.csv"));
			// Eats first line.
			String currLine = cardReader.readLine();	
			
			while ((currLine = cardReader.readLine())!=null) 
			{	
			String[] splitData = currLine.split(",");
			allCards.add(new UpgradeCard(splitData[0], splitData[1], splitData[2], splitData[3]));
			}
			cardReader.close();		
		}
		
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		
		
		
		try 
		{
			cardReader = new BufferedReader(new FileReader("C:\\Temp\\Equipment.csv"));
			// Eats first line.
			String currLine = cardReader.readLine();	
			
			while ((currLine = cardReader.readLine())!=null) 
			{	
			String[] splitData = currLine.split(",");
			//Name
			String name = splitData[0].substring(1, splitData[0].length()-1);
			String cost = splitData[1].substring(1, splitData[1].length()-1);
			String affinity = splitData[2].substring(1, splitData[2].length()-1);
			String active = splitData[3].substring(1, splitData[3].length()-1);
			String slotted = splitData[4].substring(1, splitData[4].length()-1);
			ArrayList<String> upgrades = new ArrayList<>();
			ArrayList<String> fillBonus = new ArrayList<>();
			
			
			for (int n = 5; n<16; n++)
			{
				if ("\"\"".equals(splitData[n]))
					continue;
				else
				{
					upgrades.add(splitData[n].substring(1, splitData[n].length()-1));
				}
			}
			
			for (int n = 16; n<18; n++)
			{
				if ("\"\"".equals(splitData[n]))
					continue;
				else
					fillBonus.add(splitData[n].substring(1, splitData[n].length()-1));
			}

			String unique = splitData[19].substring(1,  splitData[19].length()-1);
						
			allCards.add(new EquipmentCard(name, cost, affinity, active, slotted, upgrades, fillBonus, unique));
			}
			cardReader.close();		
		}
		
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		
		return allCards;
	}	
}

