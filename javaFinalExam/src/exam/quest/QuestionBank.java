package exam.quest;

public class QuestionBank {
    Question[] q;
    int size;
    int counter;

    public QuestionBank() {
        size=10;
        q= new Question[size];
        initBank();
    }
    void initBank () {
        q[0] = new TrueFalse("Java is great", new String[]{"[T/F]"}, new String[]{"T"}, 2);
        q[1] = new TrueFalse("Sky is blue", new String[]{"[T/F]"}, new String[]{"T"}, 1);
        q[2] = new SingleChoice("2 + 2 = ", new String[]{"3", "4", "5"}, new String[]{"2"}, 2);
        q[3] = new SingleChoice("Java is pure Object Oriented", new String[]{"Maybe", "Not at all", "Absolutely"}, new String[]{"3"}, 3);
        q[4] = new MultipleChoice("Java is: ", new String[]{"Weird", "Beautiful", "Ugly"}, new String[]{"1", "2"}, 4);
        q[5] = new MultipleChoice("OOP stands for", new String[]{"Object Oriented Paradigm", "Object Oriented Programming", "Oh Oy Pi"}, new String[]{"1", "2"}, 2);
        q[6] = new Essay("What is your name?", null, new String[]{"First and Last Name or vice versa"}, 2);
        q[7] = new Essay("What is your hobby?", null, new String[]{"A hobby with one line description"}, 2);
        q[8] = new BlankFill("Canadian College of Technology and Business", null, new String[]{"Technology", "Business"}, 2);
        q[9] = new BlankFill("Earth is located in Milky Way", null, new String[]{"Milky"}, 4);
    }
    public boolean next() {
        if (counter == size) return false;
        q[counter].present();
        q[counter].query();
        q[counter].result();
        counter++;
        return true;

    }
}
