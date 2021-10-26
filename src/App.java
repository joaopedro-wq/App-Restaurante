

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import pacote1.Pedido;
import pacote2.garcom;
import pacote3.itens;
import pacote4.produto;
import pacote5.caixa;

public class App {

    public static void main(String[] args) throws Exception {

        Scanner sanner = new Scanner(System.in);
        LinkedList<garcom> list = new LinkedList<>();
        LinkedList<produto> lista = new LinkedList<>();
        LinkedList<Pedido> comanda = new LinkedList<>();
        LinkedList<itens> item = new LinkedList<>();
        LinkedList<caixa> caixas = new LinkedList<>();

        System.out.print("Insire o nome do seu comercio  : ");
        String comercio = sanner.nextLine();
        System.out.println();
        System.out.println(" Seja Bem vindo ao " + comercio + "!");
        System.out.println("-------------------------------");
        System.out.println();

        boolean rodando = true;

        while (rodando) {

            System.out.println("================= Menu " + comercio + " =================");
            System.out.println("[1] - Cadastrar garçom: ");
            System.out.println("[2] - Cadastrar Produtos: ");
            System.out.println("[3] - Abrir Pedido: ");
            System.out.println("[4] - Adicionar Produto: ");
            System.out.println("[5] - Fechar Pedido: ");
            System.out.println("[6] - Total do Caixa: ");
            System.out.println("[7] - Sair: ");
            System.out.println("================================================= ");
            System.out.println();
            System.out.print("Opção: ");

            String opcao = sanner.nextLine();

            switch (opcao) {

                case "1": {

                    System.out.println("Cadastro Garçom: ");
                    System.out.print("Nome garçom: ");
                    String nome = sanner.nextLine();
                
                    int soma = 100;
                    for (int i = 0; i < list.size(); i++) {
                        soma = soma + 1;
                    }
                    try {
                        
                        garcom a1 = new garcom();
                        a1.setNome(nome);
                        a1.setMatricula(soma);
                        list.add(a1);
                        System.out.println("Garçom  Cadastrado. ");

                    } catch (InputMismatchException e) {
                        System.out.println();
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println("Dados inseridos invalidos, Ocorreu o seguinte erro: " + e);
                        System.out.println("Siga as seguintes instruções a seguir e não apresentará erro:");
                        System.out.println("\t1 - Inserir dados da matricula do garçom apenas numeros inteiros.");
                        System.out.println("\t2 - Tente novamente seguindo as instruções acima...");
                        System.out.println("------------------------------------------------------------------------");

                        System.out.println();
                    }
                    System.out.println();
                    break;

                }
                case "2": {

                    System.out.println("Cadastro Produtos: ");
                    int soma = 0;
                    for (int i = 0; i < lista.size(); i++) {
                        soma = soma + 1;
                    }

                    System.out.print("Nome Produtos: ");
                    String produto = sanner.nextLine();
                    System.out.print("Preço Produto: ");
                    try {

                        float preco = sanner.nextFloat();
                        sanner.nextLine();
                        produto p1 = new produto();
                        p1.setNome(produto);
                        p1.setCodigo(soma);
                        p1.setPreco(preco);
                        lista.add(p1);
                        System.out.println("Produto cadastrado.");

                    } catch (InputMismatchException e) {
                        System.out.println();
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println("Dados inseridos invalidos, Ocorreu o seguinte erro: " + e);

                        System.out.println("Siga as seguintes instruções a seguir e não apresentará erro:");
                        System.out.println("\t1 - Dados do numero do Preço do produto não é permitido String.");
                        System.out.println("\t2 - Tente novamente seguindo as instruções acima...");
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println();

                    }

                    System.out.println();

                    break;
                }
                case "3": {
                    System.out.println();

                    if (list.isEmpty()) {
                        System.out.println(
                                "Não há nenhum garçom cadastrado, por favor cadastre algum garçom antes desse processo.");
                        break;
                    } else {

                        System.out.println("Abrindo pedido....");
                        System.out.println("--------------------");
                        System.out.println("Lista dos garçons :  ");
                        System.out.println("--------------------");

                        for (int i = 0; i < list.size(); i++) {
                            System.out.println("Codigo Garçom: " + i);
                            System.out.println(list.get(i).toString());
                            System.out.println("--------------------");
                            System.out.println();
                        }
                        System.out.print("Digite o codigo do garçom: ");
                        try {
                            int c = sanner.nextInt();
                            sanner.nextLine();

                            int soma = 0;
                            for (int i = 0; i < comanda.size(); i++) {
                                soma = comanda.get(i).getCodigo() + 1;

                            }

                            boolean encontrado = false;

                            for (int i = 0; i < list.size(); i++) {

                                garcom utemp = list.get(i);
                                if (c == i) {

                                    System.out.println("Pedido Aberto. ");

                                    encontrado = true;

                                }

                                if (encontrado == true) {

                                    Pedido p = new Pedido();
                                    String abc = utemp.toString();
                                    p.setGarcom(abc);

                                    Date hoje = new Date();
                                    p.setDataPedido(hoje);

                                    p.setCodigo(soma);
                                    comanda.add(p);
                                    break;

                                }
                            }

                            if (!encontrado) {
                                System.out.println("Nao foi encontrado esse Garçom no sistema");
                                break;
                            }

                        } catch (InputMismatchException e) {
                            System.out.println();
                            System.out.println(
                                    "------------------------------------------------------------------------");
                            System.out.println("Dados inseridos invalidos, Ocorreu o seguinte erro: " + e);
                            System.out.println("Siga as seguintes instruções a seguir e não apresentará erro:");
                            System.out.println("\t1 - Inserir dados do codigo garçom apenas com numeros inteiros.");
                            System.out.println("\t2 - Tente novamente seguindo as instruções acima...");
                            System.out.println(
                                    "------------------------------------------------------------------------");
                            System.out.println();

                        }

                        System.out.println();
                        break;
                    }
                }
                case "4": {
                    System.out.println();
                    if (lista.isEmpty()) {
                        System.out.println(
                                "Nenhum produto cadastrado, por favor cadastre antes de prosseguir com esse processo.");
                        break;
                    } else {
                        System.out.println("Verificando se há pedido abertos...");

                        if (comanda.isEmpty()) {
                            System.out.println("Não há nenhum pedido Aberto, por favor abra algum pedido antes.");
                            break;
                        } else {

                            for (int j = 0; j < comanda.size(); j++) {

                                Pedido p = comanda.get(j);
                                System.out.println("--------------------");
                                System.out.println("Numero do pedido : " + p.getCodigo());
                                System.out.println("--------------------");
                                System.out.println(p.toString());

                                System.out.println();

                                for (int i = 0; i < item.size(); i++) {
                                    itens p1 = item.get(i);
                                    if (p.getCodigo() == p1.getCod()) {
                                        System.out.println(p1.toString());
                                        System.out.println();

                                    }

                                }
                                System.out.println("--------------------");

                            }

                            System.out.println();
                            System.out.print("Digite o numero do pedido: ");
                            try {

                                int cod = sanner.nextInt();
                                sanner.nextLine();

                                System.out.println();
                                System.out.println("--------------------");
                                System.out.println("Lista dos Produtos:");
                                System.out.println("--------------------");
                                for (int j = 0; j < lista.size(); j++) {
                                    System.out.println(lista.get(j).toString());
                                    System.out.println("--------------------");
                                }
                                System.out.println();
                                boolean encontrado = false;
                                for (int j = 0; j < comanda.size(); j++) {
                                    Pedido p = comanda.get(j);
                                    if (cod == p.getCodigo()) {
                                        System.out.print("Digite o Codigo do Produto: ");
                                        int prod = sanner.nextInt();
                                        sanner.nextLine();
                                        System.out.print("Digite a quantidade do produto:");
                                        int qtd = sanner.nextInt();
                                        sanner.nextLine();

                                        for (int i = 0; i < lista.size(); i++) {
                                            produto utemp = lista.get(i);

                                            if (prod == utemp.getCodigo()) {
                                                int recebe1 = p.getCodigo();
                                                itens p2 = new itens();
                                                String recebe = utemp.toString();
                                                p2.setCod(recebe1);
                                                p2.setQuantidade(qtd);
                                                p2.setProduto(recebe);
                                                item.add(p2);
                                                encontrado = true;
                                                break;

                                            }
                                        }
                                    }
                                }

                                if (!encontrado) {
                                    System.out.println(
                                            "Nao foi encontrado esse pedido no sistema ou o produto solicitado, Digite corretamente o numero do codigo.");
                                    break;
                                }
                                System.out.println();

                                for (int j = 0; j < comanda.size(); j++) {

                                    Pedido p = comanda.get(j);
                                    System.out.println("--------------------");
                                    System.out.println("Pedido Numero : " + p.getCodigo());
                                    System.out.println("--------------------");
                                    System.out.println(p.toString());

                                    System.out.println();
                                    for (int i = 0; i < item.size(); i++) {
                                        itens p1 = item.get(i);
                                        if (p.getCodigo() == p1.getCod()) {

                                            System.out.println(p1.toString());
                                            System.out.println();

                                        }

                                    }
                                    System.out.println("--------------------");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println();
                                System.out.println(
                                        "------------------------------------------------------------------------");
                                System.out.println("Dados inseridos invalidos, Ocorreu o seguinte erro: " + e);
                                System.out.println("Siga as seguintes instruções a seguir e não apresentará erro:");
                                System.out.println("\t1 - Inserir dados codigo do pedido apenas com numeros inteiros.");
                                System.out.println(
                                        "\t2 - Inserir dados do codigo do produto apenas com numeros inteiros.");
                                System.out.println(
                                        "\t4 - Inserir dados da quantidade do produto apenas com numeros inteiros.");
                                System.out.println("\t4 - Tente novamente seguindo as instruções acima...");
                                System.out.println(
                                        "------------------------------------------------------------------------");
                                System.out.println();

                            }

                            System.out.println();

                            break;
                        }

                    }
                }
                case "5": {
                    System.out.println();
                    System.out.println("Verificando se há pedido abertos...");
                    if (comanda.isEmpty()) {
                        System.out.println("Não há pedidos abertos para ser fechados, abra algum pedido antes.");
                        break;
                    } else {

                        System.out.println();

                        for (int j = 0; j < comanda.size(); j++) {

                            Pedido p = comanda.get(j);
                            System.out.println("--------------------");
                            System.out.println("Pedido Numero : " + p.getCodigo());
                            System.out.println("--------------------");
                            System.out.println(p.toString());
                            System.out.println();

                            for (int i = 0; i < item.size(); i++) {
                                itens p1 = item.get(i);
                                if (p.getCodigo() == p1.getCod()) {

                                    System.out.println(p1.toString());

                                    System.out.println();
                                }
                            }
                            System.out.println("--------------------");

                        }
                        System.out.println();
                        System.out.print("Digite o numero do pedido: ");
                        try {
                            int cod = sanner.nextInt();
                            sanner.nextLine();

                            boolean encontrado = false;
                            System.out.println();
                            System.out.println("-------------");
                            for (Pedido p : comanda) {
                                if (cod == p.getCodigo()) {
                                    System.out.println("Fechando Pedido.....");
                                    System.out.println("--------------------");
                                    System.out.print("Detalhes do Pedido número: " + p.getCodigo());
                                    System.out.print("\t\t Data: " + p.getDataPedido());
                                    System.out.println();
                                    System.out.print("" + p.getGarcom());
                                    System.out.println();
                                    System.out.println("--------------------");

                                    System.out.print("Itens:");
                                    System.out.print("\t\t\t Quantidade ");
                                    System.out.println();
                                    for (int i = 0; i < item.size(); i++) {
                                        itens p1 = item.get(i);
                                        if (p.getCodigo() == p1.getCod()) {

                                            System.out.println();
                                            System.out.print(p1.getProduto());
                                            System.out.print("  ------------ (" + p1.getQuantidade() + ") unidade");

                                            System.out.println();

                                        }
                                        for (int j = 0; j < lista.size(); j++) {
                                            produto p3 = lista.get(j);
                                            if (p3.toString().equals(p1.getProduto())) {

                                                caixa p2 = new caixa();

                                                float a = p1.getQuantidade();
                                                float b = p3.getPreco();
                                                int c = p1.getCod();

                                                p2.setCodigo(c);
                                                p2.setCalculo(a);
                                                p2.setqtdCal(b);
                                                caixas.add(p2);
                                                encontrado = true;
                                                break;
                                            }

                                        }

                                    }
                                }
                            }

                            if (!encontrado) {
                                System.out.println("Nao foi encontrado esse pedido no sistema");
                                break;
                            }

                            float soma = 0;
                            for (caixa c1 : caixas) {
                                if (cod == c1.getCodigo()) {
                                    soma = soma + c1.getCalculo();
                                }

                            }
                            System.out.println();

                            System.out.println("Total do Pedido: R$" + soma);
                            System.out.println("--------------------");
                            System.out.print("Deseja pagar o pedido? (s ou n): ");
                            String op = sanner.nextLine();
                            String condi = "s";
                            String con = "S";

                            Iterator<Pedido> pedidoIterator = comanda.iterator();
                            Iterator<itens> itensIterator = item.iterator();
                            System.out.println();
                            if (op.equals(condi) || op.equals(con)) {

                                while (itensIterator.hasNext()) {
                                    if (itensIterator.next().getCod() == cod) {
                                        itensIterator.remove();

                                    }

                                }
                                while (pedidoIterator.hasNext()) {
                                    if (pedidoIterator.next().getCodigo() == cod) {

                                        pedidoIterator.remove();
                                        System.out.println("------------------------------------");
                                        System.out.println("Pagamento realizado.");
                                        System.out.println("Muito Obrigado e volte sempre!");
                                        System.out.println("------------------------------------");

                                    }

                                }
                            } else {
                                System.out.println();
                                System.out.println("------------------------------------");

                                System.out.println("Pagamento nao realizado.");
                                System.out.println("------------------------------------");

                            }

                            for (caixa c1 : caixas) {

                                c1.setCalculo(0);
                            }

                            caixa c2 = new caixa();
                            if (op.equals(condi) || op.equals(con)) {
                                c2.setfinalCaixa(soma);
                                caixas.add(c2);
                                break;
                            }

                        } catch (InputMismatchException e) {
                            System.out.println();
                            System.out.println(
                                    "------------------------------------------------------------------------");
                            System.out.println("Dados inseridos invalidos, Ocorreu o seguinte erro: " + e);
                            System.out.println("Siga as seguintes instruções a seguir e não apresentará erro:");
                            System.out.println("\t1 - Inserir dados codigo do pedido apenas com numeros inteiros.");
                            System.out.println("\t2 - Inserir dados confirmando pagamento com a letra S.");

                            System.out.println("\t3 - Tente novamente seguindo as instruções acima...");
                            System.out.println(
                                    "------------------------------------------------------------------------");
                            System.out.println();

                        }

                    }

                    break;

                }
                case "6": {
                    System.out.println();

                    if (caixas.isEmpty() && comanda.isEmpty()) {
                        System.out.println("Nenhum pedido Aberto.");
                        System.out.println("Caixa vazio! ");
                        break;

                    } else {
                        System.out.println("Pedido em Aberto.");
                        System.out.println("Verificando total em caixa");
                        System.out.println("Aguarde...");
                        System.out.println("--------------------------------");

                        float somatorio = 0;
                        for (caixa c1 : caixas) {

                            somatorio += c1.getfinalCaixa();

                        }

                        System.out.println("Total em caixa: R$" + somatorio);
                        System.out.println("--------------------------------");
                        System.out.println();
                    }
                    break;

                }
                case "7": {

                    rodando = false;
                    System.out.println();

                    Date fim = new Date();
                    float total = 0;

                    for (caixa c1 : caixas) {

                        total += c1.getfinalCaixa();

                    }
                    System.out.println("Fechando Caixa");

                    System.out.println("Aguarde um momento....");

                    System.out.println(
                            "==================================================================================================");
                    System.out.println("Horario do término do Expediente: " + fim);
                    System.out.println(
                            "Fim do expediente em nossa " + comercio + " totalizamos  em  caixa no dia: R$" + total);
                    System.out.println(
                            "==================================================================================================");
                    System.out.println();

                    break;

                }

            }

        }

    }

}
