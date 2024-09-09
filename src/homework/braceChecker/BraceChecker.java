package homework.braceChecker;

public class BraceChecker {

    private String text;

    public BraceChecker(String text) {
        if (text == null) {
            System.out.println("Text cannot be null");
        }
        this.text = text;
    }

    public void check() {
        Stack myStack = new Stack();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            switch (c) {
                case '{':
                case '[':
                case '(':
                    myStack.push(new Brace(c, i));
                    break;

                case '}':
                    Brace pop = myStack.pop();
                    if (pop == null) {
                        System.err.println("Error: Closed " + c + "  but not opened at  " + " " + i);
                    } else {

                        if (pop.getBrace() != '{') {
                            System.err.println("Error: Closed " + c + " but opened " + " " + pop.getBrace() + " at  " + " " + pop.getIndex());
                        }
                    }
                    break;
                case ']':
                    pop = myStack.pop();
                    if (pop == null) {
                        System.err.println("Error: Closed " + " " + c + " " + " but not opened at " + i);
                    } else {

                        if (pop.getBrace() != '[') {
                            System.err.println("Error: Closed " + " " + c + " " + " but opened " + pop.getBrace() + " " + " at " + pop.getIndex());
                        }
                    }
                    break;
                case ')':
                    pop = myStack.pop();
                    if (pop == null) {
                        System.err.println("Error: Closed " + " " + c + " " + " but not opened at " + " " + i);
                    } else {

                        if (pop.getBrace() != '(') {
                            System.err.println("Error: Closed " + " " + c + " " + " but opened " + " " + pop.getBrace() + " " + " at " + pop.getIndex());
                        }
                    }
                    break;
            }

        }

        while (!myStack.isEmpty()) {
            Brace pop = myStack.pop();
            System.err.println("Error: Opened  " + " " + pop.getBrace() + " " + " at " + pop.getIndex() + " " + "but not closed.");
        }
    }
}
