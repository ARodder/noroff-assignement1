package dev.roder.characters;

public class HeroAttribute {
    private int strength;
    private int dexterity;
    private int intelligence;

    /**
     * Builds an instance of Hero attribute, given the starting attributes.
     * 
     * @param strength     starting value for strength.
     * @param dexterity    starting value for dexterity.
     * @param intelligence starting value for intelligence.
     */
    public HeroAttribute(int strength, int dexterity, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    /**
     * Add method to add one HeroAttribute to the current HeroAttribute.
     * 
     * @param newAttributes HeroAttribute to add to the current.
     * @return
     */
    public HeroAttribute add(HeroAttribute newAttributes) {
        return new HeroAttribute(
                this.strength + newAttributes.getStrength(),
                this.dexterity + newAttributes.getDexterity(),
                this.intelligence + newAttributes.getIntelligence());
    }

    /**
     * Summing multiple HeroAttributes, including the current.
     * 
     * @param attributes list of HeroAttributes to add together.
     * @return new HeroAttribute with summed values.
     */
    public HeroAttribute add(HeroAttribute[] attributes) {
        HeroAttribute result = new HeroAttribute(this.strength, this.dexterity, this.intelligence);
        for (HeroAttribute attribute : attributes) {
            if (attribute != null) {
                result.add(attribute.getStrength(), attribute.getDexterity(), attribute.getIntelligence());
            }
        }
        return result;
    }

    /**
     * Add individual values to the current HeroAttribute.
     * 
     * @param strength     individual strength value to add.
     * @param dexterity    individual dexterity value to add.
     * @param intelligence individual intelligence value to add.
     */
    public void add(int strength, int dexterity, int intelligence) {
        this.strength += strength;
        this.dexterity += dexterity;
        this.intelligence += intelligence;
    }

    /**
     * Retrieves the strength attribute.
     * 
     * @return strength attribute.
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Sets the strength attribute.
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Retrieves the dexterity attribute.
     * 
     * @return dexterity attribute.
     */
    public int getDexterity() {
        return dexterity;
    }

    /**
     * Sets the dexterity attribute.
     */
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    /**
     * Retrieves the intelligence attribute.
     * 
     * @return intelligence attribute.
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * Sets the intelligence attribute.
     */
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    /**
     * Generates a detailed string of the HeroAttribute.
     * 
     * @return Detail string of HeroAttribute.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("     Strength: " + this.strength + "\n");
        builder.append("     Dexterity: " + this.dexterity + "\n");
        builder.append("     Intelligence: " + this.intelligence + "\n");

        return builder.toString();
    }
}
