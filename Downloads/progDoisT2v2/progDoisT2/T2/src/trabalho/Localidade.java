package trabalho;

public class Localidade {
	private double s;
	private double w;
	public Localidade() {
	}
	public Localidade(double s, double w) {
		this.s = s;
		this.w = w;
	}
	public double getS() {
		return s;
	}
	public void setS(double s) {
		this.s = s;
	}
	public double getW() {
		return w;
	}
	public void setW(double w) {
		this.w = w;
	}
	@Override
	public String toString() {
		return "Localidade [s=" + s + ", w=" + w + "]";
	}
	
	

}
