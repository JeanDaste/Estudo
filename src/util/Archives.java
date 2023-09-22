package util;

import java.io.*;
import java.util.ArrayList;
public class Archives implements Serializable {

    /*public static void writeArchive(String filename, ArrayList<?> arrayList) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Object obj : arrayList) {
                outputStream.writeObject(obj);
            }
            outputStream.flush();
            System.out.println("Objects written successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("The archive is not found!");
        } catch (IOException e) {
            System.out.println("Error while writing to the archive: " + e.getMessage());
        }
     */


    public static <T extends Serializable> void writeObjects(String filename, ArrayList<T> objects) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (T obj : objects) {
                outputStream.writeObject(obj);
            }
            System.out.println("Objects written successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("The archive is not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while writing to the archive: " + e.getMessage());
        }
    }

    public static <T extends Serializable> ArrayList<T> readObjects(String filename) {
        ArrayList<T> objects = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    @SuppressWarnings("unchecked")
                    T obj = (T) inputStream.readObject();
                    objects.add(obj);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The archive is not found: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while reading the archive: " + e.getMessage());
        }
        return objects;
    }

    public static String read(String filename){
        StringBuilder c = new StringBuilder();
        try {
            FileReader arq = new FileReader(filename);
            BufferedReader lerArq = new BufferedReader(arq);
            String l;
            try {
                l = lerArq.readLine();
                while(l!=null){
                    c.append(l).append("\n");
                    l = lerArq.readLine();
                }
                arq.close();
                return c.toString();
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
            return "";
        }
    }

    public static void write(String filename,String Texto){
        try {
            FileWriter arq = new FileWriter(filename);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(Texto);
            gravarArq.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}