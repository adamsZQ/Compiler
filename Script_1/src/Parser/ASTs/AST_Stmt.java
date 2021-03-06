package Parser.ASTs;

import Interpreter.*;
import Parser.*;
import Parser.TypeSys.GenCodeException;
import Parser.TypeSys.GenSymTblException;
import Parser.TypeSys.TypeCheckException;

public class AST_Stmt extends AST {
	Stmt_DefCls stmt_cls;
	Stmt_DefIntf stmt_intf;
	Stmt_DefFunc stmt_func;
	Stmt_If stmt_if;
	Stmt_Whl stmt_whl;
	Stmt_Sg stmt_sg;
	
	public boolean setStmt(AST ast){
		switch(this.getASTType()){
		case "Stmt_DefCls":
			this.stmt_cls=(Stmt_DefCls)ast;
			break;
		case "Stmt_DefIntf":
			this.stmt_intf=(Stmt_DefIntf)ast;
			break;
		case "Stmt_DefFunc":
			this.stmt_func=(Stmt_DefFunc)ast;					
			break;
		case "Stmt_If":
			this.stmt_if=(Stmt_If)ast;
			break;
		case "Stmt_Whl":
			this.stmt_whl=(Stmt_Whl)ast;
			break;
		case "Stmt_Sg":
			this.stmt_sg=(Stmt_Sg)ast;
			break;
		default:
			return false;
		}
		return true;
	}
	
	public boolean genCode(CodeGenerator codegen)throws GenCodeException{
		switch(this.getASTType()){
		case "Stmt_DefCls":
			this.stmt_cls.genCode(codegen);
			break;
		case "Stmt_DefIntf":
			this.stmt_intf.genCode(codegen);
			break;
		case "Stmt_DefFunc":
			this.stmt_func.genCode(codegen);
			break;
		case "Stmt_If":
			this.stmt_if.genCode(codegen);
			break;
		case "Stmt_Whl":
			this.stmt_whl.genCode(codegen);
			break;
		case "Stmt_Sg":
			this.stmt_sg.genCode(codegen);
			break;
		default:
			return false;
		}
		return true;
	}
	public boolean genSymTb(CodeGenerator codegen)throws GenSymTblException{
		switch(this.getASTType()){
		case "Stmt_DefCls":
			return this.stmt_cls.genSymTb(codegen);			
		case "Stmt_DefIntf":
			return this.stmt_intf.genSymTb(codegen);
		case "Stmt_DefFunc":
			return this.stmt_func.genSymTb(codegen);
		case "Stmt_If":
			return this.stmt_if.genSymTb(codegen);			
		case "Stmt_Whl":
			return this.stmt_whl.genSymTb(codegen);
		case "Stmt_Sg":
			return this.stmt_sg.genSymTb(codegen);
		default:
			return false;
		}
	}
	public boolean checkType(CodeGenerator codegen)throws TypeCheckException{		
		boolean rst=true;
		switch(this.getASTType()){
		case "Stmt_DefCls":
			return this.stmt_cls.checkType(codegen);
		case "Stmt_DefIntf":
			return this.stmt_intf.checkType(codegen);
		case "Stmt_DefFunc":
			return this.stmt_func.checkType(codegen);
		case "Stmt_If":
			return this.stmt_if.checkType(codegen);
		case "Stmt_Whl":
			return this.stmt_whl.checkType(codegen);
		case "Stmt_Sg":
			return this.stmt_sg.checkType(codegen);
		default:
			return false;
		}
	}
	
}
