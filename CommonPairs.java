

public class CommonPairs {

	
	
	char[] Alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	String[] pairs = {"th", "on","he","an","in","er","nd","re","ed","es","ou","to","ha","en","ea"};
	int[] distancepairs = {12, 1,3,13,5,13,10,13,1,14,6,5,7,9,4};
	private String line; 
	int key ;
	CesearCipher Cipher;
	boolean status = true;
	static ToptenCipers Node;
	
	int cou ;
	int SHIFT;
	public CommonPairs(CesearCipher Cipher){
		
		this.Cipher = Cipher;
		key = -1;
		
	}
	
	public int bruteforce(String line,CesearCipher Cipher)
	{
		this.line = line;
		Node = new ToptenCipers("");
	
		//if the encrypted word is just one letter we cannnot predict the possible key
		if(line.length() > 1)
		{
			//we need to go through each letter of the ecnrypted word to figure out 
			// all the possible diagrams for that letter
			// example Other when encrypted with a 2 letter shift we get qvjgt
			for(int index = 0; index < line.length() -1 ; ++ index){
				cou = index;
				DistanceBetweenTwoLetters(index); 
				
			}
		}
		return key;
	}
	
	// the possible diagram for 
	// qvjgt is as follow
	//Distance BetweenTwoLetters does the following
	// qv = 5
	// vj = 12
	// jg =3
	// gt = 13
	
	// so qv has a distance of 5 so therefore possibilities for that one would be the following
	
	// in and to 
	// the next diagram in the word is jg which is 3 has the following possiblities he
	
	// so there are two posibilities inhet 
	// the way we figure out the key is that we will need to diagrams and the four letters of the encrypted word 
	// and we compare distances if the distance is all the same then that is our key
	
	// q -> i  = 18
	// v -> n  = 18
	// j -> h  = 22
	// g -> e  = 22
	// there for inhe cannot be the letters represented
	
	// we shift over to 
	// q -> t
	// v -> o
	// j -> h
	// g -> e
	
	// compare if not shift over a letter and search for digrams for vj and gt and repeat the process 

	
	private boolean CheckDistancebetweenletters(char letter1,char letter2, char Cletter1,char Cletter2, int index) {
		boolean DistanceTheSame = false;
		
		
			// this is where the first posbility is possible 
			// in other words     in  for qv
			String pair2 = Node.getFirstString();
			
			
			// we figure out the distance between the letters 
			int dis = TwoLetters(letter1,pair2.charAt(0));
			int dis2 = TwoLetters(letter2,pair2.charAt(1));
			int dis3 = TwoLetters(line.charAt(index),Cletter1); 
			int dis4 = TwoLetters(line.charAt(index+1), Cletter2);
			
			if(dis == dis2)
				if(dis2 == dis3) 
					if(dis3==dis4) {
							// if the distances all match then set the key to distance
							// and that will return our key that is in bruteforce function 
							key = dis;
							DistanceTheSame= true;
								
					}
			
				
		
		return DistanceTheSame;
	}

	private int TwoLetters(char letter1, char letter2) {
			
		
		int index = 0;
		
		int distance = 0;
		while (letter1 != Alphabet[index])
		{
			++index;
		}
		//c = 2 
		//t = 19 
		
		while(letter2 != Alphabet[index]) {
			if(index == 0 ) {
				index = 26;
			}
			--index;
			++distance;
		}
		return distance;
		}

	//  responsible for finding the distance between two characters of an encrpyted word 
	
	public void DistanceBetweenTwoLetters(int index)
	{
		int distanceindex1 = 0 , distanceindex2 = 0 ;
		if(line.length() - 1 >= index + 1) 
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
				
			comparetoDistanceinPairs(distanceindex2-distanceindex1, index);
		}
		
		
	}	

		// this function is called to find possible diagrams that match the distance between two 
	    // letters of an encrypted word 
	public void comparetoDistanceinPairs(int distance, int index )
	{	
		
		if(distance <0 ) { 
					distance =  -distance;
		}
		
		for(int DistancePairIndex = 0; DistancePairIndex < distancepairs.length ; ++DistancePairIndex)
		{
			if(distance == distancepairs[DistancePairIndex] && index == cou)
			{
				// if we just barely have ilerated then we want to create a new Node
				// so that way we can find all the possbilities for that digram
				Node = new ToptenCipers(pairs[DistancePairIndex]);
				DistanceBetweenTwoLetters(index+ 2);
			}
			else if(distance == distancepairs[DistancePairIndex])
			{
				// add to the node so it can add on to the possbilities 
				Node.addToEnd(pairs[DistancePairIndex]);
			}
		}
		if(index != cou) {
			while(!Node.OneNode())
			{
				// this is called once we have found all the possbilities for a diagram 
				String pair = Node.getTailString();
				// we get the tail and pass it to the function 
				// we get the letter we are currently on in the encrypted word 
				// the we get the first and second char of the diagram 
				CheckDistancebetweenletters(line.charAt(cou),line.charAt(cou + 1),pair.charAt(0),pair.charAt(1),index);
				
			}
			
		}
		Node = null;
	}
	
	
	
}
