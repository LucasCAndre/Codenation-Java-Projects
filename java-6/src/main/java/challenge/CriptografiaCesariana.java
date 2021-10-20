package challenge;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
        if (texto == null) throw new NullPointerException();
        if (texto.isEmpty()) throw new IllegalArgumentException();
        String lowerTexto = texto.toLowerCase();
        String newString = new String("");
        for (char c : lowerTexto.toCharArray()) {
            if ((c < 48 || c > 57) && c != ' ') {
                char newChar = (char) (c + 3);
                newString = newString + newChar;
            }else if (c == ' '){
                newString = newString + " ";
            }else{
                newString = newString + c;
            }
        }
        return newString;
    }

    @Override
    public String descriptografar(String texto) {
        if (texto == null) throw new NullPointerException();
        if (texto.isEmpty()) throw new IllegalArgumentException();
        String lowerDTexto = texto.toLowerCase();
        String newDString = new String("");
        for (char c : lowerDTexto.toCharArray()) {
            if ((c < 48 || c > 57) && c != ' ') {
                char newDChar = (char) (c - 3);
                newDString = newDString + newDChar;
            }else if (c == ' '){
                newDString = newDString + " ";
            }else{
                newDString = newDString + c;
            }
        }
        return newDString;
    }
}