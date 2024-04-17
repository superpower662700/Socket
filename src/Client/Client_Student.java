package Client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import Model.Student;

public class Client_Student {
	public void Connect() {
		try {
			Socket sk = new Socket("localhost", 2000);
			ObjectOutputStream oos = new ObjectOutputStream(sk.getOutputStream());
			Student s1 = new Student(1, "Quang Anh");
			oos.writeObject(s1);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Client_Student client = new Client_Student();
		client.Connect();
	}
}
