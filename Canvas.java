public interface MyCanvas {
   
   public void clear();
   
    public void setLineColor(int rgb);
   
    public void setFillColor(int rgb);
   
    public void drawSquare(int xPosition, int yPosition, int length);
   
    public void drawRectangle(int xPosition, int yPosition, int topLength, int sideLength);
   
    public void drawRightTriangle(int xPosition, int yPosition, int verticalLeg,
                                  int horizontalLeg);
   
    public void drawTriangle (int[] xPosition, int[] yPosition);
   
    public void drawLine (int xStart, int yStart, int xEnd, int yEnd);
}

class CanvasAdapter implements MyCanvas {
	private MyNewCanvas canvas;
	private int lineColor;
	private int fillColor;

	public CanvasAdapter(MyNewCanvas canvas) {
		this.canvas = canvas;
		lineColor = 0;
	    fillColor = 0xFFFFFF;
	}

	public void clear() {
		canvas.clear();
	}

	public void setLineColor(int rgb) {
		lineColor = rgb;
	} 

	public void setFillColor(int rgb){
		fillColor = rgb;
	}

	public void drawSquare(int xPosition, int yPosition, int length) {
		// x and y give the top-left corner
		int[] xCoords = {xPosition, xPosition + length,
				xPosition + length, xPosition};
		int[] yCoords = {yPosition, yPosition,
				yPosition + length, yPosition + length};
		canvas.drawShape(xCoords, yCoords, 4, lineColor, fillColor);
	}

	public void drawRectangle(int xPosition, int yPosition, int topLength, int sideLength) {
		// x and y give the top-left corner
		int[] xCoords = {xPosition, xPosition + topLength,
				xPosition + topLength, xPosition};
		int[] yCoords = {yPosition, yPosition,
				yPosition + sideLength, yPosition + sideLength};
		canvas.drawShape(xCoords, yCoords, 4, lineColor, fillColor);
	}

	public void drawRightTriangle(int xPosition, int yPosition, int verticalLeg,
			int horizontalLeg) {
		// verticalLeg and horizontalLeg can be positive or negative
		int[] xCoords = {xPosition, xPosition, xPosition + horizontalLeg};
		int[] yCoords = {yPosition, yPosition + verticalLeg, yPosition};
		
		canvas.drawShape(xCoords, yCoords, 3, lineColor, fillColor);
	}

	public void drawTriangle (int[] xPosition, int[] yPosition) {
		// each array has 3 coordinate points for the 3 corners of the Triangle
		canvas.drawShape(xPosition, yPosition, 3, lineColor, fillColor);
	}

	public void drawLine (int xStart, int yStart, int xEnd, int yEnd) {
		int[] xCoords = {xStart, xEnd};
		int[] yCoords = {yStart, yEnd};
		canvas.drawShape(xCoords, yCoords, 1, lineColor, fillColor);
	}
}
