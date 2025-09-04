package Hw1Q2;
import java.io.*;
import java.util.LinkedList;

public class MyMain {

    public static void store(InputStream in, LinkedList<Person> list) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                String[] parts = line.split(",", -1);
                if (parts.length < 3) {
                    System.err.println("Skipping malformed line: " + line);
                    continue;
                }
                String first = parts[0].trim();
                String last  = parts[1].trim();
                String id    = parts[2].trim();
                list.add(new Person(first, last, id));
            }
        }
    }

    public static void display(OutputStream out, LinkedList<Person> list) {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
        for (Person p : list) pw.println(p);
        pw.flush();
    }

    public static int find(String sid, LinkedList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) return i;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        LinkedList<Person> people = new LinkedList<>();
        try (InputStream in = new FileInputStream("Hw1Q2/Person.csv")) {
            store(in, people);
        }
        display(System.out, people);
        System.out.println(); 
        System.out.println("---- Testing find() ----");
        System.out.println("find(102) index: " + find("102", people)); 
        System.out.println("find(202) index: " + find("202", people)); 
    }
}
