package cafe.jjdev.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaController {
	//private PizzaDao pizzaDao;
	
	@RequestMapping(value="/pizzaChart", method= RequestMethod.GET)
	public ArrayList<Pizza> pizzaChart() {
		//ArrayList<Pizza> list = pizzadDao.selectPizzaList();
		ArrayList<Pizza> list = new ArrayList<Pizza>();
		list.add(new Pizza("Mushromms", 1));
		list.add(new Pizza("Bludecheese", 2));
		list.add(new Pizza("Onions", 5));
		list.add(new Pizza("Pepperoni", 3));
		return list;
	}
	
	class Pizza {
		private String topping;
		private int slices;
		
		public Pizza(String topping, int slices) {
			super();
			this.topping = topping;
			this.slices = slices;
		}
		public String getTopping() {
			return topping;
		}
		public void setTopping(String topping) {
			this.topping = topping;
		}
		public int getSlices() {
			return slices;
		}
		public void setSlices(int slices) {
			this.slices = slices;
		}
		
	}
}
