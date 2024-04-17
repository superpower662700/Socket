package Thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import Server.Server_Chat;

public class Thread_Socket_Chat implements Runnable {
	private Socket socket;
	private String message = "";
	DataInputStream br;
	DataOutputStream pr;

	public Thread_Socket_Chat(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			br = new DataInputStream(socket.getInputStream());
			pr = new DataOutputStream(socket.getOutputStream());
			System.out.println("Start : ");
			while (!(message = br.readUTF()).equals(null)) {
				System.out.println(message);
				Server_Chat.broadcastMessage(message, this);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendMessage(String message) {
		try {
			pr.writeUTF(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
