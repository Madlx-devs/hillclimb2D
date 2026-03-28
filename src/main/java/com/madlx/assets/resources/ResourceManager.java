package com.madlx.assets.resources;


import java.util.Map;

public interface ResourceManager<T> {

     void loadAll(String path);
     Map<String ,T> getAssets();

}
