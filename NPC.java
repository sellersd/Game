package Projects.Demos.Game;

class NPC {
  protected String name = "A generic NPC";

  // protected String species = "human";
  protected Human species = new Human();
  protected int level = 0;
  protected int experience = 0;

  protected int strength;
  protected int reflexes;
  protected int wisdom;

  protected int armor_protection = 0;
  protected int weapon_damage = 0;
  protected int health;

  NPC() {

    strength = 5 + species.get_str_mod();
    reflexes = 5 + species.get_ref_mod();
    wisdom = 5 + species.get_wis_mod();
    health = calculate_health();
  }

  public int get_weapon_damage() {
    return weapon_damage;
  }

  public int get_armor_protection() {
    return armor_protection;
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

  public Species get_species() {
    return species;
  }

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
