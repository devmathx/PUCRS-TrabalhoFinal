import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileTXT {
    private static final String TXT_PATH = getDataPath();

    public FileTXT() { }
    
    private static String getDataPath() {
        File root = new File(System.getProperty("user.dir"));
        File path = new File(root, "database");

        if (!path.exists()) {
            path.mkdir();
        }

        File txt = new File(path, "data.txt");

        if (!txt.exists()) {
            try {
                txt.createNewFile();
            } catch (IOException error) {
                error.printStackTrace();
            }
        }

        return txt.getAbsolutePath();
    }


    public static void write(String text, boolean overwrite) {
        try {
            FileWriter writer = new FileWriter(TXT_PATH, !overwrite);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
    
            bufferWriter.write(text);
            bufferWriter.newLine();
    
            bufferWriter.close();
            writer.close();
        
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    
    public static ArrayList<String> read() {
        ArrayList<String> rows = new ArrayList<>();

        try {
            FileReader reader = new FileReader(TXT_PATH);
            BufferedReader bufferReader = new BufferedReader(reader);

            String row;
            while ((row = bufferReader.readLine()) != null) {
                rows.add(row);
            }
            
            bufferReader.close();
            reader.close();
            
        } catch (IOException error) {
            error.printStackTrace();
        }
        return rows;
    }


    public static void remove(String rowToRemove) {
        ArrayList<String> data = read();
            
        StringBuilder content = new StringBuilder();

        for (String row : data) {
            if (row != null) {
                if (!row.equals(rowToRemove)) content.append(row).append("\n");
            }   
        }

        write(content.toString(), true);
    }

    
    public static String find(String text) {
        ArrayList<String> data = read();
        
        for (String row : data) {
            if (row.contains(text)) {
                return row;
            }
        }
        
        return null;
    }


    public static void rewrite(String oldData, String newData) {
        ArrayList<String> data = read();   

        StringBuilder content = new StringBuilder();

        for (String row : data) {
            if (row != null) {
                if (row.equals(oldData)) {
                    content.append(newData).append("\n");
                } else {
                    content.append(row).append("\n");
                }
            }   
        }

        write(content.toString(), true);
    }
}
