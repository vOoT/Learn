import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by qee on 2016/3/30.
 */
public class TimeServer {
    static int port = 80;

    /**
     * 这是一个同步IO阻塞的例子
     * @param
     */
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            while (true) {
                Socket socket = null;
                System.out.println("waiting for client to connect");
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
