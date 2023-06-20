import javax.sound.sampled.SourceDataLine;

public class CadastroPacientes {

    private Paciente[] listaPacientes = new Paciente[10];
    private int indexPaciente = 0;
    // 1- Covid
    // 2- Dengue
    // 3- Influenza
    // 4- Meningite
    // 5- Outro

    public CadastroPacientes(){
        setDataInObject();
    }

    public boolean setDataInObject() {
        String nome;                 // 0
        String cpf;                  // 1
        String telefone;             // 2
        int consultas;               // 3
        boolean convenio = false;            // 4
        
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

            for(int i = 0 ; i < values.length ; i++){
                values[i][1] = Input.lerString(values[i][0]);

                if(values[i][1] == "" || values[i][1] == " "){
                    System.out.println("\nVocê não digitou corretamente...Por favor, tente de novo!");

                    i--;
                }
                else if(i == 3){
                    if(!(values[i][1].trim().matches("^\\d+$"))){
                        System.out.println("\nVocê não digitou corretamente...Por favor, tente de novo!");
                        i--;

                    }
                }
                else if(i == 4){
                    values[i][1].trim();

                    if(values[i][1].equalsIgnoreCase("S")) convenio = true;
                    else if(values[i][1].equalsIgnoreCase("N")) convenio = false;
                    else{
                        System.out.println("\nVocê não digitou corretamente...Por favor, tente de novo!");
                        i--;
                    }
                }
            }

            nome = values[0][1];
            cpf = values[1][1];
            telefone = values[2][1];
            consultas = Integer.parseInt(values[3][1]);


            listaPacientes[indexPaciente] = new Paciente(indexPaciente, nome, cpf, telefone, consultas, convenio, diagnostico);
            System.out.print(listaPacientes[indexPaciente]);
            indexPaciente++;
        } else {
            System.out.println("Você escolheu voltar\n");
            flagCadastro = false;
            return false;
        }

        return true;
    }

    public int printMenu() {
        int option;

        System.out.println("==== CADASTRO DE PACIENTE ====");

        System.out.print("\nSelecione o diagnóstico");
        System.out.print("\n(1) - Covid");
        System.out.print("\n(2) - Dengue");
        System.out.print("\n(3) - Influenza");
        System.out.print("\n(4) - Meningite");
        System.out.print("\n(5) - Outro");
        System.out.print("\n(6) - Voltar");
        System.out.print("\n==============================");

        option = Input.lerInt("\n\nSua opção: >> ");
        Input.clearBuffer();

        switch (option) {
            case 1:
                return option;
            case 2:
                return option;
            case 3:
                return option;
            case 4:
                return option;
            case 5:
                return option;
            case 6:
                return option;
            default: {
                System.out.println("Opção inválida! Informe novamente\n");
                printMenu();
                return -1;
            }
        }
    }

}