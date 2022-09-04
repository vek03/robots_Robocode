package vek;
import robocode.*;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import static robocode.util.Utils.normalRelativeAngleDegrees;

//import java.awt.Color;
//author: Victor Cardoso
// Vek Histories

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * VekRobot5 - a robot by (your name here)
 */
public class VekRobot5 extends Robot
{
	int dist = 50;
	
	
	/**
	 * run: VekRobot5's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar
		double maxY = getBattleFieldHeight() - 5;
		double maxX = getBattleFieldWidth() - 5;

		if(getEnergy() <= 25)
		{
			ahead(300);
			back(300);
			scan();		
		}
	
		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			turnGunRight(120);
			ahead(100);
			turnGunLeft(120);
			back(90);
			turnGunRight(120);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
	
		if (e.getDistance() < 50 && getEnergy() > 50) {
			fire(3);
		}
		else {
			fire(2);
		}
		back(15);

	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		turnRight(normalRelativeAngleDegrees(90 - (getHeading() - e.getHeading())));

		ahead(dist);
		dist *= -1;
		scan();
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		turnRight(90);
		back(200);
		ahead(100);
	}	
	
	public void	onHitRobot(HitRobotEvent e){
		turnRight(120);
		back(250);
		turnRight(90);
		ahead(100);
	}	

}
