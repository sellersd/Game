package Projects.Demos.Game;

import java.util.Random;
import java.util.Scanner;

class Game {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    boolean running = true;
    String cmd;

    NPC p1 = new NPC();
    Ogre p2 = new Ogre();
    Player p3 = new Player();

    p1.print_attributes();
    p2.print_attributes();
    p3.print_attributes();

    while (running) {
      System.out.print(">>> ");
      cmd = sc.nextLine();

      if (cmd.equals("camp")) {

      } else if (cmd.equals("attack")) {
        Combat c = new Combat(p3, p2);
      } else {
        System.out.println("I do not understand what you are trying to do.");
      }

    }

    sc.close();

  }

}

class Player extends NPC {

  Player() {
    Scanner sc = new Scanner(System.in);

    System.out.print("What is your name? ");
    name = sc.nextLine();

    Species species = choose_species();
    strength = 7 + species.get_str_mod();
    reflexes = 9 + species.get_ref_mod();
    wisdom = 6 + species.get_wis_mod();

    sc.close();
  }

  Species choose_species() {
    Scanner sc = new Scanner(System.in);

    System.out.println("Choose a species: ");
    System.out.println("1. Human");
    System.out.println("2. Troll");
    System.out.println("3. Lizard Person");
    System.out.println("4. Elf");

    int choice = sc.nextInt();

    sc.close();

    if (choice == 1) {
      return new Human();
    } else if (choice == 2) {
      return new Troll();
    } else if (choice == 3) {
      return new Lizard();
    } else if (choice == 4) {
      return new Elf();
    } else {
      System.out.println("invalid choice");
      return new Human();
    }

  }

  // polymorphism
  public int calculate_health() {
    return 20 + 10 * level;
  }

}

class Species {
  protected int str_mod = 0;
  protected int ref_mod = 0;
  protected int wis_mod = 0;

  public int get_str_mod() {
    return str_mod;
  }

  public int get_ref_mod() {
    return ref_mod;
  }

  public int get_wis_mod() {
    return wis_mod;
  }
}

class Human extends Species {
  Human() {
    str_mod = 1;
    ref_mod = 1;
    wis_mod = 1;
  }
}

class Troll extends Species {
  Troll() {
    str_mod = 1;
    ref_mod = 1;
    wis_mod = 1;
  }
}

class Lizard extends Species {
  Lizard() {
    str_mod = 1;
    ref_mod = 1;
    wis_mod = 1;
  }
}

class Elf extends Species {
  Elf() {
    str_mod = 1;
    ref_mod = 1;
    wis_mod = 1;
  }
}

class Combat {

  Random rand = new Random();

  Combat(NPC att, NPC def) {

  }

  public void attack(NPC att, NPC def) {

    int threshold = 10;

    int AS = att.get_strength() + att.get_reflexes() / 10;
    int DS = def.get_reflexes() + att.get_strength() / 10;

    int d10 = rand.nextInt(10) + 1;
    int total = AS - DS + d10;

    System.out.println(att.get_name() + " attacks " + def.get_name());
    System.out.println("AS: " + AS + " - DS: " + DS + " d10: " + d10 + " = " + total);

    if (total > threshold) {
      System.out.println("Hit!");
      int diff = threshold - total;
      int dmg = calculate_damage(att, def, diff);
      update_health(def, dmg);
    } else {
      System.out.println("Miss!");
    }
  }

  public int calculate_damage(NPC att, NPC def, int diff) {
    int weapon_damage = att.get_weapon_damage();
    int armor_protection = def.get_armor_protection();

    int damage = 0;

    if (diff > 10) {
      System.out.println("Critical hit!");
      damage = 3 * weapon_damage - armor_protection;
    } else if (diff > 5) {
      System.out.println("Solid hit!");
      damage = weapon_damage - armor_protection;
    } else {
      damage = (int) (0.5 * (weapon_damage - armor_protection));

    }

    return damage;
  }

  public void update_health(NPC def, int diff) {
    System.out.println("Stub");

  }
}
