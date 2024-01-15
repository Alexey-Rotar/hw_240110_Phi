// 1. Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
// 2. Вилки лежат на столе между каждой парой ближайших философов.
// 3. Каждый философ может либо есть, либо размышлять.
// 4. Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
// 5. Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
// 6. Можно брать только две вилки одновременно
// Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза

public class Main {
    public static void main(String[] args) {

        int EAT_COUNT = 3; // кол-во приемов пищи

        Fork fork1 = new Fork("1");
        Fork fork2 = new Fork("2");
        Fork fork3 = new Fork("3");
        Fork fork4 = new Fork("4");
        Fork fork5 = new Fork("5");

        Pair pair = new Pair();

        Philosopher ph1 = new Philosopher("Phi_1", pair, fork1, fork2, EAT_COUNT);
        Philosopher ph2 = new Philosopher("Phi_2", pair, fork2, fork3, EAT_COUNT);
        Philosopher ph3 = new Philosopher("Phi_3", pair, fork3, fork4, EAT_COUNT);
        Philosopher ph4 = new Philosopher("Phi_4", pair, fork4, fork5, EAT_COUNT);
        Philosopher ph5 = new Philosopher("Phi_5", pair, fork5, fork1, EAT_COUNT);

        ph1.start();
        ph2.start();
        ph3.start();
        ph4.start();
        ph5.start();

    }
}