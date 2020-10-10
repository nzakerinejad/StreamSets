package robotProblem;

public class Position {
		
		int x;
		int y;
		CardinalCompass  cp;
		
		public Position(int x, int y, CardinalCompass cp) {
			this.x = x;
			this.y = y;
			this.cp = cp;
			
		}	
		
		
		public Position rotateRight() {
	        return new Position(x, y, cp.turnRight());
	    }

	    public Position rotateLeft() {
	        return new Position(x, y, cp.turnLeft());
	    }
	    
	    public Position moveForward(Position p) {
	    	Position nextPosition = p;
	    	switch (p.cp) 
	        { 
	        case N: 	        	
	        	nextPosition= goUp(p);	    	    
	            break;
	            
	        case E: 
	        	nextPosition = goForward(p);
	        	break;
	        	
	        case S: 
	        	nextPosition = goDown(p);
	        	break;
	        	
	        case W: 
	        	nextPosition = goBackward(p); 
	        	break;	       
	        }
			return nextPosition; 
	    }
	       
	    public Position goUp(Position p) {
	    	return new Position(x, y+1, cp);
	    }
	    public Position goDown(Position p) {
	    	return new Position(x, y-1, cp);
	    }
	    public Position goForward(Position p) {
	    	 return new Position(x+1, y, cp);
	    }
	    public Position goBackward(Position p) {
	    	return new Position(x-1, y, cp);
	    }

	    public String toString() {
	        return x + " " + y + " " + cp;
	    }
	 
}
