package castle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private Room currentRoom;
    private Integer currentIndex = 0;
    public static HashMap<String, Handler> cmdHash = new HashMap<String, Handler>();
    ArrayList<Room> rooms = new ArrayList<>();

    public Game() {
        createRooms();
    }

    private void createRooms() {
        Room outside, lobby, pub, study, bedroom;

        //	制造房间
        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");

        rooms.add(outside);
        rooms.add(lobby);
        rooms.add(pub);
        rooms.add(study);
        rooms.add(bedroom);

        outside.setRoom("west", lobby);
        outside.setRoom("north", pub);

        lobby.setRoom("north", study);
        pub.setRoom("north", study);
        bedroom.setRoom("north", study);

        cmdHash.put("bye", new ByeHandler(this));
        cmdHash.put("go", new Gohandler(this));
        cmdHash.put("help", new HelpHandler(this));


        //	初始化房间的出口
//        outside.setExits(null, lobby, study, pub);
//        lobby.setExits(null, null, null, outside);
//        pub.setExits(null, outside, null, null);
//        study.setExits(outside, bedroom, null, null);
//        bedroom.setExits(null, null, null, study);

        currentRoom = outside;  //	从城堡门外开始
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println();
        currentRoom.showPromt();
    }

    // 以下为用户命令

    private void printHelp() {
        System.out.print("迷路了吗？你可以做的命令有：go bye help");
        System.out.println("如：\tgo east");
    }

    public void goRoom(String direction) {
        Room nextRoom = null;
        if ("all_rotation".equals(direction)) {
            nextRoom = getRotationRoom();
        } else {
            nextRoom = currentRoom.getNextRoom(direction);
        }
        if (nextRoom == null) {
            System.out.println("那里没有门！");
        } else {
            currentRoom = nextRoom;
            currentRoom.showPromt();
        }
    }

    public Room getRotationRoom() {
        int nextInt = currentIndex % rooms.size();
        currentIndex++;
        return rooms.get(nextInt);
    }


    public static void main(String[] args) {
        play();
        System.out.println("感谢您的光临。再见！");

    }

    private static void play() {
        Scanner in = new Scanner(System.in);
        Game game = new Game();
        game.printWelcome();
        // 这一部分 还是硬编码
        while (true) {
            String line = in.nextLine();
            String[] words = line.split(" ");
            Handler handler = cmdHash.get(words[0]);
            if (handler.exit()) {
                break;
            } else {
                handler.Cmd(words[1]);
            }
//        		if ( words[0].equals("help") ) {
//        			game.printHelp();
//        		} else if (words[0].equals("go") ) {
//        			game.goRoom(words[1]);
//        		} else if ( words[0].equals("bye") ) {
//        			break;
//        		}
        }
        in.close();
    }

}
