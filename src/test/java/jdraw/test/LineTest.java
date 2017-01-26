package jdraw.test;

import jdraw.figures.BaseFigure;
import jdraw.figures.Line;

public class LineTest extends BaseFigureTest {

	@Override
	BaseFigure createFigure() {
		return new Line(10, 10, 40, 40);
	}

}
