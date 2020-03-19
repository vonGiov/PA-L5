import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {

    int id;
    String name;

    public Document(int id, String name, Map<Tags, String> tags) {
        this.id = id;
        this.name = name;
        this.tags = tags;
    }

    Map<Tags, String> tags;



    public Serializable load(Path path) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(path);
        id = Integer.parseInt(bufferedReader.readLine());
        name = bufferedReader.readLine();
        //todo
        return null;
    }


    public void save(String path) {
    //todo
    }

    @Override
    public String toString() {
        return id + ":" +
                name + ":" +
                tags.toString().
                        replace("{", "").
                        replace("}", "").
                        replace(" ", "").
                        replace(",", ";").
                        replace("=", ";")
                ;
    }
    //parseaza Documentul din stringul primit de la bufferedReader
    public static Document parseDocument(String str) {

        String[] splittedString = str.split(":");

        int id = Integer.parseInt(splittedString[0]);
        String name = splittedString[1];

        String[] tagKeyPairs = splittedString[2].split(";");

        String[] tags = Arrays.copyOfRange(tagKeyPairs, 0, 2);
        Tags[] parsedTags = new Tags[tags.length];
        for (int i = 0; i < tags.length; i++) parsedTags[i] = Tags.valueOf(tags[i]);

        String[] keys = Arrays.copyOfRange(tagKeyPairs, 1, 2);

        Map<Tags, String> tempTags = new HashMap<Tags, String>();

        for (int i = 0; i < tags.length; i++) tempTags.put(parsedTags[i], keys[i]);

        return new Document(id, name, tempTags);


    }
}
