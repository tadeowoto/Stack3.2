

public class Verificador {
    
    private char[] prueba1 = {'{','[','(','<','}',']',')','>'};
    private char[] prueba2 = {'{','[','(','a','[','b',')','*','c',']','-','(','d','+','e',')','}'};
    private Pila p1 = new Pila(prueba2,17);
    private char lpm[] = {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'};
    private Pila p2 = new Pila(lpm,17);
   
//Verificación de equilibrio de paréntesis
//Diseña un programa que tome una cadena de texto que puede contener
//varios tipos de paréntesis, incluyendo (), {}, [], y <> y determine si los
//paréntesis están equilibrados en la cadena. Es decir, cada paréntesis de
//apertura tiene su par correspondiente de cierre y están correctamente
//anidados. Utiliza una pila para realizar la verificación. Por ejemplo, la
//cadena "{[(a+b)*c]-(d+e)}" debería ser considerada como equilibrada,
//mientras que "[{()}]" también lo es, pero "[(])" no lo es.
    
    public boolean esApertura(char x){
        
        if(x=='{'||x=='['||x=='('||x=='<'){
           return true;
        }
        return false;
   }
    
    public boolean esCierre(char x) {
        if (x == '}' || x == ']' || x == ')' || x == '>') {
            return true;
        }
        return false;
    }
    
    public boolean esContrario(char x, char i){
        
        if ((x=='}' && i=='{') || (x==']' && i=='[') || (x==')' && i=='(') || (x=='>' && i=='<')) {
            return true;
        }
        
        return false;
        
    }
    
    public void pasaje(){
    
       
        
        while (!p1.pilaVacia()) {
            
            if (esApertura(p1.verElemento())) {
                p2.push(p1.verElemento());
                p1.pop();
            }else if(esCierre(p1.verElemento())){
                if (esContrario(p1.verElemento(),p2.verElemento())) {
                    p2.pop();
                    p1.pop();
                }else{
                    System.out.println("No hay coincidencia mi estimados y estimadas");
                    return;
                }
            }else{
                p1.pop();
            }
            
        }
        
         if(p2.pilaVacia()){
             System.out.println("Esta equilobrado");
        }else{
             System.out.println("No esta equilibrado");
         }
        
    }

}
