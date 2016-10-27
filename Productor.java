public class Productor extends Thread{
	public ColaCircularEstatica cola;
	public String nombre,dato;
	int i = 0;
	
	public Productor(ColaCircularEstatica cola, String nombre){
		this.cola = cola;
		this.nombre = nombre;
	}

	public void run(){	
		do{
			System.out.println("A la cola le falta producir	 "+cola.numProducto+" productos.");
			try{	
				int msegs = (int)((Math.random()*3000)+2000);
				sleep(msegs);
			}catch(InterruptedException e){}
			dato=nombre+Integer.toString(i);
			cola.Insertar(dato,nombre);
			cola.numProducto--;
			//cola.Listar(nombre, dato);
			i++;
		}while(cola.numProducto > 2);
		System.out.println("Ya no faltan productos...");
		System.out.println("------------------------------------------------------------");
	}
}