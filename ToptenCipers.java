

public class ToptenCipers {
		private Node firstNode;
	    private Node lastNode;

	    
	    // This file is nesscary to keep track of all different diagrams that are possible
	    // for an ecrypted word
	    

	    public ToptenCipers(String entry)
	    {
	        // create two dummy Nodes for firstNode and lastNode to reference
	        firstNode = new Node(entry);
	        lastNode = firstNode;

	        firstNode.setNext(lastNode);
	        lastNode.setPrev(firstNode);
	    }
	    // methods go here
	    
	    public boolean OneNode() {
	    	if(firstNode == lastNode)
	    	{
	    		return true;
	    	}
	    	else 
	    		return false;
	    }
	    
	    public void addToStart(String s)
	    {
	        Node nodeToAdd = new Node(s);
	        Node currentFirst = firstNode.getNext();
	        nodeToAdd.setNext(currentFirst);
	        nodeToAdd.setPrev(firstNode);
	        currentFirst.setPrev(nodeToAdd);
	        firstNode.setNext(nodeToAdd);
	    }

	    public void addToEnd(String s)
	    {
	        Node nodeToAdd = new Node(s);
	        nodeToAdd.setPrev(lastNode);
	        lastNode.setNext(nodeToAdd);
	        nodeToAdd.setNext(null);
	        this.lastNode = nodeToAdd;
	    }
	    public String getFirstString()
	    {
	    	
	    	String data = firstNode.getValue();
	    	return data;
	    }
	    public boolean TailhasPrevious()
	    {
	    	if(lastNode == firstNode)
	    	{
	    		return true;
	    	}
	    	try {
	    		if(lastNode.getPrev() != null)
	    		{
	    			return true;
	    		}else {
	    			return false;
	    		}
	    	}catch(NullPointerException ex)
	    	{
	    		return false;
	    	}
	    }
	    
	    public boolean FirstNodehasNext()
	    {
	    	try {
	    	if(firstNode.getNext() != null) {
	    		return true;
	    	}else {
	    		return false;
	    	}
	    	
	    	}catch(NullPointerException ex)
	    	{
	    		return false;
	    	}
	    }
	    public String getTailString()
	    {
	    	String data = lastNode.getValue();
	    	lastNode = lastNode.getPrev();
	    	lastNode.setNext(null);
	    	return data;
	    	
	    }

	    public String toString()
	    {
	        StringBuilder sb = new StringBuilder();
	        sb.append("' ");
	        for(Node n = firstNode.getNext(); n.getNext() != null; n = n.getNext())
	        {
	            sb.append(n).append(" ");
	        }
	        sb.append("'");
	        return sb.toString();
	    }

	    private class Node
	    {
	        private Node next = null;
	        private Node prev = null;
	        String value;

	        private Node(String s) { value = s; }
	        private Node getNext() { return next; }
	        private Node getPrev() { return prev; }
	        private void setNext(Node n) { next = n; }
	        private void setPrev(Node n) { prev = n; }
	        private String getValue() { return value; }
	        public String toString() { return value;}
	    }
	
}
