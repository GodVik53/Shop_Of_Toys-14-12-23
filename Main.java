public class Main {
    public static void main(String[] args) {
        ShopOfToys store = new ShopOfToys();

        // добавляем игрушки: 
        store.addToy(1, "Toy 1", 50, 10);
        store.addToy(2, "Toy 2", 6, 36);
        store.addToy(3, "Toy 3", 18, 28);

        // выбираем вес игрушки
        store.setToyWeight(2, 30);

        // играем:
        store.play();

        // получаем цену на игрушку:
        try {
            store.getPrizeToy();
        }
         
    }
}
