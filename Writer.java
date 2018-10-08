
import java.io.*;
public class Writer {

	private FileWriter cyperText;
	private FileWriter FileafterDecrypt;
	
	public Writer()
	{
		try {
		PrintWriter file = new PrintWriter("FrequencyAttack/CypherText.txt");
		File CyperText = new File ("FrequencyAttack/CypherText.txt");
		cyperText = new FileWriter(CyperText);
		
		File Fileafterdecrypt = new File ("FrequencyAttack/FileAfterDecrypt.txt");
		FileafterDecrypt = new FileWriter(Fileafterdecrypt);
		
		file.close();
		}catch(Exception ex)
		{
			System.out.println("The file CyperText does not exist");
		}
		
	}
	
	public void WriteToCyperText(String Encrypted)
	{
		try {
		cyperText.write(Encrypted);
		cyperText.close();
		}catch(Exception ex)
		{
			System.out.println("Error Writing to CyperText File");
		}
	}
	
	public void WriteToFileAfterDecrypt(String PlainText)
	{
		try {
			FileafterDecrypt.write(PlainText);
			FileafterDecrypt.close();
		}catch(Exception ex)
		{
			System.out.println("Error Writing to File After Decrypt");
		}
	}
}
