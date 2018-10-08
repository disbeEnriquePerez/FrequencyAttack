
import java.util.*;
import java.io.*;
public class FIleReader {

	private Scanner CypherText;
	private Scanner PlainText;
	private File cyperText;
	
	public FIleReader()
	{
		
		cyperText = new File("FrequencyAttack/CypherText.txt");
		File plainText = new File("FrequencyAttack/PlainText.txt");
		
		try {
		
		PlainText = new Scanner(plainText);
		CypherText = new Scanner(cyperText);
		}catch(Exception ex)
		{
			System.out.println("The file to read from PlainText does not exist");	
			ex.printStackTrace();
		}
	}
	
	public void createScannerForCypherText()
	{
		try {
		CypherText = new Scanner(cyperText);
		
		}catch(Exception ex)
		{
			System.out.println("The file to read from CypherText does not exist");
		}
	}
	
	
	public boolean PlainTexthasNextLine()
	{
		if(PlainText.hasNext())
		{
			return true;
		}else 
			return false;
	}
	public boolean CypherTexthasNextLine()
	{
		if(CypherText.hasNext())
		{
			return true;
		}else
			return false;
	}
	
	public String getNextPlainText()
	{
		
		return PlainText.next();
	}
	
	public String getNextCypherText()
	{
		return CypherText.next();
	}
}
