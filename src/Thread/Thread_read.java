package Thread;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Thread_read implements Runnable {
	private Socket socket;

	public Thread_read(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		try {
			DataInputStream br = new DataInputStream(socket.getInputStream());
			while (true) {
				System.out.println(br.readUTF());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

	}

}
