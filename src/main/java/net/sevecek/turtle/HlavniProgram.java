package net.sevecek.turtle;

import net.sevecek.turtle.engine.Turtle;

import java.awt.*;

public class HlavniProgram {

    public void main(String[] args) {

        Turtle zofka;

        zofka = new Turtle();
        Color cernaBarva = new Color(0,0,0);
        zofka.setPenColor(cernaBarva);

        // zmrzlina
        zofka.setLocation(150, 350);
        zofka.turnRight(180);
        nakresliTrojuhelnik(zofka, 150, 30);
        nakresliKruh(zofka, 78);
        zofka.turnLeft(180);

        // snehulak
        zofka.setLocation(400, 350);
        zofka.turnRight(90);
        nakresliKruh(zofka, 150);
        zofka.turnRight(180);
        nakresliKruh(zofka, 100);
        zofka.turnRight(90);
        zofka.move(100);
        zofka.turnRight(270);
        nakresliKruh(zofka, 75);
        zofka.move(50);
        zofka.turnLeft(90);
        zofka.move(50);
        nakresliKruh(zofka, 50);
        zofka.turnLeft(90);
        zofka.move(100);
        zofka.turnLeft(90);
        nakresliKruh(zofka, 50);

        // masinka
        zofka.setLocation(650, 370);
        zofka.turnLeft(225);
        nakresliTrojuhelnik(zofka, 100, 90);
        zofka.turnLeft(135);
        zofka.move(30);
        zofka.turnRight(90);
        nakresliObdelnik(zofka, 200, 100);
        zofka.move(200);
        zofka.turnRight(90);
        zofka.move(100);
        zofka.turnLeft(180);
        nakresliObdelnik(zofka, 230, 150);
        nakresliKruh(zofka, 150);
        zofka.turnLeft(90);
        zofka.move(60);
        zofka.turnRight(180);
        nakresliKruh(zofka, 60);
        zofka.turnRight(180);
        zofka.move(80);
        zofka.turnRight(180);
        nakresliKruh(zofka, 60);
        zofka.turnLeft(90);
    }

    public void nakresliTrojuhelnik(Turtle zofka, double velikostRamene, double uhelMeziRameny) {
        zofka.penDown();

        double velikostStranyC = vypocitejDelkuTretiStrany(velikostRamene, uhelMeziRameny);
        double uhelMeziStranouC = (180 - uhelMeziRameny) / 2;

        zofka.turnRight(90 - uhelMeziStranouC);
        zofka.move(velikostRamene);
        zofka.turnRight(180 - uhelMeziRameny);

        zofka.move(velikostRamene);
        zofka.turnRight(180 - uhelMeziStranouC);

        zofka.move(velikostStranyC);
        zofka.turnRight(90.0);

        zofka.penUp();
    }

    public double vypocitejDelkuTretiStrany(double velikostRamene, double uhelMeziRameny) {
        double tretiStrana;
        tretiStrana = Math.abs((velikostRamene
                * Math.sin((uhelMeziRameny * Math.PI / 180.0) / 2.0))
                * 2.0);
        return tretiStrana;
    }

    public void nakresliCtverec(Turtle zofka, double velikostStrany) {
        zofka.penDown();
        for (int i = 0; i < 4; i++) {
            zofka.move(velikostStrany);
            zofka.turnRight(90.0);
        }
        zofka.penUp();
    }

    public void nakresliObdelnik(Turtle zofka, double velikostStranyA, double velikostStranyB) {
        zofka.penDown();
        zofka.move(velikostStranyA);
        zofka.turnRight(90.0);
        zofka.move(velikostStranyB);
        zofka.turnRight(90.0);
        zofka.move(velikostStranyA);
        zofka.turnRight(90.0);
        zofka.move(velikostStranyB);
        zofka.turnRight(90.0);
        zofka.penUp();
    }

    public void nakresliKruh(Turtle zofka, double prumerKruhu) {
        zofka.penDown();
        double posun = (prumerKruhu * Math.PI) / 360;
        for (int i = 0; i < 360; i++) {
            zofka.move(posun);
            zofka.turnRight(1);
        }
        zofka.penUp();
    }

}
