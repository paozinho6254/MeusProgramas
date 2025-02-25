package entidades;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {

	private String nomeFuncionario;
	private NivelFuncionario nivel;
	private Double salarioBase; 
	private Empresa nomeEmpresa;
	private List<HoraContrato> listContratos = new ArrayList<HoraContrato>();
	
	public Funcionario() {
		
	}

	public Funcionario(String nomeFuncionario, NivelFuncionario nivel, Double salarioBase, Empresa nomeEmpresa) {
		this.nomeFuncionario = nomeFuncionario;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public NivelFuncionario getNivel() {
		return nivel;
	}

	public void setNivel(NivelFuncionario nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Empresa getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(Empresa nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public List<HoraContrato> getlistContratos() {
		return listContratos;
	}
	
	public void addContrato(HoraContrato contrato) {
		listContratos.add(contrato);
	}
	
	public void removeContrato(HoraContrato contrato) {
		listContratos.remove(contrato);
	}
	
	public double renda(Integer ano, Integer mes) {
		double soma = salarioBase;
		for(HoraContrato x : listContratos) {
			if(x.getData().getMonthValue() == mes && x.getData().getYear() == ano) {
				soma += x.valorTotal();
			}
		}
		return soma;
	}
	
}
