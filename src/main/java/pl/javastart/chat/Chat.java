package pl.javastart.chat;

public class Chat {
    private String nickname;
    private String message;

    public Chat(String nickname, String message) {
        this.nickname = nickname;
        this.message = message;
    }

    public String getNickname() {
        return nickname;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return nickname + " : " + message;
    }
}
