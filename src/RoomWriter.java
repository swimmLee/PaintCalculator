
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.ObjectOutputStream;
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
public class RoomWriter {
    
    public static void writeRooms(String fileName, List<Room> list) throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        try {
            for(Room room : list){
                oos.writeObject(room);
                System.out.println("Writing to file.\n" + room.toString());
            }
        }
        catch(IOException e){
            
        }
        oos.close();
    }
            /*
        for(int i =0; i<list.size(); i++){
            oos.writeObject(list.get(i));
        }
        */
}
