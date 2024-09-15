public class Cipher {
    private char[] alphabet;
    public Cipher(char[] alphabet) {
        this.alphabet = alphabet;
    }
     public String encrypt(String text, int shift) {
         StringBuilder result = new StringBuilder();
         for (int i = 0; i < text.length(); i++) {
             char ch = text.charAt(i);
             if (Character.isLetter(ch)) {
                 char base = Character.isLowerCase(ch) ? 'a' : 'A';
                 result.append((char) ((ch - base + shift) % 26 + base));
             } else {
                 result.append(ch);
             }
         }
         return result.toString();
     }

     public String decrypt(String encryptedText, int shift) {
             return encrypt(encryptedText, 26 - shift);
     }
}

/*
public String encrypt(String text, int shift) {
    StringBuilder result = new StringBuilder();

    for (char c : text.toCharArray()) {
        if (Character.isLetter(c)) {
            char encryptedChar = (char) (((c - 'a') + shift) % 40 + 'a');
            result.append(encryptedChar);
        } else {
            result.append(c);
        }
    }
    return result.toString();
}
 */