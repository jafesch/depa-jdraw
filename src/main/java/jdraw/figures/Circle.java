/*
 * Copyright (c) 2000-2016 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.figures;

import com.sun.javafx.geom.Ellipse2D;
import com.sun.javafx.geom.Point2D;
import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents rectangles in JDraw.
 * 
 * @author Christoph Denzler
 *
 */
public class Circle extends BaseFigure {
	/**
	 * Use the java.awt.Rectangle in order to save/reuse code.
	 */
	private Ellipse2D ellipse2D;

	/**
	 * Create a new rectangle of the given dimension.
	 * @param x the x-coordinate of the upper left corner of the rectangle
	 * @param y the y-coordinate of the upper left corner of the rectangle
	 * @param w the rectangle's width
	 * @param h the rectangle's height
	 */
	public Circle(int x, int y, int w, int h) {
		ellipse2D = new Ellipse2D(x, y, w, h);
	}

	/**
	 * Draw the rectangle to the given graphics context.
	 * @param g the graphics context to use for drawing.
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawOval((int) ellipse2D.getX(), (int) ellipse2D.y, (int) ellipse2D.width, (int) ellipse2D.height);
	}

	@Override
	public void setBounds(Point origin, Point corner) {
		ellipse2D.setFrameFromDiagonal(new Point2D(origin.x, origin.y), new Point2D(corner.x, corner.y));
        notifyListeners(this);
	}

	@Override
	public void move(int dx, int dy) {
        if (dx != 0 || dy != 0) {
            ellipse2D.setFrame(ellipse2D.x + dx, ellipse2D.y + dy, ellipse2D.width, ellipse2D.height);
            notifyListeners(this);
        }
	}

	@Override
	public boolean contains(int x, int y) {
		return ellipse2D.contains(x, y);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(new Rectangle((int) ellipse2D.x, (int) ellipse2D.y, (int) ellipse2D.width, (int) ellipse2D.height));
	}

	/**
	 * Returns a list of 8 handles for this Rectangle.
	 * @return all handles that are attached to the targeted figure.
	 * @see Figure#getHandles()
	 */	
	@Override
	public List<FigureHandle> getHandles() {
		return null;
	}

	@Override
	public Figure clone() {
		return null;
	}

}
