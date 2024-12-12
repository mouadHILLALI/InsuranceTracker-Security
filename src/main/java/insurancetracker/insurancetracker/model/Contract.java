package insurancetracker.insurancetracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String justifications;
    private double total;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "autoInsurance_id", referencedColumnName = "id")
    private AutoInsurance autoInsurance;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "homeInsurance_id", referencedColumnName = "id")
    private HomeInsurance homeInsurance;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "healthInsurance_id", referencedColumnName = "id")
    private HealthInsurance healthInsurance;
    public Contract(String Justifications, AutoInsurance autoInsurance , double total) {
        this.justifications = Justifications;
        this.autoInsurance = autoInsurance;
        this.total = total;
    }
    public Contract(String Justifications, HomeInsurance homeInsurance , double total) {
        this.justifications = Justifications;
        this.homeInsurance = homeInsurance;
        this.total = total;
    }
    public Contract(String Justifications, HealthInsurance healthInsurance , double total) {
        this.justifications = Justifications;
        this.healthInsurance = healthInsurance;
        this.total = total;
    }

   @Override
    public String toString() {
        return "Contract{" + "Justifications=" + justifications + '}' + super.toString();
   }
}
