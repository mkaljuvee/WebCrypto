public class SimpleCrypto implements Crypto {

    public String encrypt(String word) {
        char[] character = word.toCharArray();
        int charNum;
        char newChar;
        StringBuilder e = new StringBuilder();

        for(char c : character) {
            charNum = (int)c + 5;
            newChar = (char)charNum;
            e.append(newChar);
        }
        return e.reverse().toString();
    }

    public String decrypt(String word) {
        char[] character = word.toCharArray();
        int charNum;
        char newChar;
        StringBuilder d = new StringBuilder();

        for(char c : character) {
            charNum = (int)c - 5;
            newChar = (char)charNum;
            d.append(newChar);
        }
        return d.reverse().toString();
    }
}

