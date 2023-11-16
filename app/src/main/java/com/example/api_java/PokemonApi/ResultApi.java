// Poke.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.example.api_java.PokemonApi;
import java.util.List;


public class ResultApi {
    private String name;
    private String url;
    private int id;

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String geturl() { return url; }
    public void seturl(String value) { this.url = value; }

    public int getId() {
        String[] urlSplit = url.split("/");
        return Integer.parseInt(urlSplit[urlSplit.length - 1]);
    }
}
