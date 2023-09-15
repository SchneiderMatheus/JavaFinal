package exam.quest;

 class Question {
    public Question(String setHead, String[] setBody, String[] setAnswer, int setPoint) {
         this.head = setHead;
         this.body = setBody;
         this.answer = setAnswer;
         this.point = setPoint;
    }
    private String head;
    private String[] body;
    private String[] answer;
    private int point;
    private String[] userAnswer;
    private int userPoint;

    void present() {
        if(this instanceof Essay) {
            System.out.println(this.answer[0]);
        }
        System.out.println("Score: " + this.point);
        String hd = this.head;

        if(this instanceof BlankFill){
            for(int i=0; i<answer.length; i++) {
                hd = hd.replaceFirst(answer[i], "_____");
            }
        }
        System.out.println("Q: " +hd);

        if(body != null){
            if(body.length ==1)
                System.out.println( body[0] );
        } else {
            for(int i=0; i<body.length; i++) {
                System.out.println((i+1) + ". " + body[i]);
            }

        }
    }
    void query() {
    }
    void user(String[] answer) {

    }
    void result() {
        String a, u;
        for(int i=0; i<userAnswer.length; i++) {
            try { a = answer[i].strip(); }
            catch(ArrayIndexOutOfBoundsException e) { a = null; }
            u = userAnswer[i].strip();

            if( u.equalsIgnoreCase(a) ) {
                userPoint = userPoint + point/userAnswer.length;

            }
            System.out.println("Result: " + userPoint);
            System.out.println("Correct Answer(s): ");
            for(int j=0; i<answer.length; j++) {
                System.out.println(answer[j]);
            }
        }
    }
    int bodyCount() {
        return 0;
    }
    int ansCount () {
        return 0;
    }



}
