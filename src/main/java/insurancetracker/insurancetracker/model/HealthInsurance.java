package insurancetracker.insurancetracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "health_insurances")
public class HealthInsurance extends Insurance {
    @Column(nullable = false)
    private int age;
    private boolean hasChronicCondition;
    @Column(nullable = false)
    private String coverageType;
    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Contract contract;
    @ManyToOne
    private User user;

    public HealthInsurance(String PolicyHolderName , LocalDate startDate, LocalDate endDate , int age, String coverageType , boolean hasChronicCondition, User user) {
        this.PolicyHolderName = PolicyHolderName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.age = age;
        this.coverageType = coverageType;
        this.user = user;
        this.hasChronicCondition = hasChronicCondition;
    }
    @Override
    public String getPolicyHolderName(){
        return super.getPolicyHolderName();
    }
    @Override
    public void setPolicyHolderName(String policyHolderName){
        super.setPolicyHolderName(PolicyHolderName);
    }
    @Override
    public int getId(){
        return super.getId();
    }
    @Override
    public void setId(int id){
        super.setId(id);
    }
    @Override
    public LocalDate getStartDate() {
        return super.getStartDate();
    }
    @Override
    public void setStartDate(LocalDate startDate) {
        super.setStartDate(startDate);
    }
    @Override
    public LocalDate getEndDate() {
        return super.getEndDate();
    }
    @Override
    public void setEndDate(LocalDate endDate) {
        super.setEndDate(endDate);
    }
}
