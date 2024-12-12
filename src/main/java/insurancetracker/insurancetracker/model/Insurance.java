package insurancetracker.insurancetracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "insurances")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected int id;
    @Column(nullable = false)
    protected String PolicyHolderName;
    protected LocalDate startDate;
    protected LocalDate endDate;

}
