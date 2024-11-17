package com.botscrew.university;

import com.botscrew.university.initialiser.DataInitializer;
import com.botscrew.university.processor.CommandProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {

    @Autowired
    private CommandProcessor commandProcessor;

    @Autowired
    private DataInitializer dataInitializer;

    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }

    @Override
    public void run(String... args) {
        dataInitializer.populateDatabase();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("Enter command:");
            String input = scanner.nextLine();
            System.out.println(commandProcessor.processCommand(input.trim()));
        }
    }

}
