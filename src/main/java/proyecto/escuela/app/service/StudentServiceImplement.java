package proyecto.escuela.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.escuela.alumno.dto.StudentDto;
import proyecto.escuela.app.entity.StudentEntity;
import proyecto.escuela.app.entity.SubjectStudent_Entity;
import proyecto.escuela.app.repository.StudentRepository;
import proyecto.escuela.app.repository.SubjectStudentRepository;

@Service
public class StudentServiceImplement implements StudentService {
	// EL AUTOWRIE PERMITE HACER LA INYECCION DE DEPENDENCIA PARA SUBIRLO AL CONTEXTO DE SPRING
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private SubjectStudentRepository subjectStudentRepository;;

	// EL OVERRIDE SE USA PARA PODER MODIFICAR O APLIAR LA IMPLEMENTACION DE LOS METODOS
	@Override
	public  StudentDto addStudent (StudentEntity student) throws Exception {
		StudentEntity studentresponse = null;

		if (student.getId() != null && studentRepository.existsById(student.getId())) {
			throw new Exception("ERROR... YA EXISTE UN REGISTRO CON LOS MISMOS DATOS INGRESADOS.");
		}
		try {
			studentresponse = studentRepository.save(student);
		}
		catch ( Exception e) {
			throw new Exception ("HA OCURRIDO UN ERROR AGREGANDO LOS DATOS... POR FAVOR INTENTALO NUEVAMENTE.");
		}		
		return StudentDto.CONVERT_DTO.apply(studentresponse);
	}


	//METODO PARA GUARDAR A UN ALUMNO MANUALMENTE .
	@Override
	public StudentDto addStudentManual (StudentEntity student) throws Exception {
		StudentEntity studentResponse = new StudentEntity();

		if (student.getId() != null && studentRepository.existsById(student.getId())) {
			throw new Exception("ERROR... YA EXISTE UN REGISTRO CON LOS MISMOS DATOS INGRESADOS.");
		}
		try {

			studentResponse.setId(student.getId());
			studentResponse.setNombres(student.getNombres());
			studentResponse.setApellidos(student.getApellidos());
			studentResponse.setTelefono(student.getTelefono());

			studentRepository.save(studentResponse); 

			List<SubjectStudent_Entity> listSubjectStudentEntity = new ArrayList<>();
			student.getSubjectStudentEntityList().forEach(item -> {
				listSubjectStudentEntity.add(item);
			});

			listSubjectStudentEntity.forEach(item1 -> {
				SubjectStudent_Entity studentList = new SubjectStudent_Entity(); 
				studentList.setStudentEntity(item1.getStudentEntity());
				studentList.setSubjectEntity(item1.getSubjectEntity());

				subjectStudentRepository.save(studentList);

			});

			studentResponse.setSubjectStudentEntityList(listSubjectStudentEntity);
		}
		catch ( Exception e) {
			throw new Exception ("HA OCURRIDO UN ERROR AGREGANDO LOS DATOS... POR FAVOR INTENTALO NUEVAMENTE.");
		}				

		return StudentDto.CONVERT_DTO.apply(studentResponse);
	}


	@Override
	public StudentDto searchStudentId(Integer id) throws Exception {
		Optional<StudentEntity> StudentResponse = null;

		if (!studentRepository.existsById(id)) {
			throw new Exception("NO SE ENCONTRARON RESULTADOS PARA SU BUSQUEDA...");
		}
		try {
			StudentResponse =  studentRepository.findById(id);

		} catch (Exception e) {
			throw new Exception ("HA OCURRIDO UN ERROR REALIZANDO LA BUSQUEDA... POR FAVOR ITENTALO NUEVAMENTE.");
		}
		return StudentDto.CONVERT_DTO.apply(StudentResponse.get());
	}

	@Override
	public StudentDto modifyStudent(StudentEntity student) throws Exception {
		StudentEntity studentResponse = null;
		if (studentRepository.existsById(student.getId())) {
			try {
				studentResponse = studentRepository.save(student);

			} catch (Exception e) {
				throw new Exception ("HA OCURRIDO UN ERROR MODIFICANCO UN ALUMNO... POR FAVOR INTENTALO NUEVAMENTE.");
			}	
		}
		else {
			throw new Exception("NO EXISTEN UN ID SIMILAR PARA MODIFICAR...");
		}
		return StudentDto.CONVERT_DTO.apply(studentResponse);
	}

	@Override
	public List<StudentDto> getLitst() throws Exception {
		List<StudentDto> listStudentDto = new ArrayList<>();
		List<StudentEntity> listStudentEntity = new ArrayList<>();
		try {
			listStudentEntity = studentRepository.findAll();

		} catch (Exception e) {
			throw new Exception ("HA OCURRIDO UN ERROR OBTENIENDO LA LISTA... POR FAVOR INTENTALO NUEVAMENTE.");

		}

		listStudentEntity.forEach(item -> {
			listStudentDto.add(StudentDto.CONVERT_DTO.apply(item));

		});
		return listStudentDto;

	}

	@Override
	public void deletedStudent (Integer id) throws Exception {
		if (studentRepository.existsById(id)) {
			try {
				studentRepository.deleteById(id);

			} catch (Exception e) {
				throw new Exception ("HA OCURRIDO UN ERROR ELIMINANDO LOS DATOS DE UN ALUMNO... POR FAVOR INTENTALO NUEVAMENTE.");
			}	
		}
		else {
			throw new Exception("NO EXISTEN UN ID SIMILAR PARA BORRAR EL REGISTRO...");
		}
	}
}
