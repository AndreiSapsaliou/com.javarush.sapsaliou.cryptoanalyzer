

public class Cipher {

    public static final char[] ALPHABET_RUS = {
            'а', 'б', 'в','г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п',
            'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я',
            '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public static final char[] ALPHABET_ENG = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '.', ',', '«', '»',
            '"', '\'', ':', '!', '?', ' '};

    private int getIndex(char c, char[] alphabet) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public String encrypt(String text, int key, String language) {
        return shiftText(text, key, language);
    }

    public String decrypt(String text, int key, String language) {
        return shiftText(text, -key, language);
    }

    private String shiftText(String text, int key, String language) {
        StringBuilder shiftedText = new StringBuilder();
        char[] alphabet = language.equals("rus") ? ALPHABET_RUS : ALPHABET_ENG;

        for (char c : text.toCharArray()) {
            int idx = getIndex(c, alphabet);
            if (idx != -1) {
                int newIdx = (idx + key) % alphabet.length;
                newIdx = (newIdx + alphabet.length) % alphabet.length; // Защита от отрицательных индексов
                shiftedText.append(alphabet[newIdx]);
            } else {
                shiftedText.append(c); // Неалфавитные символы остаются без изменений
            }
        }
        return shiftedText.toString();
    }
}
