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
            FileTXT.removeEmptyLines();

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

    public static Paciente[] selectPacientesForArray(){
        Paciente[] dataPacientes = new Paciente[10];
        try {
            ArrayList<String> lines = new ArrayList<>();
            lines = FileTXT.read();
           
            int indexPaciente = 0;
            String[][] dataTextPaciente = new String[7][2];
            dataTextPaciente[0][0] = "id:";
            dataTextPaciente[1][0] = "nome:";
            dataTextPaciente[2][0] = "cpf:";
            dataTextPaciente[3][0] = "telefone:";
            dataTextPaciente[4][0] = "consultas:";
            dataTextPaciente[5][0] = "convenio:";
            dataTextPaciente[6][0] = "diagnostico:";

            
            if(lines.size() > 0){
                for(String row : lines){
                    if(lines != null){
                        for(int i = 0 ; i < 7 ; i ++){
                            int keyWordIndex = row.indexOf(dataTextPaciente[i][0]);
                            int startIndex = keyWordIndex + dataTextPaciente[i][0].length() + 1;
                            int endIndex = row.indexOf(",", startIndex);
                            
                            if(endIndex == -1){
                                endIndex = row.length();
                            }

                            if(i == 6){
                                endIndex = row.indexOf(" ", startIndex);
                            }

                            dataTextPaciente[i][1] = row.substring(startIndex, endIndex);
                        }
                    }
                    dataPacientes[indexPaciente] = new Paciente(Integer.parseInt(dataTextPaciente[0][1]), dataTextPaciente[1][1], dataTextPaciente[2][1], dataTextPaciente[3][1], Integer.parseInt(dataTextPaciente[4][1]), Boolean.parseBoolean(dataTextPaciente[5][1]), Integer.parseInt(dataTextPaciente[6][1]));
                    indexPaciente++;
                }
            }
            return dataPacientes;
        } catch(Error e) {}
        
        Paciente[] errorPaciente = new Paciente[1];

        return errorPaciente;
    }

    public static boolean reformatArray(Paciente[] newString){
        String concatContent = "";
        
        for(int i = 0 ; i < newString.length ; i ++){
            if(newString[i] != null){
                concatContent += newString[i].toString() + "\n";
            }
        }

        try {
           FileTXT.reworkTxt(concatContent);

            return true;
        } catch(Error e) {}

        return false;
    }
}
