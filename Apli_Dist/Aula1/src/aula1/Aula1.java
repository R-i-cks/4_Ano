package aula1;


        import java.text.DecimalFormat;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Scanner;

public class Aula1 {

    public void Exercicio1(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduza o nome: ");
        String nome = scanner.nextLine();
        System.out.println("Introduza o saldo: ");
        double saldo = scanner.nextDouble();

        System.out.println("O saldo do cliente "
                + nome + " é de "
                + saldo + " euros");
    }
    // 2. Ler dois inteiros e escreve-los por ordem decrescente,assim como a sua media.
    public void Exercicio2(){
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Introduza um número:  ");
        int num1 = scanner2.nextInt();
        System.out.println("Introduza um número:  ");
        int num2 = scanner2.nextInt();
        int soma = num1 + num2;
        int media = soma/2;
        if(num2>num1){
            int troca = num1;
            num1 = num2;
            num2 = troca;
        }
        System.out.println("A soma de " +
                num1 + " com " + num2 + " é igual a " + soma + " e a média dos 2 valores é de " + media);
    }
    //Ler 10 inteiros e determinar a quantidade de numeros introduzidos com valor superior a 5.
    public void Exercicio3(){
        Scanner scanner = new Scanner(System.in);
        int contador = 0;
        for( int i = 0;i<10;i++){
            System.out.println("Introduza um número:  ");
            int total = scanner.nextInt();
            if (total>5){
                contador++;
            }
        }
        System.out.println(contador);
    }
    // Esta solução acima não usa arrays, para visualização do conceito iremos criar uma nova solução
    /* Os arrays em java têm de ter o seu comprimento definido inicialmente, não permitindo aceder a indices fora deste scope.
    A sintaxe será entao int[] a = new int[quantidade] ou int a[] = new int[qnt]
    */
    public void Exercicio3_lista(){
        int[] lista_dez = new int[10];
        Scanner scanner = new Scanner(System.in);
        for( int i = 0;i<10;i++){
            System.out.println("Introduza um número:  ");
            lista_dez[i]= scanner.nextInt();
        }
        int contador = 0;
        for(int j = 0; j<10;j++){   // alternativa for( int v: lista_dez) - percorre a lista
            if (lista_dez[j]>5){   // if (v>5)
                contador++;
            }
        }
        System.out.println("Na lista " + Arrays.toString(lista_dez) +
                " de elementos introduzidos, " + contador + " são maiores que 5.");
    }

    public void Exercicio3_v3(){
        // Arraylist pode crescer com add(posição, elemento ) - desloca os outros
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i<10 ; i++){
            System.out.println("Introduza um número");
            int v = s.nextInt();
            al.add(v);
        }
        int cnt = 0;
        for(int v : al){
            if(v>5){
                cnt++;
            }
        }

    }


    /* 4. Sendo n dado pelo utilizador, ler n reais e calcular as suas raizes quadradas. */

    public void Exercicio4(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduza um valor:  ");
        float quadrado = scanner.nextFloat();
        double raiz = Math.sqrt(quadrado);
        System.out.println("A raiz de " + quadrado + " é " + raiz);


    }

    /* 5. Ler uma sequencia de inteiros (terminada pelo valor 0) e determinar a sua soma.
     Imprimir esse valor, bem como o maior e o menor valor introduzidos. */

    private void Exercicio5(){
        ArrayList<Integer> lista = new ArrayList<>();
        int valor = 1;
        int min = 9999999;
        int max = -9999999;
        int soma = 0;
        Scanner scanner = new Scanner(System.in);
        while (valor != 0){
            System.out.println("Introduza um valor: ");
            valor = scanner.nextInt();
            lista.add(valor);
            soma += valor;
            if (valor>max){
                max = valor;
            }
            if (valor<min){
                min = valor;
            }
        }
        System.out.println("Introduziu a seguinte lista de valores: " + lista + "\nsendo a soma dos valores igual a "
        + soma + ", o máximo: " + max + ", e o mínimo: " + min);

    }
    /* 6. Escrever um programa que calcule o factorial de um valor inteiro passado como parametro ao programa (e acessivel atraves do argumento sys.argv).
     O factorial do numero devera ser calculado num metodo auxiliar. */

    // A função implementa o fatorial, sendo necessário passar o valor pela linha de comando
    private int factorial( int n){
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }

    public void Exercicio6(int n){
        int f = factorial(n);
        System.out.println("O fatorial de " + n + " é " + f);
    }
    /*7. Escrever um programa que, dada um data em dia (1..31), mes (1..12)
    e ano, calcule o dia da semana dessa data. */

    public boolean AnoBissexto(int ano){
        if ((ano%4 == 0 && ano%100 !=0) || (ano%400 ==0)){
            return true;
        } else{
            return false;
        }
    }

    public int QntAnosBiss(int ano){ // calcular desde o ano 1
        int conta =0;
        for(int i=1;i<=ano;i++){
            if(AnoBissexto(ano)){
                conta+=1;
            }
        }
        return conta;
    }
    public void Exercicio7_v2(int dia, int mes, int ano) {  // 1/1/0001 foi uma segunda feira, vamos calcular com base nesta informação
        int bi6 = QntAnosBiss(ano);
        int dias_dist = (ano-1)*365 + bi6;
        int dif_mes = mes -1;
        int[] meses = {31,28,31,30,31,30,31,31,30,31,30,31};
        while (dif_mes!=0){
            dias_dist += meses[dif_mes];  // aos anos que soma-mos vamos adicionar os meses
            dif_mes -= 1;
        }
        dias_dist += dia-1;   // acrescentar os dias de diferença, sendo a ref dia 1
        int num_dia = dias_dist%7;
        String[] dias_semana = {"Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado","Domingo"};
        System.out.println("No dia "+dia+"/"+mes+"/"+ano+" foi "+dias_semana[num_dia]);

    }

    // Escrever um programa que aceite n classificacoes (numeros reais) de
    // uma UC, e indique o numero de classificacoes em cada um dos intervalos: [0, 5[, [5, 10[, [10, 15[ e [15, 20].

    public void Exercicio8() {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Introduza o número de classificações que quer inserir:  ");
        int num = s1.nextInt();
        ArrayList<Double> lcl = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            System.out.println("Introduza uma classificação: ");
            double cl = s1.nextDouble();
            lcl.add(Double.valueOf(cl));
        }
        System.out.println(lcl.toString());
        int[] lista_cl = new int[num];
        for (double j : lcl) {
            if (j <= 5) {
                lista_cl[0]++;
            } else if (j <= 10) {
                lista_cl[1]++;
            } else if (j <= 15) {
                lista_cl[2]++;
            } else {
                lista_cl[3]++;
            }
        }
        System.out.println("[0,5] : " + lista_cl[0] +
                " [5,10] : " + lista_cl[1] + " [10,15] : " + lista_cl[2] +
                " [15,20] : " + lista_cl[3]);
    }

    /* 9. Escrever um programa que aceite n temperaturas inteiras (pelo menos duas) e determine a media das temperaturas, o dia (2,3, ...) em que
    se registou a maior variacao em valor absoluto relativamente ao dia anterior e qual o valor efectivo (positivo ou negativo) dessa variacao.
    Os resultados devem ser apresentados sob a forma:
    A media das n temperaturas foi de ____ graus.
    A maior variacao registou-se entre os dias __ e __, tendo a temperatura subido/descido ___ graus. */

    public void Exercicio9(){     // Cada entrada irá corresponder à temperatura num dia
        Scanner s9 = new Scanner(System.in);
        System.out.println("Introduza o número de registos a inserir: ");
        int reg = s9.nextInt();
        ArrayList<Integer> tempdiarias = new ArrayList<>();
        if (reg<2){
            System.out.println("Introduza pelo menos 2 valores!");
        }
        else{
            int dia = 1;
            double media = 0;
            while(dia<=reg){
                System.out.println("Qual foi a temperatura no dia "+ dia +"?");
                int temp = s9.nextInt();
                tempdiarias.add(temp);
                dia+=1;
                media+=temp;
            }
            media = media/reg;
            System.out.println("A media das "+reg+ " temperaturas foi de "+media+" graus.");
            int maior_dif = -1;
            int dia0=1;
            int dia1=2;
            int dif;
            String sin= "aum";
            for(int i=0;i<reg-2;i++){
                dif = (tempdiarias.get(i + 1) -tempdiarias.get(i));
                if (dif>=0){
                    sin="aumentado";
                }
                else{
                    dif=-dif;
                    sin="diminuído";
                }
                if(dif>maior_dif){
                    maior_dif=(dif);
                    dia0=i+1;
                    dia1=i+2;
                }
            }
            System.out.println("A maior variação registou-se entre os dias "+dia0+" e "+dia1+", tendo a temperatura "+sin+" "+maior_dif+" graus.");
        }

    }

    /* 10. Escrever um programa que leia sucessivas vezes a base e altura de um triangulo retangulo (valores reais) e calcule a area e o perimetro
respectivos. Apresentar os resultados com uma precisao de 5 casas decimais. O programa apenas devera terminar com a leitura de uma base = 0.0. */

    public void Exercicio10() {
        Scanner s10 = new Scanner(System.in);
        double base = 1;
        double altura, area, hip, perimetro;
        DecimalFormat numberFormat = new DecimalFormat("#.00000");
        while (base != 0) {
                System.out.println("Introduza o valor da base do seu triângulo: ");
                base = s10.nextDouble();
                if (base!=0){
                    System.out.println("Introduza o valor de altura do seu triângulo: ");
                    altura = s10.nextDouble();
                    area = base * altura / 2;
                    hip = Math.sqrt(base * base + altura * altura);
                    perimetro = hip + base + altura;
                    System.out.println("O triângulo definido pelas medidas introduzidas tem uma área de " + numberFormat.format(area) +
                            " e um perímetro de " + numberFormat.format(perimetro));
                }
                else
                {
                System.out.println("Até à próxima!");
                }
        }
    }

    /* 11. Escrever um programa que gera dois numeros aleatorios entre 1 e 100. O programa dara 5 tentativas ao utilizador para acertar em um dos dois
numeros gerados. A cada tentativa do utilizador, o programa indicara a distancia do numero mais proximo. No fim do jogo o utilizador
devera ter a possibilidade de jogar novamente. */

    public void Exercicio11() {
        Scanner s11 = new Scanner(System.in);
        System.out.println("Tenta acertar!\n\nVou pensar num número entre 1 e 100!");
        int num1 = (int) (Math.random() * 100);
        int num2 = (int) (Math.random() * 100);
        int tenta = 5;
        int dif1 = 1;
        int dif2 = 1;
        int jog;
        while (tenta != 0 && dif1 != 0 && dif2 != 0) {
            System.out.println("Tens " + tenta + " tentativas para acertar!\nJogada: ");
            jog = s11.nextInt();
            dif1 = num1 - jog;
            dif2 = num2 - jog;
            if (dif1 == 0 || dif2 == 0) {
                System.out.println("Parabéns!Acertaste no número que pensei!");
            }
            if (dif1 < 0) {
                dif1 = -dif1;
            }
            if (dif2 < 0) {
                dif2 = -dif2;
            }
            if (dif1 >= dif2 && dif2 != 0) {
                System.out.println("Quase!!! O número que pensei está a uma distância de " + dif2);
            } else if (dif2 > dif1 && dif1 != 0) {
                System.out.println("Quase!!! O número que pensei está a uma distância de " + dif1);
            }
            tenta -= 1;
        }
        if (dif1 != 0 && dif2 != 0) {
            System.out.println("Perdeste! Os números que pensei foram: " + num1 + " " + num2);
        }
        System.out.println("Queres jogar novamente?\nIntroduz '1' para tentar novamente");
        int sn = s11.nextInt();
        if (sn == 1) {
            Exercicio11();
        }
    }


    public static void main(String[] args){
        //System.out.println("Argumentos : " + Arrays.toString(args));
        Aula1 f = new Aula1();
        //int n = Integer.valueOf(args[0]);
        //f.Exercicio1();
        //f.Exercicio2();
        // f.Exercicio3_v3()
        // f.Exercicio4();
        // f.Exercicio5();
        //f.Exercicio6(n);
        f.Exercicio7_v2(13,8,1823);
        // f.Exercicio8();
        //f.Exercicio9();
        //f.Exercicio10();
        //f.Exercicio11();
    }
}






