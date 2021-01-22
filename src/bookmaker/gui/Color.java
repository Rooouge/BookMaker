package bookmaker.gui;

public enum Color {

	BLACK(0, 0, 0, 0),
	DARK_BLUE(1, 0, 0, 170),
	DARK_GREEN(2, 0, 170, 0),
	DARK_AQUA(3, 0, 170, 170),
	DARK_RED(4, 170, 0, 0),
	DARK_PURPLE(5, 170, 0, 170),
	GOLD(6, 255, 170, 0),
	GRAY(7, 170, 170, 170),
	DARK_GRAY(8, 85, 85, 85),
	BLUE(9, 85, 85, 255),
	GREEN(10, 85, 255, 85),
	AQUA(11, 85, 255, 255),
	RED(12, 255, 85, 85),
	LIGHT_PURPLE(13, 255, 85, 255),
	YELLOW(14, 255, 255, 85),
	WHITE(15, 255, 255, 255);
	
	
	private int index;
	private java.awt.Color color;
	
	
	private Color(int index, int r, int g, int b) {
		this.index = index;
		this.color = new java.awt.Color(r, g, b);
	}
	
	
	public java.awt.Color awt() {
		return color;
	}
	
	public Color next() {
		if(index == Color.values().length-1)
			return Color.values()[0];
		return Color.values()[index+1];
	}
	
	public Color previous() {
		if(index == 0)
			return Color.values()[Color.values().length-1];
		return Color.values()[index-1];
	}
	
	public String rgbString() {
		return "(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ")";
	}	
}
