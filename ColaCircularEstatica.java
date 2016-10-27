public class ColaCircularEstatica {
   String [] cola;
   int H,T,numProducto;
   String dato,nombre;
   
   public ColaCircularEstatica(int max, int numProducto){
      this.numProducto = numProducto;
      cola = new String[max];
      H=T = -1;
   }
   
   public boolean ValidaVacio(){
      return (H==-1);//regresa un "true" si esta vacio
   }
   
   public boolean ValidaEspacio() {
      return !((H==0 && T==cola.length-1) || (T+1==H));//regresa un "true" si hay una casilla disponible
   }
   
   public synchronized void Insertar(String num,String nom){
      dato=num;
      nombre=nom;
      if(numProducto>0){
         while(!ValidaEspacio()){
            try
            {
               wait();
            }
            catch(InterruptedException e){}
         }
         if (H== -1)
            H=0;
         else if (T==cola.length-1)
            T=-1;
         T++;
         cola[T] = num;
         Listar(nombre, dato);
         notifyAll();
      }
   }

   public synchronized String Borrar(String nom) {
      String aux;
      nombre=nom;
      while(ValidaVacio()){
         try
         {
            wait();
         }
         catch(InterruptedException e){}
      }
      aux= cola[H];
      if (H==T)
         H=T=-1;
      else if (H==cola.length-1)
         H=0;
      else 
         H++;
      notifyAll();
      return aux;
   }

   public synchronized void Listar(String nombre, String dato){
      int i;
      if (H==-1) {
         try{
            wait();
         }catch(InterruptedException e){}
      }else{
         if( H <= T){
         	System.out.println("La linea " + nombre + " termino el producto " + dato);
         	System.out.println("Cola del almacen: ");
            for(i=H; i<=T; i++)
               System.out.println(cola[i]);
           System.out.println("------------------------------------------------------------");
           notifyAll();
       	}
         else {
         	System.out.println("La linea " + nombre + " termino el producto " + dato);
         	System.out.println("Cola del almacen: ");
            for(i=H; i<cola.length; i++)
               System.out.println(cola[i]);
            for(i=0; i<=T; i++)
               System.out.println(cola[i]);
           System.out.println("------------------------------------------------------------");
           notifyAll();
         }
      }
   }

   public synchronized void Listar(String nombre, String dato, int opcion){
      int i;
      if (H==-1) {
         try{
            wait();
         }catch(InterruptedException e){}
      }else{
         if( H <= T){
            System.out.println("El " + nombre + " empaco el producto " + dato);
            System.out.println("Cola del almacen: ");
            for(i=H; i<=T; i++)
               System.out.println(cola[i]);
           System.out.println("------------------------------------------------------------");
           notifyAll();
         }
         else {
            System.out.println("El " + nombre + " empaco el producto " + dato);
            System.out.println("Cola del almacen: ");
            for(i=H; i<cola.length; i++)
               System.out.println(cola[i]);
            for(i=0; i<=T; i++)
               System.out.println(cola[i]);
           System.out.println("------------------------------------------------------------");
           notifyAll();
         }
      }
   }
}