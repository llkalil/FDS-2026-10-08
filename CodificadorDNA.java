import java.time.LocalDate;

public class CodificadorDNA implements Codificador {

    public String getNome() {
        return "Codificador DNA";
    }

    public LocalDate getDataCriacao() {
        return LocalDate.of(2025, 03, 13);
    }

    public int getNivelSeguranca() {
        return 3;
    }

    public String codifica(String str) {
        StringBuilder encoded = new StringBuilder();

        for (char c : str.toCharArray()) {

            // Cada char possui 16 bits.
            // Pegamos 2 bits por vez e transformamos
            // em uma base nitrogenada.
            for (int i = 14; i >= 0; i -= 2) {

                int bits = (c >> i) & 3;

                switch (bits) {
                    case 0:
                        encoded.append('A');
                        break;

                    case 1:
                        encoded.append('C');
                        break;

                    case 2:
                        encoded.append('G');
                        break;

                    case 3:
                        encoded.append('T');
                        break;
                }
            }
        }

        return encoded.toString();
    }

    public String decodifica(String str) {
        StringBuilder decoded = new StringBuilder();

        for (int i = 0; i < str.length(); i += 8) {

            int valor = 0;

            // Cada caractere original possui 8 bases de DNA.
            for (int j = 0; j < 8; j++) {

                char base = str.charAt(i + j);

                int bits;

                switch (base) {
                    case 'A':
                        bits = 0;
                        break;

                    case 'C':
                        bits = 1;
                        break;

                    case 'G':
                        bits = 2;
                        break;

                    case 'T':
                        bits = 3;
                        break;

                    default:
                        throw new IllegalArgumentException(
                            "Sequência de DNA inválida: " + base
                        );
                }

                valor = (valor << 2) | bits;
            }

            decoded.append((char) valor);
        }

        return decoded.toString();
    }
}