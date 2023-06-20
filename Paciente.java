public class Paciente {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private int consultas;
    private boolean convenio;
    private int diagnostico;


    //========= CONSTRUCTOR ========== //


    //*** PRIMEIRA VERSÃO:  id estático controlado pelo App
    //*** POSTERIORMENTE fazer dinamico pelo txt

    public Paciente(int id, String nome, String cpf, String telefone, int consultas, boolean convenio, int diagnostico) {
        this.id = id;   //Temporário
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.consultas = consultas;
        this.convenio = convenio;
        this.diagnostico = diagnostico;
    }


    //========= MÉTODOS DE FUNCIONALIDADES ========== //

    public double totalAPagar(double value){
        if(!convenio){
            return value * consultas;
        }
        else{
            return 0;
        }
    }


    //FUNÇÃO A SER CONSTRUÍDA DEPOIS PARA FORMATAR DADOS NO TXT
    public String saveData(){
        return "";
    }





    //========= MÉTODOS GETERS ========== //

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getConsultas() {
        return consultas;
    }

    public boolean getConvenio(){
        return convenio;
    }

    public int getDiagnostico() {
        return diagnostico;
    }

    //========= MÉTODOS SETERS ========== //

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setConsultas(int consultas) {
        this.consultas = consultas;
    }

    public void setConvenio(boolean convenio) {
        this.convenio = convenio;
    }

    public void setDiagnostico(int diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setId(int id) {
        this.id = id;
    }

    //========= MÉTODOS MÁGICOS ========== //

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
