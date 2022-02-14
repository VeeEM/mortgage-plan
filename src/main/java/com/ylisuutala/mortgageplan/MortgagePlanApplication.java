package com.ylisuutala.mortgageplan;

import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.exceptionhandler.ExceptionHandlerIgnore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MortgagePlanApplication {

    public static void main(String[] args) {
	SpringApplication.run(MortgagePlanApplication.class, args);
    }
}
