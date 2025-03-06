package problemaExemplo2.entidades;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class Usuario {
	
	String nomeString;
	Date horario;
	
	public Usuario() {
		
	}
	
	public Usuario(String nomeString, Date horario) {
		super();
		this.nomeString = nomeString;
		this.horario = horario;
	}

	public String getNomeString() {
		return nomeString;
	}

	public void setNomeString(String nomeString) {
		this.nomeString = nomeString;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nomeString);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nomeString, other.nomeString);
	}

	@Override
	public String toString() {
		return "Usuario [nomeString=" + nomeString + ", horario=" + horario + "]";
	}	
	
	
	
}
