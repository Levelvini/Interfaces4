package aplication;

import entities.Contract;
import entities.Installments;
import service.ContractService;
import service.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("enter contract dada: ");
        Random rd = new Random();
        int number = rd.nextInt(100000000);
        System.out.print("enter date: ");
        DateTimeFormatter fmt= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(sc.next(), fmt);
        System.out.print("enter the contract value: ");
        double totalValue = sc.nextDouble();
        Contract obj = new Contract(number,date,totalValue);
        System.out.print("enter the installment number: ");
        int n = sc.nextInt();
        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(obj, n);

        System.out.println("Parcelas:");
        for (Installments installments : obj.getInstallments()) {
            System.out.println(installments);
        }

        sc.close();
    }
}
