import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// This class will be able to read in the CSV file for the cards once it is created and finalized

public class CardReader 
{
	public static void main(String[] args) 
	{
		Card[] allCards;
		
		BufferedReader cardReader = null;
		
		try 
		{

			String card;
			cardReader = new BufferedReader(new FileReader("location of file goes here"));
			
			// How to read file in java line by line?
			while ((card = cardReader.readLine()) != null) 
			{
				String[] splitData = card.split(",");
				
				//TODO: Instead of a generic card, we are going to have Equipment cards and Upgrade cards
				/* if ("E".equals(splitData[0]))
						EquipmentCard card = new EquipmentCard();
				else if ("U".equals(splitData[0]))
					UpgradeCard card = new UpgradeCard(); */
				
				card.setName(splitData[0]);
				card.setCost(splitData[1]);
				card.setAffinity(splitData[2]);
				
				// n = first upgrade
				// splitData[3] should contain number of upgrades
				
				//TODO: we will need to include addUpgrade and addFillBonus into the card class
				int passiveOffset = 5;
				int numPassives = splitData[3];
				for(int n=passiveOffset; n<passiveOffset+numPassives; n++)
				{
					card.addUpgrade(splitData[n]);
				}
				
				int bonusOffset = passiveOffset+numPassives;
				int numBonuses = splitData[4];
				for(int n = bonusOffset; n<bonusOffset+numBonuses; n++)
				{
					card.addFillBonus(splitData[n]);
				}
				
					
				
				System.out.println("Raw CSV data: " + card);
			}
			
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
	}	
}

