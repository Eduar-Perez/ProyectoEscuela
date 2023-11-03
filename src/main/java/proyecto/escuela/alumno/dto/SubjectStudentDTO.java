package proyecto.escuela.alumno.dto;

import java.util.function.Function;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import proyecto.escuela.app.entity.SubjectStudent_Entity;

@Data

public class SubjectStudentDTO {

	private Integer id_Subject_Entity;

	@JsonIgnore
	private StudentDto studentDto;

	private SubjectDto subjectDto;


	public static final Function <SubjectStudent_Entity, SubjectStudentDTO> CONVERT_DTO = (SubjectStudent_Entity subjectStudent) ->{

		SubjectStudentDTO subjectStudentdtoResponse = new SubjectStudentDTO ();
		subjectStudentdtoResponse.setId_Subject_Entity(subjectStudent.getId_Subject_Entity());
		subjectStudentdtoResponse.setStudentDto((StudentDto.CONVERT_DTO.apply(subjectStudent.getStudentEntity())));
		subjectStudentdtoResponse.setSubjectDto((SubjectDto.CONVERT_DTO.apply(subjectStudent.getSubjectEntity())));

		return subjectStudentdtoResponse;

	};

	public static final Function <SubjectStudentDTO, SubjectStudent_Entity> CONVERT_ENTITY = (SubjectStudentDTO subjectStudent) ->{

		SubjectStudent_Entity SubjectStudentdtoResponse = new SubjectStudent_Entity ();
		SubjectStudentdtoResponse.setId_Subject_Entity(subjectStudent.getId_Subject_Entity());
		SubjectStudentdtoResponse.setStudentEntity(StudentDto.CONVERT_ENTITY.apply(subjectStudent.getStudentDto()));
		SubjectStudentdtoResponse.setSubjectEntity(SubjectDto.CONVERT_ENTITY.apply(subjectStudent.getSubjectDto()));

		return SubjectStudentdtoResponse;

	};
}
