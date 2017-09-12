package facade;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) 
	{
		IDatabase db = new Database("jdbc:mysql://localhost/store?user=root&password=root");
		
	
		HashMap<String,String> cpu
		= db.row("select cpu.id, product.type, cores, clockspeed, cost " +
				 " from product, cpu where product.id = cpu.id " +
				 " and cpu.id = 1");
		
		String vistaCPU="<b>[type]</b><br>[cores]-[clockspeed]<br>[cost] &euro;";
		for(String chiave:cpu.keySet())
			vistaCPU = vistaCPU.replace("["+chiave+"]",cpu.get(chiave));
		System.out.println(vistaCPU);
		

		System.out.println("---------------------------------");
		
		List<HashMap<String,String>> listacpu
		= db.rows("select cpu.id, product.type, cores, clockspeed, cost " +
				 " from product, cpu where product.id = cpu.id ");
		
		String vistaRighe = "";
		for(HashMap<String,String>riga:listacpu)
		{
			String vistaRiga="<b>[type]</b><br>[cores]-[clockspeed]<br>[cost] &euro;";
			for(String chiave:riga.keySet())
				 vistaRiga = vistaRiga.replace("["+chiave+"]",riga.get(chiave));
			vistaRighe+=vistaRiga+"\n";	
		}
		
		System.out.println(vistaRighe);
		
		
	}
}
