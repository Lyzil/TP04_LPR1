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
	    this.mes = 1;
        this.dia = 1;
        this.ano = 1;
        //colocando valores inicias para a verificação funcionar
		entraAno();
		entraMes();
		entraDia();
	}
	public Data(int d, int m, int a)
	{
	    if(a > 0 && a <= 9999)
	    {this.ano = a;} // fazer primeiro para não dar erro no metodo bissexto
	    else {
            throw new IllegalArgumentException("Ano inválido: " + a);
        }
		if (m > 0 && m <= 12) {
            this.mes = m;
        } else {
            throw new IllegalArgumentException("Mês inválido: " + m);
        }
        if (d > 0 && d <= getDiasNoMes(mes, ano)) {
            this.dia = d;
        } else {
            throw new IllegalArgumentException("Dia inválido: " + d);
        }
    }
    
    private int getDiasNoMes(int mes, int ano) {
        int[] dias = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (mes == 2 && bissexto(ano)) {
            return 29;
        }
        return dias[mes - 1];
    }
	public void entraDia(int d){
		if(d>0 && d <= getDiasNoMes(mes, ano)){
			this.dia = d;
		}
		else{
			throw new IllegalArgumentException("Dia inválido");
		}
	}
	public void entraMes(int m){
		if(m>0 && m <=12){
			this.mes = m;
			if (dia > getDiasNoMes(mes, ano)) {
            dia = getDiasNoMes(mes, ano);
        }
		}
		else{
			throw new IllegalArgumentException("Mes inválido");
		}
	}
	public void entraAno(int a){
		if(a > 0 && a<=9999){
			this.ano = a;
			if (dia > getDiasNoMes(mes, ano)) {
            dia = getDiasNoMes(mes, ano);
        }
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
			if(resD >0 && resD <= getDiasNoMes(mes, ano))
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
				if (dia > getDiasNoMes(mes, ano)) {
                    dia = getDiasNoMes(mes, ano);
                }
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
				if (dia > getDiasNoMes(mes, ano)) {
                    dia = getDiasNoMes(mes, ano);
                }
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
	
	private static int escolherData() {
    System.out.print("Selecione a data que quer mudar (1 a 3): ");
    try {
        int op = scan.nextInt();
        if (op >= 1 && op <= 3) return op;
        else System.out.println("Opção inválida.");
    } catch (Exception e) {
        System.out.println("Entrada inválida.");
        scan.next(); // limpar
    }
	return -1;	
}
	
	public static void main (String[] args) {
		
    Data d1 = new Data();
	Data d2 = new Data(13, 9, 2005);
	Data d3 = new Data(1, 1, 1);
	d3.entraAno(1);
	d3.entraMes(1);
	d3.entraDia(1);
	int opcao = -1;
	Data[] Datas = { d1, d2, d3 };

	while (opcao != 0) {
        System.out.println("\n--- MENU ---");
        System.out.println("1 - Exibir data (formato xx/xx/xxxx)");
        System.out.println("2 - Exibir hora (formato xx/MesPorExtenso/xxxx)");
        System.out.println("3 - Ano é bissexto?");
        System.out.println("4 - Dias transcorridos des do inicio do ano");
        System.out.println("5 - Exibir data atual");
        System.out.println("6 - Alterar ano");
        System.out.println("7 - Alterar mes");
        System.out.println("8 - Alterar dia");
        
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");

	try {
		opcao = scan.nextInt();
		System.out.println();
	switch (opcao) {
		case 1:
			for (int i = 0; i < Datas.length; i++) {
				System.out.println("Data " + (i + 1) + ": " + Datas[i].mostra1());
			}
    break;
		case 2:
			for (int i = 0; i < Datas.length; i++) {
				System.out.println("Data " + (i + 1) + ": " + Datas[i].mostra2());
			}
			break;
		case 3:
			for (int i = 0; i < Datas.length; i++) {
				System.out.println("Data "+(i + 1)+"| O ano é bissexto?: " + (bissexto(Datas[i].retAno()) ? "SIM" : "NAO"));

			}
			break;
		case 4:
			for (int i = 0; i < Datas.length; i++) {
				System.out.println("Dias transcorridos " + (i + 1) + ": " + Datas[i].diasTranscorridos());
			}
			break;
		case 5:
			    Datas[0].apresentarDataAtual();
			break;
		case 6:
			switch (escolherData()){
				case 1:
					d1.entraAno();
					break;
				case 2:
					d2.entraAno();
					break;
				case 3:
					d3.entraAno();
					break;
				}
			break;
		case 7:
			switch (escolherData()){
				case 1:
					d1.entraMes();
					break;
				case 2:
					d2.entraMes();
					break;
				case 3:
					d3.entraMes();
					break;
				default:
					System.out.println("ERRO ERRO");
					break;
				}
			break;
		case 8:
			switch (escolherData()){
				case 1:
					d1.entraDia();
					break;
				case 2:
					d2.entraDia();
					break;
				case 3:
					d3.entraDia();
					break;
				default:
					System.out.println("ERRO ERRO");
					break;
				}
			break;
		case 0:
			System.out.println("Encerrando programa...");
			break;
		default:
			System.out.println("Opção inválida. Tente novamente.");
            }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scan.next();
            }
    	}
    }
}
