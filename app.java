public class App {
    public static void main(String[] args) {

        // String[] res = API.filterPacientes("nome", "João");

        // for (String i : res) {
        // System.out.println(i);
        // }
        
        CadastroPacientes teste1 = new CadastroPacientes();
        do{
          
        }while(execApp(teste1));
    }

    public static boolean execApp(CadastroPacientes cadastro1) {
        System.out.println("\n======================= MENU HOSPIAL =======================");
        System.out.println("(1) - Cadastrar Paciente");
        System.out.println("(2) - Remover Paciente");
        System.out.println("(3) - Exibir todos os pacientes");
        System.out.println("(4) - Exibir nomes dos pacientes em ordem alfabetica");
        System.out.println("(5) - Média de consultas por paciente");
        System.out.println("(6) - Exibir porcentagem de pacientes por diagnóstico");
        System.out.println("(7) - Fechar programa");

        int optionAtual = Input.lerInt("Sua Opção: >> ");
        Input.clearBuffer();

        switch (optionAtual) {
            case 1: {
                cadastro1.CadastrarPaciente();
                break;
            }
            case 2: {
                cadastro1.selectPacienteRemove();
                break;
            }
            case 3: {
                cadastro1.listPacientes();
                break;
            }
            case 4: {
                cadastro1.ordemAlfabetica();
                break;
            }
            case 5: {
                double mediaConsultas = cadastro1.mediaConsultas();
                if (mediaConsultas == -1) {
                    System.out.println("Nenhum paciente cadastrado");
                } else {
                    System.out.println("Média de consultas por paciente: " + mediaConsultas);
                }
                break;
            }
            case 6: {
                int diagnostico = selectDiagnostico();
                if(diagnostico != -1){
                    double value[] = cadastro1.procentagemPacientes(diagnostico);
                    
                    System.out.println("A porcentagem de pacientes com o diagnóstico " + diagnostico + " é de: " +  value[0] + "%");
                    System.out.println("Ids dos pacientes: ");
                    for(int i = 1 ; i < value.length ; i++){
                        System.out.println(value[i]);
                    }
                }
                break;
            }

            case 7: {
                System.out.println("Programa encerrado");
                break;
            }
            default: {
                if(CadastroPacientes.tryAgain("Opção Inválida!")){
                    execApp(cadastro1);
                }
                else{
                    return false;
                }
            }
        }

        return true;
    }

    public static int selectDiagnostico(){
        int option;
        String diagnostico;
        System.out.println("==== ESCOLHA O DIAGNOSTICO ====");

        System.out.print("\nSelecione o diagnóstico");
        System.out.print("\n(1) - Covid");
        System.out.print("\n(2) - Dengue");
        System.out.print("\n(3) - Influenza");
        System.out.print("\n(4) - Meningite");
        System.out.print("\n(5) - Outro");
        System.out.print("\n==============================");

        option = Input.lerInt("\n\nSua opção: >> ");
        Input.clearBuffer();

        if(option < 1 || option > 5){
            if(CadastroPacientes.tryAgain("Opção Inválida!")){
                selectDiagnostico();
            }
            else{
                return -1;
            }
        }
        else{
           return option;
        }
    }
}
