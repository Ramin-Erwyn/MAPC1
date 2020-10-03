package td1.original.client;

import refactory.Sauce;

import static refactory.Meat.MeatType.*;
import static refactory.Sauce.SauceType.*;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String args[]) {
        refactory.Burger alice_dinner = new refactory.Burger(
                "Fishy",
                List.of(new refactory.Meat(WHITEFISH, 50),
                        new refactory.Sauce(BEARNAISE, 40))
        );
        refactory.Burger bob_dinner = new refactory.Burger(
                "Beefy",
                List.of(new refactory.Meat(BEEF, 100),
                        new refactory.Sauce(BURGER, 40),
                        new refactory.DeepFriedOnions(10),
                        new refactory.Cheddar(15),
                        new refactory.DeepFriedOnions(10),
                        new refactory.Cheddar(15))
        );
        refactory.Burger charles_dinner = new refactory.Burger(
                "Own Style",
                List.of(new refactory.Meat(BEEF,400),
                        new refactory.DeepFriedOnions(20),
                        new refactory.Cheddar(30),
                        new refactory.Sauce(BARBECUE,20),
                        new refactory.Sauce(BEARNAISE,20),
                        new Sauce(BURGER,20),
                        new refactory.Cheddar(30))
        );
        List<refactory.Burger> dinners = Arrays.asList(
                alice_dinner,
                bob_dinner,
                charles_dinner
        );
        for (refactory.Burger dinner : dinners) {
            System.out.println(dinner);
        }
    }
}