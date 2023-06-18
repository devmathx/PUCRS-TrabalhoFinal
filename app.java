public class App {
    public static void main(String[] args) {
 
        String[] res = API.filterPacientes("nome", "João");
        
        for (String i : res) {
            System.out.println(i);
        }

    }
}
