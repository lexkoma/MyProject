package airlinecompany.tools;

public class HashManager {

    public static int createHashValue(String hashingString) {

        char[] symbolsArray = hashingString.toCharArray();
        int hash = 0;

        for (char iter : symbolsArray) {
            hash += iter;
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);

        return hash;
    }
}
