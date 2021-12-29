// pattern: 04
// pattern type: порождающий паттерн
// pattern name: Прототип (Prototype)
// pattern shortcat: PT

package Prototype;

public class Prototype {
    public static void main (String [] args) {

        S1 s1 = new S1(null);
	S1 s1copy = new S1(s1);

        S2 s2 = new S2(null);
	S2 s2copy = new S2(s2);

	System.out.println("s1: " + s1.getdataField1());
	System.out.println("s1: " + s1.getnumberOfS1());

	System.out.println("s1copy: " + s1copy.getdataField1());
	System.out.println("s1copy: " + s1copy.getnumberOfS1());
	
        System.out.println("s2: " + s2.getdataField2());
	System.out.println("s2: " + s2.getnumberOfS2());

	System.out.println("s2copy: " + s2copy.getdataField2());
	System.out.println("s2copy: " + s2copy.getnumberOfS2());


	S11 s11 = new S11(null);
	S11 s11copy = new S11(s11);

	System.out.println("s11: " + s11.getdataField1());
	System.out.println("s11: " + s11.getnumberOfS1());
	System.out.println("s11: " + s11.getsecondValue());

        System.out.println("s11copy: " + s11copy.getdataField1());
	System.out.println("s11copy: " + s11copy.getnumberOfS1());
	System.out.println("s11copy: " + s11copy.getsecondValue());

        
        System.out.println("--------------------- now work with registry --------------");
	
        PrototypeRegistry protRegistry = new PrototypeRegistry();

	protRegistry.addItem(s1);
	protRegistry.addItem(s2);
	protRegistry.addItem(s1copy);
	protRegistry.addItem(s2copy);
	protRegistry.addItem(s11);

	//for(int j=0; j<protRegistry.items.length; j++) {
	//    protRegistry[j]
	

    }
}


// Прототип - позволяет копировать объекты, не вдаваясь в подробности их реализации

// Интерфейс прототипов описывает операции копирования. В большинстве случаев - это
// единственный метод clone.
// Конкретный прототип реализует операцию копирования самого себя.
// Клиент создает копию объекта, обращаясь у нему через общий интерфейс прототипов.

// Хранилище прототипов облегчают доступ к часто используемым прототипам, храня
// предсозданный набор эталонных, готовых к копированию объектов. Простейшее хранилище
// может быть постоено с помощью хеш-таблицы вида "имя прототипа - прототип".


abstract class APrototype {
    abstract public APrototype clone ();

}


class S1 extends APrototype {
    String dataField1="S1 dataField";
    int numberOfS1 = 1;

    
    public S1() {};
    
    public S1(S1 source) {
	if (source != null) {
	   this.dataField1 = source.dataField1;
	   this.numberOfS1 = source.numberOfS1 + 1;
        }
    }

    public S1 clone () {
	return new S1(this);
    }

    String getdataField1() { return dataField1; }

    int getnumberOfS1() {return numberOfS1; }
}


class S2 extends APrototype {
    String anotherData2 = "S2 anotherData2";
    int anotherNumber2 = 0;


    public S2() {};
    
    public S2(S2 source) {
	if (source != null) {
	   this.anotherData2 = source.anotherData2;
	   this.anotherNumber2 = source.anotherNumber2+10;
        }
    }
    
    public S2 clone() {
	return new S2(this);
    }

    String getdataField2() { return anotherData2; }

    int getnumberOfS2() {return anotherNumber2; }

}


// наследники от первых двух классов

class S11 extends S1 {
    int secondValue = 0;

    public S11 (S11 source) {
        super((S1) source);
	if (source != null) {
	    this.secondValue = source.secondValue + 100;
	}
    }

    public S11 clone() {
	return new S11(this);
    }

    int getsecondValue() { return secondValue; }

}    


// реестр объектов - т.е. хранилище прототипов

class PrototypeRegistry {
    public APrototype[] items;
    private int currentItemId;
    private int maxRegSize=5;

    public PrototypeRegistry () {
        items = new APrototype[maxRegSize]; 
        currentItemId = -1;
    }

    public APrototype getById(int id) {
	return items[id];
    }

    public void addItem (APrototype newItem) {
	currentItemId += 1;
	if (currentItemId > maxRegSize-1)
	    currentItemId = maxRegSize-1;
	else
	    items[currentItemId] = newItem;
	;

    }

}


	

    
