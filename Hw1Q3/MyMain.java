package Hw1Q3;
import java.io.*;

public class MyMain {
    public static void main(String[] args) throws Exception {
        PersonList people = new PersonList();
        try (InputStream in = new FileInputStream("Hw1Q3/Person.csv")) {
            people.store(in);
        }
        people.display(System.out);
        System.out.println();
        System.out.println("---- Running find() tests ----");
        System.out.println("find(102) index: " + people.find("102")); 
        System.out.println("find(202) index: " + people.find("202")); 
        System.out.println("find(208) index: " + people.find("208")); 
    }
}
