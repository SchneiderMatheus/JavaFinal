package exam.quest;

class SingleChoice extends Question {

    public SingleChoice(String setHead, String[] setBody, String[] setAnswer, int setPoint) {
        super(setHead, setBody, setAnswer, setPoint);
    }
    void present() {
        System.out.println("Single Choice");
        super.present();
    }
    void query() {
        String[] answer = {System.console().readLine("A: ")};
        user(answer);
    }
}
