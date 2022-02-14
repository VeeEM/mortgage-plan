package com.ylisuutala.mortgageplan;

import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.exceptionhandler.ExceptionHandlerIgnore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataImporter implements CommandLineRunner {

    @Autowired
    private ProspectRepository prospectRepository;

    @Override
    public void run(String... args) throws Exception {
	if (args.length > 0) {
	    try {
		FileReader fileReader = new FileReader(args[0], Charset.forName("UTF-8"));
		List<InputModel> csvImports = new CsvToBeanBuilder<InputModel>(fileReader)
		    .withType(InputModel.class)
		    .withExceptionHandler(new ExceptionHandlerIgnore())
		    .build()
		    .parse();
		for (InputModel m : csvImports) {
		    Prospect prospect = m.toProspect();
		    prospectRepository.save(prospect);
		}
	    } catch(Exception e) {
		System.out.println("Could read file: " + args[0]);
	    }
	}
    }
}
