public class Locker {

    private String lockerId;
    private boolean isOccupied;
    private String contents;

    public Locker(String lockerId) {
        this.lockerId = lockerId;
        this.isOccupied = false;
        this.contents = "";
    }

    public void storeItem(String item){
        isOccupied = true;
        contents = item;
    }

    public void removeItem(){
        isOccupied = false;
        contents = "";
    }

    public String toString(){
        String lockerContents = "Locker ID: " + lockerId;
        lockerContents += "\nLocker is " + (isOccupied ? "" : "not ") + "occupied";
        lockerContents += "\nContents: " + contents;
        return lockerContents;
    }

    // CUSTOM METHODS

    public String getLockerId(){
        return this.lockerId;
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(!(o instanceof Locker l)) return false;

//        Locker l = (Locker) o;
        return l.getLockerId().equals(lockerId);
    }

}
