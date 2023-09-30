import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Jogador {
    private String id;
    private String player;
    private String altura;
    private String peso;
    private String college;
    private String born;
    private String bCity;
    private String bState;
    // definicao dos atributos da classe tipo jogador

    Jogador() {

    } // construtor padrao

    public void setAll(String id, String player, String altura, String peso, String college, String born, String bCity,
            String bState) {
        set_id(id);
        set_player(player);
        set_altura(altura);
        set_peso(peso);
        set_college(college);
        set_born(born);
        set_bCity(bCity);
        set_bState(bState);
    }

    Jogador(String id, String player, String altura, String peso, String college, String born, String bCity,
            String bState) {
        setAll(id, player, altura, peso, college, born, bCity,
                bState);
    } // construtor inicializador

    Jogador(Jogador clone) {
        clone.id = this.id;
        clone.player = this.player;
        clone.altura = this.altura;
        clone.peso = this.peso;
        clone.college = this.college;
        clone.born = this.born;
        clone.bCity = this.bCity;
        clone.bState = this.bState;
    } // construtor que clona a instancia atual

    // todos os setters verificam se a string esta vazia
    public void set_id(String id) {
        if (id.equals("")) {
            this.id = "nao informado";
        } else {
            this.id = id;
        }
    }

    public void set_player(String player) {
        if (player.equals("")) {
            this.player = "nao informado";
        } else {
            this.player = player;
        }
    }

    public void set_altura(String altura) {
        if (altura.equals("")) {
            this.altura = "nao informado";
        } else {
            this.altura = altura;
        }
    }

    public void set_peso(String peso) {
        if (peso.equals("")) {
            this.peso = "nao informado";
        } else {
            this.peso = peso;
        }
    }

    public void set_college(String college) {
        if (college.equals("")) {
            this.college = "nao informado";
        } else {
            this.college = college;
        }
    }

    public void set_born(String born) {
        if (born.equals("")) {
            this.born = "nao informado";
        } else {
            this.born = born;
        }
    }

    public void set_bCity(String bCity) {
        if (bCity.equals("")) {
            this.bCity = "nao informado";
        } else {
            this.bCity = bCity;
        }
    }

    public void set_bState(String bState) {
        if (bState.equals("")) {
            this.bState = "nao informado";
        } else {
            this.bState = bState;
        }
    } // end setters

    public String get_id() {
        return this.id;
    }

    public String get_player() {
        return this.player;
    }

    public String get_altura() {
        return this.altura;
    }

    public String get_peso() {
        return this.peso;
    }

    public String get_college() {
        return this.college;
    }

    public String get_born() {
        return this.born;
    }

    public String get_bCity() {
        return this.bCity;
    }

    public String get_bState() {
        return this.bState;
    }
    // end getters

    public void imprimir() {
        MyIO.println("[" + get_id() + " ## " + get_player() + " ## " + get_altura() + " ## " + get_peso() + " ## "
                + get_born() + " ## " + get_college() + " ## " + get_bCity() + " ## " + get_bState() + "]");
    }

    public Jogador clone(Jogador clone) {
        // chamada do construtor para clonagem
        Jogador clon = new Jogador(clone);
        return clon;
    }

    public void ler(int idPin) {
        String[] nLine = null ; 
        BufferedReader s = null;
        String line = "";
        try {
            s = new BufferedReader(new FileReader("tmp/players.csv"));
            s.readLine(); // pular cabecalho
            do{
                    nLine = s.readLine().split(",", 8);

                    String nome = nLine[1];
                    String altura = nLine[2];
                    String peso = nLine[3];
                    String college = nLine[4];
                    String nasc = nLine[5];
                    String cNasc = nLine[6];
                    String sNasc = nLine[7];
                    setAll(Integer.toString(idPin), nome, altura, peso, college, nasc, cNasc, sNasc); // funcao setAll para setar todos os atributos para a instancia atual, a fim de imprimir logo depois na main. Caso fosse criado uma nova instancia aqui, nao daria certo a impressao na main, pois seriam instancias diferentes.
            }while(Integer.valueOf(nLine[0]) != idPin); // somente ler enquanto for != id
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]) {
        Jogador jogador = new Jogador();
        String id;
        id = MyIO.readLine();
        while (!id.equals("FIM")) {
            jogador.ler(Integer.valueOf(id));
	    jogador.imprimir();
            id = MyIO.readLine();
        }
    }
}
