
import java.util.Random;

public class DriverClass {

	static CesearCipher Cipher;
	static FIleReader reader;
	static Writer write;
	
	public static void main(String[] args) {
		
		// This project is to obtain a key through brute force via diagrams
		// Commentation maybe vage due to lack of time
		
		// TODO Auto-generated method stub
		// I am going to use the cesear Cipher for my example of Monoaplphabetic Encryption
		// They key will be randomly generated 
		Random generator = new Random();
		Cipher = new CesearCipher(generator.nextInt(5) + 1);
		
		//ecrypt the Plain Text file with CesearCipher
		encryptFile(Cipher);
		
		//this function is to obtain a key through brute force 
		int key = ObtainKey(new CommonPairs(Cipher));
		
		if(key != -1)
		{
			//the key then used to decrypt the file 
			DecryptFile(Cipher,key);
		}

	}
	public static void DecryptFile(CesearCipher Cipher, int key)
		{
		
		// using they key obtained from Commonpairs we decrypt the file word by word
		// until we create the file again
			reader = new FIleReader();
			String line = "";
			while(reader.CypherTexthasNextLine())
				{
				 line += Cipher.decrypt(reader.getNextCypherText(), key);
				 line += " ";
				}
		
				write.WriteToFileAfterDecrypt(line);
		}
	
	public static void encryptFile(CesearCipher Cipher)
	{
		// Function is to ecnrypt the PlainText.txt into 
		// CypherText.txt
		 reader = new FIleReader();
		 write = new Writer();
		 String line = "";
		 while(reader.PlainTexthasNextLine()) 
		 	{
			 	line += Cipher.encrypt(reader.getNextPlainText());
			 	line += " " ;
 
		 	}
		 write.WriteToCyperText(line);
	}
	
	public static int ObtainKey(CommonPairs node)
	{
		//we will go through all the excrypted words until we get a key that is certainly it 
		
			while(reader.CypherTexthasNextLine())
			{
				//brute force atack will return -1 if it doesnt find a pattern within the word
				//otherwise it will return a key and return it back to main 
				int possiblekey = node.bruteforce(reader.getNextCypherText(), Cipher);
						
				if(possiblekey != -1 )
				{
					return possiblekey;
				}		
			}
		return -1;
	}
	

	
}
