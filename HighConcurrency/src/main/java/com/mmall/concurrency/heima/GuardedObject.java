package com.mmall.concurrency.heima;
import lombok.extern.slf4j.Slf4j;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

@Slf4j
public class GuardedObject {
    private int id;
    private Object response;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public GuardedObject() {
    }
    public GuardedObject(int generateId) {
        this.id = generateId;
    }
    public Object get(long timeout) {
        synchronized (this) {
            long current = System.currentTimeMillis();
            long period = 0;
            while (response == null) {
                if (period > timeout) {
                    break;
                }
                try {
                    this.wait(timeout - period);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                period = System.currentTimeMillis() - current;
            }
            Object result = response;
            response = null;
            log.info("get o = {}", result);
            this.notifyAll();
            return result;
        }
    }

    public void put(Object object) {
        synchronized (this) {
            while (response != null) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            log.info("put 开始送信,:{}", object);
            response = object;
            this.notifyAll();
        }
    }
}

class MailBoxes {
    public static Map<Integer, GuardedObject> boxes = new Hashtable<>();
    private static int id = 1;

    private static synchronized int generateId() {
        return id++;
    }

    public static GuardedObject CreateGuardeObject() {
        int generateId = generateId();
        GuardedObject guardedObject = new GuardedObject(generateId);
        boxes.put(generateId, guardedObject);
        return guardedObject;
    }

    public static Set<Integer> getIds() {
        return boxes.keySet();
    }
}

@Slf4j
class Person extends Thread {
    @Override
    public void run() {
        GuardedObject guardedObject = MailBoxes.CreateGuardeObject();
        log.info("开始收信 id:{}", guardedObject.getId());
        Object mail = guardedObject.get(5000);
        log.info("收到信 id:{},内容:{}", guardedObject.getId(), mail);
    }
}

@Slf4j
class PostMan extends Thread {
    private int id;
    private Object mail;

    public PostMan(int id, Object mail) {
        this.id = id;
        this.mail = mail;
    }

    @Override
    public void run() {
        GuardedObject guardedObject = MailBoxes.boxes.get(id);
        guardedObject.put(mail);
    }
}


@Slf4j
class Test20 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Person().start();
        }
        Sleeper.sleep(1);
        for (Integer id : MailBoxes.getIds()) {
            new PostMan(id, "内容" + id).start();
        }
    }

}


