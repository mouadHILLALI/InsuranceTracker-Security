package insurancetracker.insurancetracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "auto_insurances")
public class AutoInsurance extends Insurance {
    @Column(nullable = false)
    private int driverAge;
    @Column(nullable = false)
    private String vehiculeType;
    private boolean isProfessionalUse;
    private boolean hasAccidents;
    @ManyToOne
    private User user;
    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Contract contract;

    public AutoInsurance(String s, LocalDate localDate, LocalDate localDate1, int i, String s1, boolean professional, boolean b, User user) {
    }
}
