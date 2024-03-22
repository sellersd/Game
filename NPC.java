package Game;

class NPC {
  protected int strength;
  protected int reflexes;
  protected int wisdom;

  NPC() {
    strength = 5;
    reflexes = 5;
    wisdom = 5;
  }

  public int get_strength() {
    return strength;
  }

  public int get_reflexes() {
    return reflexes;
  }

  public int get_wisdom() {
    return strength;
  }
}
