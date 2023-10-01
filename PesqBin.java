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

    public void ler(String idPin) {
        String[] nLine = new String[250];
        BufferedReader s = null;
        try {
            s = new BufferedReader(new FileReader("tmp/players.csv"));
            s.readLine(); // pular cabecalho
            do {
                nLine = s.readLine().split(",", 8);
                String nome = nLine[1];
                String altura = nLine[2];
                String peso = nLine[3];
                String college = nLine[4];
                String nasc = nLine[5];
                String cNasc = nLine[6];
                String sNasc = nLine[7];
                setAll(idPin, nome, altura, peso, college, nasc, cNasc, sNasc); // funcao setAll para
                                                                                                  // setar todos os
                                                                                                  // atributos para a
                                                                                                  // instancia atual, a
                                                                                                  // fim de imprimir
                                                                                                  // logo depois na
                                                                                                  // main. Caso fosse
                                                                                                  // criado uma nova
                                                                                                  // instancia aqui, nao
                                                                                                  // daria certo a
                                                                                                  // impressao na main,
                                                                                                  // pois seriam
                                                                                                  // instancias
                                                                                                  // diferentes.
                
         } while ((!nLine[0].equals(idPin))); // somente ler enquanto for != id
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}

class PesqBin extends Jogador {
    String[] ids = new String[4];

    /*void quicksort(int esq, int dir) {
        int i = esq, j = dir, pivo = ids[(esq + dir) / 2];
        while (i <= j) { // i incrementa e j decrementa ate se i > j, para chamada rec
            while (ids[i] < pivo) {
                i++;
            }
            while (ids[j] > pivo) {
                j--;
            } // fim dos while que aproximam i e j
            if (i <= j) {
                int temp = j;
                j = i;
                i = temp; // fim swap de i com j

                i++;
                j--; // mov do i e j
            } // if com swap para colocar os < pivo a esq, e > pivo a dir
        }
        // quando i > j, tera 2 particoes, de 0(esq) a j(meio), e de i a dir(n-1)
        if (esq < j)
            quicksort(esq, j); // ordena a particao de 0 a j(meio)
        if (i < dir)
            quicksort(i, dir); // ordena a particao de i a dir(n-1)
    }*/

    public static void main(String[] args) {
        PesqBin obj = new PesqBin();
        //obj.ids = new String[5];
        String[] players = new String[200];
        int count = 0;

        do {
            // vetor de ids para ordenar
            obj.ids[count] = MyIO.readLine();
            count++;
        } while (!obj.ids[count - 1].equals("FIM"));
        for(int i = 0; i < obj.ids.length; i++){
        MyIO.println("ids: "+"i: " + i + obj.ids[i]);
        }

        //obj.quicksort(0, obj.ids.length); // ordenar os ids

        //for (int i = 0; i < obj.ids.length; i++) {
        //    obj.ler((obj.ids[i])); // le do arquivo o jogador de cada id
        //    players[i] = obj.get_player(); // atribui ao vetor players[pos] os nomes de cada jogador lido pelo id
        //}

        // ordenar o array de Strings com o nome
        for (int i = 0; i < players.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < players.length; j++) {
                if (players[menor].compareTo(players[j]) > 0) {
                    menor = j;
                }
            }
            // swap players[i], players[menor(j)]
            String temp = players[menor];
            players[menor] = players[i];
            players[i] = temp;
        } // fim selec sort

        // pesqBin e leitura dos jogadores da entrada
        String nome = "";
        do {
            nome = MyIO.readLine();

            boolean resp = false;
            int dir = players.length - 1, esq = 0, meio;
            while (esq <= dir) {
                meio = (esq + dir) / 2;
                if (players[meio] == nome) {
                    resp = true;
                    esq = players.length;
                } else if (nome.compareTo(players[meio]) > 0){
                    esq = meio + 1;
                } else if (nome.compareTo(players[meio]) < 0){
                    dir = meio - 1;
                }
            } // enquando esq <= dir, ate a pos meio == nome ou nao achar

            if(resp){
                MyIO.println("SIM");
            }else{
                MyIO.println("NAO");
            } // fim pesqBin
        } while (!nome.equals("FIM"));
    }
}
