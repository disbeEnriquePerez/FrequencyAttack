package FrequencyAttack;

public class CommonPairs {

	
	
	char[] Alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	String[] pairs = {"th", "on","he","an","in","er","nd","re","ed","es","ou","to","ha","en","ea"};
	int[] distancepairs = {12, 1,3,13,5,13,10,13,1,14,6,5,7,9,4};
	private String line; 
	ToptenCipers returnciper;
	CesearCipher Cipher;
	boolean status = true;
	ToptenCipers Node;
	
	int cou ;
	int SHIFT;
	public CommonPairs(String line, ToptenCipers node, CesearCipher Cipher){
		this.line = line;
		this.Cipher = Cipher;
		Node = new ToptenCipers();
		if(line.length() > 1) {
			for(int index = 0; index < line.length() -1 ; ++ index){
				cou = index;
				DistanceBetweenTwoLetters(index); 
				
			}
		}else {
			
			//REMEBER TO PUT HERE PLACE THE LETTER BACK INTO OBECT TOP TEN CIPERS
		}
		
	}
	
	// qvjgt
	// qv = 5
	// vj = 12
	// jg =3
	// gt = 13
	public void CheckNodes(int index) {
		if(Node.LastNodehasNext())
		{
				char Letter1,Letter2;
				char CLetter1,CLetter2;
				String pair;
				
				if(line.length() % 2 == 1)
					{
						for(int lineIndex = 0; lineIndex  < line.length() -3 ; lineIndex += 2)
							{
								pair = Node.getTailString();
								System.out.println(pair);
								if(CheckDistancebetweenletters(line.charAt(lineIndex),line.charAt(lineIndex + 1),pair.charAt(0),pair.charAt(1)))
										{
											System.out.println(Cipher.decrypt(line, SHIFT));
										}
							}
				  }else
				{
					  	for(int lineIndex = 0; lineIndex < line.length() -2 ; lineIndex += 2)
					  		{
					  			pair = Node.getTailString();
					  			if(CheckDistancebetweenletters(line.charAt(lineIndex),line.charAt(lineIndex + 1),pair.charAt(0),pair.charAt(1))) 
					  				{
					  					System.out.println(Cipher.decrypt(line, SHIFT));
					
					  				}
				
					  		}
			
				}
		
		}
	}
	//v				j			  t				h
	private boolean CheckDistancebetweenletters(char letter1,char letter2, char Cletter1,char Cletter2) {
		boolean DistanceTheSame = false;
		int index = 2;
		
		while(Node.TailhasPrevious() && (!DistanceTheSame))
		{
			
			
			String pair2 = Node.getTailString();
			//		e				r
			System.out.println(pair2);
			int dis = TwoLetters(letter1,Cletter1);
			int dis2 = TwoLetters(letter2,Cletter2);
			int dis3 = TwoLetters(line.charAt(index),pair2.charAt(0)); 
			int dis4 = TwoLetters(line.charAt(index+1), pair2.charAt(1));
			
			if(dis == dis2)
				if(dis2 == dis3) 
					if(dis3==dis4) {
							SHIFT = dis;
							DistanceTheSame= true;
								
					}
				
		}
		return DistanceTheSame;
	}

	private int TwoLetters(char letter1, char letter2) {
			
		int distance = 0 , distance2 = 0;
		for(int indexForArray = 0 ; indexForArray < Alphabet.length ; ++indexForArray)
		{
			if(letter1 == Alphabet[indexForArray])
			{
				distance = indexForArray;
			}
			if(letter2 == Alphabet[indexForArray])
			{
				distance2 = indexForArray;
			}
		}
		

		return distance2 - distance;
		}

	//  q v j g t 
	public void DistanceBetweenTwoLetters(int index)
	{
		int distanceindex1 = 0 , distanceindex2 = 0 ;
		if(line.length() - 1 > index + 1) 
		{
			for(int AlpaIndex = 0; AlpaIndex < Alphabet.length ; ++AlpaIndex)
			{
		
				if(line.charAt(index) == Alphabet[AlpaIndex])
					{
						distanceindex1 = AlpaIndex;
					}
				if(line.charAt(index +1) == Alphabet[AlpaIndex])
					{
						distanceindex2 = AlpaIndex;
					}
			}
			if(line.length()% 2 == 1) {
			
				comparetoDistanceinPairs(distanceindex2-distanceindex1, index);
				
				
			
			//q v j g t
			}else if(line.length() - 1  > index  ){
				comparetoDistanceinPairs(distanceindex2-distanceindex1, index);		
				
			}
		
		}else 
			CheckNodes(index);
	}	

		
	public void comparetoDistanceinPairs(int distance, int index )
	{	
		
		if(distance <0 ) { 
					distance =  -distance;
		}
		
		for(int DistancePairIndex = 0; DistancePairIndex < distancepairs.length ; ++DistancePairIndex)
		{
			if(distance == distancepairs[DistancePairIndex] && index == cou)
			{
				System.out.println(pairs[DistancePairIndex]);
				Node.addToEnd(pairs[DistancePairIndex]);
				DistanceBetweenTwoLetters(index+ 2);
			}
			else if(distance == distancepairs[DistancePairIndex])
			{
				System.out.println(pairs[DistancePairIndex]);
				Node.addToEnd(pairs[DistancePairIndex]);
				DistanceBetweenTwoLetters(index+2);
			}
		}
	}
	
	
	public ToptenCipers getNode(){
		return returnciper;
	}
	
}
