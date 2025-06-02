package a_02_heranca_e_polimorfismo;

public class Gato extends Animal{
    // sobrescreve método da clase pai
    @Override
    public void emitirSom() {
        System.out.println("Miau Miau!");
    }
}
