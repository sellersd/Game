package Projects.Demo.Game;

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
