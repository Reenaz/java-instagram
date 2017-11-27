package ru.kfu.itis;

import com.google.gson.Gson;

public class GsonTest {
    public static void main(String[] args) {
        String name = "ddddd";
        String json = new Gson().toJson(name);
        System.out.println(json);
    }
}
