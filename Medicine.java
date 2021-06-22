/**
* A class of Medicine for the Prescriptions
* @author Atakan Altın
*/
public class Medicine {
    private String name;
    private int cost;
    private int quantiy;
    private static int staticId = 10000;
    private int id;

    public Medicine(String name, int cost, int quantiy){
        this.name=name;
        this.cost=cost;
        this.quantiy=quantiy;
        this.id=staticId;
        staticId++;
    }

    @Override
    public String toString() {
        return String.format("\nName: %s\nMedicine ID: %d\nCost: %d\nQuantity: %d\n",name,id,cost,quantiy);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return this.quantiy;
    }

    public void setQuantity(int quantiy) {
        this.quantiy = quantiy;
    }

    public int getId() {
        return this.id;
    }
}
