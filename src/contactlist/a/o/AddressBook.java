/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contactlist.a.o;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author arets
 */
public class AddressBook implements Serializable{
    
    private ArrayList<Contact> contacts ; 
    
    public AddressBook() {
    contacts = new ArrayList<>();

    }
    
    
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void displayContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact.firstName + " " + contact.sureName + " - " + contact.phone);
        }
    }

    public Contact searchContactByPhone(String phone) {
        for (Contact contact : contacts) {
            if (contact.phone.equals(phone)) {
                return contact;
            }
        }
        return null;
    }

    public void deleteContactByPhone(String phone) {
        Contact contactToRemove = null;
        for (Contact contact : contacts) {
            if (contact.phone.equals(phone)) {
                contactToRemove = contact;
                break;
            }
        }
        if (contactToRemove != null) {
            contacts.remove(contactToRemove);
        }
    }
    
    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(contacts);
            System.out.println("Contacts saved to file: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
     public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            contacts = (ArrayList<Contact>) ois.readObject();
            System.out.println("Contacts loaded from file: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
}
