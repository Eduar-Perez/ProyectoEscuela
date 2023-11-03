package proyecto.escuela.alumno.dto;

import java.util.function.Function;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import proyecto.escuela.app.entity.SubjectEntity;

@Data
@Getter
@Setter

public class SubjectDto {

	private Integer id;

	private String nameSubject;

	public static final Function <SubjectDto, SubjectEntity> CONVERT_ENTITY = (SubjectDto subjectDto) -> {
		SubjectEntity subjectEntityResponse = new SubjectEntity ();
		subjectEntityResponse.setId(subjectDto.getId());
		subjectEntityResponse.setNameSubject(subjectEntityResponse.getNameSubject());

		return subjectEntityResponse;

	};

	public static final Function <SubjectEntity, SubjectDto> CONVERT_DTO = (SubjectEntity subjectEtity) -> {
		SubjectDto SubjectDtoResponse = new SubjectDto();
		SubjectDtoResponse.setId(subjectEtity.getId());
		SubjectDtoResponse.setNameSubject(subjectEtity.getNameSubject());

		return SubjectDtoResponse;

	};

}
