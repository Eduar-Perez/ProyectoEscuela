package proyecto.escuela.alumno.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import lombok.Data;
import proyecto.escuela.app.entity.StudentEntity;
import proyecto.escuela.app.entity.SubjectStudent_Entity;

@Data

public class StudentDto {

	private Integer id;

	private String nombres;

	private String apellidos;

	private long telefono;

	private List<SubjectStudentDTO> subjectStudent;


	public static final Function <StudentDto, StudentEntity> CONVERT_ENTITY = (StudentDto alumnoDto) -> {

		//Asignar el estudiante a cada Subjet_estudent (id)
		if(alumnoDto.getSubjectStudent()!= null) {
			alumnoDto.getSubjectStudent().forEach(item -> {
				StudentDto studentDtoResponse = new StudentDto(); 
				studentDtoResponse.setId(alumnoDto.getId());
				item.setStudentDto(studentDtoResponse);
				
			});
		}

		StudentEntity studentEntityResponse = new StudentEntity();
		studentEntityResponse.setId(alumnoDto.getId());
		studentEntityResponse.setNombres(alumnoDto.getNombres());
		studentEntityResponse.setApellidos(alumnoDto.getApellidos());
		studentEntityResponse.setTelefono(alumnoDto.getTelefono());

		//Proceso para pasar la lista subject_estuden DTO a entity
		if(alumnoDto.getSubjectStudent()!= null) {

			List <SubjectStudent_Entity> subjectStudentEntity = new ArrayList<>();
			alumnoDto.getSubjectStudent().forEach(item -> {
				subjectStudentEntity.add(SubjectStudentDTO.CONVERT_ENTITY.apply(item));
			});

			studentEntityResponse.setSubjectStudentEntityList(subjectStudentEntity);
		}
		return studentEntityResponse;

	};

	public static final Function <StudentEntity, StudentDto> CONVERT_DTO = (StudentEntity alumnoEntity) ->{

		StudentDto studentDtoRespose = new StudentDto();

		if (alumnoEntity.getSubjectStudentEntityList() != null) {
			List <SubjectStudentDTO> subjectStudentDto = new ArrayList<>();
			alumnoEntity.getSubjectStudentEntityList().forEach(item -> {
				subjectStudentDto.add(SubjectStudentDTO.CONVERT_DTO.apply(item));
			});
			studentDtoRespose.setSubjectStudent(subjectStudentDto);
		}

		studentDtoRespose.setId(alumnoEntity.getId());
		studentDtoRespose.setNombres(alumnoEntity.getNombres());
		studentDtoRespose.setApellidos(alumnoEntity.getApellidos());
		studentDtoRespose.setTelefono(alumnoEntity.getTelefono());


		return studentDtoRespose;
	};
}

