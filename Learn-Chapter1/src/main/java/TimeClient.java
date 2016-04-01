import java.io.*;
import java.net.Socket;

/**
 * Created by qee on 2016/4/1.
 */
public class TimeClient {
    static  int port=80;
    public static  void main(String [] args){
        Socket socket=null;
        BufferedReader bufferedReader= null;
        PrintWriter printWriter=null;
        try {
            socket = new Socket("127.0.0.1",port);
            bufferedReader= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);

            String str="query";
            printWriter.println(str);
            String out =bufferedReader.readLine();
            System.out.println(out);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(printWriter !=null){
                printWriter.close();
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                socket=null;
            }
        }


    }
}
