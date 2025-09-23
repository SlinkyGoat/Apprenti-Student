import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaFilter {

    AddressCollection addresses = new AddressCollection();

    void filterLambdas() {

        // Call the filter function
        List<Address> addressByCity = filterAddresses(addresses.addressList,
                a -> a.getCity().equalsIgnoreCase("Philadelphia"));

        List<Address> addressByState = filterAddresses(addresses.addressList,
                a -> a.getState().equalsIgnoreCase("PA"));

        List<Address> addressByPostalCode = filterAddresses(addresses.addressList,
                a -> a.getPostalCode().equalsIgnoreCase("18031"));

        List<Address> addressByStateAndStreet = filterAddresses(addresses.addressList,
                a -> a.getState().equalsIgnoreCase("PA")
                        && a.getStreet().contains("Jackson"));

        System.out.println("Done");
    }

    List<Address> filterAddresses(List<Address> source, Predicate<Address> criteria){
        List<Address> result = new ArrayList<>();
        for(Address a : source){
            if(criteria.test(a)){
                result.add(a);
            }
        }
        return result;
    }

}
