package pl.javastart.chat;

public class Message {
    private String author;
    private String message;

    public Message(String author, String message) {
        this.author = author;
        this.message = message;
    }

    @Override
    public String toString() {
        return author + ": " + message;
    }
}
