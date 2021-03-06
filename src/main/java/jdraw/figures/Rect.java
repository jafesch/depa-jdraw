/*
 * Copyright (c) 2000-2016 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import jdraw.figures.handles.NorthEastHandle;
import jdraw.figures.handles.NorthWestHandle;
import jdraw.figures.handles.SouthEastHandle;
import jdraw.figures.handles.SouthWestHandle;
import jdraw.framework.*;

/**
 * Represents rectangles in JDraw.
 * 
 * @author Christoph Denzler
 *
 */
public class Rect extends BaseFigure {
	/**
	 * Use the java.awt.Rectangle in order to save/reuse code.
	 */
	private java.awt.Rectangle rectangle;

	/**
	 * Create a new rectangle of the given dimension.
	 * @param x the x-coordinate of the upper left corner of the rectangle
	 * @param y the y-coordinate of the upper left corner of the rectangle
	 * @param w the rectangle's width
	 * @param h the rectangle's height
	 */
	public Rect(int x, int y, int w, int h) {
		rectangle = new java.awt.Rectangle(x, y, w, h);
	}

	/**
	 * Draw the rectangle to the given graphics context.
	 * @param g the graphics context to use for drawing.
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(rectangle.x, rectangle.y, 
							 rectangle.width, rectangle.height);
		g.setColor(Color.BLACK);
		g.drawRect(rectangle.x, rectangle.y, 
							 rectangle.width, rectangle.height);
	}
	
	@Override
	public void setBounds(Point origin, Point corner) {
		rectangle.setFrameFromDiagonal(origin, corner);
        notifyListeners(this);

	}

	@Override
	public void move(int dx, int dy) {
        if (dx != 0 || dy != 0) {
            rectangle.setLocation(rectangle.x + dx, rectangle.y + dy);
            notifyListeners(this);
        }
	}

	@Override
	public boolean contains(int x, int y) {
		return rectangle.contains(x, y);
	}

	@Override
	public Rectangle getBounds() {
		return rectangle.getBounds();
	}

	/**
	 * Returns a list of 8 handles for this Rectangle.
	 * @return all handles that are attached to the targeted figure.
	 * @see jdraw.framework.Figure#getHandles()
	 */	
	@Override
	public List<FigureHandle> getHandles() {
		List<FigureHandle> handles = new LinkedList<>();
		handles.add(new NorthWestHandle(this));
		handles.add(new NorthEastHandle(this));
		handles.add(new SouthWestHandle(this));
		handles.add(new SouthEastHandle(this));
		return handles;
	}

	@Override
	public Figure clone() {
		return null;
	}

}
