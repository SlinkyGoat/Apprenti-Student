import java.util.ArrayList;

public class LockerManager {

    ArrayList<Locker> lockers;

    public LockerManager(){
        this.lockers = new ArrayList<Locker>();
    }

    public void addLocker(String lockerId){
        lockers.add(new Locker(lockerId));
    }

    public Locker getLocker(String lockerId){
        Locker lockerFromId = null;
        for(Locker locker : lockers){
            if(locker.getLockerId().equals(lockerId)){
                lockerFromId = locker;
                break;
            }
        }
        return lockerFromId;
    }

    public void removeLocker(String lockerId){
        // lockers.remove() can work if we override .equals() method
        lockers.remove(new Locker(lockerId));
    }

    public void displayAllLockers(){
        for(Locker locker : lockers){
            System.out.println(locker.toString());
            System.out.println();
        }
    }

}
