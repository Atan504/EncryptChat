public class Message {
    private String sender;
    private String time;
    private String text;
    private String calibrationString;

    //constructors
    public Message(){}
    public Message(String sender, String time, String text, String calibrationString) {
        this.sender = sender;
        this.time = time;
        this.text = text;
        this.calibrationString = calibrationString;
    }

    //getters
    public String getSender() {
        return sender;
    }

    public String getTime() {
        return time;
    }

    public String getText() {
        return text;
    }

    public String getCalibrationString() {
        return calibrationString;
    }

    //fromString
    //creates the message object from a given string
    public void fromString(String input){
        this.sender = "";
        this.time = "";
        this.calibrationString = "";
        this.text = "";
         int breaker = 0;
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '|'){ breaker++; }
            if(breaker == 0){
                this.sender += input.charAt(i);
            }
            if(breaker == 1){
                this.time += input.charAt(i);
            }
            if(breaker == 2){//text of the message builder
                this.text += input.charAt(i);
            }
            if(breaker == 3){//calibration string building
                this.calibrationString +=input.charAt(i);
            }
        }
        this.time = this.time.substring(1);
        this.text = this.text.substring(1);
        this.calibrationString = this.calibrationString.substring(1);
    }

    //toString


    @Override
    public String toString() {
        return this.sender + "|" + this.time + "|" + this.text + "|" + this.calibrationString;
    }
}
