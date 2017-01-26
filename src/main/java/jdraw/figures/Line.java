/*
 * Copyright (c) 2000-2016 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.figures;

import com.sun.javafx.geom.Line2D;
import jdraw.figures.handles.NorthEastHandle;
import jdraw.figures.handles.NorthWestHandle;
import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents rectangles in JDraw.
 * 
 * @author Christoph Denzler
 *
 */
public class Line extends BaseFigure {
	/**
	 * Use the java.awt.Rectangle in order to save/reuse code.
	 */
	private Line2D line2D;

	/**
	 * Create a new rectangle of the given dimension.
	 * @param x1 the x-coordinate of the upper left point of the line
	 * @param y1 the y-coordinate of the upper left point of the line
	 * @param x2 the x-coordinate of the bottom right point of the line
	 * @param y2 the y-coordinate of the bottom right point of the line
	 */
	public Line(int x1, int y1, int x2, int y2) {
		line2D = new Line2D(x1, y1, x2, y2);
	}

	/**
	 * Draw the rectangle to the given graphics context.
	 * @param g the graphics context to use for drawing.
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawLine((int) line2D.x1, (int) line2D.y1, (int) line2D.x2, (int) line2D.y2);
	}

	@Override
	public void setBounds(Point origin, Point corner) {
		line2D.setLine(origin.x, origin.y, corner.x, corner.y);
        notifyListeners(this);
	}

	@Override
	public void move(int dx, int dy) {
        if (dx != 0 || dy != 0) {
            line2D.setLine(line2D.x1 + dx, line2D.y1 + dy, line2D.x2 + dx, line2D.y2 + dy);
            notifyListeners(this);
        }
	}

	@Override
	public boolean contains(int x, int y) {
		return line2D.contains(x, y);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(new Rectangle( (int) line2D.x1, (int) line2D.y1, (int) line2D.getBounds().getWidth(), (int) line2D.getBounds().getHeight()));
	}

	/**
	 * Returns a list of 8 handles for this Rectangle.
	 * @return all handles that are attached to the targeted figure.
	 * @see Figure#getHandles()
	 */	
	@Override
	public List<FigureHandle> getHandles() {
		List<FigureHandle> handles = new LinkedList<>();
		handles.add(new NorthWestHandle(this));
		handles.add(new NorthEastHandle(this));
		return handles;
	}

	@Override
	public Figure clone() {
		return null;
	}

}
