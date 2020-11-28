import java.util.ArrayList;
import java.util.Scanner;

public class p10901 {
    static class Car {
        int at_time, arrive;

        public Car(int t){
            at_time = t;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test, load, max, use_time, time, car, t;
        boolean atLeft;
        String bank;
        test = sc.nextInt();
        while(test-- > 0){
            atLeft = true;
            load = 0;
            time = 0;
            max = sc.nextInt();
            use_time = sc.nextInt();
            car = sc.nextInt();
            ArrayList<Car> cars = new ArrayList<>();
            ArrayList<Car> left = new ArrayList<>();
            ArrayList<Car> right = new ArrayList<>();
            while(car-- > 0){
                t = sc.nextInt();
                bank = sc.next();
                Car c = new Car(t);
                cars.add(c);
                if(bank.equals("left")) left.add(c);
                else right.add(c);
            }

            int tL, tR;
            while(!left.isEmpty() || !right.isEmpty()){
                if(!left.isEmpty()) tL = left.get(0).at_time;
                else tL = Integer.MAX_VALUE;
                if(!right.isEmpty()) tR = right.get(0).at_time;
                else tR = Integer.MAX_VALUE;

                if(tL == tR && atLeft) tR = Integer.MAX_VALUE;
                else if(tL == tR && !atLeft) tL = Integer.MAX_VALUE;
                if(tL <= time && atLeft) tR = Integer.MAX_VALUE;
                else if(tR <= time && !atLeft) tL = Integer.MAX_VALUE;

                if(tL < tR){
                    if(left.get(0).at_time - time > 0) time += (left.get(0).at_time - time);
                    if(!atLeft){
                        time += use_time;
                        atLeft = !atLeft;
                    }
                    while(left.size() > 0 && left.get(0).at_time <= time && load < max){
                        load++;
                        left.remove(0).arrive = time+use_time;
                    }
                    time += use_time;
                    atLeft = !atLeft;
                    load = 0;
                }
                else if(tR < tL){
                    if(right.get(0).at_time - time > 0) time += (right.get(0).at_time - time);
                    if(atLeft){
                        time += use_time;
                        atLeft = !atLeft;
                    }
                    while(right.size() > 0 && right.get(0).at_time <= time && load < max){
                        load++;
                        right.remove(0).arrive = time+use_time;
                    }
                    time += use_time;
                    atLeft = !atLeft;
                    load = 0;
                }
            }

            for(Car c : cars){
                System.out.println(c.arrive);
            }
            if(test > 0) System.out.println();
        }
    }
}
