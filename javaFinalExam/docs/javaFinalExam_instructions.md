
# *Software*: `exam`


## Description

`exam` will be able to ask for a `Potency`, `Difficulty` from `Quest` to `present` an exam anytime. Ideally it may also calculate time from `start` to `end` the `exam` and display the compiled `result`(s)

`Quest` will be able to set the desired `Potency`-count of `Question`(s) and `Difficulty` (`Easy`, `Medium`, `Hard`) asked by `exam`. Based on the `Potency` and `Difficulty` the `Quest` will ask for `Question`(s) from `QuestionBank`.

`QuestionBank` will be able to hold a complete pool of available all kinds and difficulty of `Question`(s). `QuestionBank` will be able to provide `Question`(s) according to `potency` and `difficulty` from the available pool of `Question`(s) ideally randomly.

`Question` will be able to hold `head` (main question text) and `body` (supporting question text) and `answer` (actual answer to question) and `point` (maximum score) and `userAnswer` and `score` (how much user scored) and `difficulty`. Every `Question` will be able to `present` itself with `head` and `body` and `process` itself after `userAnswer` accordingly.

There are five type(s) of `Question`(s): `SingleChoice` (user can only select one option out of many), `MultipleChoice` (user can select multiple option out of many), `TrueFalse` (user can select either `True` or `False`), `BlankFill` (user need to fill the missing word(s) or phrase(s)) and `Essay` (user can write a description as an answer).


## Instruction(s)

### *Project Scaffolding*
1. Create a *Project Workspace* `javaFinalExam`
2. Create a *document folder* `docs` inside `javaFinalExam`
3. *Download* and *copy* `javaFinalExam_instructions_A.md` into `docs`
4. Create *source code folder* `src` inside `javaFinalExam`
5. Create an *abstraction* `FinalExam` inside `src`
6. Create *entry point* `main` inside `FinalExam`
7. `sysout "Java Rocks!"` inside `main`
8. *Testing*: `FinalExam` should print `Java Rocks!` at *console*

### *Software Scaffolding*: `exam`
9. Create a *package* `exam` inside `src`
10. Create an *abstraction* `exam` inside `exam`
11. Create a *package* `exam.quest` inside `exam`
12. Create an *abstraction* `Quest` inside `exam.quest`
13. Create another *abstraction* `QuestionBank` inside `exam.quest`
13. Create another *abstraction* `Question` inside `exam.quest`
14. Create more *abstraction*(s) `SingleChoice`, `MultipleChoice`, `TrueFalse`, `BlankFill` and `Essay` inside `exam.quest`
19. *Specialize* `SingleChoice`, `MultipleChoice`, `TrueFalse`, `BlankFill` and `Essay` through `Question` *inheritance*

### *Access Modification(s)*: `exam`
20. *Expose* `exam` to `public` *audience*
21. *Expose* `Quest` to `public` *audience*
22. *Expose* `QuestionBank`, `Question`, `BlankFill`, `Essay`, `MultipleChoice`, `SingleChoice`, `TrueFalse` to `default` *audience*

### *Define*: `Question`
23. Introduce `String head`, `String[] body`, `String[] answer`, `int point`, `String[] userAnswer`, `int userPoint` to *state* of `Question`.
24. Make *state* of `Question` available to `private` *audience* only
25. Introduce *Parameterized Constructor*: `Question(String setHead, String[] setBody, String[] setAnswer, int setPoint)` for `default` audience
26. *Mutate* `head`, `body`, `answer` and `point` with *parameters*

### *Parameterized Constructor(s)*:
27. Add *parameterized constructor* `SingleChoice(String setHead, String[] setBody, String[] setAnswer, int setPoint)` to `SingleChoice`
28. Add *parameterized constructor* `MultipleChoice(String setHead, String[] setBody, String[] setAnswer, int setPoint)` to *abstraction* `MultipleChoice`
29. Add *parameterized constructor* `TrueFalse(String setHead, String[] setBody, String[] setAnswer, int setPoint)` to *abstraction* `TrueFalse`
30. Add *parameterized constructor* `BlankFill(String setHead, String[] setBody, String[] setAnswer, int setPoint)` to *abstraction* `BlankFill`
31. Add *parameterized constructor* `Essay(String setHead, String[] setBody, String[] setAnswer, int setPoint)` to *abstraction* `Essay`
32. Add *Statement* `super(setHead, setBody[], setAnswer, setPoint)` from `27` to `31` to call `Question` *parameterized constructor*

### *Define*: `Question`
33. Introduce *behavior* `void present` to `default` *audience* only
34. Introduce *behavior* `void query` to `default` *audience* only
35. Introcude *behavior* `void user(String[] answer)` to `default` *audience* only
36. Introduce *behavior* `void result` to `default` *audience* only
36. Introduce *behavior* `bodyCount` to `default` *audience* only
37. Introduce *behavior* `ansCount` to `default` *audience* only

## *Define*: `present` - responsible to print `Question` accordingly
38. `if ( this instanceof Essay)` then `sysout answer[0]`
39. `sysout "Score: " + point`
40. `String hd = head`
41. `if ( this instanceof BlankFill )` then `for(int i=0; i<answer.length; i++) hd = hd.replaceFirst(answer[i], "_____")`
42. `sysout "Q: " + hd`
43. `if(body != null)` then:
- 43a. `if(body.length == 1)` then `System.out.println( body[0] )`
- 43b. `else for(int i=0; i<body.length; i++) sysout (i+1) + ". " + body[i]`

## *Define*: `result` - responsible to print score of the answer
44. `String a, u`
45. `for(int i=0; i<userAnswer.length; i++)`
- 45a. `try { a = answer[i].strip(); }`
- 45b. `catch(ArrayIndexOutOfBoundsException e) { a = null; }`
- 45c. `u = userAnswer[i].strip()`
- 45d. ` if( u.equalsIgnoreCase(a) )` then
  - 45d-1. `userPoint = userPoint + point/userAnswer.length`
- 45e. `sysout "Result: " + userPoint`
- 45f. `sysout "Correct Answer(s): "`
- 45g. `for(int i=0; i<answer.length; i++)`
  - 45g-1. `sysout answer[i]`

### *Define*: `BlankFill` - responsible to `present` and `query` based on its type
## *Define*: `present`
46. `sysout`
47. `sysout "Fill in the Blank(s)"`
48. `super.present()`

## *Define*: `query`
49. `String[] answer = new String[ansCount()]`
50. `for(int i=0; i<ansCount(); i++)`
- 50a. `answer[i] = System.console().readLine("A: ")`
51. `user(answr)`

### *Define*: `Essay` - responsible to `present` and `query` based on its type
## *Define*: `present`
52. `sysout`
53. `sysout "Essay: "`
54. `super.present()`

## *Define*: `query`
55. `String[] ans = {System.console().readLine("A: ")}`
56. `user(ans)`

### *Define*: `MultipleChoice` - responsible to `present` and `query` based on its type
## *Define*: `present`
57. `sysout`
58. `sysout "Multiple Choice"`
59. `super.present()`

## *Define*: `query`
60. `String[] answer = new String[bodyCount()];`
61. `for(int i=0; i<bodyCount(); i++)`
- 61a. `answer[i] = System.console().readLine("A: ")`
62. `user(answer)`

### *Define*: `SingleChoice` - responsible to `present` and `query` based on its type
## *Define*: `present`
63. `sysout`
64. `sysout "Single Choice"`
65. `super.present()`

## *Define*: `query`
66. `String[] answer = {System.console().readLine("A: ")}`
67. `user(answer)`

### *Define*: `TrueFalse` - responsible to `present` and `query` based on its type
## *Define*: `present`
68. `sysout`
69. `sysout "True/False"`
70. `super.present()`

## *Define*: `query`
71. `String ans`
72. `do`
- 72a. `ans = System.console().readLine()`
- 72b. `ans = ans.toLowerCase()`
- 72c. `if(ans.charAt(0) == 't' || ans.charAt(0) == 'f') break`
- 72d. `else sysout "[T/F]"`
73. `while( true )`
74. `String[] answer = {ans}`
75. `user(answer)`

### *Define*: `QuestionBank` - responsible to create questions via`initBank` and manage each question `present`, `query` and `result` via `next`
76. Introduce `Question[] q`
77. Introduce `int size` to *state* of `QuestionBank`
78. Introduce `int counter`
## *Define*: `QuestionBank` - *default constructor*
79. `size = 10` - total number of questions `QuestionBank` contains - we may add more
80. `q = new Question[size]`
81. Call `initBank`

## *Define*: `initBank` - define every types of `Question` by *instantiating* a spcific type and pass `Question`: `head`, `body[]`, actual `answer[]` and `point` to score  
82. `q[0] = new TrueFalse("Java is great", new String[]{"[T/F]"}, new String[]{"T"}, 2)`
83. `q[1] = new TrueFalse("Sky is blue", new String[]{"[T/F]"}, new String[]{"T"}, 1)`
84. `q[2] = new SingleChoice("2 + 2 = ", new String[]{"3", "4", "5"}, new String[]{"2"}, 2)`
85. `q[3] = new SingleChoice("Java is pure Object Oriented", new String[]{"Maybe", "Not at all", "Absolutely"}, new String[]{"3"}, 3)`
86. `q[4] = new MultipleChoice("Java is: ", new String[]{"Weird", "Beautiful", "Ugly"}, new String[]{"1", "2"}, 4)`
87. `q[5] = new MultipleChoice("OOP stands for", new String[]{"Object Oriented Paradigm", "Object Oriented Programming", "Oh Oy Pi"}, new String[]{"1", "2"}, 2)`
88. `q[6] = new Essay("What is your name?", null, new String[]{"First and Last Name or vice versa"}, 2)`
89. `q[7] = new Essay("What is your hobby?", null, new String[]{"A hobby with one line description"}, 2)`
90. `q[8] = new BlankFill("Canadian College of Technology and Business", null, new String[]{"Technology", "Business"}, 2)`
91. `q[9] = new BlankFill("Earth is located in Milky Way", null, new String[]{"Milky"}, 4)`

## *Define*: `boolean next` - control `Question` management by `present` and `query` and show `result`
92. `if (counter == size) return false`
93. `q[counter].present()`
94. `q[counter].query`
95. `q[counter].result`
96. `counter++`
97. `return true`
98. Expose `QuestionBank` and `next` to `public` *audience*

### *Testing*: `QuestionBank` via `FinalExam`
99. Add `QuestionBank qb = new QuestionBank()`
100. Add `while( qb.next() );`