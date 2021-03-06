package br.com.feiranamao.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="LOJA")
public class Loja implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
		@Id 
		@NotNull
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_loja")
		@SequenceGenerator(name="seq_loja", sequenceName = "seq_loja", initialValue = 1)
		private long id_loja;
		
		public long getId_loja() {
			return id_loja;
		}

		public void setId_loja(long id_loja) {
			this.id_loja = id_loja;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		private String nome;
	
}
