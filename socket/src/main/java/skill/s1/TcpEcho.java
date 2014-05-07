package skill.s1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by wangmingjie on 14-2-11.
 */
public class TcpEcho {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8080);
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            String hi = "hello, nihao!";
             out.write(hi.getBytes());

            int a = 0;
            byte[] bytes = new byte[12];

            while ((a=in.read(bytes))!=0){
                System.out.print(new String(bytes,0,a));
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
