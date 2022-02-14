package com.ylisuutala.mortgageplan;

import com.opencsv.bean.CsvBindByName;

public class InputModel {
    @CsvBindByName(column = "Customer", required = true)
    public String name;
    @CsvBindByName(column = "Total loan", required = true)
    public double loanTotal;
    @CsvBindByName(column = "Interest", required = true)
    public double interest;
    @CsvBindByName(column = "Years", required = true)
    public int years;
    
    public InputModel() {
    }
    
    public Prospect toProspect() {
	Prospect prospect = new Prospect();
	prospect.setName(this.name);
	prospect.setLoanTotal(this.loanTotal);
	prospect.setInterest(this.interest / 100);
	prospect.setYears(this.years);
	
	return prospect;
    }
}
