package proyecto.escuela.app.service;

import java.util.List;

import proyecto.escuela.alumno.dto.TeacherDto;
import proyecto.escuela.app.entity.TeacherEntity;

public interface TeacherService {

	public TeacherDto addTeacher (TeacherEntity teacherEntity) throws Exception ;
		
	public TeacherDto searchTeacher (Integer id) throws Exception ;
	
	public TeacherDto modifyTeacher (TeacherEntity teacherEnity) throws Exception ;
	
	public List <TeacherDto> getList () throws Exception;
	
	public void  deleteTeacher (Integer id) throws Exception;
		
}
