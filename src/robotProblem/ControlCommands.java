package robotProblem;

public class ControlCommands {	

	MotionCommand command;
	
	public ControlCommands(MotionCommand command) {
		this.command = command;
	}

    public Position moveToAnotherPlace(Position curPosition, MotionCommand command) 
    { 
    	Position nextPositon = curPosition;
        switch (command) 
        { 
        case L: 
        	nextPositon = curPosition.rotateLeft(); 
            break; 
        case R: 
        	nextPositon = curPosition.rotateRight(); 
            break; 
        case M: 
        	nextPositon = curPosition.moveForward(curPosition);
        default: 
             
        } 
        return nextPositon;
    }
}

     enum MotionCommand {

    	L , R, M  
    }




