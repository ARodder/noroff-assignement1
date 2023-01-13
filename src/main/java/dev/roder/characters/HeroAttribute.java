package dev.roder.characters;

public class HeroAttribute {
    private int strength;
    private int dexterity;
    private int intelligence;

    public HeroAttribute(int strength, int dexterity, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public HeroAttribute add(HeroAttribute newAttributes){
        return new HeroAttribute(
                this.strength + newAttributes.getStrength(),
                this.dexterity + newAttributes.getDexterity(),
                this.intelligence + newAttributes.getIntelligence());
    }

    public HeroAttribute add(HeroAttribute[] attributes){
        HeroAttribute result = new HeroAttribute(this.strength,this.dexterity,this.intelligence);
        for(HeroAttribute attribute: attributes){
            if(attribute != null){
                result.add(attribute.getStrength(), attribute.getDexterity(), attribute.getIntelligence());
            }
        }
        return result;
    }
    public void add(int strength,int dexterity,int intelligence){
        this.strength += strength;
        this.dexterity += dexterity;
        this.intelligence += intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("     Strength: "+this.strength+"\n");
        builder.append("     Dexterity: "+this.dexterity+"\n");
        builder.append("     Intelligence: "+ this.intelligence+"\n");

        return builder.toString();
    }
}
