package proyecto.escuela.app.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table (name = "subjectM")
@Data
@Getter
@Setter

public class SubjectEntity {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column (nullable = false)
	private String nameSubject;

	@ManyToOne 
	@JoinColumn (name = "subject_teacher")
	private TeacherEntity teacher;

	@ManyToOne
	@JoinColumn (name = "subject_classroom")
	private	ClassroomEntity classroom;

}

