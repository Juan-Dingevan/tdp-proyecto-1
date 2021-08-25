package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student s = new Student(12345, "Dingevan", "Juan Ignacio", "jidingevan@gmail.com", "url", "path");
            	SimplePresentationScreen screen = new SimplePresentationScreen(s);
            }
        });
    }
}