package facade;
import java.util.HashMap;

public class CPU 
{
	int id;
	String description;
	String type;
	
	public static CPU fromMap(HashMap<String,String> dato)
	{
		CPU cpu = new CPU();
		cpu.id = Integer.parseInt(dato.get("id"));
		cpu.description = dato.get("description");
		cpu.type = dato.get("type");
		return cpu;
	}
	
	public int prezzo()
	{
		return
			type.equals("I7") ? 100: 50;
	}

	@Override
	public String toString() {
		return "CPU [id=" + id + ", description=" + description + ", type="
				+ type + " Prezzo: "+this.prezzo()+"]";
	}
	
	
	
}
