public class LatinInstrumental {
    public static String useInstrument(String noun, String instrument) {
        return noun + " " + "par le moyen de" + " " + instrument;
    }

    public static void main(String[] args) {
        String noun = "travail";
        String instrument = "l'ordinateur";

        System.out.println(useInstrument(noun, instrument));

        //travail par le moyen de l'ordinateur
    }
}