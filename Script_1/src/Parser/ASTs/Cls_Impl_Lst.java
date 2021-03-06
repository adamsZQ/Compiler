package Parser.ASTs;

import java.util.*;

import Parser.*;
import Parser.TypeSys.GenCodeException;
import Parser.TypeSys.GenSymTblException;
import Parser.TypeSys.R_Function;
import Parser.TypeSys.T_Class;
import Parser.TypeSys.T_Interface;
import Parser.TypeSys.T_Type;
import Parser.TypeSys.TypeCheckException;

public class Cls_Impl_Lst extends AST {
	boolean isE=true;
	LinkedList<TypeExp_Idn> imps;
	LinkedList<String> extd_types;
	
	public void addImp(TypeExp_Idn par){
		if(this.imps==null){
			this.imps=new LinkedList<TypeExp_Idn>();			
			this.isE=false;
		}
		this.imps.add(par);
	}
	public boolean isE() {
		return isE;
	}
	public void setE() {
		this.isE = true;
	}
	public boolean genCode(CodeGenerator codegen)throws GenCodeException{
		
		return true;
	}
	public boolean genSymTb(CodeGenerator codegen)throws GenSymTblException{
		if(isE){
			return true;
		}
		this.extd_types=new LinkedList<String>();
		HashSet<String> all_t=new HashSet<String>();
		for(TypeExp_Idn t:imps){
			if(!t.genSymTb(codegen))return false;
			if(all_t.contains(t.rst_type))
				return false;
			this.extd_types.add(t.rst_type);
			all_t.add(t.rst_type);
		}
		return true;
	}
	public boolean checkType(CodeGenerator codegen)throws TypeCheckException{
		if(isE){
			return true;
		}
		
		return true;
	}
}
