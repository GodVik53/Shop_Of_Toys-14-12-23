import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShopOfToys {
    private List<Toys> toys;
    private List<Toys> prizeToys;

    public ShopOfToys() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
    }

    public void addToy(int id, String name, int quantity, double weight) {
        Toys toy = new Toys(id, name, quantity, weight);
        toys.add(toy);
    }

    public void setToyWeight(int id, double weight) {
        for (Toys toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public void play() {
        // calculate total weight
        double totalWeight = 0;
        for (Toys toy : toys) {
            totalWeight += toy.getWeight();
        }

        // generate random number
        Random rand = new Random();
        double randomNumber = rand.nextDouble() * totalWeight;

        // find the prize toy
        Toys prizeToy = null;
        for (Toys toy : toys) {
            if (randomNumber < toy.getWeight()) {
                prizeToy = toy;
                break;
            }
            randomNumber -= toy.getWeight();
        }

        // add the prize toy to the list of prize toys
        if (prizeToy != null && prizeToy.getQuantity() > 0) {
            prizeToys.add(prizeToy);

            // decrement the quantity of the prize toy
            prizeToy.setQuantity(prizeToy.getQuantity() - 1);
        }
    }

    public void getPrizeToy() throws IOException {
        if (prizeToys.size() > 0) {
            // remove the first prize toy from the list of prize toys
            Toys prizeToy = prizeToys.remove(0);

            // write the prize toy to a file
            FileWriter writer = new FileWriter("prize_toys.txt", true);
            writer.write(prizeToy.getId() + "," + prizeToy.getName() + "\n");
            writer.close();
        }
    }
}
