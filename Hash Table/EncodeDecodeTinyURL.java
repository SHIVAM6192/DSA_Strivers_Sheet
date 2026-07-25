import java.util.HashMap;

// https://leetcode.com/problems/encode-and-decode-tinyurl
public class EncodeDecodeTinyURL {
    private HashMap<String, String> map;
    private int id;
    private static final String BASE_URL = "http://tinyurl.com/";

    EncodeDecodeTinyURL(){
        map = new HashMap<>();
        id = 0;
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortURL = BASE_URL + id;
        map.put(shortURL, longUrl);
        id++;
        return shortURL;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
