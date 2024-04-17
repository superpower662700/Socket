package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server_Chat_1_1 {
	public void server() {
		int count = 0;
		try {
			ServerSocket server = new ServerSocket(2000);
			Scanner scanner = new Scanner(System.in);
			System.out.println("Server is running ... ");
			while (true) {
				Socket socket = server.accept();
				System.out.println("Server connected  ... " + count++);
//				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//				PrintStream pr = new PrintStream(socket.getOutputStream());
				DataInputStream br = new DataInputStream(socket.getInputStream());
				DataOutputStream pr = new DataOutputStream(socket.getOutputStream());
				System.out.println("Start : ");
				String mes = "";
				while (!(mes = br.readUTF()).equals("END")) {
					System.out.println(mes);
					mes = scanner.nextLine();
					if (mes.equals("END")) {
						pr.writeUTF(mes);
						break;
					}
					pr.writeUTF(mes);
				}
				socket.close();
				System.out.println("END");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Server_Chat_1_1 server = new Server_Chat_1_1();
		server.server();
	}
}
