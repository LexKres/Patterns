// pattern: 03
// pattern name: Строитель (Builder)
// pattern type: порождающий
// pattern shortcat: BD
		       
// Позваляет создавать сложные объекты прошагово.
// Дает возможность использовать один и тот же код строительства для получения
// разных представлений объектов.

package Builder;


public class Builder {
    public static void main (String [] args) {
	System.out.println("Pattern Builder");

    // теперь пишем клиентский код, который всем этим пользуется

    // создаем строителей
	ClassOfI_Builder1 builder1 = new ClassOfI_Builder1();
	ClassOfI_Builder2 builder2 = new ClassOfI_Builder2();

    // создаем директора строитеоьства
	Director director = new Director();

	
	// Строим объект по шагаво, получая в конце готовый объект
	director.method_P(builder1);
	director.method_W();  // реализуем логику строительства
	Product1 my_product1 = builder1.method_N(); // а теперь получаем построенный объект
	
    	// Строим объект по шагаво, получая в конце готовый объект
	director.method_P(builder2);
	director.method_W();  // реализуем логику строительства
	Product2 my_product2 = builder2.method_N(); // а теперь получаем построенный объект
    }
}


interface BuilderI {
    void method_P();    // создать новый отстраиваемый объект
    void method_T1();   // этапы строительства
    void method_T2();
    void method_T3();
}


class Director {
    private BuilderI builder;
    
    void method_P(BuilderI pi) {
	builder = pi;
    }

    void method_W() {
	builder.method_P();  // создать новый строящийся объект
	builder.method_T1(); // выполнить 1й этап строительства
	builder.method_T2(); // выполнить 2й этап строительства
	builder.method_T3(); // выполнить 3й этап строительства
    }

}


// классы-стоящиеся объекты
// они не являются родственниками

class Product1 {
    Product1(){
	System.out.println("Строящийся объект №1 создан");
    }
}


class Product2 {
    Product2() {
	System.out.println("А это создан строящийся объект №2");
    }
}


// Теперь пишем строителей для каждого объекта свой


class ClassOfI_Builder1 implements BuilderI {
    Product1 f;

    public void method_P() {
	f = new Product1();
    }

    public void method_T1() {
	System.out.println("1й этап строительства объекта: Product1");
    }

    public void method_T2() {
	System.out.println("2й этап строительства объекта: Product1");
    }

    public void method_T3() {
	System.out.println("3й этап строительства объекта: Product1");
    }

    Product1 method_N() {
	// вернуть созданный объект заказчику
	System.out.println("Возвращаем созданный Product1");
	return this.f;
    }

}
       
    
class ClassOfI_Builder2 implements BuilderI {
    Product2 f;

    public void method_P() {
	f = new Product2();
    }

    public void method_T1() {
	System.out.println("1й этап строительства объекта: Product1");
    }

    public void method_T2() {
	System.out.println("2й этап строительства объекта: Product1");
    }

    public void method_T3() {
	System.out.println("3й этап строительства объекта: Product1");
    }

    Product2 method_N() {
	// вернуть созданный объект заказчику
	System.out.println("Возвращаем созданный Product2");
	return this.f;
    }
}



    
