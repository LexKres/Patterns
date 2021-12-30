package Tests;

public class TestInheritance {
    public static void main (String [] args) {
        Son son = new Dother();
    }
}

abstract class King {
    abstract public void sayWhoIAm ();
}


class Son extends King {
    @Override
    public void sayWhoIAm() {
        System.out.println("I am Son");
    }
}

class Dother extends King {
    @Override
    public void sayWhoIAm() {
        System.out.println("I am Dother");
    }
}