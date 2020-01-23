package br.com.xyinc.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="TSDCORD")
public class Points implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
		@Id 
		@NotNull
	    @Size(max = 40)
		private String name;
		
		private long x;
		private long y;
		
		public Points(){
		}
		
		public Points(String name, long x, long y){
			this.name= name;
			this.x=x;
			this.y=y;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public long getX() {
			return x;
		}
		public void setX(long x) {
			this.x = x;
		}
		public long getY() {
			return y;
		}
		public void setY(long y) {
			this.y = y;
		}
		
}
