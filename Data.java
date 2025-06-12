import java.text.DateFormat;
import java.util.Date;
import java.util.Locale; 
import java.util.Scanner;

public class Data{
	
	private int dia;
	private int mes;
	private int ano;
	private int diasNoMes[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final Scanner scan = new Scanner(System.in);
	
	public Data()
	{
		entraAno();
		entraMes();
		entraDia();
	}
	public Data(int d, int m, int a)
	{
	    if(a > 0 && a <= 9999){this.ano = a;} // fazer primeiro para não dar erro no metodo bissexto
		diasNoMes[1] = bissexto(ano) ? 29 : 28;
		if(d > 0 && d <=diasNoMes[m-1] && m >0 && m <=12)
		{
			this.dia = d;
			this.mes = m;
		}
	    else{
			throw new IllegalArgumentException("Data inválida: " + d + "/" + m + "/" + a);
		}
	}
	public void entraDia(int d){
		if(d>0 && d <= diasNoMes[mes-1]){
			this.dia = d;
		}
		else{
			throw new IllegalArgumentException("Dia inválido");
		}
	}
	public void entraMes(int m){
		if(m>0 && m <=12){
			this.mes = m;
		}
		else{
			throw new IllegalArgumentException("Mes inválido");
		}
	}
	public void entraAno(int a){
		if(a > 0 && a<=9999){
			this.ano = a;
			diasNoMes[1] = bissexto(ano) ? 29 : 28;
		}
		else{
			throw new IllegalArgumentException("Ano inválido");
		}
	}
	public void entraDia(){
	    int resD;
	    boolean verificador = false;
	    while (!verificador){
	        System.out.print("Digite o dia: ");
	        try {
			resD = scan.nextInt();
			if(resD >0 && resD <= diasNoMes[mes-1])
			{
				this.dia = resD;
				verificador = true;
			}else{
				System.out.println("Valor errado!!! digite novamente!");
				}
		} catch (Exception e)
		{
			System.out.println("Entrada inválida. Digite um número inteiro.");
        	scan.next();
		}
	    }
	}
	public void entraMes(){
	    int resM;
	    boolean verificador = false;
	    while (!verificador){
	        System.out.print("Digite o mes: ");
	        try {
			resM = scan.nextInt();
			if(resM >0 && resM <= 12)
			{
				this.mes = resM;
				verificador = true;
			}else{
				System.out.println("Valor errado!!! digite novamente!");
				}
    		} catch (Exception e)
    		{
    			System.out.println("Entrada inválida. Digite um número inteiro.");
            	scan.next();
    		}
	    }
	}
	public void entraAno(){
	    int resA;
	    boolean verificador = false;
	    while (!verificador){
	        System.out.print("Digite o ano: ");
	        try {
			resA = scan.nextInt();
			if(resA > 0 &&resA <= 9999)
			{
				this.ano = resA;
                diasNoMes[1] = bissexto(ano) ? 29 : 28;
				verificador = true;
			}else{
				System.out.println("Valor errado!!! digite novamente!");
				}
    		} catch (Exception e)
    		{
    			System.out.println("Entrada inválida. Digite um número inteiro.");
            	scan.next();
        	}
    	}
	}
	
	public int retDia(){return dia;}
	public int retMes(){return mes;}
	public int retAno(){return ano;}
	
	public String mostra1(){
		return String.format("%02d/%02d/%04d", dia, mes, ano);
	}
	
	public String mostra2(){
	    String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
		return String.format("%02d/%s/%04d", dia, meses[mes-1], ano);
	}
	
	public static boolean bissexto(int ano){
		if (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0))
        {
            return true;
        }
		else{return false;}
	}
	
	public int diasTranscorridos(){
		int qtdDias = 0;
        diasNoMes[1] = bissexto(ano) ? 29 : 28;
            for (int i = 0; i < mes - 1; i++) {
                qtdDias += diasNoMes[i];
            }
            qtdDias += dia;
        return qtdDias;
	}
	
	public void apresentarDataAtual(){
		Date dataAtual = new Date();
        DateFormat formatar = DateFormat.getDateInstance(DateFormat.FULL, new Locale("pt", "BR"));
        	System.out.print(formatar.format(dataAtual));
	}
	
	public static void main (String[] args) {
		
	}
}
