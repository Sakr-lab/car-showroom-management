package cars;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    private static void searchRange(ArrayList<Cars> car,String type,Scanner in){
        System.out.println("Entre range of "+type);
        System.out.println("from : ");
        int f=in.nextInt();
        System.out.println("to : ");
        int t=in.nextInt();
        in.nextLine();

        boolean found=false;
        for(Cars c:car){
            int value= switch (type){
                case "price" -> c.getPrice();
                case "release" -> c.getReleaseDate();
                case "speed" -> c.getMaxSpeed();
                case "capacity" -> c.getEngineCapacity();
                default -> -1;
            };
            if(value>=f && value<=t){
                found=true;
                System.out.println(c.toStringCars());
            }
        }
        if(!found){
            System.out.println("\t not found similar cars");
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String name,color;
        int releaseDate,price,maxSpeed,engineCapacity;
        ArrayList<Cars> car=new ArrayList<>();
        ArrayList<Cars> sell_cars=new ArrayList<>();
        boolean run=true;
        while(run){
            System.out.println("\t \t \t select option");
            System.out.println("add \t sell \t display \t search \t edit \t exit");
            String s=in.nextLine();
            boolean found=false;
            int id;
            switch (s){
                case "add":
                    System.out.print("name : ");
                    name=in.nextLine();
                    System.out.print("color : ");
                    color=in.nextLine();
                    System.out.print("release date : ");
                    releaseDate=in.nextInt();
                    System.out.print("price : ");
                    price=in.nextInt();
                    System.out.print("max speed : ");
                    maxSpeed=in.nextInt();
                    System.out.print("engine capacity : ");
                    engineCapacity=in.nextInt();
                    in.nextLine();
                    car.add(new Cars(name,color,releaseDate,price,maxSpeed,engineCapacity));
                    System.out.println("Done ☺");
                    break;
                case "sell":
                    if(car.isEmpty()) {
                        System.out.println("Store is empty");
                    }
                    else{
                    System.out.print("Entre id of car : ");
                    id=in.nextInt();
                    for (int i = 0; i < car.size(); i++) {
                        if(car.get(i).getId()==id){
                            found=true;
                            System.out.println(car.get(i).toStringCars());
                            System.out.println("press c to complete sell or any character to exit");
                            in.nextLine();
                            char ok=in.nextLine().charAt(0);
                            if(ok=='c'){
                                System.out.print("Entre discount : ");
                                int discount=in.nextInt();
                                in.nextLine();
                                sell_cars.add(new Cars(car.get(i),discount));
                                car.remove(i);
                                System.out.println("sell car is done ");
                                int x=sell_cars.size()-1;
                                System.out.println(sell_cars.get(x).toStringSellCars());
                            }else{
                                break;
                            }

                        }
                    }
                    if(!found){
                        System.out.println("Not Found That Id");
                    }}
                    break;
                case "display":
                    System.out.println("cars or history");
                    String d=in.nextLine();
                    if(d.equals("cars")){
                        if(car.isEmpty()){
                            System.out.println("Store is empty");
                        }
                        else{
                            for(Cars c: car){
                                System.out.println(c.toStringCars());
                            }
                        }
                    }
                    else if(d.equals("history")){
                        if(sell_cars.isEmpty()){
                            System.out.println("\t \t \t no history yet");
                        }
                        else{
                            for(Cars c: sell_cars){
                                System.out.println(c.toStringSellCars());
                            }
                        }
                    }
                    break;
                case "search":
                    System.out.println(" Search by { price , release , speed , capacity }");
                    String Se=in.nextLine();
                    switch (Se){
                        case "price":
                            searchRange(car,"price",in);
                            break;
                        case "release":
                            searchRange(car,"release",in);
                            break;
                        case "speed":
                            searchRange(car,"speed",in);
                            break;
                        case "capacity":
                            searchRange(car,"capacity",in);
                            break;
                        default:
                            System.out.println("Unknown option");
                    }
                    break;
                case "edit":
                    System.out.print("Entre Id : ");
                    id=in.nextInt();
                    in.nextLine();
                    boolean check=false;
                    for(Cars c: car)  {
                        if(c.getId()==id){
                            check=true;
                            System.out.println("name = "+c.getName());
                            System.out.print("new name : ");
                            name=in.nextLine();
                            c.setName(name);

                            System.out.println("color = "+c.getColor());
                            System.out.print("new color : ");
                            color=in.nextLine();
                            c.setColor(color);

                            System.out.println("release date = "+c.getReleaseDate());
                            System.out.print("new release date : ");
                            releaseDate=in.nextInt();
                            c.setReleaseDate(releaseDate);

                            System.out.println("price = "+c.getPrice());
                            System.out.print("new price : ");
                            price=in.nextInt();
                            c.setPrice(price);

                            System.out.println("max speed = "+c.getMaxSpeed());
                            System.out.print("new max speed : ");
                            maxSpeed=in.nextInt();
                            c.setMaxSpeed(maxSpeed);

                            System.out.println("engine capacity = "+c.getEngineCapacity());
                            System.out.print("new engine capacity : ");
                            engineCapacity=in.nextInt();
                            in.nextLine();
                            c.setEngineCapacity(engineCapacity);
                            break;
                        }
                    }
                    if(!check){
                        System.out.println("Not Found That Id");
                    }
                    break;
                case "exit":
                    run=false;
                    break;
                default:
                    break;
            }
        }

    }
}

/*
            Select option
add car: get input by variable and add it in new object in ArrayList
sell car: remove it from cars_ArrayList and add it in sell_cars_ArrayList_
show car: display all cars in cars_ArrayList
search: by price(),by motor_CC(),by speed(),by name();
edit car by id: get id from user and get new information then edit object that he selected if id is it
 */