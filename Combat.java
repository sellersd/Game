import java.util.Random;

class Combat {

  Random rand = new Random();

  public attack(NPC att, NPC def) {

    int threshold = 10;

    int AS = att.get_strength() + att.get_reflexes() / 10;
    int DS = def.get_reflexes() + att.get_strength() / 10;

    int d10 = rand.nextInt(10) + 1;
    int total = AS - DS + d10;

    System.out.println(att.get_name() + " attacks " + def.get_name());
    System.out.println("AS: " + AS + " - DS: " + DS + " d10: " + d10 + " = " + total);

    if(total > threshold) {
      System.out.println("Hit!");
      int diff = threshold - total;
      update_health(def, diff);
    }
    else {
      System.out.println("Miss!");
    }
  }

  public calculate_damage(NPC att, NPC def) {
    int weapon_damage = att.get_weapon_damage();
    int armor_protection = def.get_armor_protection();

    int damage = 0;

    if(diff > 10) {
      System.out.println("Critical hit!");
      damage = 3 * weapon_damage - armor_protection;
    }
    else if(diff > 5) {
      System.out.println("Solid hit!");
      damage = weapon_damage - armor_protection;
    }
    else {
      damage = (int)(0.5 * (weapon_damage - armor_protection));

    }
  }

  public void update_health(NPC def, int diff) {
    System.out.println("Stub");

  }
}
