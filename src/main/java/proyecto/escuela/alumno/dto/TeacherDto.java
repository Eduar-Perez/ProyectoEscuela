package proyecto.escuela.alumno.dto;

import java.util.function.Function;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import proyecto.escuela.app.entity.TeacherEntity;

@Data
@Getter
@Setter

public class TeacherDto {

	private Integer id;


	private String names;


	private String lastName;


	private Long phones;

	// LAMDA PARA CONVERTIR
	public static final Function <TeacherDto, TeacherEntity> CONVERT_ENTITY = (TeacherDto teacherDto) -> {
		TeacherEntity teacherEntity = new TeacherEntity();	
		teacherEntity.setId(teacherDto.getId());
		teacherEntity.setNames(teacherDto.getNames());
		teacherEntity.setLastName(teacherDto.getLastName());
		teacherEntity.setPhones(teacherDto.getPhones());

		return teacherEntity;

	};

	public static final Function <TeacherEntity, TeacherDto> CONVERT_DTO = (TeacherEntity tacherentity) -> {
		TeacherDto teacherDto = new TeacherDto();
		teacherDto.setId(tacherentity.getId());
		teacherDto.setNames(tacherentity.getNames());
		teacherDto.setLastName(tacherentity.getLastName());
		teacherDto.setPhones(tacherentity.getPhones());

		return teacherDto;

	};

}
