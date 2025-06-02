package a_02_heranca_e_polimorfismo;

public class Cabra extends Animal{
    // sobrescreve método da clase pai
    @Override
    public void emitirSom() {
        System.out.println("Méééé!");
    }
}
