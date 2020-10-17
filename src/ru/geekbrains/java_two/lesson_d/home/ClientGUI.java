package ru.geekbrains.java_two.lesson_d.home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClientGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 500;
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Размер экрана пользователя для позиционирования окна

    private final JTextArea log = new JTextArea();
    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JCheckBox cbAlwaysOnTop = new JCheckBox("Always on top");
    private final JTextField tfLogin = new JTextField("ivan");
    private final JPasswordField tfPassword = new JPasswordField("123");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JButton btnDisconnect = new JButton("<html><b>Disconnect</b></html>");
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");

    private final JList<String> userList = new JList<>();

    private ClientGUI() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocation(screenSize.width / 2 - WIDTH / 2,  screenSize.height / 2 - HEIGHT / 2); // Окно рисуется в центре экрана
        JScrollPane scrollLog = new JScrollPane(log);
        JScrollPane scrollUser = new JScrollPane(userList);
        String[] users = {"user1", "user2", "user3", "user4", "user5",
                "user_with_an_exceptionally_long_name_in_this_chat"};
        userList.setListData(users);
        scrollUser.setPreferredSize(new Dimension(100, 0));
        cbAlwaysOnTop.addActionListener(this);

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(cbAlwaysOnTop);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        panelBottom.add(btnDisconnect, BorderLayout.WEST);
        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);

        add(scrollLog, BorderLayout.CENTER);
        add(scrollUser, BorderLayout.EAST);
        add(panelTop, BorderLayout.NORTH);
        add(panelBottom, BorderLayout.SOUTH);

        tfMessage.addKeyListener(new KeyAdapter() { // Слушатель нажатия на Enter
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    sendMessage(tfMessage.getText());
                    tfMessage.setText("");
                }
            }
        });

        log.setEditable(false);

        btnSend.addActionListener(this);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ClientGUI::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == cbAlwaysOnTop) {
            System.out.println("select");
            setAlwaysOnTop(cbAlwaysOnTop.isSelected());
        } else if (src == btnSend) {
            sendMessage(tfMessage.getText());
            tfMessage.setText("");
        } else {
            throw new RuntimeException("Unknown action source: " + src);
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        String msg;
        StackTraceElement[] ste = e.getStackTrace();
        msg = "Exception in " + t.getName() + " " +
                e.getClass().getCanonicalName() + ": " +
                e.getMessage() + "\n\t at " + ste[0];
        JOptionPane.showMessageDialog(this, msg, "Exception", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }

    // Запись сообщений в окно сообщений
    private void sendMessage(String message) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String messageString = now.format(dateFormatter) + "   " + message + "\n";
        log.append(messageString);

        try {
            writeToLog(messageString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // Запись сообщений в текстовый файл
    private void writeToLog(String messageString) throws IOException {
        PrintStream ps = new PrintStream(new FileOutputStream("log.txt", true));
        ps.print(messageString);
        ps.close();
    }
}
