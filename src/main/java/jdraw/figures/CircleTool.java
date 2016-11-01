/*
 * Copyright (c) 2000-2016 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.figures;

import jdraw.framework.DrawContext;
import jdraw.framework.DrawTool;
import jdraw.framework.DrawView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * This tool defines a mode for drawing rectangles.
 *
 * @see jdraw.framework.Figure
 *
 * @author  Christoph Denzler
 */
public class CircleTool extends BaseTool {

	/**
	 * Temporary variable. During circke creation (during a
	 * mouse down - mouse drag - mouse up cycle) this variable refers
	 * to the new circle that is inserted.
	 */
	private Circle newCircle = null;

	/**
	 * Create a new circle tool for the given context.
	 * @param context a context to use this tool in.
	 */
	public CircleTool(DrawContext context) {
		this.context = context;
		this.view = context.getView();
	}

	/**
	 * Activates the Cirlce Mode. There will be a
	 * specific menu added to the menu bar that provides settings for
	 * Rectangle attributes
	 */
	@Override
	public void activate() {
		this.context.showStatusText("Circle Mode");
	}

	/**
	 * Initializes a new Circle object by setting an anchor
	 * point where the mouse was pressed. A new Circle is then
	 * added to the model.
	 * @param x x-coordinate of mouse
	 * @param y y-coordinate of mouse
	 * @param e event containing additional information about which keys were pressed.
	 *
	 * @see DrawTool#mouseDown(int, int, MouseEvent)
	 */
	@Override
	public void mouseDown(int x, int y, MouseEvent e) {
		if (newCircle != null) {
			throw new IllegalStateException();
		}
		anchor = new Point(x, y);
		newCircle = new Circle(x, y, 0, 0);
		view.getModel().addFigure(newCircle);
	}

	/**
	 * During a mouse drag, the Circle will be resized according to the mouse
	 * position. The status bar shows the current size.
	 *
	 * @param x   x-coordinate of mouse
	 * @param y   y-coordinate of mouse
	 * @param e   event containing additional information about which keys were
	 *            pressed.
	 *
	 * @see DrawTool#mouseDrag(int, int, MouseEvent)
	 */
	@Override
	public void mouseDrag(int x, int y, MouseEvent e) {
		newCircle.setBounds(anchor, new Point(x, y));
		java.awt.Rectangle r = newCircle.getBounds();
		this.context.showStatusText("w: " + r.width + ", h: " + r.height);
	}

	/**
	 * When the user releases the mouse, the Cirlce object is updated
	 * according to the color and fill status settings.
	 *
	 * @param x   x-coordinate of mouse
	 * @param y   y-coordinate of mouse
	 * @param e   event containing additional information about which keys were
	 *            pressed.
	 *
	 * @see DrawTool#mouseUp(int, int, MouseEvent)
	 */
	@Override
	public void mouseUp(int x, int y, MouseEvent e) {
		newCircle = null;
		anchor = null;
		this.context.showStatusText("Cirlce Mode");
	}
	
	@Override
	public Icon getIcon() {
		return new ImageIcon(getClass().getResource(IMAGES + "oval.png"));
	}

	@Override
	public String getName() {
		return "Cirlce";
	}

}
