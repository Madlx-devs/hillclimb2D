package com.madlx.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class TerrainLoader {
    public static HashMap<String, int[][]> maps = new HashMap<>();

    public TerrainLoader() {
        try {
            InputStream is = getClass().getResourceAsStream("/textures/terrains.txt");
            if (is != null) {
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.startsWith("//")) {
                        continue;
                    }
                    if (line.isEmpty()) {
                        continue;
                    } else {
                        maps.put(line, loadTerrain(line));
                    }
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int[][] loadTerrain(String terrainName) {
        int[][] arr = new int[0][];
        try {
            InputStream is = getClass().getResourceAsStream("/textures/" + terrainName);
            if (is != null) {
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.startsWith("//")) {
                        continue;
                    }
                    if (line.isEmpty()) {
                        continue;
                    }
                     arr = new int[line.length()][line.length()];
                    for(int i=0;i<line.length();i++){
                        for(int j =0;j<line.length();j++){
                            arr[i][j]=line.charAt(i);
                        }
                    }

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return arr;
    }
    public static  int[][] getTerrain(String name){
        return maps.get(name);
    }
}