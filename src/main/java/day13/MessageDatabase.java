package day13;

import java.util.ArrayList;
import java.util.List;

public class MessageDatabase {
    private static final List<Message> messages = new ArrayList<>();

    public static void sendMessage(User u1, User u2, String text) {
        messages.add(new Message(u1, u2, text));
    }

    public static List<Message> getMessages() {
        return messages;
    }

    public static void showDialog(User u1, User u2) {
        messages.stream()
                .filter(message -> (message.getSender().equals(u1) || message.getSender().equals(u2)) &&
                        (message.getReceiver().equals(u1) || message.getReceiver().equals(u2)))
                .forEach(message -> System.out.println(message.getSender() + ": " + message.getText()));
    }

}
