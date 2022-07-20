import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String RESTAURANT_NAME) throws restaurantNotFoundException {
        for (Restaurant record: restaurants) {
            if(record.getName().equals(RESTAURANT_NAME))
                return record;
            else
                throw new restaurantNotFoundException("Restaurant Not Found");
        }
        return null;
    }


    public Restaurant addRestaurant(String NAME, String LOCATION, LocalTime OPENING_TIME, LocalTime CLOSING_TIME) {
        Restaurant newRestaurant = new Restaurant(NAME, LOCATION, OPENING_TIME, CLOSING_TIME);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String RESTAURANT_NAME) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(RESTAURANT_NAME);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
