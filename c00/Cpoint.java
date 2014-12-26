
public class Cpoint {
	
	private double[] coordinate = new double[2];
	
	public Cpoint(double[] coordianate) {
		for (int i=0; i < 2; i++){
			this.coordinate[i]=coordinate[i];
		}
	}	
	
	public void setCoordinate (int index, double value) {
		coordinate[index]=value;
	}
	
	public double getCoordinate (int index, double value) {
		return coordinate[index];
	}
	
	

}
