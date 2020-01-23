package br.com.xyinc.model;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class References implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
		private long x;
		private long y;
		private Double m;
		
		public References(long x, long y, Double m) {
			this.x=x;
			this.y=y;
			this.m=m;
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
		public Double getM() {
			return m;
		}
		public void setM(Double m) {
			this.m = m;
		}
	
		
}
