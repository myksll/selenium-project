package com.cydeo.tests.day09_review_javafaker_driverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {


    @Test
    public void test1(){

        //Create Java Faker object.
        Faker faker =  new Faker();

        //Print out random first name using Faker object
        System.out.println("faker.name().firstName() = " + faker.name().firstName());

        //Print out random last name using FAKER OBJECT
        System.out.println("faker.name().lastName() = " + faker.name().lastName());

        ////Print out random last name using Faker object
        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        //Random numbers generating with specific formatting
        String randomNumber= faker.numerify("###-###-####");
        System.out.println("randomNumber = " + randomNumber);

        //Random numbers generating with specific formatting
        String randomNumber2= faker.numerify("833-###-####");
        System.out.println("randomNumber2 = " + randomNumber2);

        //Print out a city
        System.out.println("faker.address().city() = " + faker.address().city());

        //Print out a zip code
        System.out.println("faker.address().zipCode() = " + faker.address().zipCode());

        //letterify() method is used to generate RANDOM letters with specific formatting
        System.out.println("faker.letterify(\"????-????-????\") = " + faker.letterify("????-????-????"));

        //bothify() method is used to generate both letters and digits randomly
        System.out.println("faker.bothify(\"#?#?-#?#?#-#?#?#?#?#\") = " + faker.bothify("#?#?-#?#?#-#?#?#?#?#"));

        //chuckNorris method is used to create chuckNorris facts
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());
        System.out.println("faker.merve().fact() = " + faker.chuckNorris().fact().replaceAll("Chuck Norris", "Merve"));




    }
}
