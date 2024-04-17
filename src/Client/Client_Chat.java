package Client;

import java.io.IOException;
import java.net.Socket;

import Thread.Thread_read;
import Thread.Thread_write;

public class Client_Chat {
	public void connect() {
		try {
			Socket socket = new Socket("localhost", 2000);
			System.out.println("Client start ... ");
			Runnable read = new Thread_read(socket);
			Runnable write = new Thread_write(socket);

			Thread tr = new Thread(read);
			Thread tw = new Thread(write);
			tr.start();
			tw.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Client_Chat client = new Client_Chat();
		client.connect();
	}
}
