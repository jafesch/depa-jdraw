package jdraw.grid;

import jdraw.framework.PointConstrainer;

import java.awt.*;

/**
 * Created by Julian on 14-Nov-16.
 */
public class SimpleGrid implements PointConstrainer {
	@Override
	public Point constrainPoint(Point p) {
		System.out.println("SimpleGrid:constrainPoint: " + p);
		return p;
	}

	@Override
	public int getStepX(boolean right) {
		return 0;
	}

	@Override
	public int getStepY(boolean down) {
		return 0;
	}

	@Override
	public void activate() {
		System.out.println("SimpleGrid:activate()");
	}

	@Override
	public void deactivate() {
		System.out.println("SimpleGrid:deactivate()");
	}

	@Override
	public void mouseDown() {
		System.out.println("SimpleGrid:mouseDown()");
	}

	@Override
	public void mouseUp() {
		System.out.println("SimpleGrid:mouseUp()");
	}
}
