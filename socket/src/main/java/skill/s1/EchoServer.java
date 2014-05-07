package skill.s1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.SortedMap;

/**
 * Created by wangmingjie on 14-2-11.
 */
public class EchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080, 100);

            while (true) {
                Socket socket = serverSocket.accept();

                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();

                byte[] bytes = new byte[12];
                int total = 0;
                int a = 0;

                while ((a = in.read(bytes)) != -1) {
                    System.out.println();
                    out.write(bytes, 0, a);
                    total += a;
                }
               // out.write("I am your majesti!".getBytes());
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
