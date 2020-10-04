package day13;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String username;
    private List<User> subscriptions;

    public User(String username) {
        this.username = username;
        subscriptions = new ArrayList<>();
    }

    public void subscribe(User user) {
        if (!subscriptions.contains(user)) {
            subscriptions.add(user);
        }
    }

    public boolean isSubscribed(User user) {
        return subscriptions.contains(user);
    }

    public boolean isFriend(User user) {
        return isSubscribed(user) && user.isSubscribed(this);
    }

    public void sendMessage(User user, String text) {
        MessageDatabase.sendMessage(this, user, text);
    }

    public String getUsername() {
        return username;
    }

    public List<User> getSubscriptions() {
        return subscriptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return username;
    }
}
