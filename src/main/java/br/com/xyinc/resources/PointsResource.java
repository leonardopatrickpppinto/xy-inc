package br.com.xyinc.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.xyinc.model.Points;
import br.com.xyinc.model.References;
import br.com.xyinc.repository.PointsRepository;
import br.com.xyinc.repository.ReferencesRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="API REST XY Inc v2")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class PointsResource  {

	@Autowired
	ReferencesRepository referencesRepository;
	
	@Autowired
	PointsRepository pointsRepository;
	
	@ApiOperation(value=" Return List Points")
	@GetMapping("/points")
	public List<Points> listPoints(){
		
		return pointsRepository.findAll();
	}
	
	@ApiOperation(value=" Return References Points")
	@GetMapping("/references/{coordinateX}/{coordinateY}/{distanceMax}")
	public List<Points> listReference(
			@PathVariable(value = "coordinateX") long x,
			@PathVariable(value = "coordinateY") long y,
			@PathVariable(value = "distanceMax") Double m){
		
		return (List<Points>) referencesRepository.findAllReferences(x,y,m);
	}
	
	@ApiOperation(value=" Return References Points")
	@PostMapping("/references")
	public List<Points> listReferences(@RequestBody References ref){
		
		return (List<Points>) referencesRepository.findAllReferences(
				ref.getX(),
				ref.getY(),
				ref.getM()
				);
	}
	
	@ApiOperation(value="Find Poins By Name")
    @RequestMapping(value = "points/{name}", method = RequestMethod.GET)
	public List<Points> findByName(@PathVariable(value = "name") String name) {
		return pointsRepository.findByName(name);
	}
	
    @ApiOperation(value=" Post Points")
	@PostMapping("/points")
	public Points savePoint(@RequestBody Points points) throws Exception {
		
		if(points.getX()<0)
			throw new Exception("Invalid coordinate X");
		
		if(points.getY()<0)
			throw new Exception("Invalid coordinate Y");
		
		return pointsRepository.save(points);
	}
	
    @ApiOperation(value="Delete Points")
	@DeleteMapping("/points")
	public void deletePoints(@RequestBody Points points) {
		pointsRepository.delete(points);
		
	}
	
    @ApiOperation(value="Update Points")
	@PutMapping("/points")
	public Points updatePoints(@RequestBody Points points) {
		return pointsRepository.save(points);
	}

	
}
