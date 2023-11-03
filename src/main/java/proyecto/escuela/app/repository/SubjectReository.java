package proyecto.escuela.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyecto.escuela.app.entity.SubjectEntity;

@Repository

public interface SubjectReository extends JpaRepository<SubjectEntity, Integer>{
}
