package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client_1 {
	public void connect() {
		try {
			Socket sk = new Socket("localhost", 1985);
			PrintStream ps = new PrintStream(sk.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			System.out.println("Client is running ...");
			ps.println("Client request.");
			String rq = br.readLine();
			if (rq != null) {
				System.out.println(rq);

			} else {
				System.out.println("fail");
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Client_1 cl = new Client_1();
		cl.connect();
	}
}
