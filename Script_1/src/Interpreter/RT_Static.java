//static objs and functions
package Interpreter;

import java.util.ArrayList;
import java.util.HashMap;

import Parser.ASTs.Data_Func;
import Parser.ASTs.Data_Obj;
import Parser.ASTs.Type_Func;
import Parser.ASTs.Type_Obj;

public class RT_Static {
	HashMap<String,ArrayList<Type_Func>> funcs=new HashMap<String,ArrayList<Type_Func>>();
	HashMap<String,Data_Obj> objs=new HashMap<String,Data_Obj>();
	
	public ArrayList<Type_Func> getFunc(String name){
		return funcs.get(name);
	}
	public Data_Obj getObj(String name){
		return objs.get(name);
	}
	public boolean addObj(String name, Data_Obj obj){
		//TODO check unique firstly
		objs.put(name, obj);
		return true;
	}
	public boolean addFunc(String name, Type_Func func){
		//TODO check unique firstly
		if(funcs.get(name).isEmpty()){
			funcs.put(name, new ArrayList<Type_Func>());
		}
		funcs.get(name).add(func);
		return true;
	}
}
