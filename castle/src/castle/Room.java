package castle;

public class Room {
    private String description;
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;

    public Room(String description) 
    {
        this.description = description;
    }

    public void setExits(Room north, Room east, Room south, Room west) 
    {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
    }


    public Room getNextRoom(String direction){
        Room nextRoom = null;
        if(direction.equals("north")) {
            nextRoom = this.northExit;
        }
        if(direction.equals("east")) {
            nextRoom = this.eastExit;
        }
        if(direction.equals("south")) {
            nextRoom = this.southExit;
        }
        if(direction.equals("west")) {
            nextRoom = this.westExit;
        }
        return  nextRoom;
    }

    public void showPromt() {
        System.out.println("你在:" + this.toString());
        System.out.print("出口有: ");
        if (this.northExit != null)
            System.out.print("north ");
        if (this.eastExit != null)
            System.out.print("east ");
        if (this.southExit != null)
            System.out.print("south ");
        if (this.westExit != null)
            System.out.print("west ");
        System.out.println();
    }

    @Override
    public String toString()
    {
        return description;
    }
}
