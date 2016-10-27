import java.util.Scanner;
public class Examen2{
	public static void main(String[] args) {
		Productor a,b,c,d;
		ColaCircularEstatica cola;
		Consumidor c1, c2;
		int numerproductos, tamanocola, tamanocamion, i;
		Scanner s1 = new Scanner(System.in);	
		System.out.println("Ingresa el tamano de la cola: ");
		tamanocola = s1.nextInt();
		System.out.println("Ingresa la capacidad de los camiones: ");
		tamanocamion = s1.nextInt();
		do{
			System.out.println("Ingresa el numero de productos: ");
			numerproductos = s1.nextInt();
		}
		while(numerproductos < 2*tamanocamion);
		System.out.println("------------------------------------------------------------");
		cola = new ColaCircularEstatica(tamanocola, numerproductos);
		
		a = new Productor(cola, "A");
		b = new Productor(cola, "B");
		c = new Productor(cola, "C");
		d = new Productor(cola, "D");
		c1 = new Consumidor(cola, "camion 1", tamanocamion);
		c2 = new Consumidor(cola, "camion 2", tamanocamion);
		a.start();
		b.start();
		c.start();
		d.start();
		c1.start();
		c2.start();
	}
}