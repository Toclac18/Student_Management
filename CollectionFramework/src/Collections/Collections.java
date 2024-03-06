/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;
import data.Shelf;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Tocla
 */
public class Collections {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
     
        Shelf TU = new Shelf();
        int choice;
        do {
            printMenu();
            System.out.print("Enter the given above: ");
            choice = Integer.parseInt(sc.nextLine());
            
            switch (choice) {
                case 1:
                    TU.addStudent();
                    break;
                case 2:
                    TU.updateProfile();
                    break;
                case 3:
                    TU.removeStudent();
                    break;
                case 4:
                    TU.printList();
                    break;
                case 5:
                    TU.readFromFile();
                    break;
                case 6:
                    TU.listToFile();
                    break;
                case 7:
                    System.out.print("Enter Students code: ");
                    String code1 = sc.nextLine();
                    TU.searchStudent(code1);
                    break;
                default:
                    return;
            }
        } while(choice < 8);
    }
    
    public static void printMenu() {
        System.out.println("1. Add a new Student");
        System.out.println("2. Update profile");
        System.out.println("3. Remove a student");
        System.out.println("4. Print List of Students");
        System.out.println("5. Read from File");
        System.out.println("6. List to File");
        System.out.println("7. Search Students");
        System.out.println("8. Exit");
    }
}
