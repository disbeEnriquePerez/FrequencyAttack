

public class CesearCipher {

	private String EncryptedWord;
	private int key;
	
	
	public CesearCipher(int key)
	{
		this.key = key;		
	}

	public  String decrypt(String CipherText, int key) {
		char[] array = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		String newString = "";
		
		
		for(int index = 0 ; index < CipherText.length() ; ++ index)
		{
			char letter = CipherText.charAt(index);
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

	public  String encrypt(String Plaintext)
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
			this.EncryptedWord = newString;
		return newString;
		
	}
	
	public String get_Encrypted(){
		
		return EncryptedWord;
	}
}
