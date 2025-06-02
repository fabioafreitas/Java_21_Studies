import java.util.ArrayList;
import java.util.List;

import a_01_encapsulamento.Rectangle;
import a_02_heranca_e_polimorfismo.Animal;
import a_02_heranca_e_polimorfismo.Cabra;
import a_02_heranca_e_polimorfismo.Cachorro;
import a_02_heranca_e_polimorfismo.Gato;
import a_03_generics.GenericLinkedList;
import a_03_generics.GenericNode;

public class App {

    public static void main(String[] args) throws Exception {
        // exercicio01();
        // exercicio02();
        exercicio03();


    }

    private static void exercicio03() {
        GenericNode<String> node4 = null;
        GenericNode<String> node3 = new GenericNode<String>(node4,"Fábio");
        GenericNode<String> node2 = new GenericNode<String>(node3,"Chamo");
        GenericNode<String> node1 = new GenericNode<String>(node2,"Me");
        GenericNode<String> listHead = new GenericNode<String>(node1,"Oi");



    }

    private static void exercicio02() {
        // instanciando lista de animais
        List<Animal> animais = new ArrayList<>();
        animais.add(new Cachorro());
        animais.add(new Gato());
        animais.add(new Cabra());
        for (Animal animal : animais) {
            animal.emitirSom();
        }

        if(animais.isEmpty()) {
            return;
        }

        // forçanco verificação de tipo com base na instância
        System.out.println(
            animais.getFirst() instanceof Cachorro ? "Primeiro animal é um cachorro": "Primeiro animal não é um cachorro"
        );
        System.out.println(
            animais.getLast() instanceof Gato ? "Último animal é um gato": "Último animal não é um gato"
        );
        
    }

    private static void exercicio01() {
        List<Rectangle> rec = new ArrayList<>();

        rec.add(new Rectangle(2,3)); 
        rec.add(new Rectangle(4,4));

        for (Rectangle currRec : rec) {
            System.out.println(String.join(
                "\n",
                "Rectangle Info:",
                "Length = "+currRec.getLength(),
                "Width = "+currRec.getWidth(),
                "Area = "+currRec.getArea(),
                "Perimeter = "+currRec.getPerimeter(),
                "Square? " + (currRec.isSquare() ? "Yes" : "No")
            )+"\n");
        }
    }
}
