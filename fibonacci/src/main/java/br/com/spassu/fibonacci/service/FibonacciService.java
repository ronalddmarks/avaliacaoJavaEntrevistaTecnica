package br.com.spassu.fibonacci.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciService {

  public String getSequence(Integer size) {
    List<Long> sequence = new ArrayList<Long>(Arrays.asList(0L, 1L));

    while (sequence.size() < size) {
      int index = sequence.size() - 1;
      sequence.add(sequence.get(index) + sequence.get(index - 1));
    }

    sequence = sequence.subList(0, size);

    return sequence
      .stream()
      .map(n -> n.toString())
      .reduce("", (c, n) -> c + ", " + n)
      .substring(2)
      .concat(".");
  }
}
