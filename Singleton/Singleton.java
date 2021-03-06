// pattern: 05
// pattern name: Одиночка (Singleton)
// pattern type: порождающий
// pattern shortcat: ST
		       
// Гарантирует, что у класса есть только один экзеспляр, и предоставляет к нему 
// глобальную точку доступа.


package Singleton;


public class Singleton {
    public static void main (String [] args) {

	ASingleton asingleton = ASingleton.getInstance();
	
    }
}


class ASingleton {
    private static ASingleton instance;
    
    private ASingleton () {};
    
    public static ASingleton getInstance() {
	if (instance == null) {
	    // Внимание, здесь понадобиться синзронизация потоков, если вы
	    // работаете в многопоточной среде.
	    instance = new ASingleton();
	}
	return instance;
    }
}


