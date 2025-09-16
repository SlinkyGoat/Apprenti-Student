package learn.memories.models;

public class Memory {

    private int id; // unique identifier
    private String from; // who shared the memory
    private String content; // the memory itself
    private boolean shareable; // whether it is public or private

    public Memory(){}
    public Memory(int id, String from, String content, boolean shareable) {
        this.id = id;
        this.from = from;
        this.content = content;
        this.shareable = shareable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isShareable() {
        return shareable;
    }

    public void setShareable(boolean shareable) {
        this.shareable = shareable;
    }
}
