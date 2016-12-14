import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// This class will be able to read in the CSV file for the cards once it is created and finalized

public class CardReader 
{
	public Card[] loadCards() 
	{
		Card[] allCards = new Card[300];
		int cardCount = 0;
		
		BufferedReader cardReader = null;
		
		try 
		{

			String currLine;
			cardReader = new BufferedReader(new FileReader("C:\\Temp\\Upgrades.csv"));
			
			// Eats first line nom nom nom
			cardReader.readLine();
			/*
			while ((currLine = cardReader.readLine()) != null) 
			{				
				String[] splitData = currLine.split(",");
				allCards[cardCount] = new UpgradeCard(splitData[0], Integer.parseInt((splitData[1])), AFFINITY.valueOf(splitData[2]), UPGRADE.valueOf(splitData[3]));
				
				cardCount++;
				//System.out.println("Raw CSV data: " + allCards[cardCount] + "\n");
			}
			*/
			
			cardReader.close();
			
			
			cardReader = new BufferedReader(new FileReader("C:\\Temp\\Equipment.csv"));
			
			// Eats first line nom nom nom
			cardReader.readLine();
			
			while ((currLine = cardReader.readLine()) != null) 
			{				
				String[] splitData = currLine.split(",");
				
				//determine size of passivesArray
				int passiveCount = 0;
				if (splitData[5].equals("")) passiveCount = 0;
				else if (splitData[6].equals("")) passiveCount = 1;
				else if (splitData[7].equals("")) passiveCount = 2;
				else if (splitData[8].equals("")) passiveCount = 3;
				else passiveCount = 4;
				
				UPGRADE[] passives = new UPGRADE[passiveCount];
				for (int n=5, m=0; m<passiveCount; n++, m++)
				{
					passives[m] = UPGRADE.valueOf(splitData[n]);
				}
				
				int fillBonusCount = 0;
				if (splitData[9].equals("")) fillBonusCount = 0;
				else if (splitData[10].equals("")) fillBonusCount = 1;
				else fillBonusCount = 2;

				UPGRADE[] fillBonus = new UPGRADE[fillBonusCount];
				for (int n=9, m=0; m<fillBonusCount; n++, m++)
				{
					fillBonus[m] = UPGRADE.valueOf(splitData[n]);
				}
				
				allCards[cardCount] = new EquipmentCard(splitData[0], Integer.parseInt((splitData[1])), AFFINITY.valueOf(splitData[2]), Boolean.valueOf(splitData[3]), Boolean.valueOf(splitData[4]), passives, fillBonus);	
				
				cardCount++;
			}
			cardReader.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				if (cardReader != null)
				{
					cardReader.close();
				}
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		return allCards;
	}	
}

