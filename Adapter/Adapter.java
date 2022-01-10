// pattern: 06
// pattern name: Адаптер (Adapter)
// pattern type: структурный
// pattern shortcat: AD

// Позволяет объектам с несовместимыми интерфейсами работать вместе

package Adapter;


public class Adapter {
    public static void main (String [] args) {

	Service service = new Service();
	SAdapter sadapter = new SAdapter(service);

	Client client = new Client(sadapter);
	System.out.println(client.ClientMethod());
    }
}


// SH: для простоты я тип парамтера везде выбрал String
// На самом деле тип параметра в Service.method_T_service по идее должен
// отличаться от типа параметра в IforClient.method_T


// описывает протокол, через который клиент может работать с другими классами
interface IforClient {
    String method_T(String data);
}


// какой-то полезный класс, обычно сторонний.
// Клиент не может использовать этот класс напрямую, т.к. сервис имеет
// непонятный ему интерфейс.
class Service {
    String method_T_service(String specialData) {
	return "We are using Service for: " + specialData;
    }
}


// адаптер может одновременно работать и с клиентом, и с сервисом
class SAdapter implements IforClient {
    Service service;

    SAdapter (Service service) {
	this.service = service;
    }
    
    String convertToServiceFormat (String incomeData) {
	return incomeData + "_converted";
    }
    
    public String method_T (String data) {
	String specialData = convertToServiceFormat(data);
	return service.method_T_service(specialData);
    }
    
}


// клиентский класс, который содержит существенную бизнес-логику программы
class Client {
    IforClient adapter;

    String ClientMethod() {
	return adapter.method_T("Client call adapter ...");
    }

    Client(IforClient adapter) {
	this.adapter = adapter;
    }
}
