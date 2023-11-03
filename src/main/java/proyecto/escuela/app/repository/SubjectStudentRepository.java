package proyecto.escuela.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyecto.escuela.app.entity.SubjectStudent_Entity;

@Repository
public interface SubjectStudentRepository extends JpaRepository<SubjectStudent_Entity, Integer> {

}
