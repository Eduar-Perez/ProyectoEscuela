package proyecto.escuela.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "teacher")
@Data
@Getter
@Setter

public class TeacherEntity {
@Id
private Integer id;
	
@Column(name = "names", nullable = false)
private String names;

@Column(name = "lastName", nullable = false)
private String lastName;

@Column(name = "phones", nullable = false)
private Long phones;
	


}
