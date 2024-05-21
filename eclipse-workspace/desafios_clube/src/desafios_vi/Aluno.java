package desafios_vi;

public class Aluno {
	private Double nota;
	private Integer faltas;
	
	
	public Aluno(Double nota, Integer faltas) {
		this.nota = nota;
		this.faltas = faltas;
	}
	
	
	public Double getNota() {
		return nota;
	}


	public void setNota(Double nota) {
		this.nota = nota;
	}


	public Integer getFaltas() {
		return faltas;
	}


	public void setFaltas(Integer faltas) {
		this.faltas = faltas;
	}


	public String getConc() {
		String conc;
		if (getNota()<5){
			conc = "INS";
		} else if (getNota()>=5 && getNota()<7) {
			conc = "REG";
		} else if (getNota()>=7 && getNota()<9) {
			conc = "REG";
		} else {
			conc = "EXC";
		}
		
		return conc;
	}
	
	public Integer faltas(int dias) {
		 if (dias <= 0) {
	            throw new IllegalArgumentException("Número inválido de dias.");
	        }
	    return (getFaltas() * 100) / dias;
	}
	
	

}
