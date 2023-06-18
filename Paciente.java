public class Paciente {
    String nome;
    String cpf;
    String telefone;
    int consultas;
    boolean convenio;
    String diagnostico;

    public Paciente() {
        
    }

    public String toString() {
        String text = "";
        text += "nome: " + nome;
        text += ", cpf: " + cpf;
        text += ", telefone: " + telefone;
        text += ", consultas: " + consultas;
        text += ", convenio: " + convenio;
        text += ", diagnostico: " + diagnostico;

        return "{ " + text + " }";
    } 
}
