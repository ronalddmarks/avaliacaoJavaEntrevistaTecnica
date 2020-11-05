package br.com.spassu.fibonacci;

import java.util.Scanner;

import br.com.spassu.fibonacci.service.FibonacciService;

public class App {

  public static void main(String[] args) {
    FibonacciService fibonacciService = new FibonacciService();
    
    Scanner scan = new Scanner(System.in);
    String line = scan.nextLine();
    
    System.out.println(
      fibonacciService.getSequence(
        Integer.valueOf(line)
      )
    );
    
    scan.close();
  }
}
