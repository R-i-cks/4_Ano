package aula1;


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

    /* 6. Escrever um programa que calcule o factorial de um valor inteiro passado como parametro ao programa (e acessivel atraves do argumento sys.argv).
     O factorial do numero devera ser calculado num metodo auxiliar. */
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

    // Escrever um programa que aceite n classificacoes (numeros reais) de
    // uma UC, e indique o numero de classificacoes em cada um dos intervalos: [0, 5[, [5, 10[, [10, 15[ e [15, 20].

    public void Exercicio8(){
        Scanner s1 = new Scanner(System.in);
        System.out.println("Introduza o número de classificações que quer inserir:  ");
        int num = s1.nextInt();
        ArrayList<Double> lcl = new ArrayList<>();
        for(int i = 0;i< num ; i++){
            System.out.println("Introduza uma classificação: ");
            double cl = s1.nextDouble();
            lcl.add(Double.valueOf(cl));
        }
        System.out.println(lcl.toString());
        int[] lista_cl= new int[num];
        for(double j: lcl){
            if(j<=5){
                lista_cl[0]++;
            } else if (j<=10) {
                lista_cl[1]++;
            } else if (j<=15) {
                lista_cl[2]++;
            } else {
                lista_cl[3]++;
            }
        }
        System.out.println("[0,5] : " + lista_cl[0] +
                " [5,10] : " + lista_cl[1] + " [10,15] : " + lista_cl[2] +
                " [15,20] : " + lista_cl[3]);




    }
    public static void main(String[] args){
        //System.out.println("Argumentos : " + Arrays.toString(args));
        Aula1 f = new Aula1();
        //int n = Integer.valueOf(args[0]);
        //f.Exercicio1();
        //f.Exercicio2();
        // f.Exercicio3_v3()
        //f.Exercicio6(n);
        f.Exercicio8();
    }
}






