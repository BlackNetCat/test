
public class Cline extends Cpoint {
	
	private Cpoint begin;
	private Cpoint end;
	
	public Cline(double[] coordianate, Cpoint begin, Cpoint end) {
		super(coordianate);
		this.begin = begin;
		this.end = end;
	}

	public Cpoint getBegin() {
		return begin;
	}

	public void setBegin(Cpoint begin) {
		this.begin = begin;
	}

	public Cpoint getEnd() {
		return end;
	}

	public void setEnd(Cpoint end) {
		this.end = end;
	}
	
	
	
	
	
	
	
}
