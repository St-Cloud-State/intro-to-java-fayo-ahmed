package Hw1Q3;
import java.io.*;
import java.util.LinkedList;

public class PersonList {
    private final LinkedList<Person> list = new LinkedList<>();

    public void store(InputStream in) throws IOException {
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
                list.add(new Person(parts[0].trim(), parts[1].trim(), parts[2].trim()));
            }
        }
    }

    public void display(OutputStream out) {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
        for (Person p : list) pw.println(p);
        pw.flush();
    }

    public int find(String sid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) return i;
        }
        return -1;
    }

    
    public int size() { return list.size(); }
}
