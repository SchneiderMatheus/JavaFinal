package exam.quest;

class MultipleChoice extends Question{
    public MultipleChoice(String setHead, String[] setBody, String[] setAnswer, int setPoint) {
        super(setHead, setBody, setAnswer, setPoint);
    }
    void present() {
        System.out.println("Multiple Choice");
        super.present();
    }
    void query() {
        String[] answer = new String[bodyCount()];
        for(int i=0; i<bodyCount(); i++) {
            answer[i] = System.console().readLine("A: ");
        }
        user(answer);
    }
}
