package FrequencyAttack;

public class ToptenCipers {
		private Node firstNode;
	    private Node lastNode;

	    public ToptenCipers()
	    {
	        // create two dummy Nodes for firstNode and lastNode to reference
	        firstNode = new Node("Head");
	        lastNode = new Node("Tail");

	        firstNode.setNext(lastNode);
	        lastNode.setPrev(firstNode);
	    }
	    // methods go here
	    
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
	        Node currentLast = lastNode.getPrev();
	        nodeToAdd.setPrev(currentLast);
	        nodeToAdd.setNext(lastNode);
	        currentLast.setNext(nodeToAdd);
	        lastNode.setPrev(nodeToAdd);
	    }

	    public void remove(String stringToRemove)
	    {	
	    		
	    	for ( Node iterator = firstNode ; iterator != null; iterator = iterator.next){
	    		if( iterator.value.equals(stringToRemove)){
	    			iterator.next.setPrev((iterator.getPrev()));
	    			iterator.prev.setNext(iterator.next);
	    			iterator.setNext(null);
	    			iterator.setPrev(null);
	    		}
	    	}
	    }

	    public boolean addAfter(String afterThis, String toAdd)
	    {
	        Node nodeToAddAfter = findNode(afterThis);
	        if(nodeToAddAfter == null)
	        {
	            return false;
	        }
	        Node nodeToAdd = new Node(toAdd);
	        nodeToAdd.setPrev(nodeToAddAfter);
	        nodeToAdd.setNext(nodeToAddAfter.getNext());
	        nodeToAddAfter.getNext().setPrev(nodeToAdd);
	        nodeToAddAfter.setNext(nodeToAdd);
	        return true;
	    }

	    public boolean addBefore(String beforeThis, String toAdd)
	    {
	        Node nodeToAddBefore = findNode(beforeThis);
	        if(nodeToAddBefore == null)
	        {
	        	return false;
	        }
	        Node nodeToAdd = new Node(toAdd);
	        nodeToAdd.setNext(nodeToAddBefore);
	        nodeToAdd.setPrev(nodeToAddBefore.getPrev());
	        nodeToAddBefore.getPrev().setNext(nodeToAdd);
	        nodeToAddBefore.setPrev(nodeToAdd);
	        return true;
	    }

	    private Node findNode(String s)
	    {
	        for(Node iterator = firstNode.getNext(); iterator.getNext() != null; iterator = iterator.getNext())
	        {
	            if(iterator.getValue().equals(s))
	            {
	                return iterator;
	            }
	        }
	        return null;
	    }

	    public String toStringBackwards()
	    {
	    		String Backwards = "' ";
	    	for(Node iterator = lastNode.getPrev(); iterator != firstNode ; iterator = iterator.getPrev()){

	    			Backwards += iterator.value + " ";
	    	}
	        return Backwards + "'";
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
