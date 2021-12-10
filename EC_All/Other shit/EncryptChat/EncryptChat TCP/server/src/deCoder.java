public class deCoder {

    public static String DeEncrypt(int e1,int e2 ,int e3 ,int e4 ,int e5 , String text){
        char x;
        String re = "";
        int m;

        for (int i = 1; i < text.length(); i++){

            x = text.charAt(i);
            m = x;
            m = m-e1-(e2*e3)-(e1*e4)-8-(e3/e5);
            x = (char)m;

            re = re + x;
        }
        return re;
    }
}
