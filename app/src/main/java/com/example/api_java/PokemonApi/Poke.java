package com.example.api_java.PokemonApi;


import java.util.List;

public class Poke {
    private String next;
    private long count;
    private List<ResultApi> results;

    public String getNext() {
        return next;
    }

    public void setNext(String value) {
        this.next = value;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long value) {
        this.count = value;
    }

    public List<ResultApi> getResults() {
        return results;
    }

    public void setResults(List<ResultApi> value) {
        this.results = value;
    }
}
