public class Cipher {
    private char[] alphabet;
    public Cipher(char[] alphabet) {
        this.alphabet = alphabet;
    }
     public String encrypt(String text, int shift) {
         StringBuilder result = new StringBuilder();

         for (char c : text.toCharArray()) {
             if (Character.isLetter(c)) {
                 char encryptedChar = (char) (((c - 'a') + shift) % 26 + 'a');
                 result.append(encryptedChar);
             } else {
                 result.append(c);
             }
         }
         return result.toString();
     }
        // Логика шифрования

    // public String decrypt(String encryptedText, int shift) {
        // Логика расшифровки
    // }
}
