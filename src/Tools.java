package res;
import res.CONSTANTS.AFFINITY;
import res.CONSTANTS.HERONAME;

public final class Tools{
	
	private Tools(){};
	
	/*
	 * Temp function until Hero loader is completed
	 */
	public static AFFINITY[] getHeroAffinity(HERONAME name)
	{
		AFFINITY[] myAffinities = new AFFINITY[2];
		
		switch(name)
		{
			case CRUNCH:
			myAffinities[0] = AFFINITY.FURY;
			myAffinities[1] = AFFINITY.ORDER;
			break;
			case COUNTESS:
			myAffinities[0] = AFFINITY.GROWTH;
			myAffinities[1] = AFFINITY.CORRUPTION;
			break;
			case KWANG:
			myAffinities[0] = AFFINITY.ORDER;
			myAffinities[1] = AFFINITY.CORRUPTION;
			break;
			case LTBELICA:
			myAffinities[0] = AFFINITY.INTELLECT;
			myAffinities[1] = AFFINITY.ORDER;
			break;
			case NARBASH:
			myAffinities[0] = AFFINITY.GROWTH;
			myAffinities[1] = AFFINITY.INTELLECT;
			break;
			case THEFEY:
			myAffinities[0] = AFFINITY.GROWTH;
			myAffinities[1] = AFFINITY.INTELLECT;
			break;
			case GREYSTONE:
			myAffinities[0] = AFFINITY.FURY;
			myAffinities[1] = AFFINITY.INTELLECT;
			break;
			case KHAIMERA:
			myAffinities[0] = AFFINITY.GROWTH;
			myAffinities[1] = AFFINITY.FURY;
			break;
			case RIKTOR:
			myAffinities[0] = AFFINITY.INTELLECT;
			myAffinities[1] = AFFINITY.CORRUPTION;
			break;
			case GRIMEXE:
			myAffinities[0] = AFFINITY.INTELLECT;
			myAffinities[1] = AFFINITY.CORRUPTION;
			break;
			case IGGYSCORCH:
			myAffinities[0] = AFFINITY.FURY;
			myAffinities[1] = AFFINITY.CORRUPTION;
			break;
			case SEVAROG:
			myAffinities[0] = AFFINITY.GROWTH;
			myAffinities[1] = AFFINITY.CORRUPTION;
			break;
			case HOWITZER:
			myAffinities[0] = AFFINITY.FURY;
			myAffinities[1] = AFFINITY.INTELLECT;
			break;
			case STEEL:
			myAffinities[0] = AFFINITY.INTELLECT;
			myAffinities[1] = AFFINITY.ORDER;
			break;
			case GADGET:
			myAffinities[0] = AFFINITY.INTELLECT;
			myAffinities[1] = AFFINITY.ORDER;
			break;
			case TWINBLAST:
			myAffinities[0] = AFFINITY.FURY;
			myAffinities[1] = AFFINITY.GROWTH;
			break;
			case RAMPAGE:
			myAffinities[0] = AFFINITY.GROWTH;
			myAffinities[1] = AFFINITY.FURY;
			break;
			case DEKKER:
			myAffinities[0] = AFFINITY.GROWTH;
			myAffinities[1] = AFFINITY.ORDER;
			break;
			case KALLARI:
			myAffinities[0] = AFFINITY.INTELLECT;
			myAffinities[1] = AFFINITY.CORRUPTION;
			break;
			case GIDEON:
			myAffinities[0] = AFFINITY.INTELLECT;
			myAffinities[1] = AFFINITY.CORRUPTION;
			break;
			case MURDOCK:
			myAffinities[0] = AFFINITY.FURY;
			myAffinities[1] = AFFINITY.INTELLECT;
			break;
			case FENGMAO:
			myAffinities[0] = AFFINITY.FURY;
			myAffinities[1] = AFFINITY.ORDER;
			break;
			case MURIEL:
			myAffinities[0] = AFFINITY.GROWTH;
			myAffinities[1] = AFFINITY.ORDER;
			break;
			case SPARROW:
			myAffinities[0] = AFFINITY.GROWTH;
			myAffinities[1] = AFFINITY.ORDER;
			break;
			case GRUX:
			myAffinities[0] = AFFINITY.FURY;
			myAffinities[1] = AFFINITY.CORRUPTION;
			break;	
		}		
		
		return myAffinities;
	}
}