package Parser.ASTs;

import Parser.*;

public class ExprAccs_App extends AST {
	ExprAccs pre_accs;
	ExprAccs_App pre_app;
	ExprPri_Var var;
	FuncApp_ArgLst arg_lst;
	public void lnkApp(ExprAccs pre_accs,ExprPri_Var var,FuncApp_ArgLst arg_lst){
		this.pre_accs=pre_accs;
		this.var=var;
		this.arg_lst=arg_lst;
	}
	public void lnkApp(ExprAccs_App pre_app,ExprPri_Var var,FuncApp_ArgLst arg_lst){
		this.pre_app=pre_app;
		this.var=var;
		this.arg_lst=arg_lst;
	}
	public void setApp(ExprPri_Var var,FuncApp_ArgLst arg_lst){
		this.var=var;
		this.arg_lst=arg_lst;
	}
}