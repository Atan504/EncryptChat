package EncryptChatClient;

public class Encryption {

    public static String EncryptL1(/*Token*/int e1,int e2,int e3,int e4,int e5, String text){
        char x;
        String re = "";

        for (int i = 0; i < text.length(); i++) {

            x = text.charAt(i);
            x = (char) ( x+(e1*42+(86*e2)+e5));

            re = re + x;
        }
        return re;
    }


    public static String EncryptL2(/*Token*/int e1,int e2,int e3,int e4,int e5, String text){
        char x;
        String re = "";

        for (int i = 0; i < text.length(); i++) {

            x = text.charAt(i);
            x = (char) (x+(e1*e2*e3*e4*e5*69420));

            re = re + x;
        }
        return re;
    }

    public static String EncryptL3(/*Token*/int e1,int e2,int e3,int e4,int e5, String text){
        char x;
        String re = "";

        for (int i = 0; i < text.length(); i++) {

            x = text.charAt(i);
            x = (char) (x+(Math.pow(e4,e2*e3)+e4*e5 + e1));

            re = re + x;
        }
        return re;
    }






}
