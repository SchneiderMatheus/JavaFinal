package exam.quest;

class BlankFill extends Question{
    public BlankFill(String setHead, String[] setBody, String[] setAnswer, int setPoint) {
        super(setHead, setBody, setAnswer, setPoint);
    }
    void present () {
        System.out.println("Fill in the Blank(s)");
        super.present();
    }
    void query () {
        String[] answer = new String[ansCount()];
        for(int i=0; i<ansCount(); i++) {
            answer[i] = System.console().readLine("A: ");
        }
        user(answer);
    }

}
