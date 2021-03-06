//Alan Smith
package model;

import java.util.ArrayList;
import java.util.Comparator;

public class Order implements Comparator<Order> {
    
    int[] Drow;
    int[] dcol;
    ArrayList<Integer> items;
    ArrayList<Warehouse> availWarehouse;
    int[] droneCord;
    int[] wareHouseCord;

    public Order(int[] Drow, int[] dcol, ArrayList<String> itemsa) {
        this.Drow = Drow;
        this.dcol = dcol;
        for(String item: itemsa){
            items.add(Integer.parseInt(item));
        }
    }
    
    

    public int[] getDelCord() {
        return delCord;
    }


    public void setDelCord(int[] delCord) {
        this.delCord = delCord;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }
    
    public int compare(Order a, Order b){
    	int scorea = a.getQuickestRoute() + a.getItems().size();
    	int scoreb = b.getQuickestRoute() + b.getItems().size();
    	
    	return scorea - scoreb;
    }
    
    public void setDroneCord(int[] dCord){
    	this.droneCord = dCord;
    }
    
    public int getQuickestRoute(){
        int tempa = droneCord[0] - delCord[0] ;
        int tempb = droneCord[1] - delCord[1];
        int tempc = tempa * tempa;
        int tempd = tempb * tempb;
        int tempe = tempc + tempd;
        double result = Math.sqrt(tempe);
        
        return (int) Math.abs(Math.round(result));
    }
    
    public void getAvailableWarehouses(){
    	Map m = Map.getInstance();
    	
    }
    public int movesToClosestWareHouse(){
    	int currentLeast = 10000000;
    	
    	for(Warehouse e : availWarehouse){
    		int noMoves = e.getQuickestRouteToHere(droneCord);
    		if(e.getQuickestRouteToHere(droneCord) < currentLeast){
    			currentLeast = noMoves;
    		}
    	}
    	return currentLeast;
    	
    }
}
