import java.util.Scanner; 
public class Data{
	
	private int dia;
	private int mes;
	private int ano;
	private int dias[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public Data()
	{
		entraDia();
		entraMes();
		entraAno();
	}
	public Data(int d, int m, int a)
	{
		if(bissexto())
		{dias[1]++;}
		if(d > 0 && d <=dias[m-1] && m >0 && m <=12 && a <= 9999)
		{
			this.dia = d;
			this.mes = m;
			this.ano = a;
		}
	}
	entraDia(int d){
		if(d>0 && d <= dias[mes-1]){
			this.dia = d;
		}
	}
	entraMes(int m){
		if(m>0 && m <=12){
			this.mes = m;
		}
	}entraAno(int a){
		if(a<=9999){
			this.ano = a;
		}
	}
	public void entraDia(){}
	public void entraMes(){}
	public void entraAno(){}
	
	public int retDia(){return dia}
	public int retMes(){return mes}
	public int retAno(){return ano}
	
	public String mostra1(){
		
	}
	
	public String mostra2(){
		
	}
	
	public boolean bissexto(){
		if (this->ano % 4 == 0 && (this->ano % 100 != 0 || this->ano % 400 == 0))
        {
            return true;
        }
		else{return false;}
	}
	
	public int diasTranscorridos(){
		
	}
	
	public void apresentarDataAtual(){
		
	}
	
	public static void main (String[] args) {
		
	}
}