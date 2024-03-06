/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Tocla
 */
public class Students {
    private String name,code, room;;
    private int yob;


    public Students(String name, int yob, String code, String room) {
        this.name = name;
        this.yob = yob;
        this.code = code;
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return name + ", " + yob + ", " + code + ", " + room;
    }
    
    
    public void print() {
        System.out.printf("|Name: %-20s|Year of Birth: %-8d|Student code: %-10s|Room: %-7s|\n", name, yob, code, room);
    }
    
}
