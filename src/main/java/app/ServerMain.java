package main.java.app;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerMain {
	public static final int PORT =8881;
	public static String IP;
	
    public static void main(String[] args) {
    	new ServerMain().startServer();

    }
    
    private void startServer() {
		InetAddress ip;
		
        try {
            ip = InetAddress.getLocalHost();
            IP = ip.getHostAddress();
            System.out.println("IP address of the server: " + ip.getHostAddress());
            System.out.println("Creating a socket - " + (new Date()).toString());
            System.out.println("Main Server done");
            
            ServerSocket serverSocket = new ServerSocket(PORT);
            
            ServerWaitingClient swc = new ServerWaitingClient(serverSocket);
            Thread tr = new Thread(swc);
            tr.start();
          
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
