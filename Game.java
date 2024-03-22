import java.util.Scanner;

class Game {
  public static void main(String[] args) {
    NPC p1 = new NPC();
    Ogre p2 = new Ogre();
    Player p3 = new Player();

    p1.print_attributes();
    p2.print_attributes();
    p3.print_attributes();
  }
}

class NPC {
  protected String name = "A generic NPC";

  // protected String species = "human";
  protected Human species = new Human();
  protected int level = 0;
  protected int experience = 0;

  protected int strength;
  protected int reflexes;
  protected int wisdom;

  protected int health;

  NPC() {

    strength = 5 + species.get_str_mod();
    reflexes = 5 + species.get_ref_mod();
    wisdom = 5 + species.get_wis_mod();
    health = calculate_health();
  }

  public int calculate_health() {
    return 10 + 10 * level;
  }

  public int get_health() {
    return health;
  }

  public String get_name() {
    return name;
  }

  public int get_level() {
    return level;
  }

  public int get_experience() {
    return experience;
  }

  // public String get_species() {
  // return species;
  // }

  public int get_strength() {
    return strength;
  }

  public int get_reflexes() {
    return reflexes;
  }

  public int get_wisdom() {
    return wisdom;
  }

  public void print_attributes() {
    System.out.println("\n\n**************************************************");
    System.out.println(name);
    System.out.println("Species\tLevel\tExperience");
    System.out.println(String.format("%s\t%d\t%d", species, level, experience));

    System.out.println("Health: " + health);
    System.out.println("Strength: " + strength);
    System.out.println("Reflexes: " + reflexes);
    System.out.println("Wisdom: " + wisdom);

    System.out.println("**************************************************\n\n");

  }
}

class Ogre extends NPC {

  Ogre() {
    name = "a monstrous ogre";
    // species = "ogre";
    strength = 12;
    reflexes = 3;
    wisdom = 1;
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
