
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.Serializable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lheberer
 */
public class RoomReader implements Serializable {
    
    public static List<Room> readRooms(String fileName) throws FileNotFoundException,
            IOException, ClassNotFoundException, EOFException {
        System.out.println("Inside RoomReader class");
        List<Room> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj;
        System.out.println("Inside RoomReader class");
        try {
            obj = ois.readObject();
            if(obj != null){
                System.out.println("obj not null after first read => true");
            }
            else{
                System.out.println("obj is null after first read");
            }
            while(obj != null){
                Room room = (Room) obj;
                list.add(room);
                System.out.println("Inside read loop\n" + room.toString());
                obj = ois.readObject();
            /*
            for(Room room : list){
                room = (Room) ois.readObject();
                list.add(room);
                */
            
            }
        }
        catch (EOFException e) {
            // Do nothing, this is expected.
        }
        
        if (list.isEmpty()) {
            System.out.println("No rooms yet");
        }

        for (Room room : list) {
            System.out.println(room.toString());
        }
        
        ois.close();
        return list;
    }

    private static class FileInputstream {

        public FileInputstream() {
        }
    }
}
