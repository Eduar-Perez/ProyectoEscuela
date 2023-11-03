package proyecto.escuela.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.escuela.alumno.dto.TeacherDto;
import proyecto.escuela.app.entity.TeacherEntity;
import proyecto.escuela.app.repository.TeacherRepository;

@Service
public class TeacherServiceImplement implements TeacherService {

	@Autowired
	public TeacherRepository teacherRepository;

	@Override

	public TeacherDto addTeacher(TeacherEntity teacher) throws Exception {
		if (teacher.getId() != null && teacherRepository.existsById(teacher.getId())) {
			throw new Exception ("ERROR... YA EXISTE UN REGISTRO CON LOS MISMOS DATOS INGRESADOS.");
		}
		try {
			teacherRepository.save(teacher);
		} catch (Exception e) {
			throw new Exception ("HA OCURRIDO UN ERROR AGREGANDO LOS DATOS... POR FAVOR INTENTALO NUEVAMENTE.");

		}
		return TeacherDto.CONVERT_DTO.apply(teacher);
	}

	@Override
	public TeacherDto searchTeacher(Integer id) throws Exception {
		Optional<TeacherEntity> teacherEntity = null;
		if (teacherRepository.findById(id) == null) {
			throw new Exception("NO SE ENCONTRARON RESULTADOS PARA SU BUSQUEDA...");
		}
		else {
			try {
				teacherEntity = teacherRepository.findById(id);
			} catch (Exception e) {
				throw new Exception("HA OCURRIDO UN ERROR REALIZANDO LA BUSQUEDA... POR FAVOR ITENTALO NUEVAMENTE.");
			}
		}
		TeacherDto teacherDto = new TeacherDto();
		teacherDto.setId(teacherEntity.get().getId());
		teacherDto.setNames(teacherEntity.get().getNames());
		teacherDto.setLastName(teacherEntity.get().getLastName());
 		teacherDto.setPhones(teacherEntity.get().getPhones());

		return teacherDto ;
	}

	@Override
	public TeacherDto modifyTeacher(TeacherEntity teacherEnity) throws Exception {
		TeacherEntity teacherEntity = null;
		if (teacherRepository.existsById(teacherEnity.getId())) {
			try {
				teacherEntity = teacherRepository.save(teacherEnity);
			} catch (Exception e) {
				throw new Exception ("HA OCURRIDO UN ERROR MODIFICANCO LOS DATOS... POR FAVOR INTENTALO NUEVAMENTE.");
			} 
		}
		else {
			throw new Exception("NO EXISTEN UN ID SIMILAR PARA MODIFICAR...");
		}
		TeacherDto teacherDto = new TeacherDto();
		teacherDto.setId(teacherEntity.getId());
		teacherDto.setNames(teacherEntity.getNames());
		teacherDto.setLastName(teacherEntity.getLastName());
		teacherDto.setPhones(teacherEntity.getPhones());

		return teacherDto;
	}

	@Override
	public List<TeacherDto> getList() throws Exception {
		List <TeacherEntity> listResponseEntity = new ArrayList<>();
		List <TeacherDto> listResponseDto = new ArrayList<>();
		try {
			listResponseEntity = teacherRepository.findAll();
		} catch (Exception e) {
			throw new Exception ("HA OCURRIDO UN ERROR OBTENIENDO LA LISTA... POR FAVOR INTENTALO NUEVAMENTE.");
		} 
		listResponseEntity.forEach (item -> {
			TeacherDto teacherDto = new TeacherDto();
			teacherDto.setId(item.getId());
			teacherDto.setNames(item.getNames());
			teacherDto.setLastName(item.getLastName());
			teacherDto.setPhones(item.getPhones());
			listResponseDto.add(teacherDto);
		});

		return listResponseDto;
	}

	@Override
	public void deleteTeacher(Integer id) throws Exception {
		if (teacherRepository.existsById(id)) {
			try {
				teacherRepository.deleteAll();
			} catch (Exception e) {
				throw new Exception ("HA OCURRIDO UN ERROR ELIMINANDO LOS DATOS DEL PROFESOR... POR FAVOR INTENTALO NUEVAMENTE.");

			} 
		} else {
			throw new Exception ("NO EXISTEN UN ID SIMILAR PARA BORRAR EL REGISTRO...");
		}
	}



}
