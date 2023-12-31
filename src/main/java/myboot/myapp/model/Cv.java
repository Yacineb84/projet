package myboot.myapp.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Entity
@Table(name = "cv")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cv {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cv",cascade = CascadeType.ALL )
    private List<Activity> activities = new LinkedList<>();
    
    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @Exclude
    private User user;

	public Cv(List<Activity> activities, User user) {
		super();
		this.activities = activities;
		this.user = user;
	}
    
    

}
