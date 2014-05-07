package skill.s1;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Created by wangmingjie on 14-2-11.
 */
public class Test {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            if (networkInterfaces == null) {
                System.out.println("no addresses");
            } else {
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface interf = networkInterfaces.nextElement();
                    System.out.println("interface is : " + interf.getName());

                    Enumeration<InetAddress> addresses = interf.getInetAddresses();

                    if (!addresses.hasMoreElements()) {
                        System.out.println(interf.getName() + " : no address");
                    }

                    while (addresses.hasMoreElements()) {
                        InetAddress address = addresses.nextElement();
                        String name = address.getHostAddress();
                        System.out.println("the address is : " + name);
                        System.out.println(address.getHostName());
                    }

                    System.out.println("*******");
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
