package EncryptChatClient;

public class MasterEncryption {

    public static String MasterEncryption(int e1,int e2,int e3,int e4,int e5,String text){
        char x;
        String c = "";
        String Mre = "";
        for (int i = 0; i < text.length(); i++) {
            x = text.charAt(i);
            c = String.valueOf(x);

            if(i%4 == 0){
                x =  Encryption.EncryptL2(e1,e2,e3,e4,e5,c).charAt(0);

            }else if(i%4 == 1){
                x =  Encryption.EncryptL3(e1,e2,e3,e4,e5,c).charAt(0);
            }else if(i%4 == 2){
                x = Encryption.EncryptL4(e1,e2,e3,e4,e5,c).charAt(0);
            } else{
                x =  Encryption.EncryptL1(e1,e2,e3,e4,e5,c).charAt(0);
            }


            Mre += x;
        }
        return Mre;
    }


}
