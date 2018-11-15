package com.CodeHeap.ReflectionAPI.TransactionViaProxy;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//todo commit and rollback should be implemented within controller, rollback is fired by proxy object whenever exception is thrown...
public class User implements ISelectGoods {
    private final int ID;
    private int[] goods = new int[3];
    public User(int id){

        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator +
                Initializer.class.getName()
                        .replace(Initializer.class.getSimpleName(),"")
                        .replaceAll("[.]", File.separator);

        try (BufferedReader brUsers =
                     new BufferedReader(
                             new FileReader(path+"users.txt")
                     )
        ) {
            boolean userFound = false;
            String line;
            int userNum=1;
            while (brUsers.ready()&&(line = brUsers.readLine())!=null){
                if(line.contains("User#"+userNum++)){
                    userFound = true;
                    int arrayNum = 0;
                    Matcher matcher = Pattern.compile("(Good#)(\\d+)").matcher(line);
                    while(matcher.find()){
                        goods[arrayNum++]=Integer.valueOf(matcher.group(2));
                    }
                }
            }
            if(!userFound) throw new Exception("user#"+id+" not found");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        this.ID=id;
    }

    @Override
    public int askForGood(int goodId){
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator +
                Initializer.class.getName()
                        .replace(Initializer.class.getSimpleName(),"")
                        .replaceAll("[.]", File.separator);

        try (BufferedReader brGoods =
                     new BufferedReader(
                             new FileReader(path+"goods.txt")
                     )
        ) {
            boolean goodFound = false;
            String line;
            while(brGoods.ready()&&(line = brGoods.readLine())!=null){
                Matcher matcher = Pattern.compile("(Good#" + goodId + "\\s+)(\\d+)").matcher(line);
                if(matcher.find()){
                    return Integer.valueOf(matcher.group(2));
                }
            }

            throw new Exception("good#"+goodId+" not found");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getGood(int goodId){
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator +
                Initializer.class.getName()
                        .replace(Initializer.class.getSimpleName(),"")
                        .replaceAll("[.]", File.separator);

        try (RandomAccessFile raf = new RandomAccessFile(path + "goods.txt", "rw")
        ) {
            String line;
            Matcher matcher = Pattern.compile("(Good#" + goodId + "\\s+)(\\d+)").matcher("");
            while((line=raf.readLine())!=null){
                matcher.reset(line);
                if(matcher.find()){
                    raf.seek(raf.getFilePointer()-matcher.group(2).length()-3-1);
                    raf.write(
                            Integer.toString(Integer.valueOf(matcher.group(2))-1).getBytes()
                    );
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void putGoodToBasket(int goodId){
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator +
                Initializer.class.getName()
                        .replace(Initializer.class.getSimpleName(),"")
                        .replaceAll("[.]", File.separator);
        boolean bucketIsFull = true;
        for (int i = 0; i < goods.length; i++) {
            if(goods[i]==0){
                goods[i]=goodId;
                bucketIsFull = false;
                break;
            }
        }
        try{
            if(bucketIsFull)
                throw new Exception("bucket is full of goods...");
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        try (RandomAccessFile raf = new RandomAccessFile(path + "users.txt", "rw")
        ) {
            String line;
            Matcher matcher = Pattern.compile("(User#" + ID + "\\s+)").matcher("");
            while((line=raf.readLine())!=null){
                matcher.reset(line);
                if(matcher.find()){
                    raf.seek(raf.getFilePointer()-1);
                    raf.write(("Good#"+goodId+" ").getBytes());
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("User#"+this.ID+" ");
        for (Integer good : goods) {
            if(good==0) continue;
            result.append("Good#").append(good).append(" ");
        }
        return result.toString();
    }
}
