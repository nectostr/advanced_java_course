import java.util.Random;
import java.util.Scanner;

/**
 * Created by Любовь on 09.11.2016.
 */
public class Fight {
    Scanner in = new Scanner(System.in);
    Pokemon firstP;
    Pokemon secondP;
    Random rnd = new Random();

    public int Fightig(Pokemon firstPset, Pokemon secondPset) {
        firstP = firstPset;
        secondP = secondPset;

        while (firstP.getHealth() > 0 && secondP.getHealth() > 0) {
            Action();
        }
        if (firstP.getHealth() > secondP.getHealth()) {
            System.out.println("First pokemon win's");
        } else {
            System.out.println("Second pokemon win's");
        }
        return 0;
    }

    public void Action() {
        int firstAttachValue = 0;
        int secondAttachValue = 0;
        int firstDefendValue = 0;
        int secondDefendValue = 0;

        System.out.println("First pokemon'master, enter type of action, please (a=attach/d=defend)");
        if ("a".equals(in.next()) && (firstP.getEnergy() > 0)) {
            System.out.println("First pokemon'master, enter type of attach, please");
            int i = 0;
            firstAttachValue = firstP.getAttack()[i];
            firstP.setEnergy(firstP.getEnergy() - i - 1);

        } else {
            if (firstP.getEnergy() > 0) {
                System.out.println("First pokemon'master, enter type of defend, please");

            } else {
                System.out.println("First pokemon'master, attach is unavailable for you, enter type of defend, please");
            }
            int i = 0;
            firstDefendValue = firstP.getDefend()[i];
            firstP.setEnergy(firstP.getEnergy() - i - 1);
        }
        System.out.println("Second pokemon'master, enter type of action, please (a=attach/d=defend)");
        if ("a".equals(in.next()) && (secondP.getEnergy() > 0)) {
            System.out.println("Second pokemon'master, enter type of attach, please");
            secondAttachValue = secondP.getAttack()[0];
        } else {
            if (secondP.getEnergy() > 0) {
                System.out.println("Second pokemon'master, enter type of defend, please");
            } else {
                System.out.println("Second pokemon'master, attach is unavailable for you, enter type of defend, please");
            }
            secondDefendValue = secondP.getDefend()[0];
            secondP.setEnergy(secondP.getEnergy() + secondP.getRestLevel());
        }
        //System.out.println(firstAttachValue + " " + secondAttachValue + " " + firstDefendValue + " " + secondDefendValue);
        //System.out.println(firstP.getHealth() + " " + secondP.getHealth());
        //System.out.println(rnd.nextInt(4));
        if (secondAttachValue > 0)
            firstP.setHealth(firstP.getHealth() - secondAttachValue + firstDefendValue - rnd.nextInt(4));
        if (firstAttachValue > 0)
            secondP.setHealth(secondP.getHealth() - firstAttachValue + secondDefendValue - rnd.nextInt(4));
        System.out.println("Amount of health for first pokemon is  " + firstP.getHealth()
                + " and amount of energy is " + firstP.getEnergy());
        System.out.println("Amount of health for second pokemon is " + secondP.getHealth()
                + " and amount of energy is " + secondP.getEnergy());
        System.out.println("decrease of energy " + firstP.getRestLevel() + " " + secondP.getRestLevel());
    }

}
