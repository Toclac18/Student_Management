/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package data;

import java.io.*;
import java.util.*;

/**
 *
 * @author Tocla
 */
public class Shelf extends ArrayList<Students> {

    private List<Students> arr = new ArrayList(); 
    private Scanner sc = new Scanner(System.in);

    public Shelf() {
    }

    public void readFromFile() throws FileNotFoundException, IOException {
        List<Students> str = new ArrayList();
        FileReader fr = new FileReader(
                "D:/JavaGeneral/JavaGeneral/Materials/PRO192/PRO-SE1801/Assigment/Minhtrang_BMW/Students.txt");
        BufferedReader br = new BufferedReader(fr);
        if (checkFile(fr)) {
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                } else {
                    String txt[] = line.split(", ");
                    if (txt.length >= 4) {
                        String name = txt[0];
                        int yob = Integer.parseInt(txt[1]);
                        String code = txt[2];
                        String room = txt[3];
                        str.add(new Students(name, yob, code, room));
                    }
                }
            }
            br.close();
            fr.close();
            for (Students s : str) {
                s.print();
            }
            System.out.println("Reading successfully");
        } else {
            System.out.println("File is not ready");
        }
    }

    public void listToFile() throws IOException {
        FileWriter fw = new FileWriter(
                "D:/JavaGeneral/JavaGeneral/Materials/PRO192/PRO-SE1801/Assigment/Minhtrang_BMW/Students.txt", false);
        BufferedWriter bw = new BufferedWriter(fw);

        printList();
        for (Students students : arr) {
            bw.newLine();
            bw.write(students.toString());
        }

        bw.close();
        fw.close();

        System.out.println("Successfully");
        arr.clear();

    }

    public void addStudent() throws IOException {
        String name, code, room;
        int yob;

        System.out.print("Enter Student name: ");
        name = sc.nextLine();

        System.out.print("Enter Student year of birth: ");
        yob = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Student code: ");
        code = sc.nextLine();

        System.out.print("Enter Student room: ");
        room = sc.nextLine();

        arr.add(new Students(name, yob, code, room));

        System.out.println("Input data successfully");

        FileWriter fw = new FileWriter(
                "D:/JavaGeneral/JavaGeneral/Materials/PRO192/PRO-SE1801/Assigment/Minhtrang_BMW/Students.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Students students : arr) {
            bw.newLine();
            bw.write(students.toString());
        }

        bw.close();
        fw.close();

    }

    public int searchStudent(String code1) throws FileNotFoundException, IOException {
        List<Students> str = new ArrayList();

        FileReader fr = new FileReader(
                "D:/JavaGeneral/JavaGeneral/Materials/PRO192/PRO-SE1801/Assigment/Minhtrang_BMW/Students.txt");
        BufferedReader br = new BufferedReader(fr);

        String line = "";
        while (true) {
            line = br.readLine();
            if (line == null) {
                break;
            }
            if (line.contains(code1) == true) {
                String txt[] = line.split(", ");
                String name = txt[0];
                int yob = Integer.parseInt(txt[1]);
                String code = txt[2];
                String room = txt[3];
                str.add(new Students(name, yob, code, room));
            }
        }
        for (int i = 0; i < str.size(); i++) {
            if (str.get(i).getCode().equalsIgnoreCase(code1) == true) {
                str.get(i).print();
                return i;
            }
        }
        System.out.println("Student not found");
        return -1;
    }

    public void updateProfile() throws FileNotFoundException, IOException {
        String name, code, room;
        int yob;

        FileReader fr = new FileReader(
                "D:/JavaGeneral/JavaGeneral/Materials/PRO192/PRO-SE1801/Assigment/Minhtrang_BMW/Students.txt");
        BufferedReader br = new BufferedReader(fr);

        String line = "";
        while (true) {
            line = br.readLine();
            if (line == null) {
                break;
            } else {
                String txt[] = line.split(", ");
                if (txt.length == 4) {
                    name = txt[0];
                    yob = Integer.parseInt(txt[1]);
                    code = txt[2];
                    room = txt[3];
                    arr.add(new Students(name, yob, code, room));
                }

            }
        }

        System.out.print("Enter student code: ");
        String code1 = sc.nextLine();

        for (Students students : arr) {
            if (students.getCode().equalsIgnoreCase(code1) == true) {
                students.print();
                System.out.print("Enter new Name: ");
                students.setName(name = sc.nextLine());
                System.out.print("Enter new Student code: ");
                students.setCode(code = sc.nextLine());
                System.out.print("Enter new Year of Birth: ");
                students.setYob(yob = Integer.parseInt(sc.nextLine()));
                System.out.print("Enter new Room: ");
                students.setRoom(room = sc.nextLine());
            }
        }

    }

    public void removeStudent() throws FileNotFoundException, IOException {
        String name, code, room;
        int yob;

        FileReader fr = new FileReader(
                "D:/JavaGeneral/JavaGeneral/Materials/PRO192/PRO-SE1801/Assigment/Minhtrang_BMW/Students.txt");
        BufferedReader br = new BufferedReader(fr);

        String line = "";
        while (true) {
            line = br.readLine();
            if (line == null) {
                break;
            } else {
                String txt[] = line.split(", ");
                if (txt.length == 4) {
                    name = txt[0];
                    yob = Integer.parseInt(txt[1]);
                    code = txt[2];
                    room = txt[3];
                    arr.add(new Students(name, yob, code, room));
                }

            }
        }

        System.out.print("Enter student code: ");
        String code1 = sc.nextLine();

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getCode().equalsIgnoreCase(code1) == true) {
                arr.get(i).print();
                arr.remove(i);
            }
        }
    }

    public void printList() {
        if (arr.isEmpty()) {
            System.out.println("You need to input data first");
        } else {
            for (Students students : arr) {
                students.print();
            }
        }
    }

    public boolean checkFile(FileReader fileName) throws IOException {
        File file = new File(
                "D:/JavaGeneral/JavaGeneral/Materials/PRO192/PRO-SE1801/Assigment/Minhtrang_BMW/Students.txt");
        return file.exists();
    }
}
