package insurancetracker.insurancetracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "home_insurances")
public class HomeInsurance extends Insurance {
    @Column(nullable = false)
    private double propertyValue;
    private boolean isHouse;
    private boolean hasSecuritySystem;
    private boolean isInRiskZone;
    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Contract contract;
    @ManyToOne
    private User user;
    public HomeInsurance(String PolicyHolderName , LocalDate startDate , LocalDate endDate , double propertyValue , boolean isHouse, boolean hasSecuritySystem, boolean isInRiskZone , User user) {
        this.PolicyHolderName = PolicyHolderName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.propertyValue = propertyValue;
        this.isHouse = isHouse;
        this.hasSecuritySystem = hasSecuritySystem;
        this.isInRiskZone = isInRiskZone;
        this.user = user;
    }
    public double getPropertyValue() {
        return propertyValue;
    }
    public void setPropertyValue(double PropertyValue) {
        this.propertyValue = PropertyValue;
    }
    public boolean getIsHouse() {
        return isHouse;
    }
    public void setIsHouse(boolean isHouse) {
        this.isHouse = isHouse;
    }
    public boolean getHasSecuritySystem() {
        return hasSecuritySystem;
    }
    public void setHasSecuritySystem(boolean hasSecuritySystem) {
        this.hasSecuritySystem = hasSecuritySystem;
    }
    public boolean getIsInRiskZone() {
        return isInRiskZone;
    }
    public void setIsInRiskZone(boolean isInRiskZone) {
        this.isInRiskZone = isInRiskZone;
    }
    public Contract getContract() {
        return contract;
    }
    public void setContract(Contract contract) {
        this.contract = contract;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
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

