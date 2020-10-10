package robotProblem;

public enum CardinalCompass {	

	  N  {
	        @Override
	        public CardinalCompass turnLeft(){
	            return W;
	        }

	        @Override
	        public CardinalCompass turnRight(){
	            return E;
	        }
	    },			  
	  E{
	        @Override
	        public CardinalCompass turnLeft(){
	            return N;
	        }

	        @Override
	        public CardinalCompass turnRight(){
	            return S;
	        }
	    },
	  S{
	        @Override
	        public CardinalCompass turnLeft(){
	            return E;
	        }

	        @Override
	        public CardinalCompass turnRight(){
	            return W;
	        }
	    },
	  W{
	        @Override
	        public CardinalCompass turnLeft(){
	            return S;
	        }

	        @Override
	        public CardinalCompass turnRight(){
	            return N;
	        }
	        
	    };
  public abstract CardinalCompass turnLeft();

  public abstract CardinalCompass turnRight();  


}
