public class Paciente {

    private String nome;
    private String cpf;
    private int numeroTelefeone;
    private String convenio;
    private String diagnostico;
    private int numeroConsultas;

    public Paciente(String nome, String cpf, int numeroTelefeone, String convenio, String  diagnostico, int numeroConsultas){
        this.nome = nome;
        this.cpf = cpf;
        this.numeroTelefeone = numeroTelefeone;
        this.convenio = convenio;
        this.diagnostico = diagnostico;
        this.numeroConsultas = numeroConsultas;
    }


    public double valorTotalConsultas(double value){
        return value * this.numeroConsultas;
    }

    public String getConvenio() {
        return convenio;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getNumeroTelefeone() {
        return numeroTelefeone;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public int getNumeroConsultas() {
        return numeroConsultas;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setNumeroConsultas(int numeroConsultas) {
        this.numeroConsultas = numeroConsultas;
    }

    public void setNumeroTelefeone(int numeroTelefeone) {
        this.numeroTelefeone = numeroTelefeone;
    }

    public String toString() {
        return 
            "Nome: " + this.nome + 
            "\nCpf: " + this.cpf + 
             "\nTelefone: " + this.numeroTelefeone +
             "\nConvênio: " + this.convenio +
             "\nDiagnóstico: " + this.diagnostico +
             "\nNumero de Consultas: " + this.numeroConsultas
        ; 
    }
}
