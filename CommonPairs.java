package FrequencyAttack;

public class CommonPairs {

	
	
	char[] Alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	String[] pairs = {"th", "on","he","an","in","er","nd","re","ed","es","ou","to","ha","en","ea"};
	int[] distancepairs = {12, 1,3,13,5,13,10,13,1,14,6,5,7,9,4};
	private String line; 
	ToptenCipers returnciper;
	CesearCipher Cipher;
	boolean status = true;
	Node returnNode;
	
	
	public CommonPairs(String line, ToptenCipers node, CesearCipher Cipher){
		this.line = line;
		this.Cipher = Cipher;
		
		
		for(int index = 0; index < (line.length() - 1) ; ++ index){
			
				comparetoDistanceinPairs(DistanceBetweenLetters(index)); 
		}
		
	}
	
	public int DistanceBetweenLetters(int index)
	{
		boolean status1 = true;
		boolean status2 = true;
		int distanceindex1 = 0 , distanceindex2 = 0 ;

		for(int AlpaIndex = 0; (AlpaIndex < Alphabet.length ) && ( status1 || status2) ; ++AlpaIndex){
		
			if(line.charAt(index) == Alphabet[AlpaIndex])
			{
				distanceindex1 = index;
				status1 = false;
			
			}
			if(line.charAt(index +1) == Alphabet[AlpaIndex])
			{
				distanceindex2 = index;
				status2 = false;
			}
		
		}
		
		return distanceindex2 - distanceindex1;
	}	
		
	public void comparetoDistanceinPairs(int distance )
	{	
		for(int DistancePairIndex = 0; DistancePairIndex < distancepairs.length ; ++DistancePairIndex)
		{
			if(distance == distancepairs[DistancePairIndex])
			{
				
			}
		}
	}
	
	
	public ToptenCipers getNode(){
		return returnciper;
	}
	
	
	private Node firstnode = null;
	
	private class Node{
	    public String Name;
        public Node next = null;
        public Node node = null;
        public int Key; 
        public int pority; 
        
        public Node(String Name){
        	
        }
    
        public void setKey(int key){
        	this.Key = key;
        }
        public void setNext(Node Next){
        	node.setNext(Next);
        }
        public Node getString(){
        	return node;
        }
        public void setContact(String string){
        	this.Name = string;
        }
        public void next()
        {
        	this.node = next;
        }
        public void setPriorty(int num){
        	this.pority = num;
        }
        
        public void setNode(Node node)
        {
        	this.node = node;
        }
    }
}
