public class CodificadorRotativo {

    public static String codificar(String mensagem, int chave) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < mensagem.length(); i++) {
            int valor = mensagem.charAt(i);

            valor += chave + (i * 7);

            valor = Integer.rotateLeft(valor, 3);

            resultado.append((char) valor);
        }

        return resultado.toString();
    }

    public static String decodificar(String mensagem, int chave) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < mensagem.length(); i++) {
            int valor = mensagem.charAt(i);

            valor = Integer.rotateRight(valor, 3);

            valor -= chave + (i * 7);

            resultado.append((char) valor);
        }

        return resultado.toString();
    }

    public static void main(String[] args) {

        String mensagem = "Olá mundo!";
        int chave = 123;

        String codificada = codificar(mensagem, chave);

        System.out.println("Original: " + mensagem);
        System.out.println("Codificada: " + codificada);
        System.out.println("Decodificada: " + decodificar(codificada, chave));
    }
}