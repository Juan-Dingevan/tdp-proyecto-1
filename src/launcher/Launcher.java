package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Integer lu = 130683;
            	String apellido = "Dingevan";
            	String nombre = "Juan Ignacio";
            	String email = "jidingevan@gmail.com";
            	String url = "https://github.com/Juan-Dingevan/tdp-proyecto-1";
            	String path = "/images/me.jpg";
            	
            	Student s = new Student(lu, apellido, nombre, email, url, path);
            	SimplePresentationScreen screen = new SimplePresentationScreen(s);
            }
        });
    }
}