package proyecto.escuela.alumno.dto;

import java.util.function.Function;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import proyecto.escuela.app.entity.ClassroomEntity;

@Data
@Getter
@Setter

public class ClassroomDto {

	private Long id;

	private String codigo;

	private String descripcion;

	public static final Function <ClassroomDto, ClassroomEntity> CONVERT_ENTITY = (ClassroomDto classroomDto) -> {
		ClassroomEntity classroomentityResponse = new ClassroomEntity (); 
		classroomentityResponse.setId(classroomDto.getId());
		classroomentityResponse.setCodigo(classroomDto.getCodigo());
		classroomentityResponse.setDescripcion(classroomDto.getDescripcion());

		return classroomentityResponse;
	};

	public static final Function <ClassroomEntity, ClassroomDto> CONVERT_DTO = (ClassroomEntity classroomDto) -> {
		ClassroomDto classroomDtoResponse = new ClassroomDto();
		classroomDtoResponse.setId(classroomDto.getId());
		classroomDtoResponse.setCodigo(classroomDto.getCodigo());
		classroomDtoResponse.setDescripcion(classroomDto.getDescripcion());

		return classroomDtoResponse;
	};

}
