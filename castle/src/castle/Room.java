package castle;

import java.util.*;

/**
 * 现在这个代码可扩展性不强
 * 每增加一个方向，所有地方都需要修改
 * 用一个容器陈放 该房间可以通往的其他房间，这一步改动比较大 仔细体会
 */
public class Room {
    private String description;
    HashMap<String,Room> hashMap = new HashMap<>();
    private Integer currentIndex = 0;
    ArrayList<Room> rooms;
//    private Room northExit;
//    private Room southExit;
//    private Room eastExit;
//    private Room westExit;


    public Room(String description) 
    {
        this.description = description;
    }

    public void setRoom(String description,Room room) {
        hashMap.put(description, room);
        rooms = new ArrayList<>();
        Set<Map.Entry<String, Room>> entries = hashMap.entrySet();
        for (Map.Entry<String, Room> entry : entries) {
            rooms.add(entry.getValue());
        }
    }

    //    public void setExits(Room north, Room east, Room south, Room west)
//    {
//        if(north != null)
//            northExit = north;
//        if(east != null)
//            eastExit = east;
//        if(south != null)
//            southExit = south;
//        if(west != null)
//            westExit = west;
//    }

    public Room getNextRoom(String direction){
        if("any".equals(direction)){  //任意门
            return  getRandomRoom();
        }else if ("rotation".equals(direction)){  //轮换门
            return  getRotationRoom();
        }
        return hashMap.get(direction);
    }

    public Room getRotationRoom(){
        int nextInt = currentIndex % rooms.size();
        currentIndex++;
        return rooms.get(nextInt);
    }

    public Room getRandomRoom(){
        int nextInt = new Random().nextInt(rooms.size());
        return rooms.get(nextInt);
    }

//    public Room getNextRoom(String direction){
//        Room nextRoom = null;
//        if(direction.equals("north")) {
//            nextRoom = this.northExit;
//        }
//        if(direction.equals("east")) {
//            nextRoom = this.eastExit;
//        }
//        if(direction.equals("south")) {
//            nextRoom = this.southExit;
//        }
//        if(direction.equals("west")) {
//            nextRoom = this.westExit;
//        }
//        return  nextRoom;
//    }

    public void showPromt() {
        System.out.println("你在:" + this.toString());
        System.out.print("出口有: ");
        for (Map.Entry<String, Room> stringRoomEntry : hashMap.entrySet()) {
            System.out.print(stringRoomEntry.getKey()+"\t");
        }

//        if (this.northExit != null)
//            System.out.print("north ");
//        if (this.eastExit != null)
//            System.out.print("east ");
//        if (this.southExit != null)
//            System.out.print("south ");
//        if (this.westExit != null)
//            System.out.print("west ");
        System.out.println();
    }

    @Override
    public String toString()
    {
        return description;
    }
}
