import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Catalog implements Serializable {

    int id;
    String name;
    List<Document> documentList = new ArrayList<Document>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Serializable load(Path path) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(path);
        id = Integer.parseInt(bufferedReader.readLine());
        name = bufferedReader.readLine();
        String line;
        while ((line = bufferedReader.readLine()) != null) documentList.add(Document.parseDocument(line));
        return null;
    }

    public void save(String path) throws IOException {

        BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(path));
        bufferedWriter.write(id + "\n" + name + "\n" + documentList.toString());


    }
}
