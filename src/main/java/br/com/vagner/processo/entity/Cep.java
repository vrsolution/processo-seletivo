/**
 * 
 */
package br.com.vagner.processo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author Vagner Rodrigues Souza
 *
 */
@Entity
@Table(name="cep")
public class Cep implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1177855055672783438L;

	@Id
	@Column(length=8)
	@ApiModelProperty(value="CEP")
	private String cep;
	
	@Column(length=70,nullable=false)
	@ApiModelProperty(value="Logradouro")
	private String logradouro;
	
	@Column(length=40,nullable=false)
	@ApiModelProperty(value="Bairro")
	private String bairro;
	
	@Column(length=40,nullable=false)
	@ApiModelProperty(value="Cidade")
	private String cidade;
	
	@Column(length=2,nullable=false)
	@ApiModelProperty(value="Unidade Federal")
	private String uf;
	
	
	

	/**
	 * 
	 */
	public Cep() {
	}

	
	
	/**
	 * @param cep
	 * @param logradouro
	 * @param bairro
	 * @param cidade
	 * @param uf
	 */
	public Cep(String cep, String logradouro, String bairro, String cidade, String uf) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
	}



	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @param logradouro the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * @param uf the uf to set
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		return result;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Cep)) {
			return false;
		}
		Cep other = (Cep) obj;
		if (bairro == null) {
			if (other.bairro != null) {
				return false;
			}
		} else if (!bairro.equals(other.bairro)) {
			return false;
		}
		if (cep == null) {
			if (other.cep != null) {
				return false;
			}
		} else if (!cep.equals(other.cep)) {
			return false;
		}
		if (cidade == null) {
			if (other.cidade != null) {
				return false;
			}
		} else if (!cidade.equals(other.cidade)) {
			return false;
		}
		if (logradouro == null) {
			if (other.logradouro != null) {
				return false;
			}
		} else if (!logradouro.equals(other.logradouro)) {
			return false;
		}
		if (uf == null) {
			if (other.uf != null) {
				return false;
			}
		} else if (!uf.equals(other.uf)) {
			return false;
		}
		return true;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Cep [cep=%s, logradouro=%s, bairro=%s, cidade=%s, uf=%s]", cep, logradouro, bairro,
				cidade, uf);
	}
	
	
	


}
