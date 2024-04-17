package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_1 {
	public void server() {
		try {
			ServerSocket sv = new ServerSocket(1985);
			System.out.println("Server is running ...");
			Socket sk = sv.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			PrintStream pr = new PrintStream(sk.getOutputStream());

			String rq = br.readLine();
			if (rq != null) {
				System.out.println(rq);

				pr.println("Success");
			} else {
				System.out.println("fail");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Server_1 sv = new Server_1();
		sv.server();
	}
}
