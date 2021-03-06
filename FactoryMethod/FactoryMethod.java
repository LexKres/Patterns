// pattern: 01
// pattern type: порождающий паттерн
// pattern name: Фабричный метод (Factory method)
// pattern shortcat: FM


//  Швец, стр. 69
/*
  Фабричный метод - порождающий паттерн проектрирования, который 
определяет общий интерфейс для создания объектов в суперклассе,
позволяя своим изменять тип создаваемых объектов.
 */

//  Швец, стр. 71
/*
  Фабрисный метод создает объекты не напрямую, используя оператор new,
а через вызов "фабричного метода", который уже их сделает через new.
  
  стр 78
  Применимость: когда заранее неизвестны типы и зависимости объектов, с
которыми должен работать ваш код.

 */
package FactoryMethod;

public class FactoryMethod {
    public static void main (String [] args) {
	System.out.println("Test output");

	// смысл в том, что переменная имеет тип абстрактоного класса, в котором
	// обозначен фабричный метод
	CreatorA cpa = new ConcreteCreator_a();
	cpa.createProductFM().doStuff();
    }
			    
}


//-----------------------------------------------------------------------


interface ProductI {
    void doStuff();
}

class ConcreteProduct_a implements ProductI {
    public void doStuff() {
	System.out.println("ConcreteProduct_a doStuff()");
    }
}

class ConcreteProduct_b implements ProductI {
    public void doStuff() {
	System.out.println("ConcreteProduct_b doStuff()");
    }
}
    

// Необязательно, но фабричный метод часто делают абстрактным
// Чан стр. 158
// Абстрактные методы могут существовать только в абстрактных классах
abstract class CreatorA {

    ProductI someProduct;

    // это наш фабричный метод
    public abstract ProductI createProductFM();


    public void someOperation(){
	someProduct.doStuff();
    }

}


class ConcreteCreator_a extends CreatorA {
    public ProductI createProductFM() {
	return new ConcreteProduct_a();
    }
}


class ConcreteCreator_b extends CreatorA {
    public ProductI createProductFM() {
	return new ConcreteProduct_b();
    }
}
    
