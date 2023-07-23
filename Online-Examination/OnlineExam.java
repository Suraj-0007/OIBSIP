import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Login extends JFrame implements ActionListener {
    JButton btnSubmit;
    JLabel userLabel, passLabel;
    final JTextField textField1, textField2;

    Login() {
        userLabel = new JLabel("Username:");
        textField1 = new JTextField(15);
        passLabel = new JLabel("Password:");
        textField2 = new JPasswordField(8);
        btnSubmit = new JButton("SUBMIT");
        btnSubmit.addActionListener(this);

        JPanel newPanel = new JPanel(new GridLayout(3, 1));
        newPanel.add(userLabel);
        newPanel.add(textField1);
        newPanel.add(passLabel);
        newPanel.add(textField2);
        newPanel.add(btnSubmit);

        add(newPanel, BorderLayout.CENTER);
        setTitle("Login Form");
    }

    public void actionPerformed(ActionEvent ae) {
        String username = textField1.getText();
        String password = textField2.getText();
        // Implement login validation here (e.g., check against a database).
        // For simplicity, we assume any non-empty username and password is valid.
        if (username.equals("Suraj") && password.equals("1234")) {
            new OnlineTest("Online Exam Portal - Welcome, " + username + "!");
            dispose(); // Close the login window after successful login
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.");
        }
    }
}

class OnlineTest extends JFrame implements ActionListener {
    JButton btnNext, btnBookmark;
    JLabel label;
    ButtonGroup bg;
    int m[] = new int[15];
    JRadioButton radioButton[] = new JRadioButton[5];
    int current = 0,count = 0, x = 1, y = 1, now = 0;

    OnlineTest(String s) {
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();

        for (int i = 0; i < 5; i++) {
            radioButton[i] = new JRadioButton();
            add(radioButton[i]);
            bg.add(radioButton[i]);
        }

        btnNext = new JButton("Next Question");
        btnBookmark = new JButton("Bookmark Question");
        btnNext.addActionListener(this);
        btnBookmark.addActionListener(this);
        add(btnNext);
        add(btnBookmark);
        set();
        label.setBounds(30, 40, 450, 20);
        radioButton[0].setBounds(50, 80, 450, 20);
        radioButton[1].setBounds(50, 110, 200, 20);
        radioButton[2].setBounds(50, 140, 200, 20);
        radioButton[3].setBounds(50, 170, 200, 20);
        btnNext.setBounds(100, 240, 150, 30);
        btnBookmark.setBounds(270, 240, 200, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(700,350);
        Color c = new Color(0, 150, 255);
        getContentPane().setBackground(c);
    }


    /* handle all event */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            if (qcheck())
                count = count + 1;
            current++;
            set();
            if (current == 14) {
                btnNext.setEnabled(false);
                btnBookmark.setText("Result");
            }
        }

        if (e.getActionCommand().equals("Bookmark Question")) {
            JButton bk = new JButton("Bookmark " + x);
            bk.setBounds(480, 20 + 30 * x, 150, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 14)
                btnBookmark.setText("Score");
            setVisible(false);
            setVisible(true);
        }

        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (qcheck())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (qcheck())
                count = count + 1;
            current++;
            JOptionPane.showMessageDialog(this,"You have answered " + count + " Questions correctly" );
            System.exit(0);
        }
    }


    /* SET Questions with options */
    void set() {
        radioButton[4].setSelected(true);
        if (current == 0) {
            label.setText("Que1:  Who invented C++?");
            radioButton[0].setText("Dennis Ritchie");
            radioButton[1].setText("Ken Thompson");
            radioButton[2].setText("Brian Kernighan");
            radioButton[3].setText("Bjarne Stroustrup");
        }
        if (current == 1) {
            label.setText("Que2:  Which concept allows you to reuse the written code?");
            radioButton[0].setText("Encapsulation");
            radioButton[1].setText("Abstraction");
            radioButton[2].setText("Inheritance");
            radioButton[3].setText(" Polymorphism");
        }
        if (current == 2) {
            label.setText("Que3: Which of the following user-defined header file extension used in c++?");
            radioButton[0].setText("hg");
            radioButton[1].setText("cpp");
            radioButton[2].setText("h");
            radioButton[3].setText(" hf");
        }
        if (current == 3) {
            label.setText("Que4: Wrapping data and its related functionality into a single entity is known as _____________");
            radioButton[0].setText(" Abstraction");
            radioButton[1].setText("Encapsulation");
            radioButton[2].setText("Polymorphism");
            radioButton[3].setText("Modularity");
        }
        if (current == 4) {
            label.setText("Que5:  Which of the following correctly declares an array in C++?");
            radioButton[0].setText(" array{10};");
            radioButton[1].setText("array array[10];");
            radioButton[2].setText("int array;");
            radioButton[3].setText("int array[10];");
        }
        if (current == 5) {
            label.setText("Que6: Which of the following is a correct identifier in C++?");
            radioButton[0].setText("VAR_1234");
            radioButton[1].setText(" $var_name");
            radioButton[2].setText("7VARNAME");
            radioButton[3].setText("7var_name");
        }
        if (current == 6) {
            label.setText("Que7:  Which component is used to compile, debug and execute the java programs?");
            radioButton[0].setText("JRE");
            radioButton[1].setText("JIT");
            radioButton[2].setText("JDK");
            radioButton[3].setText("JVM");
        }
        if (current == 7) {
            label.setText("Que8:  Which one of the following is not a Java feature?");
            radioButton[0].setText("Object-oriented");
            radioButton[1].setText("Use of pointers");
            radioButton[2].setText("Portable");
            radioButton[3].setText("Dynamic and Extensible");
        }
        if (current == 8) {
            label.setText("Que9: Which of these cannot be used for a variable name in Java?");
            radioButton[0].setText("identifier & keyword");
            radioButton[1].setText("identifier");
            radioButton[2].setText("keyword");
            radioButton[3].setText("none of the mentioned");
        }
        if (current == 9) {
            label.setText("Que10: What is the extension of java code files?");
            radioButton[0].setText(".js");
            radioButton[1].setText(".txt");
            radioButton[2].setText(".class");
            radioButton[3].setText(".java");
        }
        if (current == 10) {
            label.setText("Que11: Which is more effective while calling the C++ functions?");
            radioButton[0].setText("call by object");
            radioButton[1].setText("call by pointer");
            radioButton[2].setText("call by value");
            radioButton[3].setText("call by reference");
        }
        if (current == 11) {
            label.setText("Que12: Which of the following is used to terminate the function declaration in C++?");
            radioButton[0].setText(";");
            radioButton[1].setText("]");
            radioButton[2].setText(")");
            radioButton[3].setText(":");
        }
        if (current == 12) {
            label.setText("Que13: Which keyword is used to define the macros in c++?");
            radioButton[0].setText(" #macro");
            radioButton[1].setText("#define");
            radioButton[2].setText("macro");
            radioButton[3].setText("define");
        }
        if (current == 13) {
            label.setText("Que14:  The C++ code which causes abnormal termination/behaviour of a program should be written under _________ block.");
            radioButton[0].setText("catch");
            radioButton[1].setText(" throw");
            radioButton[2].setText("try");
            radioButton[3].setText("finally");
        }
        if (current == 14) {
            label.setText("Que15: Which of the following symbol is used to declare the preprocessor directives in C++?");
            radioButton[0].setText("$");
            radioButton[1].setText("^");
            radioButton[2].setText("#");
            radioButton[3].setText("*");
        }

        label.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            radioButton[j].setBounds(50, 80 + i, 200, 20);
    }

    /* declare right answers. */
    boolean qcheck() {
        if (current == 0)
            return (radioButton[3].isSelected());
        if (current == 1)
            return (radioButton[2].isSelected());
        if (current == 2)
            return (radioButton[2].isSelected());
        if (current == 3)
            return (radioButton[1].isSelected());
        if (current == 4)
            return (radioButton[3].isSelected());
        if (current == 5)
            return (radioButton[0].isSelected());
        if (current == 6)
            return (radioButton[1].isSelected());
        if (current == 7)
            return (radioButton[1].isSelected());
        if (current == 8)
            return (radioButton[2].isSelected());
        if (current == 9)
            return (radioButton[3].isSelected());
        if(current == 10)
            return(radioButton[3].isSelected());
        if(current == 11)
            return(radioButton[0].isSelected());
        if(current == 12)
            return(radioButton[1].isSelected());
        if(current == 13)
            return(radioButton[2].isSelected());
        if(current == 14)
            return(radioButton[2].isSelected());
        return false;
    }

    public static void main(String s[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Login loginForm = new Login();
                loginForm.setSize(400, 150);
                loginForm.setVisible(true);
                loginForm.setLocationRelativeTo(null); // Center the login window
            }
        });
    }
}