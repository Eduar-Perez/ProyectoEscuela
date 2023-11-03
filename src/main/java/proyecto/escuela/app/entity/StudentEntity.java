package proyecto.escuela.app.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "student")
public class StudentEntity {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) ESTA LINEA SIRVE ARA COLOCAR EL ID AUTOINCREMENTABLE.
	private Integer id;

	@Column(name="nombres", nullable = false)
	private String nombres;

	@Column(name="apellidos", nullable = false)
	private String apellidos;

	@Column(name="telefono")
	private long telefono;

	@OneToMany (mappedBy = "studentEntity", cascade = {CascadeType.ALL})
	private List<SubjectStudent_Entity>  subjectStudentEntityList;

}

