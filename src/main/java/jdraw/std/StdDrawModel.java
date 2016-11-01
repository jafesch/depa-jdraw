/*
 * Copyright (c) 2000-2016 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.std;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import jdraw.framework.*;

/**
 * Provide a standard behavior for the drawing model. This class initially does not implement the methods
 * in a proper way.
 * It is part of the course assignments to do so.
 * @author Julian Fisch
 *
 */
public class StdDrawModel implements DrawModel, FigureListener {
	/** List of figures contained in the drawing. */
	private final List<Figure> figures = new LinkedList<>();
	/** List of listeners interested in changes of any figure. */
	private final List<DrawModelListener> listeners = new ArrayList<>();

	@Override
	public void addFigure(Figure f) {
		if (f != null && !figures.contains(f)) {
			figures.add(f);
			f.addFigureListener(this);
			notifyListeners(f, DrawModelEvent.Type.FIGURE_ADDED);
		}
	}

	@Override
	public void removeFigure(Figure f) {
		if (figures.remove(f)) {
			f.removeFigureListener(this);
			notifyListeners(f, DrawModelEvent.Type.FIGURE_REMOVED);
		}
	}

	@Override
	public Iterable<Figure> getFigures() {
		return Collections.unmodifiableList(figures);
	}

	@Override
	public void addModelChangeListener(DrawModelListener listener) {
		if (listener != null && !listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	@Override
	public void removeModelChangeListener(DrawModelListener listener) {
		listeners.remove(listener);
	}

	/** The draw command handler. Initialized here with a dummy implementation. */
	// TODO initialize with your implementation of the undo/redo-assignment.
	private DrawCommandHandler handler = new EmptyDrawCommandHandler();

	/**
	 * Retrieve the draw command handler in use.
	 * @return the draw command handler.
	 */
	@Override
	public DrawCommandHandler getDrawCommandHandler() {
		return handler;
	}

	@Override
	public void setFigureIndex(Figure f, int index) {
        if(index < 0 || index >= figures.size()) {
            throw new IndexOutOfBoundsException();
        }
        int pos = figures.indexOf(f);
        if (pos < 0) throw new IllegalArgumentException("Figure f not contained in model");
        if (pos != index) {
            figures.remove(f);
            figures.add(index, f);
            notifyListeners(f, DrawModelEvent.Type.DRAWING_CHANGED);
        }
	}

	@Override
	public void removeAllFigures() {
        for (Figure figure : figures) {
            figure.removeFigureListener(this);
        }
        figures.clear();
        notifyListeners(null, DrawModelEvent.Type.DRAWING_CLEARED);
	}

	protected void notifyListeners(Figure f, DrawModelEvent.Type type) {
		DrawModelEvent dme = new DrawModelEvent(this, f, type);
		for (DrawModelListener l : new ArrayList<>(listeners)) {
			l.modelChanged(dme);
		}
	}

	@Override
	public void figureChanged(FigureEvent e) {
		notifyListeners(e.getFigure(), DrawModelEvent.Type.FIGURE_CHANGED);
	}
}
