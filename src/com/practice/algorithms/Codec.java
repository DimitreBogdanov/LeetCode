package com.practice.algorithms;

import java.util.HashMap;
import java.util.Map;

public class Codec {

    private Map<String, String> map;

    public Codec(){
        map = new HashMap<>();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int val = longUrl.hashCode();
        String resultUrl = "http://tinyurl.com/" + val;
        map.put(resultUrl, longUrl);
        return resultUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.getOrDefault(shortUrl, "");
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));