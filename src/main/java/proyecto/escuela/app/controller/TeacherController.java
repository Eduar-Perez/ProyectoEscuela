package proyecto.escuela.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto.escuela.alumno.dto.TeacherDto;
import proyecto.escuela.app.entity.TeacherEntity;
import proyecto.escuela.app.service.TeacherService;
@RestController
@RequestMapping ("/teacher")

public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@RequestMapping("/addTeacher")
	public TeacherDto addTeacher (@RequestBody TeacherDto teacher) throws Exception {
		TeacherEntity teacherEntityResponse = TeacherDto.CONVERT_ENTITY.apply(teacher);
		teacherService.addTeacher(teacherEntityResponse);

		return TeacherDto.CONVERT_DTO.apply(teacherEntityResponse);

	}

	@GetMapping ("/searchTeacher/{id}")
	public TeacherDto searchTeacher (@PathVariable Integer id) throws Exception{

		return teacherService.searchTeacher(id);

	}

	@PutMapping ("/modifyTeacher")
	public TeacherDto modifyTeacher (@RequestBody TeacherDto teacher) throws Exception{
		TeacherEntity teacherDtoResponse = TeacherDto.CONVERT_ENTITY.apply(teacher);

		return 	teacherService.modifyTeacher(teacherDtoResponse);

	}

	@GetMapping ("/getList")
	public List<TeacherDto> getList () throws Exception{

		return teacherService.getList();

	}

	@DeleteMapping ("/deleteTeacher/{id}")
	public void deleteTeacher (@PathVariable Integer id) throws Exception {
		teacherService.deleteTeacher(id);
	}

}
