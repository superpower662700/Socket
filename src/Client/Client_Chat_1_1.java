package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client_Chat_1_1 {
	public void connect() {
		try {
			Socket socket = new Socket("localhost", 2000);
			System.out.println("Client start ... ");
			Scanner scanner = new Scanner(System.in);
//			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			PrintStream pr = new PrintStream(socket.getOutputStream());
			DataInputStream br = new DataInputStream(socket.getInputStream());
			DataOutputStream pr = new DataOutputStream(socket.getOutputStream());
			pr.writeUTF("Start !");
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
			System.out.println("END !");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Client_Chat_1_1 client = new Client_Chat_1_1();
		client.connect();
	}
}
