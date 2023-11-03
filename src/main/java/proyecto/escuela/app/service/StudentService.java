package proyecto.escuela.app.service;

import java.util.List;

import proyecto.escuela.alumno.dto.StudentDto;
import proyecto.escuela.app.entity.StudentEntity;

public interface StudentService {

	public StudentDto  addStudent (StudentEntity student) throws Exception;

	public StudentDto searchStudentId (Integer id) throws Exception;

	public StudentDto modifyStudent (StudentEntity student) throws Exception;

	public List <StudentDto> getLitst () throws Exception;

	public void  deletedStudent (Integer id) throws Exception;

	public StudentDto addStudentManual(StudentEntity student) throws Exception;




}