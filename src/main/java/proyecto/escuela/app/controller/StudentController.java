package proyecto.escuela.app.controller;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto.escuela.alumno.dto.StudentDto;
import proyecto.escuela.app.entity.StudentEntity;
import proyecto.escuela.app.service.StudentService;
@RestController
@RequestMapping ("/alumno")
public class StudentController {

	@Autowired
	private StudentService StudentServices;


	@PostMapping ("/crearalumno")
	public StudentDto addStudent (@RequestBody StudentDto student) throws Exception {		
		
		guardarDocumento(student);
		return null;
	}
	@GetMapping("/buscaralumno/{id}")
	public ResponseEntity<StudentDto> searchStudentId (@PathVariable Integer id) throws Exception {
		StudentDto estuResp = StudentServices.searchStudentId(id);
		return new ResponseEntity<StudentDto>(estuResp, HttpStatus.OK);	
	}

	@PutMapping("/modificaralumno")
	public StudentDto modifyStudent (@RequestBody StudentDto student) throws Exception {
		StudentEntity studentEntity = StudentDto.CONVERT_ENTITY.apply(student);
		StudentServices.modifyStudent(studentEntity);

		StudentDto studentDto = StudentDto.CONVERT_DTO.apply(studentEntity);

		return studentDto;
	}

	@GetMapping("/obtenerlista")
	public List<StudentDto> getLitst () throws Exception{

		return StudentServices.getLitst();
	}

	@DeleteMapping("/eliminaralumno/{id}")
	public void  deletedStudent (@PathVariable Integer id) throws Exception {
		
		StudentServices.deletedStudent(id);
	}

	public void guardarDocumento (StudentDto student) {
		
		try {
			String ruta = "src\\archivo1.txt";
		    File f = new File(ruta);
		    FileWriter fw = new FileWriter(f);
		    PrintWriter escritura = new PrintWriter(fw);
		         escritura.println(student);
		    
		    escritura.close(); 
		} catch (Exception e) {
			// TODO: handle exception
			var loco = 3;
		}
		
	}

}
