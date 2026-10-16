package solid.i;

interface IAnimal{
    void fly();
    void run();
    void swim();
    void jump();
}

interface Flyable{
    void fly();
}

interface Runable{
    void run();
}

interface Swimmable{
    void swim();
}

interface Jumpable{
    void jump();
}

public class interfaceSegregationDemo {
    public static void main(String[] args) {
        // Interface segregation
        // chia nhỏ một interface lớn thành nhiều interface
        // nhỏ với từng mục đích cụ thể
    }
}
