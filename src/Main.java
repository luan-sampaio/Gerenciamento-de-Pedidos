import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        int option;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Boas vindas ao sistema de pedidos do Chez Gourmet!");

        // Lista de pedidos registrados
        Vector<Pedidos> listOrder = new Vector<>();
        int id = 0;

        while (true) {
            ShowOptions();

            try {
                option = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Digite um número inteiro.");
                scanner.nextLine();
                option = 5;
            }

            // Lidar com as opções do menu
            switch (option) {
                case 1:
                    System.out.println("Pedido N°: " + (id + 1));
                    System.out.print("Insira o seu nome: ");

                    String clientName = scanner.next();
                    Pedidos clientOrders = new Pedidos(clientName, id);

                    //clientOrders(clientName, id);
                    int subOption;
                    boolean notFinish = true;

                    System.out.print("- Nome do item: ");
                    String nameItem = scanner.next();

                    System.out.print("- Preço do pedido: ");
                    int priceItem = scanner.nextInt();
                    clientOrders.SetItem(nameItem, priceItem);

                    // Caso o cliente queira adicionar mais itens.
                    while (notFinish) {

                        System.out.println("Escolha uma das opções:");
                        System.out.println("1. Adicionar mais itens");
                        System.out.println("2. Encerrar o pedido");
                        System.out.print("Opção: ");

                        try {
                            subOption = scanner.nextInt();
                        } catch (Exception e) {
                            System.out.println("Digite um número inteiro.");
                            scanner.nextLine();
                            subOption = 3;
                        }

                        if (subOption == 1) {
                            // Adiciona outro item ao pedido
                            System.out.print("- Nome do item: ");
                            nameItem = scanner.next();

                            System.out.print("- Preço do pedido: ");
                            priceItem = scanner.nextInt();

                                clientOrders.SetItem(nameItem, priceItem);

                        } else if (subOption == 2) {
                                // Encerra o pedido e o imprime
                                notFinish = false;
                                System.out.println("\n========================================");
                                System.out.println(" Restaurante Chez Gourmet");
                                System.out.println("========================================");
                                System.out.println("Pedido N°: " + (id + 1));
                                System.out.println("Cliente: " + clientName);
                                System.out.println("----------------------------------------");
                                System.out.println("Itens:");

                                // Aqui você faria um loop para percorrer os itens do pedido
                                float totalValue = 0;
                                LinkedList<Item> listItem = clientOrders.getListItem();

                                for (Item item : listItem) {
                                // Usamos o '+' para juntar o texto com as variáveis do item
                                    totalValue += item.getPrice();
                                    System.out.println("- " + item.getName()+ " R$ " + item.getPrice());
                                }

                                System.out.println("----------------------------------------");
                                // O valor total deve ser calculado
                                System.out.println("Total: R$ " + totalValue);
                                System.out.println("========================================");
                                System.out.println(" Obrigado pela preferência! :) ");
                                System.out.println("========================================\n");

                        } else {
                                System.out.println("Opção invalida, tente novamente.");
                        }
                    }
                    listOrder.add(clientOrders);
                    ++id;
                    break;

                case 2:
                    // Remover um pedido já existente
                    System.out.print("Qual o número de pedido que você deseja remover? ");
                    int removeOrder = scanner.nextInt();
                    --removeOrder;

                    if (removeOrder > id || removeOrder < 0) {
                        System.out.println("Número de pedido inexistente.");
                    } else {
                        listOrder.remove(removeOrder);
                    }
                    break;
                case 3:
                    // Listar todos os pedidos registrados
                    for (Pedidos pedido : listOrder) {
                        System.out.println("========================================");
                        System.out.println("Pedido N°: " + (pedido.getId() + 1));
                        System.out.println("Cliente: " + pedido.getName());
                        System.out.println("----------------------------------------");
                        System.out.println("Itens:");

                        float totalValue = 0;
                        LinkedList<Item> outputList = pedido.getListItem();
                        for (Item item : outputList) {
                            System.out.println("- " + item.getName() + " R$ " + item.getPrice());
                            totalValue += item.getPrice();
                        }

                        System.out.println("----------------------------------------");
                        System.out.println("Total: R$ " + totalValue);
                        System.out.println("========================================\n\n");
                    }

                    break;
                case 4:
                    // Encerrar programa
                    System.out.println("========================================");
                    System.out.println("Compra finalizada!");
                    System.out.println("Volte sempre!");
                    System.out.println("========================================\n");

                    return;
                default:
                    System.out.println("Opção invalida, tente novamente.");
                    break;
            }
        }
    }

    public static void ShowOptions() {
        System.out.println("Escolha uma das opções:");
        System.out.println("1. Registrar Pedido");
        System.out.println("2. Remover pedido");
        System.out.println("3. Listar Pedidos");
        System.out.println("4. Sair");
        System.out.print("Opção: ");

    }
}
