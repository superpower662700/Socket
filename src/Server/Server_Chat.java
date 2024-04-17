package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Thread.Thread_Socket_Chat;

public class Server_Chat {
	private static List<Thread_Socket_Chat> clients = new ArrayList<>();

	public void server() {
		int count = 0;
		try {
			ServerSocket server = new ServerSocket(2000);
			Scanner scanner = new Scanner(System.in);
			System.out.println("Server is running ... ");
			while (true) {
				System.out.println("Server connected ... " + count++);
				Thread_Socket_Chat thread_socket = new Thread_Socket_Chat(server.accept());

				Thread thread = new Thread(thread_socket);
				clients.add(thread_socket);
				thread.start();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void broadcastMessage(String message, Thread_Socket_Chat sender) {
		for (Thread_Socket_Chat client : clients) {
			if (client != sender) {
				client.sendMessage(message);
			}
		}
	}

	public static void main(String[] args) {
		Server_Chat server = new Server_Chat();
		server.server();
	}
}