package proyecto.escuela.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyecto.escuela.app.entity.TeacherEntity;

@Repository

public interface TeacherRepository extends JpaRepository<TeacherEntity, Integer>{

}
