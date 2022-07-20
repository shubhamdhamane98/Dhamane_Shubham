import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String NAME, String LOCATION, LocalTime OPENING_TIME, LocalTime CLOSING_TIME) {
        this.name = NAME;
        this.location = LOCATION;
        this.openingTime = OPENING_TIME;
        this.closingTime = CLOSING_TIME;
    }

    public boolean isRestaurantOpen() {
        LocalTime currentTime = getCurrentTime();

        if(openingTime.isBefore(currentTime) && currentTime.isBefore(closingTime))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        return menu;
    }

    private Item findItemByName(String ITEM_NAME){
        for(Item item: menu) {
            if(item.getName().equals(ITEM_NAME))
                return item;
        }
        return null;
    }

    public void addToMenu(String NAME, int PRICE) {
        Item newItem = new Item(NAME,PRICE);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String ITEM_NAME) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(ITEM_NAME);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(ITEM_NAME);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }

}
