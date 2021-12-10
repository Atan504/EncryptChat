import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;


public class GreetServer {
        //variables
        static char x;
        static int m;
        static String text = "";
        private static ServerSocket serverSocket;
        private static Socket clientSocket;
        private static PrintWriter out;
        private static BufferedReader in;
        public static void start(int port) throws IOException {
                serverSocket = new ServerSocket(port);
                while (true) {
                        //socket
                        // (Atan) FIXME: 12/8/2021 kinda shit ngl
                        clientSocket = serverSocket.accept();
                        out = new PrintWriter(clientSocket.getOutputStream(), true);
                        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        String greeting = in.readLine();
                        //packet recognition
                        if (greeting.charAt(0) == '1') {
                                out.println("recognised packet");
                                panel.sendCON(greeting.substring(1));
                        } else if (greeting.charAt(0) == '2') {
                                // (Atan) no problem here. yes sir.
                                //dns.... don't even bother
                                new Thread() {
                                        public void run() {
                                FileWriter fw = null;
                                try {
                                out.println("recognised packet");
                                panel.sendCON("Trying connection from: "+ clientSocket.getInetAddress().toString().substring(1) + " --- " + greeting.substring(1));
                                fw = new FileWriter("ipTXBO.txt", true);
                                File file = new File("ipTXBO.txt");
                                FileReader fr = new FileReader(file);
                                PrintWriter pw = new PrintWriter (fw);
                                LineNumberReader lnr = new LineNumberReader(fr);
                                BufferedWriter bw = new BufferedWriter(fw);

                                int line;
                                String st;
                                if((st = lnr.readLine()) == null){
                                        pw.write(clientSocket.getInetAddress().toString().substring(1) + "\r\n" + "=" + "\r\n" + greeting.substring(1)+ "\r\n" + "--------------------------\r\n");
                                }else {
                                        boolean done = false;
                                        while ((st = lnr.readLine()) != null) {
                                                System.out.println(st);

                                                if (st.equals(greeting.substring(1))) {
                                                        line = lnr.getLineNumber() - 3;
                                                        Path path = Paths.get(file.getPath());
                                                        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
                                                        lines.set(line, clientSocket.getInetAddress().toString().substring(1));
                                                        Files.write(path, lines, StandardCharsets.UTF_8);
                                                        done = true;

                                                }
                                        }

                                        if(!done){
                                                pw.write(clientSocket.getInetAddress().toString().substring(1) + "\r\n" + "=" + "\r\n" + greeting.substring(1) + "\r\n" + "--------------------------\r\n");

                                        }
                                }

                                pw.close();
                                fw.close();
                                } catch (IOException e) {
                                        e.printStackTrace();
                                }
                                        }
                                }.start();
                        } else{
                                out.println("unrecognised packet");
                        }

                }
        }

        public static void stop() throws IOException { // gues what this does <---
                clientSocket = serverSocket.accept();
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                in.close();
                out.close();
                clientSocket.close();
                serverSocket.close();
        }

        public static void main(String[] args) throws IOException {
                /*(Atan)
                 TODO
                        between networkes
                        maybe recode all code
                        check all funcs
                        make client goof lol
                        comment on un commented stuff
                        better gui
                        implement encrption
                        list of thing to do in future:
                                heart beat
                                users
                                comercial gui
                                easy use

                */
                //frame
                JFrame frame = new JFrame();
                frame.setTitle("EncryptChat Server");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setBounds(300,300,500,300);
                panel panel = new panel();
                frame.add(panel);
                frame.setVisible(true);

                //GreetServer.start(6666); (Atan) dont delete the comment WILL DO PROBLEMS!
                GreetServer server = new GreetServer();

        }
}