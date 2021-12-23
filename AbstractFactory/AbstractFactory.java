// pattern: 02
// pattern name: Абстрактная фабрика (Abstract factory)
// pattern type: порождающий
// pattern shortcat: AF

		       
		       
package AbstractFactory;


// Швец стр 85
/* Абстрактная фабрика - порождающий паттерн проектрирования, который позволяет
   создавать семейства связанных объектов, не привязываясь к конкретным классам
   создваываемых объектов.
 */
   
public class AbstractFactory {
    public static void main (String [] args) {
	System.out.println("Pattern: Abstract Factory");

	// создаем объекты
	
	ClassOfA classOfA = new ClassOfA();

	ClassD_Client classD_Client = new ClassD_Client();

	ClassOfI classOfI = new ClassOfI();

	// указывавем , чего мы конкретно хотим, т.к. логику свою уже описали в
	// ClassOfA.method_T
	// а связь на него мы установили в
	// ClassOfI.method_Na
	// теперь устанавливаем связь межлу ними у объекта-клиента
	
	classD_Client.method_Pi (classOfI);
	
	// и теперь вызываем метод клиента, этот код не будет как бы не меняется
	// в этом и была цель шаблона проектрирования

	classD_Client.method_W();

	// теперь для реализаци какой-то другой прикладной логики нам нужно будет
	// сделать новый класс-наследник от ClassOfA
	// описать новую логику в его методе method_T
	// сделать новый класс-наследник от ClassOfI
	// и переписать в нем метод method_Na чтобы он возвращал созданный объект ClassOfA
    }
}

//----------------------------------------------------------------

abstract class AbstractClassA {
    public abstract void method_T();
	// это трудяга - основаная логика прикладной программы
}


interface AbstractFactoryI {
    AbstractClassA method_Na();
}


class ClassD_Client {
    //

    AbstractFactoryI fi;

    void method_Pi (AbstractFactoryI pi) {
	fi = pi;
    }
     
    void method_W () {
	// метод, неизменяемость
	AbstractClassA fa = fi.method_Na();

	fa.method_T();
    }
}


class ClassOfA extends AbstractClassA {
    // класс - реализатор прикладной логики 
    public void method_T() {
	System.out.println ("Прикладная логика");
    }
}


class ClassOfI implements AbstractFactoryI {
    //
    public AbstractClassA method_Na () {
	return new ClassOfA();
	    }
}


    
