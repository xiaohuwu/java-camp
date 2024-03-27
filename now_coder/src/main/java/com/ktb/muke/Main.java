package com.ktb.muke;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(buffer)) {
            // 写入int:
            output.writeInt(12345);
            // 写入String:
            output.writeUTF("Hello");
            // 写入Object:
            output.writeObject(Double.valueOf(123.456));
        }

        try (ObjectInputStream input = new ObjectInputStream(streamTran(buffer))) {
            int n = input.readInt();
            String s = input.readUTF();
            Double d = (Double) input.readObject();
            System.out.println("d = " + d);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    private static InputStream streamTran(ByteArrayOutputStream in) {
        return new ByteArrayInputStream(in.toByteArray());
    }
}
