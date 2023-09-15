package exam.quest;

class TrueFalse extends Question{
    public TrueFalse(String setHead, String[] setBody, String[] setAnswer, int setPoint) {
        super(setHead, setBody, setAnswer, setPoint);
    }
    void present() {
        System.out.println("True/False");
        super.present();
    }
    void query (){
        String ans;

        // control true or false

        do {
            ans = System.console().readLine();
            ans = ans.toLowerCase();
            if(ans.charAt(0) == 't' || ans.charAt(0) == 'f') {
                break;
            } else {
                System.out.println("[T/F]");
            }
        } while ( true );

        String[] answer = {ans};
        user(answer);
    }
}
