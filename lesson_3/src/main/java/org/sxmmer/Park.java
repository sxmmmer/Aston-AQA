package org.sxmmer;

public class Park {
    public class Attraction{
        private String name;
        private String time;
        private int price;

        public Attraction(String name, String time, int price){
            this.name = name;
            this.time = time;
            this.price = price;
        }

        public void info(){
            System.out.println("Название аттракциона: " + name);
            System.out.println("Время работы: " + time);
            System.out.println("Стоимость: " + price + "$");
            System.out.println();
        }
    }

    public static void main(String[] args){
        Park park = new Park();
        Attraction panicRoom = park.new Attraction("Команта страха",
                "12:00 - 23:00",
                5);
        Attraction rollerCoaster = park.new Attraction("Американские горки",
                "10:00 - 21:00",
                6);
        Attraction wheel = park.new Attraction("Колесо обозрения",
                "10:00 - 22:00",
                8);
        panicRoom.info();
        rollerCoaster.info();
        wheel.info();
    }
}
