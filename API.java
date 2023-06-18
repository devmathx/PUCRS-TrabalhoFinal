import java.util.ArrayList;
import java.util.Iterator;

public class API {
    
    public API() {}

    public static boolean registerPaciente(String paciente) {
        try {
            FileTXT.write(paciente, false);

            return true;
        } catch(Error e) {}
        
        return false;
    }

    public static boolean deletePaciente(String cpf) {
        try {
            String res =  FileTXT.find(cpf);
            if (res == null) {
                return false;
            }    

            FileTXT.remove(res);

            return true;
        } catch(Error e) {}

        return false;
    }

    public static boolean updatePaciente(String paciente, String cpf) {
        try {
            String res =  FileTXT.find(cpf);
            if (res == null) {
                return false;
            }    

            FileTXT.rewrite(res, paciente);

            return true;
        } catch(Error e) {}

        return false;
    }

    public static String findPaciente(String cpf) {
        try {
            String res = FileTXT.find(cpf);

            return res;
        } catch(Error e) {}

        return null;
    }

    public static String[] getAllPacientes() {
        try {
            ArrayList<String> list = FileTXT.read();
            
            String[] data = new String[list.size()];
            
            int index = 0;
            for (String row : list) {
                data[index] = row;
                index++;
            }

            return data;
        } catch(Error e) {}
        
        return null;
    }

    public static String[] filterPacientes(String prop, String value) {
        String param = prop + ": " + value;

        try {
            ArrayList<String> list = FileTXT.read();
            Iterator<String> iterator = list.iterator();

            while (iterator.hasNext()) {
                String row = iterator.next();
                if (!row.contains(param)) {
                    iterator.remove();
                }
            }

            String[] data = list.toArray(new String[list.size()]);

            return data;
        } catch(Error e) {}

        return null;
    }
}
