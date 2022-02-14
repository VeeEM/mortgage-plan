package com.ylisuutala.mortgageplan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "prospects")
public class Prospect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;
    
    @Min(value = 1, message = "Loan total must be greater than 0")
    @Column(name = "loan_total")
    private double loanTotal;
    
    @Digits(integer = 20, fraction = 20, message = "Interest must be numeric.")
    private double interest;
    
    @Min(value = 1, message = "Years must be greater than 0")
    private int years;
    
    public Integer getId() {
	return this.id;
    }
    
    public void setId(Integer id) {
	this.id = id;
    }
    
    public String getName() {
	return this.name;
    }
    
    public void setName(String name) {
	this.name = name;
    }
    
    public double getLoanTotal() {
	return this.loanTotal;
    }
    
    public void setLoanTotal(double loanTotal) {
	this.loanTotal = loanTotal;
    }
    
    public double getInterest() {
	return this.interest;
    }
    
    public void setInterest(double interest) {
	this.interest = interest;
    }
    
    public int getYears() {
	return this.years;
    }
    
    public void setYears(int years) {
	this.years = years;
    }
    
    public double getMonthlyPayment() {
	double monthlyInterest = this.interest / 12;
	int numPayments = this.years * 12;

	if (this.interest == 0)
	    return Math.roundHundredths(this.loanTotal / (this.years * 12));

	return Math.roundHundredths((this.loanTotal * (monthlyInterest * Math.pow(1 + monthlyInterest, numPayments)))
	    / (Math.pow(1 + monthlyInterest, numPayments) - 1));
    }

}
