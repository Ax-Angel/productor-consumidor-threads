public class Consumidor extends Thread{
	public ColaCircularEstatica cola;
	public String nombre,dato;
	public int tamano;
	
	public Consumidor(ColaCircularEstatica cola, String nombre, int tamano){
		this.cola = cola;
		this.nombre = nombre;
		this.tamano = tamano;
	}

	public void run(){
		/*try{	
				sleep(1000);
		}catch(InterruptedException e){}*/
		int i;
		do{
			System.out.println("Al "+nombre+" le queda capacidad de: "+tamano);
			try{	
				sleep(3000);
			}catch(InterruptedException e){}
			if(cola.ValidaVacio()){
				System.out.println("Cola de almacen vacia...");
				System.out.println("------------------------------------------------------------");
			}else{
				dato=cola.Borrar(nombre);
				tamano--;
				if (cola.H==-1) {
					System.out.println("El " + nombre + " empaco el producto " + dato);
         			System.out.println("Cola del almacen: ");
			        System.out.println("Cola vacia");
        			System.out.println("------------------------------------------------------------");
				}
				else
					cola.Listar(nombre, dato, 0);
			}
		}while(tamano>0);

		System.out.println("El "+ nombre + " ya se lleno...");
		System.out.println("------------------------------------------------------------");
	}
}