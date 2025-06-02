package a_02_heranca_e_polimorfismo;


// animal é a implementação 
public abstract class Animal implements IAnimal {

    // método sobrescrito, devido a exigência do template definido na interface IAnimal
    @Override
    public void emitirSom() {
        System.out.println("Som genérico!");
    }
    
}
