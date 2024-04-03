package Projects.Demos.Game;

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
