public class StorageLockers {

    public static void main(String[] args) {

        /*
        1. display menu
            show options: rent, access, release
            if no lockers available hide RENT option
            exit on any other key input
        2. rent a locker
            assign next available locker
            generate 4-digit PIN (as string WITH leading/trailing zeros)
            store locker/PIN in array
        3. access a locker
            prompt user for locker/PIN
            validate inputs against stored data
            grant access or error
        4. release a locker
            prompt user for locker/PIN
            confirm user action (are you sure you want to release locker x?)
            clear data from array
            error for incorrect PIN/locker
        5. initialize lockers array
            create array with null values
            allow configurable size (at startup)
        6. generate PIN with leading/trailing zeros
            random 4-digit string
            ensure it preserves leading zeros
        7. DRY refactoring with methods
        8. input validation and error handling
        9. display helpful error messages
            invalid input, wrong PIN, unavailable lockers etc.
        10. update menu based on locker availability
            hide "RENT" if lockers are full


        int arraySize;
        int lockers[arraySize] -> set values to null
        int lockersAvailable = arraySize

        display menu options: [1] RENT, [2] ACCESS, [3] RELEASE
            if lockersAvailable = 0 then do not display RENT
        userInput = get user input
        if userInput = RENT then
            find first element in lockers[] where the value is null
            generate PIN ->
                loop 4 times:
                    create random digit and add to string
                return PIN string
            store PIN in lockers array at
            print "thank you" and give user locker instructions
            end (go back to menu)

        else if userInput = ACCESS then
            lockerNumber = input user for locker number
            confirm locker is rented
            PIN = input user for PIN number
            if lockers[lockerNumber] = PIN then
                grant access
            else
                error message
            end (go back to menu)

        else if userInput = RELEASE then
            lockerNumber = input user for locker number
            confirm locker is rented
            userConfirmation = prompt user (are they sure they want to release locker)
            if userConfirmation = 'yes' then
                set lockers[lockerNumber] to null (deletes PIN and opens locker up for renting)
            else if userConfirmation = 'no' then
                print(the locker has not been released)
            end (go back to menu)
        else
            exit program
         */



        /*
        NOTE:
        validate all inputs from users so that they are correct/formatted as needed


        METHODS:
        prompt user for locker and validate it is rented
        prompt user for PIN and validate it is correct
        display menu
        prompt user for menu selection
         */




    }

}
