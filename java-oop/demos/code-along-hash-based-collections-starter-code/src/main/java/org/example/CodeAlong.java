package org.example;

public class CodeAlong {

    public static void main(String[] args) {

        BirthdayManager adamsBirthday = new BirthdayManager();

        System.out.println("Adding new Friend Ralph");
        Friend ralph = new Friend("Ralph", "09/02/1974");
        adamsBirthday.addFriend(ralph);

        System.out.println("Adding new friend Mike");
        Friend mike = new Friend("Mike", "01/17/1977");
        adamsBirthday.addFriend(mike);

        for(Friend friend : adamsBirthday.getFriends()){
            System.out.println(friend);
        }

        System.out.println("Ralph is giving gifts:");
        adamsBirthday.addGift(ralph, new Gift("New grill", "27\""));
        adamsBirthday.addGift(ralph, new Gift("dnd books", "3"));

        System.out.println("Mike is giving gifts:");
        adamsBirthday.addGift(mike, new Gift("tattoo", "large"));

        System.out.println("Time to open your gifts");
        for(Friend friend : adamsBirthday.getMap().keySet()){
            System.out.println(friend.getName());
            System.out.println("Gave the following:");
            for(Gift gift : adamsBirthday.getMap().get(friend)){
                System.out.println(gift.description + " " + gift.size);
            }
        }

        Friend seamus = new Friend("Seamus", "09/07/1974");
        System.out.println(adamsBirthday.getMap().get(seamus));
    }

}
