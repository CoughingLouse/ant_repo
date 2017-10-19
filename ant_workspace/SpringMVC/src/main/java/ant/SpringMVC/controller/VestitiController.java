package ant.SpringMVC.controller;


import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ant.SpringMVC.res.*;

@Controller
public class VestitiController 
{
	//QUi creo un nuovo oggetto Dao che sarà un Dao Prototype e quindi per quanti dao
	//creerò sarà sempre questo a essere aggiornato
	@Autowired
	DAO dao;
	private JsonGenerator jsonGenerator = null;
	private ObjectMapper objectMapper = null;

	////// INDUMENTI //////
	@RequestMapping(value="/indumenti", method=RequestMethod.GET)
	public String indumenti(Map<String,Object> model)
	{
		model.put("scarpe", dao.scarpe);
		model.put("pantaloni", dao.pantaloni);
		model.put("felpe", dao.felpe);
		return "indumenti";
	}

	////// SCARPE //////
	@RequestMapping(value="/scarpe", method=RequestMethod.GET)
	public String scarpe(Map<String,Object> model)
	{
		model.put("scarpe", dao.scarpe);
		return "scarpe";
	}

	@RequestMapping(value="/scarpa/{id}", method=RequestMethod.GET)
	public String scarpa(@PathVariable ("id") int id, Map<String,Object> model)
	{
		model.put("scarpa", dao.scarpe.get(id));
		return "scarpa"; // qui corrisponde alla vista, tipicamente nella cartella "jsp" o "views"
	}

	// TODO: /json/scarpe
	@RequestMapping(value="/json/scarpe", method=RequestMethod.GET)
	public String scarpejson(Map<String,Object> model)
	{
		model.put("scarpe", dao.scarpe);
		return "scarpejson";
	}

	//////// PANTALONI /////////
	@RequestMapping(value="/pantaloni", method=RequestMethod.GET)
	public String pantaloni(Map<String,Object> model)
	{
		model.put("pantaloni", dao.pantaloni);
		return "pantaloni";
	}

	@RequestMapping(value="/pantaloni/{id}", method=RequestMethod.GET)
	public String pantaloni(@PathVariable ("id") int id, Map<String,Object> model)
	{
		model.put("pantaloni", dao.pantaloni.get(id));
		return "pantaloni";
	}

	// TODO: /json/pantaloni
	@RequestMapping(value="/json/pantaloni", method=RequestMethod.GET)
	public String pantalonijson(Map<String,Object> model)
	{
		model.put("pantaloni", dao.pantaloni);
		return "pantalonijson";
	}

	/////////// FELPE ///////////
	@RequestMapping(value="/felpe", method=RequestMethod.GET)
	public String felpe(Map<String,Object> model)
	{
		model.put("felpe", dao.felpe);
		return "felpe";
	}

	@RequestMapping(value="/felpe/{id}", method=RequestMethod.GET)
	public String felpe(@PathVariable ("id") int id, Map<String,Object> model)
	{
		model.put("felpe", dao.felpe.get(id));
		return "felpe";
	}

	// TODO: /json/felpe
	@RequestMapping(value="/json/felpe", method=RequestMethod.GET)
	public String felpejson(Map<String,Object> model)
	{
		String ris = "";
//		Indumenti[] ind = 
		for(Indumento f:dao.felpe)
		{
			ris += f.toJSON();
		}
//		ris += "]";
		
		System.out.println("felpejson: " + ris);
		model.put("felpejson", ris);
		return "felpejson";
	}

	// FIXME: decidere l'implementazione per usare sto metodo scassamento...
//	@RequestMapping(value="/json/felpe", method=RequestMethod.GET)
//	public String felpejson(Map<String,Object> model)
//	{
//		objectMapper = new ObjectMapper();
//		Indumento bean = new Felpa();
//		try
//		{
//			jsonGenerator = objectMapper.getJsonFactory()
//					.createJsonGenerator(System.out, JsonEncoding.UTF8);
//			jsonGenerator.writeObject(bean);
//			String json = objectMapper.writeValueAsString(bean);
////			objectMapper.writeValue(System.out, bean);
//			model.put("felpejson", json);
//		}
//		catch (IOException e){}
//		
//		return "felpejson";
//	}



	/*
	@RequestMapping(value ="/gioco/casa/{developer}", method=RequestMethod.GET)
	public String giochi1
	(@PathVariable ("developer") String developer, Map<String,Object> model)
	{
		ArrayList<Gioco> listagiochi = new ArrayList<Gioco>();

		for(Gioco g : dao.games)
		{
			if(g.getDeveloper().equalsIgnoreCase(developer))
			{
				listagiochi.add(g);
			}
		}
		model.put("listone", listagiochi);
		System.out.println(listagiochi.get(0));
		return "gioco";	//"persone" è la vista, lo trovo nella cartella "jsp"
		//jsp=java server pages è sia vista che template
	}

	@RequestMapping(value ="/gioco/anno/{year}", method=RequestMethod.GET)
	public String giochi1
	(@PathVariable ("year") int year, Map<String,Object> model)
	{
		ArrayList<Gioco> listagiochi = new ArrayList<Gioco>();

		for(Gioco g : dao.games)
		{
			if(g.getAnno() == year)
			{
				listagiochi.add(g);
			}
		}
		model.put("listone", listagiochi);
		System.out.println(listagiochi.get(0));
		return "gioco";//"persone" è la vista, lo trovo nella cartella "jsp"
		//jsp=java server pages è sia vista che template
	}

	@RequestMapping(value ="/gioco/listone", method=RequestMethod.GET)
	public String giochi2(Map<String,Object> model)
	{
		model.put("listone", dao.games);
		System.out.println(dao.games.size() + "OOOOOOOOOOOOOOOOOOOOOOOO");
		return "listone";
	}

	// TODO: aggiungi vestiario
    @RequestMapping(value = "/gioco/addGame", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("addGame", "gioco", new Gioco());
    }

    @RequestMapping(value = "/addGame", method = RequestMethod.POST)
    public String submit(@ModelAttribute("gioco") Gioco gioco, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }

        if(dao.newGame(gioco))
        		model.put("listone", dao.games);
        else
        		model.put("listone", dao.games);
        //metodo che salva nel db gioco
        //model.addAttribute("titolo", gioco.getNome());
        //model.addAttribute("anno", gioco.getAnno());
       // model.addAttribute("developer", gioco.developer.nome);

        return "listone";
    }
	 */
}


