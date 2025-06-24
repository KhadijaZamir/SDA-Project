/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdafinalproject;

import java.util.HashMap;

public class UserDatabase {
    private static final HashMap<String, String[]> users = new HashMap<>();
    
    public static boolean addUser(String username, String password, String email) {
        if (users.containsKey(username)) return false;
        users.put(username, new String[]{password, email});
        return true;
    }
    
    public static boolean validateUser(String username, String password) {
        if (!users.containsKey(username)) return false;
        return users.get(username)[0].equals(password);
    }
    
    public static boolean emailExists(String email) {
        for (String[] userData : users.values()) {
            if (userData[1].equals(email)) return true;
        }
        return false;
    }
}
