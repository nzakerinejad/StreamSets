package robotProblem;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class SolutionRobotMovement {

	public static void main(String[] args) {
		String robotPosition1 = "1 2 N" ;
		String commandLine1 = "L M L M L M L M M";
		String expectedResult1 = "1 3 N";
		
		String robotPosition2 = "3 3 E" ;
		String commandLine2 = "M M R M M R M R R M";		
		String expectedResult2 = "5 1 E";	
			

		newRobotPositionTest(expectedResult1, robotPosition1, commandLine1);
		newRobotPositionTest(expectedResult2, robotPosition2, commandLine2);
	}
	
	private static void newRobotPositionTest(String expectedResult, String robotPosition, String commandLine) {
		Position newRobotPositon = findNewPosition(robotPosition, commandLine);		
		assertEquals(expectedResult, newRobotPositon.toString());
		System.out.println(newRobotPositon.toString());
	}

	private static Position findNewPosition(String robotPosition, String commandLine) {
		Position newRobotPositon = readRobotPosition(robotPosition);
		ArrayList<MotionCommand> listOfCommands = readOrdersList(commandLine );
		for (MotionCommand command : listOfCommands) {
			ControlCommands controlCommand = new ControlCommands(command);
			newRobotPositon = controlCommand.moveToAnotherPlace(newRobotPositon, command);
		}
		return(newRobotPositon);	
	}

	
	
	private static Position readRobotPosition(String robotPosition) {
		
		String[] positionArray = robotPosition.split(" ");
		int x = Integer.parseInt(positionArray[0]);
        int y = Integer.parseInt(positionArray[1]);
        CardinalCompass cp = CardinalCompass.valueOf(positionArray[2]);
        return (new Position (x, y, cp));           
		
	}

	

	private static ArrayList<MotionCommand> readOrdersList(String commandLine){
		String[] commandArray = commandLine.split(" ");
		
		ArrayList<MotionCommand> listOfCommands = new ArrayList<MotionCommand>();
		for (String str : commandArray) {
			listOfCommands.add(MotionCommand.valueOf(str));
		}

		return listOfCommands;
		
	}
	
}
