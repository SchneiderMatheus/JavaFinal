package exam.quest;
class Essay extends Question{
    public Essay(String setHead, String[] setBody, String[] setAnswer, int setPoint) {
        super(setHead, setBody, setAnswer, setPoint);
    }
    void present () {
        System.out.println("Essay: ");
        super.present();
    }
    void query() {
        String[] ans = {System.console().readLine("A: ")};
        user(ans);
    }
}
