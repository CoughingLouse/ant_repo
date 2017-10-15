/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ant.SpringMVC.jsp;


import ant.SpringMVC.resources.*;

import java.util.Map;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class AutoController 
{
	
	@RequestMapping("/auto") 			//mappo il metodo all'indirizzo
	public String auto(Map<String, Object> model) 	//il model diventa il parametro
	{
		ArrayList<Auto> autos = new ArrayList<Auto>();
		autos.add(new Auto("Punto", 1300));
		autos.add(new Auto("Panda", 1000));
		
		//ho messo nel model le persone, nei dati che andrò a graficare
		model.put("lista", autos);
		return "autos";	//"persone" è la vista, lo trovo nella cartella "jsp"
		//jsp=java server pages è sia vista che template
	}
	
	@RequestMapping("/auto/{id}") //mapping con parametro
	public String auto
	(
			@PathVariable("id") int id,
			Map<String, Object> model
	) 
	{
		ArrayList<Auto> auto = new ArrayList<Auto>();
		auto.add(new Auto("Fiat", 1300));
		auto.add(new Auto("Panda", 1000));
		
		
		model.put("auto", auto.get(id)); //"auto" = variabile nel model di tipo persona
		return "auto";
	}

	
}
