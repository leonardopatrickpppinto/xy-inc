package br.com.xyinc;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.xyinc.model.Points;
import br.com.xyinc.model.References;
import br.com.xyinc.repository.PointsRepository;
import br.com.xyinc.repository.ReferencesRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PointsRepositoryTest {
		
		@Autowired
		private PointsRepository pointsRepository;
		
		@Autowired
		private ReferencesRepository referenceRepository;
		
		@Rule
		public ExpectedException thrown = ExpectedException.none();
		
		@Test
		public void createShouldPersitsPoints() {
			Points points = new Points();
			points.setName("Lanchonete");
			points.setX(27);
			points.setY(12);
			
			this.pointsRepository.save(points);
			
			assertThat(points.getName()).isNotNull();
			assertThat(points.getX()).isNotNull();
			assertThat(points.getY()).isNotNull();
			
		}
		
		@Test
		public void findAllPoints() {
			
			//TODO Em outro cenário, outro teste seria necessário, para não iniciar com um delete
			this.pointsRepository.deleteAll();
			
			ArrayList<Points>  points = new ArrayList<Points>();
			points.add(new Points("Lanchonete", 27, 12));
			points.add(new Points("Posto", 31, 18));
			points.add(new Points("Joalheria", 15, 12));
			points.add(new Points("Floricultura", 19, 21));
			points.add(new Points("Pub", 12, 8));
			points.add(new Points("Supermercado", 23, 6));
			points.add(new Points("Churrascaria", 28, 2));
			
			for(Points p: points)
				this.pointsRepository.save(p);
			
			List<Points> foundPoints  = this.pointsRepository.findAll();
			
			assertThat(foundPoints.size()).isEqualTo(7);
		}
		
		@Test
		public void findReferencePoints() {
			
			//TODO Somente para demostração, em cenário de produção outra logica seria aplicada.
			this.pointsRepository.deleteAll();
			
			ArrayList<Points>  points = new ArrayList<Points>();
			points.add(new Points("Lanchonete", 27, 12));
			points.add(new Points("Posto", 31, 18));
			points.add(new Points("Joalheria", 15, 12));
			points.add(new Points("Floricultura", 19, 21));
			points.add(new Points("Pub", 12, 8));
			points.add(new Points("Supermercado", 23, 6));
			points.add(new Points("Churrascaria", 28, 2));
			
			for(Points p: points)
				this.pointsRepository.save(p);
			
			References reference = new References(20, 10, 10.0);
			
			List<Points> foundPoints  = this.referenceRepository
											 .findAllReferences(
																reference.getX(),
																reference.getY(),
																reference.getM()
																);
			
			assertThat(foundPoints.size()).isEqualTo(4);
		}
		

		
		
}
