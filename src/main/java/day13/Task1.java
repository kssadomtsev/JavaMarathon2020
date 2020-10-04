package day13;

public class Task1 {
    public static void main(String[] args) {
        User user1 = new User("User1");
        User user2 = new User("User2");
        User user3 = new User("User3");
        user1.subscribe(user2);
        user1.subscribe(user3);
        user2.subscribe(user1);
        System.out.println(user1.isFriend(user2));
        System.out.println(user2.isFriend(user1));
        System.out.println(user1.isFriend(user3));
        user1.sendMessage(user2,"Привет");
        user1.sendMessage(user2,"Как ты?");
        user2.sendMessage(user1,"Привет");
        user2.sendMessage(user1,"Все ок");
        user2.sendMessage(user1,"Ты как?");
        MessageDatabase.showDialog(user1, user2);
        //MessageDatabase.showDialog(user1, user3);
        //MessageDatabase.showDialog(user2, user1);
        user3.sendMessage(user1, "прив))");
        user3.sendMessage(user1, "Пойдешь гулять");
        user3.sendMessage(user1, "???");
        user1.sendMessage(user3, "привет");
        user1.sendMessage(user3, "не смогу");
        user1.sendMessage(user3, "((");
        user3.sendMessage(user1, "грусть(");
        MessageDatabase.showDialog(user3, user1);
        MessageDatabase.getMessages().forEach(System.out::println);
    }
}
