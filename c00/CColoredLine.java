
public class CColoredLine extends Cline {

	int color;
	
	public CColoredLine(double[] coordianate, Cpoint begin, Cpoint end,
			int color) {
		super(coordianate, begin, end);
		this.color = color;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

}
