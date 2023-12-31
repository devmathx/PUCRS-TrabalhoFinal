import javax.sound.sampled.SourceDataLine;
import java.util.Arrays;
import java.util.Comparator;

public class CadastroPacientes {

    private Paciente[] listaPacientes;
    private int indexPaciente;
    // 1- Covid
    // 2- Dengue
    // 3- Influenza
    // 4- Meningite
    // 5- Outro

    public CadastroPacientes(Paciente[] dataPacientes) {
        listaPacientes = new Paciente[10];

        if(dataPacientes.length > 1){
            for(int i = 0; i< dataPacientes.length; i ++){
                if(dataPacientes[i] != null){
                    listaPacientes[i] = dataPacientes[i];
                    indexPaciente++;
                }
            }
        }
        else{
              indexPaciente = 0;
        }
    }

    public boolean CadastrarPaciente() {
        if(indexPaciente == 10){
            System.out.println("Você ja chegou ao limite de pacientes cadastrados!");
            return false;
        }
        
        
        String nome; // 0
        String cpf; // 1
        String telefone; // 2
        int consultas; // 3
        boolean convenio = false; // 4

        boolean flagCadastro = true;
        int diagnostico;

        String[][] values = new String[5][2];
        values[0][0] = "Nome: ";
        values[1][0] = "CPF: ";
        values[2][0] = "Telefone: ";
        values[3][0] = "Consultas: ";
        values[4][0] = "Convênio (S/N): ";

        diagnostico = printMenu();

        if (diagnostico != 6) {
            System.out.print("==============================\n");

            for (int i = 0; i < values.length; i++) {
                values[i][1] = Input.lerString(values[i][0]);

                if (values[i][1] == "" || values[i][1] == " ") {
                    System.out.println("\nVocê não digitou corretamente...Por favor, tente de novo!");

                    i--;
                } else if (i == 3) {
                    if (!(values[i][1].trim().matches("^\\d+$"))) {
                        System.out.println("\nVocê não digitou corretamente...Por favor, tente de novo!");
                        i--;

                    }
                } else if (i == 4) {
                    values[i][1].trim();

                    if (values[i][1].equalsIgnoreCase("S"))
                        convenio = true;
                    else if (values[i][1].equalsIgnoreCase("N"))
                        convenio = false;
                    else {
                        System.out.println("\nVocê não digitou corretamente...Por favor, tente de novo!");
                        i--;
                    }
                }
                else if(i == 1){
                    if(findPaciente(values[i][1].trim()) != -1){
                        System.out.println("\nJá existe um paciente com esse CPF cadastrado...Por favor, tente de novo!");
                        i--;
                    }
                }
            }

            nome = values[0][1];
            cpf = values[1][1];
            telefone = values[2][1];
            consultas = Integer.parseInt(values[3][1]);

            addInArray(new Paciente(indexPaciente, nome, cpf, telefone, consultas, convenio, diagnostico));
            System.out.println("Paciente cadastrado com sucesso!");
        } else {
            System.out.println("Você escolheu voltar\n");
            flagCadastro = false;
            return false;
        }

        return true;
    }

    private int printMenu() {
        String option;

        System.out.println("\n==== CADASTRO DE PACIENTE ====");

        System.out.print("Selecione o diagnóstico");
        System.out.print("\n(1) - Covid");
        System.out.print("\n(2) - Dengue");
        System.out.print("\n(3) - Influenza");
        System.out.print("\n(4) - Meningite");
        System.out.print("\n(5) - Outro");
        System.out.print("\n==============================");

        option = Input.lerString("\n\nSua opção: >> ");

        switch (option) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            default: {
                System.out.println("Opção inválida! Informe novamente\n");
                printMenu();
                return -1;
            }
        }
    }

    // Posteriormente fazer método para o txt
    private void addInArray(Paciente paciente) {
        listaPacientes[indexPaciente] = paciente;
        API.registerPaciente(listaPacientes[indexPaciente].toString());

        indexPaciente++;
    }

    public int findPaciente(String cpf) {
        if(indexPaciente > 0){
            for (int i = 0; i < indexPaciente; i++) {
                if (cpf.equalsIgnoreCase(listaPacientes[i].getCpf())) {
                    return i;
                }
            }
        }

        return -1;
    }

    public void listPacientes() {
        System.out.println("\n===== LISTA DE PACIENTES =====");

        if(indexPaciente > 0){
            for (int i = 0; i < indexPaciente; i++) {
                System.out.println("(" + (i + 1) + ") - " + listaPacientes[i]);
            }
        }
        else{
            System.out.println("Ainda não existe nenhum paciente cadastrado!");
        }
       
    }

    public boolean selectPacienteRemove() {
        if(indexPaciente == 0){
            System.out.println("Ainda não existe nenhum paciente cadastrado!");
            return false;
        }
        
        int removeIndex = -1;

        System.out.println("\nComo você deseja remover? ");
        System.out.println("(1) - Ver lista e escolher paciente");
        System.out.println("(2) - Remover por cpf");

        String select = Input.lerString("Sua opção: >> ");
        int selectInt = Integer.parseInt(select);
       
        switch (selectInt) {
            case 1: {
                boolean flagFind = false;
                this.listPacientes();
                String option = (Input.lerString("Sua opção: >> "));
                int intOption = Integer.parseInt(option) -1;

                for (int i = 0; i < indexPaciente; i++) {
                    if (intOption == i) {
                        flagFind = true;
                        removeIndex = i;
                        break;
                    }
                }

                if (!flagFind) {
                    if(tryAgain("Sua opção foi invpalida!")){
                        selectPacienteRemove();
                    }
                    else{
                        return false;
                    }
                }
                break;
            }

            case 2: {
                String cpf = Input.lerString("Informe o CPF do paciente: ");
                removeIndex = this.findPaciente(cpf);
                if (removeIndex == -1) {
                    if(tryAgain("O CPF informado não está cadastrado!")){
                        selectPacienteRemove();
                    }
                    else{
                        return false;
                    }
                }
                break;
            }

            default: {
                if(tryAgain("Opção inválida!")){
                    selectPacienteRemove();
                }
                else{
                    return false;
                }
            }
        }

        removePaciente(removeIndex);
        System.out.println("Paciente removido da lista!");
        return true;
    }

    public static boolean tryAgain(String text) {
        System.out.println(text);
        String value = Input.lerString("Deseja tentar novamente (S/N)? ");

        if (value.equalsIgnoreCase("S")) {
            return true;
        } else if (value.equalsIgnoreCase("N")) {
            System.out.println("Operação cancelada!");
            return false;
        } else {
            System.out.println("Opção Inválida! Cancelando operação...");
            return false;
        }
    }

    private void removePaciente(int index) {
        API.deletePaciente(listaPacientes[index].toString());
        listaPacientes[index] = null;
        reformatArray();
        indexPaciente--;
    }

    // ARRAY É TODO REORGANIZADO
    private void reformatArray() {
        Paciente[] temporaryPacientes = new Paciente[10];
        int indexTemporary = 0;

        for (int i = 0; i < temporaryPacientes.length; i++) {
            if (listaPacientes[i] != null) {
                temporaryPacientes[indexTemporary] = listaPacientes[i];
                temporaryPacientes[indexTemporary].setId(indexTemporary);
                indexTemporary++;
            }
        }

        for (int i = 0; i < listaPacientes.length; i++) {
            if (temporaryPacientes[i] != null) {
                listaPacientes[i] = temporaryPacientes[i];
            } else {
                listaPacientes[i] = null;
            }
        }

        API.reformatArray(listaPacientes);
    }


    public void ordemAlfabetica(){

        if(indexPaciente > 0){
             String[] nomes = new String[(indexPaciente)];
        
            for(int i = 0; i < nomes.length ; i++){
                nomes[i] = listaPacientes[i].getNome();
            }

            System.out.println("\n==== LISTA DE PACIENTES EM ORDEM ALFABETICA ====");

            Arrays.sort(nomes, String.CASE_INSENSITIVE_ORDER);
            for (String nome : nomes) {
                System.out.println(">> " + nome);
            }
        }
        else{
            System.out.println("Ainda não existe nenhum paciente cadastrado");
        }

       
    }

    public double mediaConsultas(){
        double total = 0;
        if(indexPaciente > 0){
            for(int i = 0; i < indexPaciente; i++){
                 total += listaPacientes[i].getConsultas();
            }
        }
        else{
            return -1.0;
        }

        return (total / indexPaciente);
    }

    public double[] procentagemPacientes(int diagnostico){

        if(indexPaciente == 0){
            double err[] = {-1.0};
            return err;
        }

        double valueOfDiagnostico[] = new double[indexPaciente +1];
        valueOfDiagnostico[0] = 0.0;
        int indexArray = 1;

        for(int i = 0; i < indexPaciente ; i++){
            if(listaPacientes[i].getDiagnostico() == diagnostico){
                valueOfDiagnostico[0] += 1.0;
                valueOfDiagnostico[indexArray] = (i);
                indexArray++;
            }
        }
        

        valueOfDiagnostico[0] =  (100 * valueOfDiagnostico[0]) / indexPaciente;

        return valueOfDiagnostico;
    }
}