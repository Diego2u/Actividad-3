//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class act3 {
    static class Card {
        private final String palo;
        private final String color;
        private final String valor;

    public Card(String palo, String color, String valor) {
        this.palo = palo;
        this.color = color;
        this.valor = valor;
    }
    public String getPalo() {
        return palo;
    }
    public String getColor() {
        return color;
    }
    public String getValor() {
        return valor;
    }
}
//Creamos la lase Card y Definimos el Palo, Color y valor como variables que nos regresara el programa

static class Deck{
    private final Card[] Cartas;
    private int numCarta;

    public Deck() {
        Cartas = new Card [52];
        numCarta = 0;
        inicializarDeck();
        //ponemos el contador total de cartas del deck
    }
    private void inicializarDeck() {
        String[] palos = {"Treboles", "Corazones", "Espadas", "Diamantes"};
        String[] colores = {"Negro", "Rojo"};
        String[] valores = {"2","3","4","5","6","7","8","9","10","J","Q","K"};
        //Definimos los valores de Palos, colores y valores

        for (String palo : palos) {
            String color = (palo.equals("Treboles") || palo.equals("Diamantes")) ? colores[0] : colores[1];
            for (String valor : valores) {
                Cartas[numCarta] = new Card(palo, color, valor);
                numCarta = numCarta + 1;
            }
        }
    }

    public void shuffle() {
        int index = 0;
        while (index < numCarta) {
            int randomIndex = (int) (Math.random() * numCarta);
            Card temp = Cartas[index];
            Cartas[index] = Cartas[randomIndex];
            Cartas[randomIndex] = temp;
            index = index + 1;
            /* Random index lo obtuvimos de un video de youtube,
            hace una multiplicacion de math random por el numero de cartas
             */
        }
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        if (numCarta == 0) {
            System.out.println("No quedan cartas en el Deck.");
            return;
        }
        Card Carta = Cartas[0];
        removeFirstCard();
        System.out.println(Carta.getPalo() + "," + Carta.getColor() + "," + Carta.getValor());
        System.out.println("Quedan " + numCarta + " cartas en deck.");
    }

    public void hand() {
        if (numCarta < 5) {
            System.out.println("No hay suficientes cartas en el Deck.");
            return;
        }
        int count = 0;
        while (count < 5) {
            Card Carta = Cartas[0];
            removeFirstCard();
            System.out.println(Carta.getPalo() + "," + Carta.getColor() + "," + Carta.getValor());
            count = count + 1;
        }
        System.out.println("Quedan " + numCarta + " cartas en deck.");
    }

    public void pick() {
        if (numCarta == 0) {
            System.out.println("No quedan cartas en el Deck.");
            return;
        }

        int randomIndex = (int) (Math.random() * numCarta);
        Card Carta = Cartas[randomIndex];

        // Remover la carta seleccionada del deck
        int i = randomIndex;
        while (i < numCarta - 1) {
            Cartas[i] = Cartas[i + 1];
            i = i + 1; // Incrementar manualmente
        }
        Cartas[numCarta - 1] = null; // Limpiar la última carta
        numCarta--; // Disminuir el contador de cartas

        // Imprimir la información de la carta seleccionada
        System.out.println(Carta.getPalo() + "," + Carta.getColor() + "," + Carta.getValor());
        System.out.println("Quedan " + numCarta + " cartas en el deck.");
    }

    private void removeFirstCard() {
        if (numCarta > 0) {
            int index = 0;
            while (index < numCarta - 1) {
                Cartas[index] = Cartas[index + 1];
                index = index + 1;
            }
            Cartas[numCarta - 1] = null; // Limpiar la última carta
            numCarta = numCarta - 1;
        }
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        deck.head();
        deck.pick();
        deck.hand();
    }
}}
