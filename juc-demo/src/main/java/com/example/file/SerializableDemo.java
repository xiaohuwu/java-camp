package com.example.file;
import java.io.*;
import java.util.Arrays;

public class SerializableDemo {

    public static class Person implements Serializable {
        private String name;
        private Long age;

        public Person(String name, Long age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getAge() {
            return age;
        }

        public void setAge(Long age) {
            this.age = age;
        }
    }


    public static void main(String[] args) {
        //序列化
//        Person person = new Person("John Doe", 30L);
//
//        try (FileOutputStream fileOutputStream = new FileOutputStream("person.ser");
//             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
//            objectOutputStream.writeObject(person);
//            System.out.println("Person object has been serialized to 'person.ser' file.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        //反序列化
        try (FileInputStream fileInputStream = new FileInputStream("person.ser");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            Object deserializedPerson =  objectInputStream.readObject();
            System.out.println("Person object has been deserialized:");
            System.out.println(deserializedPerson);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

//    public static void main(String[] args) throws IOException {
////        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//        OutputStream outputStream = new ObjectOutputStream();
//        try (ObjectOutputStream output = new ObjectOutputStream(buffer)) {
//            // 写入int:
//            output.writeInt(12345);
//            // 写入String:
//            output.writeUTF("Hello");
//            // 写入Object:
//            output.writeObject(Double.valueOf(123.456));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        byte[] bytes = buffer.toByteArray();
//        System.out.println(Arrays.toString(bytes));
//
//        try (ObjectInputStream input = new ObjectInputStream(new ByteArrayInputStream(bytes))) {
//            int n = input.readInt();
//            String s = input.readUTF();
//            Double d = (Double) input.readObject();
//            System.out.println("n = " + n);
//            System.out.println("s = " + s);
//            System.out.println("d = " + d);
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
}
