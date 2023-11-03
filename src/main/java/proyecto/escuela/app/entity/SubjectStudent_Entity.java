package proyecto.escuela.app.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data

public class SubjectStudent_Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idSubjectStudentEntity")
	private Integer id_Subject_Entity;

	@ManyToOne
	@JoinColumn (name = "studententity_subjectstudent_entity")
	private StudentEntity studentEntity;

	@ManyToOne
	@JoinColumn (name = "subjectentity_subjectstudent_entity")
	private SubjectEntity subjectEntity;

}
