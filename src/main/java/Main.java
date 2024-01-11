// 1. Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
// 2. Вилки лежат на столе между каждой парой ближайших философов.
// 3. Каждый философ может либо есть, либо размышлять.
// 4. Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
// 5. Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
// 6. Можно брать только две вилки одновременно
// Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза

public class Main {
    public static void main(String[] args) {
        Fork fork1 = new Fork("1");
        Fork fork2 = new Fork("2");
        Fork fork3 = new Fork("3");
        Fork fork4 = new Fork("4");
        Fork fork5 = new Fork("5");

        Philosopher ph1 = new Philosopher("Phi_1", fork1, fork2);
        Philosopher ph2 = new Philosopher("Phi_2", fork2, fork3);
        Philosopher ph3 = new Philosopher("Phi_3", fork3, fork4);
        Philosopher ph4 = new Philosopher("Phi_4", fork4, fork5);
        Philosopher ph5 = new Philosopher("Phi_5", fork5, fork1);

        ph1.start();
        ph2.start();
        ph3.start();
        ph4.start();
        ph5.start();

    }
}

