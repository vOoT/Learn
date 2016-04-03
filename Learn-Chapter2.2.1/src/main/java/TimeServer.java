import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by qee on 2016/4/1.
 * 采用线程池和任务队列实现一种伪异步的I/O通信框架。
 * 其本质还是同步IO无法解决同步IO的问题
 */
public class TimeServer {
    static  int port=80;
    public  static  void  main(String [] args )  {
        ServerSocket serverSocket=null;
        try {
            serverSocket = new ServerSocket(port);
            TimeHandlerPool timeHandlerPool = new TimeHandlerPool(50,1000);
            while (true){
                Socket socket=serverSocket.accept();
                timeHandlerPool.execute(new TimeServerHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(serverSocket !=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
