package service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FlamesCheckService
{
// FlamesCheckService has a method findFlames to find the flames between two names
// char findFlames(String name1, String name2) takes two strings as arguments
	// Your task is to calculate the flames value and return the corresponding character as output 
	// You must return only the following values ['f','l','a','m','e','s']
	// change the return value at the end of the method corresponding to your return value
	public char findFlames(String name1, String name2)
	{
		ArrayList<Character> flames=new ArrayList<Character>();
		flames.add('f');
		flames.add('l');
		flames.add('a');
		flames.add('m');
		flames.add('e');
		flames.add('s');
		//Names should not be null
		try
		{
		
		//Find number of non common characters between names
		name1=name1.toLowerCase();
		name2=name2.toLowerCase();
		Set<Character> notCommonCharacter=new HashSet<Character>();
		int name1Length=name1.length();
		int name2Length=name2.length();
		int numberOfNonCommonCharacter=name1Length;
		for(int letter=0 ;letter<name1Length;letter++)
		{
			notCommonCharacter.add(name1.charAt(letter));
		}
		for(int letter=0 ;letter<name2Length;letter++)
		{
			if(notCommonCharacter.contains(name2.charAt(letter)))
			{
				notCommonCharacter.remove(name2.charAt(letter));
				numberOfNonCommonCharacter--;
			}
			else
			{
				numberOfNonCommonCharacter++;
			}
		}
		
		
		//Lopping through flames
		
		int charactersLeft=6;
		int currentChar=0;
		while(charactersLeft>1)
		{
			int remove=((numberOfNonCommonCharacter-1)%charactersLeft);
			int removeCharacter=( currentChar+remove)%charactersLeft;
			flames.remove(flames.get(removeCharacter));
			currentChar=removeCharacter;
			charactersLeft--;
		}
		
		
		}
		catch(NullPointerException ex)
		{
			System.out.println("Sorry Cannot perform FLAMES to person without name");
		}
		return flames.get(0);
		
	}
}

