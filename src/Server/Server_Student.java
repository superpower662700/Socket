package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import Model.Student;

public class Server_Student {
	public void Server() {
		try {
			ServerSocket sv = new ServerSocket(2000);
			System.out.println("Server is running ...");
			Socket sk = sv.accept();
			System.out.println("Server connected ...");
			ObjectInputStream ois = new ObjectInputStream(sk.getInputStream());
			Student s1 = (Student) ois.readObject();
			if (s1 != null) {
				System.out.println("Student: " + s1.getId() + " - " + s1.getName());
			} else {
				System.out.println("FAIL");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Server_Student server = new Server_Student();
		server.Server();
	}
}
