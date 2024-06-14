import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {   
        String [] candidatos = {"Felipe", "Marcia", "Clara", "Augusto", "João"};
        for(String candidato: candidatos) {
            entrarEmContato(candidato);

        }
    }
    static void entrarEmContato(String candidato) {
        int tentativasRealizados = 1;
        boolean tentarNovamente = true;
        boolean atendeu = false;
            //! Precisa sofrer algum tipo de alteração, caso contrario será criado um loop
        do {
            atendeu = atender();
            tentarNovamente = !atendeu;
            if(tentarNovamente)
                tentativasRealizados++;
            else
                System.out.println("Contato Realizado com sucesso");
           
        }while(tentarNovamente && tentativasRealizados < 3);
        if(atendeu)
            System.out.println("Conseguimos contato com "+candidato+" na "+tentativasRealizados+" Tentativa.");
        else
            System.out.println("Não conseguimos contato com "+candidato+", número máximo de tentativas "+tentativasRealizados+ " realizadas.");

    }
        //Metodo auxiliar
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    static void imprimirSelecionados(){
        String [] candidatos = {"Felipe", "Marcia", "Clara", "Augusto", "João"};
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");
        for(int i=0; i < candidatos.length; i++) {
            System.out.println("O candidato de N° "+ (i+1) + " é " + candidatos[i]);
        }

    } 

    static void selecaoCandidatos() {

        String [] candidatos = {"Felipe", "Marcia", "Clara", "Augusto", "João", "Cleber", "Fabricio", "Julia", "Daniela"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 & candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " +candidato+" Solicitou o valor de salário "+salarioPretendido);
            if(salarioBase >= salarioPretendido) {
                System.out.println("O candidato "+candidato+" foi selecionado para a vaga.");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static void analiseCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        }else if(salarioBase == salarioPretendido)
            System.out.println("Ligar para o candidato com contra proposta");
        else {
            System.out.println("Aguardar resultado dos demais candidatos");
        }
    }
}
