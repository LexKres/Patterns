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

	System.out.println(s1.getdataField1());
	System.out.println(s1.getnumberOfS1());

	System.out.println(s1copy.getdataField1());
	System.out.println(s1copy.getnumberOfS1());
	
	System.out.println(s2.getdataField2());
	System.out.println(s2.getnumberOfS2());

	System.out.println(s2copy.getdataField2());
	System.out.println(s2copy.getnumberOfS2());
	
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

    S1 (S1 source) {
	if (source != null) {
	   this.dataField1 = source.dataField1;
	   this.numberOfS1 = source.numberOfS1 + 1;
        }
    }

    public S1 clone () {
	return new S1 (this);
    }

    String getdataField1() { return dataField1; }

    int getnumberOfS1() {return numberOfS1; }
}


class S2 extends APrototype {
    String anotherData2 = "S2 anotherData2";
    int anotherNumber2 = 0;
    
    S2 (S2 source) {
	if (source != null) {
	   this.anotherData2 = source.anotherData2;
	   this.anotherNumber2 = source.anotherNumber2+10;
        }
    }
    
    public S2 clone() {
	return new S2 (this);
    }

    String getdataField2() { return anotherData2; }

    int getnumberOfS2() {return anotherNumber2; }


}


    