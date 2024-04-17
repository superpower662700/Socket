package Thread;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Thread_write implements Runnable {
	private Socket socket;

	public Thread_write(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Scanner scanner = new Scanner(System.in);
				DataOutputStream pr = new DataOutputStream(socket.getOutputStream());
				pr.writeUTF(scanner.nextLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub

	}
}
