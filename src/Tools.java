final class Tools{
	
	private Tools(){};
	
	/*
	 * Temp function until Hero loader is completed
	 */
	static AFFINITY[] getHeroAffinity(HERONAME name)
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
			myAffinities[0] = AFFINITY.INTELLIGENCE;
			myAffinities[1] = AFFINITY.ORDER;
			break;
			case NARBASH:
			myAffinities[0] = AFFINITY.GROWTH;
			myAffinities[1] = AFFINITY.INTELLIGENCE;
			break;
			case THEFEY:
			myAffinities[0] = AFFINITY.GROWTH;
			myAffinities[1] = AFFINITY.INTELLIGENCE;
			break;
			case GREYSTONE:
			myAffinities[0] = AFFINITY.FURY;
			myAffinities[1] = AFFINITY.INTELLIGENCE;
			break;
			case KHAIMERA:
			myAffinities[0] = AFFINITY.GROWTH;
			myAffinities[1] = AFFINITY.FURY;
			break;
			case RIKTOR:
			myAffinities[0] = AFFINITY.INTELLIGENCE;
			myAffinities[1] = AFFINITY.CORRUPTION;
			break;
			case GRIMEXE:
			myAffinities[0] = AFFINITY.INTELLIGENCE;
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
			myAffinities[1] = AFFINITY.INTELLIGENCE;
			break;
			case STEEL:
			myAffinities[0] = AFFINITY.INTELLIGENCE;
			myAffinities[1] = AFFINITY.ORDER;
			break;
			case GADGET:
			myAffinities[0] = AFFINITY.INTELLIGENCE;
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
			myAffinities[0] = AFFINITY.INTELLIGENCE;
			myAffinities[1] = AFFINITY.CORRUPTION;
			break;
			case GIDEON:
			myAffinities[0] = AFFINITY.INTELLIGENCE;
			myAffinities[1] = AFFINITY.CORRUPTION;
			break;
			case MURDOCK:
			myAffinities[0] = AFFINITY.FURY;
			myAffinities[1] = AFFINITY.INTELLIGENCE;
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
	
	/*
	 * Temp function until Hero loader is completed
	 */
	static ROLE getHeroRole(HERONAME name)
	{
		if (name == HERONAME.CRUNCH || name == HERONAME.KWANG || name == HERONAME.GREYSTONE ||
			name == HERONAME.KHAIMERA|| name == HERONAME.FENGMAO || name == HERONAME.GRUX)
			return ROLE.FIGHTER;
		
		else if (name == HERONAME.COUNTESS || name == HERONAME.KALLARI)
			return ROLE.ASSASSIN;
		
		else if (name == HERONAME.LTBELICA || name == HERONAME.IGGYSCORCH || name == HERONAME.HOWITZER ||
				 name == HERONAME.GADGET || name == HERONAME.GIDEON)
			return ROLE.CASTER;
		
		else if (name == HERONAME.NARBASH || name == HERONAME.RIKTOR || name == HERONAME.SEVAROG ||
				 name == HERONAME.STEEL || name == HERONAME.RAMPAGE)
			return ROLE.TANK;
		
		else if (name == HERONAME.THEFEY || name == HERONAME.DEKKER || name == HERONAME.MURIEL)
			return ROLE.SUPPORT;
		
		else if (name == HERONAME.GRIMEXE || name == HERONAME.TWINBLAST || name == HERONAME.MURDOCK ||
				 name == HERONAME.SPARROW)
			return ROLE.RANGER;
		
		else return ROLE.RANGER;
	}
	
	/*
	 * Temp function until Hero loader is completed
	 */
	static double getHeroCardScale(ROLE role)
	{
		if (role == ROLE.ASSASSIN)
			return 0.8;
		else if (role == ROLE.CASTER)
			return 0.4;
		else if (role == ROLE.FIGHTER)
			return 0.8;
		else if (role == ROLE.RANGER)
			return 1.0;
		else if (role == ROLE.SUPPORT)
			return 0.4;
		else if (role == ROLE.TANK)
			return 0.8;
		
		return 0.0;
	}
}