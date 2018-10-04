package FrequencyAttack;
import java.util.Random;

public class CesearCipher {

	private String EncryptedWord;

	public static String decrypt(String Plaintext, int key) {
		char[] array = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		String newString = "";
		
		for(int index = 0 ; index < Plaintext.length() ; ++ index)
		{
			char letter = Plaintext.charAt(index);
			for(int index2 = 0 ; index2 <array.length; ++index2)
			{
				if(letter == array[index2])
				{
					int value = (index2 - key + 26) % 26;
					newString += array[value];
				}
			}
		}
		return newString;
	}

	public static String encrypt(String Plaintext, int key)
	{
		char[] array = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		 
		String Lowercase = Plaintext.toLowerCase();		
		String newString = "";
		
		for(int index = 0 ; index < Plaintext.length(); ++ index)
		{
			char letter = Lowercase.charAt(index);
			for(int index2 = 0 ; index2 < array.length ; ++index2)
			{
				if(letter == array[index2])
				{
						int value = (index2 + key) % 26; 
						newString += array[value];	
				}
			}
		}
		return newString;
		
	}
	
	public String get_Encrypted(){
		
		return EncryptedWord;
	}
}
