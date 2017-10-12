package antsrl.guerra;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Hello world!
 *
 */


public class App 
{
	public static void main( String[] args )
    {
    	  ApplicationContext context =
    			  new ClassPathXmlApplicationContext("oggetti.xml");

//    	  // sto prendendo l'oggetto di tipo HelloWorld con id=rocco
//    	  // devo castarlo al tipo corretto poiché getBean() restituisce un Object
//         HelloWorld a = (HelloWorld) context.getBean("rocco");
//         HelloWorld b = (HelloWorld) context.getBean("rocco");
//         System.out.println(a.getMessage());
//         System.out.println(b.getMessage());
    	  
    	  CarroArmato car = (CarroArmato) context.getBean("carroArmato");
    	  System.out.println(car.getSoldato().getNome());
         
         											
    }
}
